package com.vsoft.cursomc.services;

import java.util.Optional;

import com.vsoft.cursomc.services.exception.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vsoft.cursomc.domain.Categoria;
import com.vsoft.cursomc.repositories.CategoriaRepository;
import com.vsoft.cursomc.services.exception.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		return repo.save(obj);
	}

	public Categoria update(Categoria obj){
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id){
		try{
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir Categorias que possuem produtos!");
		}

	}

}
