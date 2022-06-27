package com.example.runwayimport.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String login;

    public AccountDTO() {

    }

    public AccountDTO(final Integer id, final String firstName, final String lastName,
            final String fullName, final String email, final String login) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.email = email;
        this.login = login;
    }

    public Integer getId() {
        return this.id;
    }

    public AccountDTO setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public AccountDTO setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return this.lastName;
    }

    public AccountDTO setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFullName() {
        return this.fullName;
    }

    public AccountDTO setFullName(final String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public AccountDTO setEmail(final String email) {
        this.email = email;
        return this;
    }

    public String getLogin() {
        return this.login;
    }

    public AccountDTO setLogin(final String login) {
        this.login = login;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AccountDTO)) {
            return false;
        }
        AccountDTO accountTO = (AccountDTO) o;
        return Objects.equals(id, accountTO.id) &&
                Objects.equals(firstName, accountTO.firstName) &&
                Objects.equals(lastName, accountTO.lastName) &&
                Objects.equals(fullName, accountTO.fullName) &&
                Objects.equals(email, accountTO.email) && Objects.equals(login, accountTO.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, fullName, email, login);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", email='" + getEmail() + "'" +
            ", login='" + getLogin() + "'" +
            "}";
    }

}
