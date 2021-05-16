package com.tomaszewski.ToysSwap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tomaszewski.ToysSwap.enums.AgeCategory;
import com.tomaszewski.ToysSwap.enums.Brand;
import com.tomaszewski.ToysSwap.enums.ProductCategory;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String photo;
    @NotEmpty
    private String ageCategory;
    @NotNull
    private BigDecimal price;
    @NotEmpty
    private String city;
    @NotEmpty
    private String category;
    @NotEmpty
    private String brand;
    @JsonIgnore
    @ManyToOne()
//    @JoinColumn("user_id")
    User user;

    public Advertisement(String title, String description, String ageCategory, BigDecimal price,
                         String country, String category, String brand, String photo, User user) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.ageCategory = ageCategory;
        this.price = price;
        this.city = country;
        this.category = category;
        this.brand = brand;
        this.user = user;
    }

    public Advertisement() {

    }

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand.getDisplayValue();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory.getDisplayValue();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String country) {
        this.city = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category.getDisplayValue();
    }
}
