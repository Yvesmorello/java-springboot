package br.edu.unicesumar.crud.controller;

import br.edu.unicesumar.crud.model.domain.Pessoa;
import br.edu.unicesumar.crud.model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired //CRIANDO UMA INSTANCIA DE REPOSITORY DAI PODE USAR O REPOSITORY NA CLASSE
    private PessoaRepository pessoaRepository;

    //LISTAR TODAS AS PESSOAS -> GET
    @GetMapping //anotaçÃO para mapear requisições.
    public List<Pessoa> all(){
        return pessoaRepository.findAll();
    }

    //PESSOA POR ID -> GET/ID
    @GetMapping("/{id}")//anotaçÃO para mapear requisições
    public Pessoa getById(@PathVariable Long id){ //VARIAÇÃO DO CAMINHO - ( O {ID} VAI VIRAR O "LONG ID" )
        return pessoaRepository.findById(id).orElse(null);
    }

    //CRIAR PESSOA
    @PostMapping
    public Pessoa create(@RequestBody Pessoa nova){
        return pessoaRepository.save(nova);
    }

    //EDITAR PESSOA -> PUT/ID
    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody Pessoa update){

        Pessoa pessoaDb = pessoaRepository.findById(id).orElse(new Pessoa());

        pessoaDb.setId(update.getId());
        pessoaDb.setNome(update.getNome());
        pessoaDb.setDocumento(update.getDocumento());

        return pessoaDb;
    }

    //EXCLUIR PESSOA POR ID -> DELET/ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        pessoaRepository.deleteById(id);
    }

}
