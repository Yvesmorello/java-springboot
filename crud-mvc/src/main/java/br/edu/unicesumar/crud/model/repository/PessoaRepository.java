package br.edu.unicesumar.crud.model.repository;

import br.edu.unicesumar.crud.model.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


    //olha pra tabela
    //nativa
    @Query(nativeQuery = true, value = "select p.* from ES_PESSOA p" + "where p.doc like '%:search%'")
    List<Pessoa> searchByDocumentoNativo(@Param("search") String search);

    //olha pra classe o java
    //Hql
    @Query(value = "select p from Pessoa" + "where p.documento like '%:search%' ")
    List<Pessoa> searchByDocumentoHql(@Param("search") String search);


    //Spring Data
    List<Pessoa> findByDocumentoLike(String search);


}
