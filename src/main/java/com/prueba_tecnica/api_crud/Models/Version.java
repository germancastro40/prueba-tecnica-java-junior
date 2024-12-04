package com.prueba_tecnica.api_crud.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "version")
@Builder
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "version_id")
    private int version_id;

    @ManyToOne
    @JoinColumn(name = "app_id", nullable = false)
    private Application application;

    @Column(unique = true, nullable = false, name = "version")
    @NotEmpty(message = "The version can't be empty")
    private String version;

    @Column(name = "version_description", nullable = false)
    @NotEmpty(message = "The version_description can't be empty")
    private String version_description;

    public Version(String version, Integer version_id, String version_description) {
        this.version = version;
        this.version_id = version_id;
        this.version_description = version_description;
    }

    public Version(){}

    public Integer getVersion_id() {
        return version_id;
    }

    public void setVersion_id(Integer version_id) {
        this.version_id = version_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion_description() {
        return version_description;
    }

    public void setVersion_description(String version_description) {
        this.version_description = version_description;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
