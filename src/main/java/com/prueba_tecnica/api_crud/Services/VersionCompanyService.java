package com.prueba_tecnica.api_crud.Services;

import com.prueba_tecnica.api_crud.Dtos.Request.VersionCompanyRequest;
import com.prueba_tecnica.api_crud.Dtos.Response.CompanyCodeResponse;
import com.prueba_tecnica.api_crud.Models.Company;
import com.prueba_tecnica.api_crud.Models.Version;
import com.prueba_tecnica.api_crud.Models.VersionCompany;
import com.prueba_tecnica.api_crud.Repositories.VersionCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class VersionCompanyService {

    @Autowired
    private VersionCompanyRepository versionCompanyRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private VersionService versionService;

    public VersionCompany save(VersionCompanyRequest request){
        Company company = companyService.findById(request.getCompany_id());
        Version version = versionService.findById(request.getVersion_id());

        VersionCompany versionCompany = new VersionCompany();
        versionCompany.setCompany(company);
        versionCompany.setVersion(version);
        versionCompany.setVersion_company_description(request.getVersion_company_description());
        return versionCompanyRepository.save(versionCompany);
    }

    public VersionCompany findById(int id){
        return versionCompanyRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The version company was not found"));
    }


    public CompanyCodeResponse getCompanyInformation(int companyId){
    Optional<VersionCompany> versionCompany= versionCompanyRepository.findByCompany_IdCompany(companyId);

    if (versionCompany.isEmpty()){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The company was not found");
    }

    VersionCompany company =versionCompany.get();
    CompanyCodeResponse companyCodeResponse = new CompanyCodeResponse();

    companyCodeResponse.setCompany_name(company.getCompany().getName_company());
    companyCodeResponse.setCompany_code(company.getCompany().getId_company());
    companyCodeResponse.setVersion(company.getVersion().getVersion());
    companyCodeResponse.setApp_name(company.getVersion().getApplication().getApp_name());
    return companyCodeResponse;
    }
}
