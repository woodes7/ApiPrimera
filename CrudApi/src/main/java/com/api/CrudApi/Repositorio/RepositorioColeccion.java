package com.api.CrudApi.Repositorio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.CrudApi.Modelos.Coleccion;
@Repository
public interface RepositorioColeccion extends JpaRepository<Coleccion, Long>{

	

}
