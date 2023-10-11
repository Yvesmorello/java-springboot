package br.edu.unicesumar.crud.controller;

import br.edu.unicesumar.crud.model.Pessoa;
import br.edu.unicesumar.crud.service.PessoaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService service;


    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pessoa> all(){
        return service.selectAll();
    }

    @GetMapping("/{id}")
    public Pessoa getId(@PathVariable Long id){
        return service.selectAll().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);

    }
}
