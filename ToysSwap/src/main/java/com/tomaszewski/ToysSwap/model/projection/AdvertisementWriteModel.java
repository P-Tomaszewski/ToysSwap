package com.tomaszewski.ToysSwap.model.projection;

import com.tomaszewski.ToysSwap.model.User;

import java.math.BigDecimal;

public class AdvertisementWriteModel {
    private String title;
    private String description;
    private String photo;
    private String ageCategory;
    private BigDecimal price;
    private String city;
    private String category;
    private String brand;
    private User user;
    private String login;



    public AdvertisementWriteModel(String title, String description, String login, String photoFile, String ageCategory, BigDecimal price, String city, String category, String brand) {
        this.title = title;
        this.description = description;
        this.photo = photoFile;
        this.ageCategory = ageCategory;
        this.price = price;
        this.city = city;
        this.category = category;
        this.brand = brand;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
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

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
