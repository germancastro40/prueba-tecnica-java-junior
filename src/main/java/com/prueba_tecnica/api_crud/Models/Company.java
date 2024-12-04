package com.prueba_tecnica.api_crud.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prueba_tecnica.api_crud.Utils.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Set;

@Entity
@Table(name = "company")
@AllArgsConstructor()
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private int idCompany;

    @NotEmpty(message = "The codigo_company can't be empty")
    @Column(name = "codigo_company")
    private String codigo_company;

    @NotEmpty(message = "The name_company can't be empty")
    @Column(name = "name_company")
    private String name_company;

    @NotEmpty(message = "The description_company can't be empty")
    @Column(name = "description_company")
    private String description_company;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VersionCompany> versionCompanies;

    @JsonIgnore()
    @Enumerated(EnumType.STRING)
    private State state;

    public Company(Integer id_company, String codigo_company, String name_company, String description_company, State state) {
        this.idCompany = id_company;
        this.codigo_company = codigo_company;
        this.name_company = name_company;
        this.description_company = description_company;
        this.state = state;
    }

    public Company(){}


    public Integer getId_company() {
        return idCompany;
    }

    public void setId_company(Integer id_company) {
        this.idCompany = id_company;
    }

    public String getCodigo_company() {
        return codigo_company;
    }

    public void setCodigo_company( String codigo_company) {
        this.codigo_company = codigo_company;
    }

    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public String getDescription_company() {
        return description_company;
    }

    public void setDescription_company(@NotEmpty(message = "The description can't be empty") String description_company) {
        this.description_company = description_company;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
