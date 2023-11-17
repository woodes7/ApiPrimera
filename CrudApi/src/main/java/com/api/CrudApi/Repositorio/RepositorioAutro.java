package com.api.CrudApi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.CrudApi.Modelos.Autor;
@Repository
public interface RepositorioAutro extends JpaRepository<Autor, Long>  {

}
