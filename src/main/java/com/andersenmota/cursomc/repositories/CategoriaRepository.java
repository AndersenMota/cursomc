package com.andersenmota.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersenmota.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

	
}
