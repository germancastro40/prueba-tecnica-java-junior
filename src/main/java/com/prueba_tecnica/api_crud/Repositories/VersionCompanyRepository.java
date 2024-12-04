package com.prueba_tecnica.api_crud.Repositories;

import com.prueba_tecnica.api_crud.Models.VersionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VersionCompanyRepository extends JpaRepository<VersionCompany, Integer> {

    Optional<VersionCompany> findByCompany_IdCompany(int idCompany);
}
