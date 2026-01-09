package com.hsf.dto;

import java.util.Set;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String winUser;
    private boolean active;
    private String firma;
    private String adresse;
    private String telefon;
    private String fax;
    private Set<String> groups;

    // Getters and setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getWinUser() {
        return winUser;
    }
    public void setWinUser(String winUser) {
        this.winUser = winUser;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String getFirma() {
        return firma;
    }
    public void setFirma(String firma) {
        this.firma = firma;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public Set<String> getGroups() {
        return groups;
    }
    public void setGroups(Set<String> groups) {
        this.groups = groups;
    }
}