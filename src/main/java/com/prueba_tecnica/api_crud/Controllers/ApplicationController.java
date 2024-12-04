package com.prueba_tecnica.api_crud.Controllers;

import com.prueba_tecnica.api_crud.Middleware.BeanValidator;
import com.prueba_tecnica.api_crud.Models.Application;
import com.prueba_tecnica.api_crud.Services.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private BeanValidator validator;

    @PostMapping
    public ResponseEntity<?>createApplication(@Valid @RequestBody Application application, BindingResult result){
        if (result.hasErrors()){
            Map<Object, Object> resp = new HashMap<>();
            resp.put("error", validator.getValidationErrors(result));
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(applicationService.save(application), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>FindById(@PathVariable("id")int id){
        return new ResponseEntity<>(applicationService.findById(id), HttpStatus.OK);
    }
}
