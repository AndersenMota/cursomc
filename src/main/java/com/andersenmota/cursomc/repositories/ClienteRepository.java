package com.andersenmota.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersenmota.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

	
}
