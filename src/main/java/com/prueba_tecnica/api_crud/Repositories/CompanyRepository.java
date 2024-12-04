package com.prueba_tecnica.api_crud.Repositories;

import com.prueba_tecnica.api_crud.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
