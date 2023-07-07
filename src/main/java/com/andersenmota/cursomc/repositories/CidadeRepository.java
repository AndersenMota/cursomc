package com.andersenmota.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersenmota.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade,Integer> {

	
}
