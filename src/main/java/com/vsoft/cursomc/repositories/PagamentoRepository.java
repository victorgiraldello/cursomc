package com.vsoft.cursomc.repositories;

import com.vsoft.cursomc.domain.Categoria;
import com.vsoft.cursomc.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
