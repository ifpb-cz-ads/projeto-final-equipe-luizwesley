package com.petshop.petshop.Controllers;


import com.petshop.petshop.DTO.CompraProdutoDTO;
import com.petshop.petshop.DTO.ProdutoCodigoDTO;
import com.petshop.petshop.DTO.ProdutoRequestDTO;
import com.petshop.petshop.models.Fornecedor;
import com.petshop.petshop.models.Produto;
import com.petshop.petshop.repositories.FornecedorRp;
import com.petshop.petshop.repositories.ProdutoRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    ProdutoRp produtoRp;

    @Autowired
    FornecedorRp fornecedorRp;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    public Iterable<Produto> getAll(){
        Iterable<Produto> produtos = produtoRp.findAll();
        System.out.println(produtos);
        return produtos;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("codigo")
    public Produto getByCodigo(@RequestBody ProdutoCodigoDTO data){
        if(produtoRp.existsById(data.codigo())){
            return produtoRp.findById(data.codigo()).get();
        }
        return null;


    }
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping
    public void addProduto(@RequestBody ProdutoRequestDTO data){
        Fornecedor fornecedor = fornecedorRp.findByCnpj(data.fornecedor());
        Produto produtoData = new Produto(data);
        produtoData.setFornecedor(fornecedor);
        produtoRp.save(produtoData);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("compra")
    public boolean compraProduto(@RequestBody CompraProdutoDTO data){
        if(produtoRp.existsById(data.codigo())){
            Produto produto = produtoRp.findById(data.codigo()).get();
            produto.setEstoque(produto.getEstoque() + data.quantidade());
            produtoRp.save(produto);
            return true;
        }
        return false;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("deletaProduto")
    public boolean deletaProduto(ProdutoCodigoDTO data){
        if(produtoRp.existsById(data.codigo())){
            Produto produto = produtoRp.findById(data.codigo()).get();
            produtoRp.delete(produto);
            return true;
        }
        return false;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("zeraProduto")
    public boolean zeraProduto(ProdutoCodigoDTO data){
        if(produtoRp.existsById(data.codigo())){
            Produto produto = produtoRp.findById(data.codigo()).get();
            produtoRp.save(produto);
            return true;
        }
        return false;
    }
}
