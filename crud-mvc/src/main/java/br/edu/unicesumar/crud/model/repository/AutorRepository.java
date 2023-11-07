package br.edu.unicesumar.crud.model.repository;

import br.edu.unicesumar.crud.model.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {


}
