package br.edu.unicesumar.crud.controller;


import br.edu.unicesumar.crud.model.Pessoa;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    //get /id ->
    //put /id ->

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody Pessoa pessoaUpdate){
       Pessoa pessoEdit = mock().stream().filter(pessoa->pessoa.getId().equals(id))
               .findFirst().orElse(null);

       if(pessoEdit == null) {
           return null;
       }
       return new Pessoa(pessoEdit.getId(), pessoaUpdate.getNome(), pessoaUpdate.getDocumento());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Pessoa pessoaRemove = mock().stream().filter(pessoa->pessoa.getId().equals(id))
                .findFirst().orElse(null);

        mock().remove(pessoaRemove);
    }

    private List<Pessoa> mock() {
        return Arrays.asList(new Pessoa(1L, "Maria","123"),
                             new Pessoa(2L, "Magali","321"),
                             new Pessoa(3L, "Ronaldo","987"),
                             new Pessoa(4L, "João","456"),
                             new Pessoa(5L, "Joaquim","654"),
                             new Pessoa(6L, "Roberto","789"),
                             new Pessoa(7L, "Eduardo","741"),
                             new Pessoa(8L, "Alvaro","852"));
    }
}
