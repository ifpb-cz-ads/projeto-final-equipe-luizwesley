package com.petshop.petshop.Controllers;

import com.petshop.petshop.DTO.ClienteCpfDTO;
import com.petshop.petshop.DTO.ProdutoCodigoDTO;
import com.petshop.petshop.DTO.ServicoByIdDTO;
import com.petshop.petshop.DTO.ServicoRealizaDTO;
import com.petshop.petshop.DTO.ServicoRealizadoIdDTO;
import com.petshop.petshop.DTO.ServicoRequestDTO;
import com.petshop.petshop.models.Cliente;
import com.petshop.petshop.models.Funcionario;
import com.petshop.petshop.models.Pet;
import com.petshop.petshop.models.Servico;
import com.petshop.petshop.models.ServicoRealizado;
import com.petshop.petshop.repositories.FuncionarioRp;
import com.petshop.petshop.repositories.PetRp;
import com.petshop.petshop.repositories.ServicoRealizadoRp;
import com.petshop.petshop.repositories.ServicoRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("servico")



public class ServicoController {
    @Autowired
    ServicoRp servicoRp;
    @Autowired
    PetRp petRp;
    @Autowired
    FuncionarioRp funcionarioRp;
    @Autowired
    ServicoRealizadoRp servicoRealizadoRp;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("cadastraServico")
    public void cadastraServico (@RequestBody ServicoRequestDTO data) {
        Servico servico = new Servico();
        servico.setTipo(data.tipo());
        servico.setValor(data.valor());
        servicoRp.save(servico);
    }
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("realizaServico")
    public void realizaServico(@RequestBody ServicoRealizaDTO data){
        Servico servico = servicoRp.findById(data.servico()).get();
        Pet pet = petRp.findById(data.pet()).get();
        Funcionario funcionario = funcionarioRp.findById(data.funcionario()).get();
        ServicoRealizado servicoRealizado = new ServicoRealizado(servico, pet, funcionario);
        servicoRealizadoRp.save(servicoRealizado);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("servicos")
    public Iterable<Servico> getAllServicos (){
        return servicoRp.findAll();
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("servicosRealizados")
    public Iterable<ServicoRealizado> getAllServicosRealizados(){return servicoRealizadoRp.findAll();
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("servicoById")
    public Servico getServicoById(@RequestBody ServicoByIdDTO data){
        if(servicoRp.existsById(data.id())){
            return servicoRp.findById(data.id()).get();
        }
        return null;

    }
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("servicoRealizadoById")
    public ServicoRealizado getServicoRealizadoById(@RequestBody ServicoRealizadoIdDTO data){
        if(servicoRealizadoRp.existsById(data.id())){
            return servicoRealizadoRp.findById(data.id()).get();
        }
        return null;

    }
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("deletaServico")
    public boolean deleteServico(@RequestBody ServicoByIdDTO data){
        if(servicoRp.existsById(data.id())){
            Servico servico = servicoRp.findById(data.id()).get();
            servicoRp.delete(servico);
            return true;
        }
        return false;
    }
}
