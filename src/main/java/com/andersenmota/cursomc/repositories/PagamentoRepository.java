package com.andersenmota.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersenmota.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {

	
}
