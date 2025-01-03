package com.example.api_client.api_client_ds.dto;

import com.example.api_client.api_client_ds.entities.Client;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private Double income;
    private Integer children;

    public ClientDTO() {}

    public ClientDTO(Long id, String name, String cpf, LocalDate birthDate, Double income, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.income = income;
        this.children = children;
    }
    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.birthDate = client.getBirthDate();
        this.income = client.getIncome();
        this.children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
