package com.vsoft.cursomc.services;

import com.vsoft.cursomc.domain.Cliente;
import com.vsoft.cursomc.repositories.ClienteRepository;
import com.vsoft.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
