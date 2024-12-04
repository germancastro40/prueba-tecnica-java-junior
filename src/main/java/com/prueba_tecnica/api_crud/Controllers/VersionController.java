package com.prueba_tecnica.api_crud.Controllers;

import com.prueba_tecnica.api_crud.Dtos.Request.VersionRequest;
import com.prueba_tecnica.api_crud.Middleware.BeanValidator;
import com.prueba_tecnica.api_crud.Services.VersionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("version")
public class VersionController {
    @Autowired
    private VersionService versionService;

    @Autowired
    private BeanValidator validator;

    @PostMapping()
    public ResponseEntity<?>createVersion(
            @Valid @RequestBody VersionRequest request, BindingResult result
            ){
        if (result.hasErrors()){
            Map<Object, Object> resp = new HashMap<>();
            resp.put("error", validator.getValidationErrors(result));
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(versionService.save(request), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable("id") int id){
        return new ResponseEntity<>(versionService.findById(id), HttpStatus.OK);
    }
}
