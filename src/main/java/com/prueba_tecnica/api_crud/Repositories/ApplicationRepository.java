package com.prueba_tecnica.api_crud.Repositories;

import com.prueba_tecnica.api_crud.Models.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
