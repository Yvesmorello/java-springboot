package com.example.ultimato.controller;
import com.example.ultimato.model.Aluno;
import com.example.ultimato.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public List<Aluno> all(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Aluno getById(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Aluno create(@RequestBody Aluno novaPessoa){
        return repository.save(novaPessoa);
    }

    @PutMapping("/{id}")
    public Aluno update(@PathVariable Long id, @RequestBody Aluno pessoaUpdate){
        Aluno pessoaEdit = repository.findById(id).orElse(new Aluno());

        pessoaEdit.setId(pessoaUpdate.getId());
        pessoaEdit.setNome(pessoaUpdate.getNome());
        pessoaEdit.setDocumento(pessoaUpdate.getDocumento());
        repository.save(pessoaEdit);

        return pessoaEdit;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
