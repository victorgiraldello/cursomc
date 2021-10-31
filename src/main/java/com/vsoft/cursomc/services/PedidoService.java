package com.vsoft.cursomc.services;

import com.vsoft.cursomc.domain.Categoria;
import com.vsoft.cursomc.domain.Pedido;
import com.vsoft.cursomc.repositories.CategoriaRepository;
import com.vsoft.cursomc.repositories.PedidoRepository;
import com.vsoft.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		 Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	} 

}
