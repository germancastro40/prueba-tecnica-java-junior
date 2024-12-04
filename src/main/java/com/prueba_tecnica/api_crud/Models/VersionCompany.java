package com.prueba_tecnica.api_crud.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "version_company")
public class VersionCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_company_id")
    private int version_company_id;

    @ManyToOne()
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne()
    @JoinColumn(name = "version_id", nullable = false)
    private Version version;

    @NotNull(message = "the version_company_description can't be null")
    private String version_company_description;

    public VersionCompany(int version_company_id, String version_company_description) {
        this.version_company_id = version_company_id;
        this.version_company_description = version_company_description;
    }

    public VersionCompany(){}

    public int getVersion_company_id() {
        return version_company_id;
    }

    public void setVersion_company_id(int version_company_id) {
        this.version_company_id = version_company_id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public @NotNull(message = "the version_company_description can't be null") String getVersion_company_description() {
        return version_company_description;
    }

    public void setVersion_company_description(@NotNull(message = "the version_company_description can't be null") String version_company_description) {
        this.version_company_description = version_company_description;
    }
}
