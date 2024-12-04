package com.prueba_tecnica.api_crud.Dtos.Response;

import jakarta.validation.constraints.Min;

public class CompanyCodeResponse {
    private int company_code;
    private String company_name;
    private String app_name;
    private String version;

    public CompanyCodeResponse(){}

    public CompanyCodeResponse(int company_code, String company_name, String app_name, String version) {
        this.company_code = company_code;
        this.company_name = company_name;
        this.app_name = app_name;
        this.version = version;
    }

    public int getCompany_code() {
        return company_code;
    }

    public void setCompany_code(int company_code) {
        this.company_code = company_code;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
