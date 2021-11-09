package com.vsoft.cursomc.services.validation.utils;

import com.vsoft.cursomc.domain.Cliente;
import com.vsoft.cursomc.domain.enuns.TipoCliente;
import com.vsoft.cursomc.dto.ClienteDTO;
import com.vsoft.cursomc.dto.ClienteNewDTO;
import com.vsoft.cursomc.repositories.ClienteRepository;
import com.vsoft.cursomc.resources.exceptions.FieldMessage;
import com.vsoft.cursomc.services.validation.ClienteUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
    @Autowired
    private ClienteRepository repo;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(ClienteUpdate ann) {
    }
    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        List<FieldMessage> list = new ArrayList<>();
        Integer uriId = Integer.parseInt(map.get("id"));

        Cliente aux = repo.findByEmail(objDto.getEmail());

        if(aux != null && !aux.getId().equals(uriId)){
            list.add(new FieldMessage("email", "Email já existente."));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
