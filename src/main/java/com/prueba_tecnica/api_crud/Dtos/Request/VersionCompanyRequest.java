package com.prueba_tecnica.api_crud.Dtos.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class VersionCompanyRequest {
    @Min(value = 1, message = "The min value for company_id is 1")
    private int company_id;

    @Min(value = 1, message = "The min value for version_id is 1")
    private int version_id;

    @NotEmpty(message = "The version_company_description can't be empty ")
    private String version_company_description;

    public VersionCompanyRequest(int company_id, int version_id, String version_company_description) {
        this.company_id = company_id;
        this.version_id = version_id;
        this.version_company_description = version_company_description;
    }

    @Min(value = 1, message = "The min value for company_id is 1")
    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(@Min(value = 1, message = "The min value for company_id is 1") int company_id) {
        this.company_id = company_id;
    }

    @Min(value = 1, message = "The min value for version_id is 1")
    public int getVersion_id() {
        return version_id;
    }

    public void setVersion_id(@Min(value = 1, message = "The min value for version_id is 1") int version_id) {
        this.version_id = version_id;
    }

    public @NotEmpty(message = "The version_company_description can't be empty ") String getVersion_company_description() {
        return version_company_description;
    }

    public void setVersion_company_description(@NotEmpty(message = "The version_company_description can't be empty ") String version_company_description) {
        this.version_company_description = version_company_description;
    }
}
