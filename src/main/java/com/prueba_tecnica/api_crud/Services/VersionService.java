package com.prueba_tecnica.api_crud.Services;

import com.prueba_tecnica.api_crud.Dtos.Request.VersionRequest;
import com.prueba_tecnica.api_crud.Models.Application;
import com.prueba_tecnica.api_crud.Models.Version;
import com.prueba_tecnica.api_crud.Repositories.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VersionService {
    @Autowired
    private VersionRepository versionRepository;
    @Autowired
    private ApplicationService applicationService;

    public Version save(VersionRequest request){
        Application application = applicationService.findById(request.getApp_id());

        Version version = new Version();
        version.setVersion(request.getVersion());
        version.setApplication(application);
        version.setVersion_description(request.getVersion_description());
        return versionRepository.save(version);
    }

    public Version findById(int id){
        return versionRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Version not found"));
    }
}
