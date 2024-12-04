package com.prueba_tecnica.api_crud.Services;

import com.prueba_tecnica.api_crud.Models.Company;
import com.prueba_tecnica.api_crud.Repositories.CompanyRepository;
import com.prueba_tecnica.api_crud.Utils.State;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company save(Company company){
        return companyRepository.save(company);
    }
    public Page<Company> getAll(Pageable pageable){
        Page<Company> companies = companyRepository.findAll(pageable);
        return companies;
    }

    public Company findById(int id){
        return companyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found"));
    }

    public Company updateById(Company company, int id){
        if (companyRepository.findById(id).isEmpty()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "We can't update a non-existent data");
        }
        company.setId_company(id);
        return companyRepository.save(company);
    }
    //Hard delete
    public boolean deleteById(int id){
        boolean resp = true;
        if (companyRepository.findById(id).isEmpty()){
            resp = false;
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "We can't delete a non-existent data");
        }
        companyRepository.deleteById(id);
        return resp;
    }
    //Soft delete
    public boolean deletedLogicalById(int id){
        boolean resp = true;
        Optional<Company> company = companyRepository.findById(id);
        if (company.isEmpty()){
            resp = false;
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "We can't delete a non-existent data");
        }
        company.get().setState(State.ENABLE);
        companyRepository.save(company.get());
        return resp;
    }

    //Note: The difference between both delete ways,
    // is that in one the data is deleted permanently of the database
    //in the other, we can see the database in the database, but it can't be acceded by the users
    //this is util when the data is related with other information in the table, like this case
}
