package com.prueba_tecnica.api_crud.Middleware;


import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BeanValidator {
    public List<String> getValidationErrors(BindingResult result) {
        return result.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
    }
}
