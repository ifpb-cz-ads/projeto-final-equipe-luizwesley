package com.petshop.petshop.Controllers;

import com.petshop.petshop.DTO.ItensVendaTotalDTO;
import com.petshop.petshop.DTO.VendaRequestDTO;
import com.petshop.petshop.DTO.VendaTotalRequestDTO;
import com.petshop.petshop.models.*;
import com.petshop.petshop.repositories.*;
import com.petshop.petshop.secondary.FormaPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("venda")


public class VendaController {
    @Autowired
    private ProdutoRp produtoRp;
    @Autowired
    FuncionarioRp funcionarioRp;
    @Autowired
    ClienteRp clienteRp;
    @Autowired
    VendaRp vendaRp;
    @Autowired
    VendaTotalRp vendaTotalRp;
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("itemVenda")
    public void itemVenda(@RequestBody VendaRequestDTO data){
        if(!vendaTotalRp.existsById(data.codigoVenda().getCodigo())) {
            System.out.println(vendaTotalRp.save(new VendaTotal(data.codigoVenda().getCodigo())));
        }
        Optional<VendaTotal> vendaTotalOp = vendaTotalRp.findById(data.codigoVenda().getCodigo());
        VendaTotal vendaTotal = new VendaTotal(vendaTotalOp.get().getCodigo());
        Optional<Produto> produtoOp = produtoRp.findById(data.codigo());
        Produto produto = new Produto(produtoOp.get().getCodigo(), produtoOp.get().getNome(), produtoOp.get().getPreco(), produtoOp.get().getEstoque(), produtoOp.get().getFornecedor());
        Venda itemVenda = new Venda();
        System.out.println(itemVenda);
        itemVenda.setValor(data.valor());
        itemVenda.setQuantidade(data.quantidade());
        itemVenda.setProduto(produto);
        itemVenda.setCodigoVenda(data.codigoVenda());
        vendaRp.save(itemVenda);
        }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    public Iterable<VendaTotal> getAllVendaTotal(){
        return vendaTotalRp.findAll();
    }
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("finalizaVenda")
    public void finalizaVenda(@RequestBody VendaTotalRequestDTO data){
            System.out.println(data.codigoVenda());
        if(!vendaTotalRp.existsById(data.codigoVenda())) {
            vendaTotalRp.save(new VendaTotal(data.codigoVenda()));
        }
        vendaTotalRp.existsById(1L);
            System.out.println("Aqui");
        Optional<VendaTotal> vendaTotalOp = vendaTotalRp.findById(1L);
        System.out.println("vendaTotalOp");
        VendaTotal vendaTotal = new VendaTotal(vendaTotalOp.get().getCodigo());
        System.out.println("Aqui");
        Iterable<Venda> totalVendas = vendaRp.findAll();
        ArrayList<Venda> itensVenda = new ArrayList<>();
        for (Venda venda:totalVendas) {
            if(venda.getCodigoVenda().getCodigo() == vendaTotal.getCodigo()){
                Optional<Produto> produtoOp = produtoRp.findById(venda.getProduto().getCodigo());
                Produto produto = produtoOp.get();
                produto.setEstoque(produto.getEstoque()-venda.getQuantidade());
                itensVenda.add(venda);
            }
        }
        List<FormaPagamento> formasPagamento = data.formasPagamento();
        Optional<Funcionario> funcionarioOp = funcionarioRp.findById(data.funcionario());
        Funcionario funcionario = new Funcionario(funcionarioOp.get().getCpf(),funcionarioOp.get().getNome(),funcionarioOp.get().getTelefones(), funcionarioOp.get().getEndereco(), funcionarioOp.get().getMatricula(), funcionarioOp.get().getRg(), funcionarioOp.get().getSalario());
        Optional<Cliente> clienteOp = clienteRp.findById(data.cliente());
        Cliente cliente = new Cliente(clienteOp.get().getCpf(), clienteOp.get().getNome(),clienteOp.get().getTelefones(), clienteOp.get().getEndereco(), clienteOp.get().getEmail());
        vendaTotal.setItensVenda(itensVenda);
        vendaTotal.setFormasPagamento(formasPagamento);
        vendaTotal.setCliente(cliente);
        vendaTotal.setFuncionario(funcionario);
        vendaTotalRp.save(vendaTotal);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("itemVendaByCodigo")
    public List<Venda> getItesVendaTotalByCodigo(@RequestBody ItensVendaTotalDTO data){
        if(vendaTotalRp.existsById(data.codigoVenda())){
            return vendaTotalRp.findById(data.codigoVenda()).get().getItensVenda();
        }
        return null;
    }
    


}
