package com.tomaszewski.ToysSwap.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "imie nie moze byc puste")
    private String login;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    private String name;
    private String lastName;
    private String city;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver", orphanRemoval = true)
//    private List<Advertisement> advertisements;

    public User(String login, String password, String email, String name) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

//    public List<Advertisement> getAdvertisements() {
//        return advertisements;
//    }
//
//    public void setAdvertisements(List<Advertisement> advertisements) {
//        this.advertisements = advertisements;
//    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
