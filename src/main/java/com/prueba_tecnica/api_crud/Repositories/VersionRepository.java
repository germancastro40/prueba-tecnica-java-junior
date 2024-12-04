package com.prueba_tecnica.api_crud.Repositories;

import com.prueba_tecnica.api_crud.Models.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version, Integer> {
}
