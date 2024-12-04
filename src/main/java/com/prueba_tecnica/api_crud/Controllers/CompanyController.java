package com.prueba_tecnica.api_crud.Controllers;

import com.prueba_tecnica.api_crud.Middleware.BeanValidator;
import com.prueba_tecnica.api_crud.Models.Company;
import com.prueba_tecnica.api_crud.Services.CompanyService;
import com.prueba_tecnica.api_crud.Services.VersionCompanyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private BeanValidator validator;

    @Autowired
    private VersionCompanyService versionCompanyService;

    @PostMapping()
    public ResponseEntity<?>saveCompany(@Valid @RequestBody Company company, BindingResult result){
        if(result.hasErrors()){
            Map<Object, Object>resp = new HashMap<>();
            resp.put("error", validator.getValidationErrors(result));
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(companyService.save(company));
    }

    @GetMapping()
    public ResponseEntity<?>getCompanyList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page, size);

        return ResponseEntity.ok(companyService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getCompanyById(@PathVariable("id")int id){
        return ResponseEntity.ok(companyService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>updateCompany(
            @PathVariable("id") int id,
            @Valid @RequestBody Company company, BindingResult result
    ){
        if (result.hasErrors()){
            return new ResponseEntity<>(validator.getValidationErrors(result), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(companyService.updateById(company, id), HttpStatus.OK);
    }

    @DeleteMapping("/hard-delete/{id}")
    public ResponseEntity<?>hardDelete(@PathVariable("id")int id){
        Map<String,String> resp = new HashMap<>();
        if (companyService.deleteById(id)){
            resp.put("message", "The content was successful deleted");
            return ResponseEntity.ok(resp);
        }
        resp.put("message", "Not was possible delete the content");
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<?>softDelete(@PathVariable("id")int id){
        Map<String,String> resp = new HashMap<>();
        if (companyService.deletedLogicalById(id)){
            resp.put("message", "The content was successful deleted");
            return ResponseEntity.ok(resp);
        }
        resp.put("message", "Not was possible delete the content");
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("information/{code}")
    public ResponseEntity<?> getCompanyDetails(@PathVariable("code") int code){
        return new ResponseEntity<>(versionCompanyService.getCompanyInformation(code), HttpStatus.OK);
    }
}
