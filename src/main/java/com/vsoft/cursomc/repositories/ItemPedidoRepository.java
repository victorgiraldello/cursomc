package com.vsoft.cursomc.repositories;

import com.vsoft.cursomc.domain.Categoria;
import com.vsoft.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{

}
