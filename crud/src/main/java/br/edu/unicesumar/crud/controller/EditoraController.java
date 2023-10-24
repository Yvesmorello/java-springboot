package br.edu.unicesumar.crud.controller;


import br.edu.unicesumar.crud.model.domain.Editora;
import br.edu.unicesumar.crud.model.domain.Pessoa;
import br.edu.unicesumar.crud.model.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editora")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping
    public List<Editora> all(){
        return editoraRepository.findAll();
    }

    @GetMapping("/{id}")
    public Editora getById(@PathVariable Long id){
        return editoraRepository.findById(id).orElse(null);
    }
//
//    @PutMapping("/{id}")
//    public Editora update(@PathVariable Long id, @RequestBody Editora editoraUpdate){
//        Pessoa pessoEdit = mock().stream().filter(editora->editora.getId().equals(id))
//                .findFirst().orElse(null);
//
//        if(pessoEdit == null) {
//            return null;
//        }
//        return new Pessoa(pessoEdit.getId(), editoraUpdate.getNome(), editoraUpdate.getDocumento());
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id){
//        Pessoa pessoaRemove = mock().stream().filter(pessoa->pessoa.getId().equals(id))
//                .findFirst().orElse(null);
//
//        mock().remove(pessoaRemove);
//    }
}
