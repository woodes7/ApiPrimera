package com.api.CrudApi.Repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.CrudApi.Modelos.Libro;
@Repository
public interface RepositorioLibro extends JpaRepository<Libro, Long>  {

}
