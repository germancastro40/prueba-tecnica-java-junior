package com.prueba_tecnica.api_crud.Dtos.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class VersionRequest {
    @NotNull(message = "The app_id can't be null")
    @Min(value = 1, message = "The min value for app_id would be 1")
    private int app_id;
    @NotEmpty(message = "The version can't be emty")
    private String version;
    @NotEmpty(message = "The version_description can't be emty")
    private String version_description;

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
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
}
