package com.andersenmota.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.andersenmota.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

	
}
