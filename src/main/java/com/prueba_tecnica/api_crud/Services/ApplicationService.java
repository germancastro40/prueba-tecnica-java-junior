package com.prueba_tecnica.api_crud.Services;

import com.prueba_tecnica.api_crud.Models.Application;
import com.prueba_tecnica.api_crud.Repositories.ApplicationRepository;
import com.prueba_tecnica.api_crud.Utils.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application save(Application application){
        application.setState(State.ENABLE);
        return applicationRepository.save(application);
    }

    public Application findById(int id){
        return applicationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found"));
    }


}
