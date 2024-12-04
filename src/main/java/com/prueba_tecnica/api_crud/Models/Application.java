package com.prueba_tecnica.api_crud.Models;

import com.prueba_tecnica.api_crud.Utils.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Integer id;

    @NotEmpty(message = "The app_code can't be empty")
    @Column(unique = true, name = "app_code")
    private String app_code;

    @NotEmpty(message = "The app_name can't be empty")
    @Column(name = "app_name", unique = true)
    private String app_name;

    @NotEmpty(message = "The app_description can't be empty")
    @Column(name = "app_description")
    private String app_description;

    @Enumerated(value = EnumType.STRING)
    private State state;

    public Application(Integer id, String app_code, String app_name, String app_description, State state) {
        this.id = id;
        this.app_code = app_code;
        this.app_name = app_name;
        this.app_description = app_description;
        this.state = state;
    }

    public Application(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "The app_code can't be empty") String getApp_code() {
        return app_code;
    }

    public void setApp_code(@NotEmpty(message = "The app_code can't be empty") String app_code) {
        this.app_code = app_code;
    }

    public @NotEmpty(message = "The app_name can't be empty") String getApp_name() {
        return app_name;
    }

    public void setApp_name(@NotEmpty(message = "The app_name can't be empty") String app_name) {
        this.app_name = app_name;
    }

    public @NotEmpty(message = "The app_description can't be empty") String getApp_description() {
        return app_description;
    }

    public void setApp_description(@NotEmpty(message = "The app_description can't be empty") String app_description) {
        this.app_description = app_description;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}