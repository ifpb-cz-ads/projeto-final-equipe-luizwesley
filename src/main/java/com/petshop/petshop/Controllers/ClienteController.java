package com.petshop.petshop.Controllers;


import com.petshop.petshop.DTO.ClienteCpfDTO;
import com.petshop.petshop.DTO.ClienteRequestDTO;
import com.petshop.petshop.models.Cliente;
import com.petshop.petshop.repositories.ClienteRp;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
@NoArgsConstructor
public class ClienteController {
    @Autowired
    private ClienteRp clienteRp;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    public Iterable<Cliente> getAll(){
        return clienteRp.findAll();
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping
    public boolean addCliente(@RequestBody ClienteRequestDTO data){
        if(!clienteRp.existsById(data.cpf())){
            Cliente clienteData = new Cliente(data);
            clienteRp.save(clienteData);
            return true;
        }
        return false;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("cpf")
    public Cliente getClienteByCpf(@RequestBody ClienteCpfDTO data){
        if(clienteRp.existsById(data.cpf())){
            Cliente cliente = clienteRp.findByCpf(data.cpf());
            System.out.println(cliente.getPets());
            return cliente;
        }
        return null;

    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PatchMapping("atualizaCliente")
    public boolean atualizaCliente(@RequestBody ClienteRequestDTO data){
        if(clienteRp.existsById(data.cpf())){
            Cliente clienteData = clienteRp.findById(data.cpf()).get();
            clienteData.setEmail(data.email());
            clienteData.setNome(data.nome());
            clienteData.getEndereco().setRua(data.rua());
            clienteData.getEndereco().setBairro(data.bairro());
            clienteData.getEndereco().setCidade(data.cidade());
            clienteData.setTelefones(data.telefones());
            clienteRp.save(clienteData);
            return true;
        }
        return false;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("deletaCliente")
    public boolean deleteCliente(@RequestBody ClienteCpfDTO data){
        if(clienteRp.existsById(data.cpf())){
            Cliente cliente = clienteRp.findById(data.cpf()).get();
            clienteRp.delete(cliente);
            return true;
        }
        return false;
    }


}
