package com.vsoft.cursomc.repositories;

import com.vsoft.cursomc.domain.Categoria;
import com.vsoft.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
