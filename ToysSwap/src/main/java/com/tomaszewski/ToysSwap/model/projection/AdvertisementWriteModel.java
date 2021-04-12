package com.tomaszewski.ToysSwap.model.projection;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.math.BigDecimal;

public class AdvertisementWriteModel {
    private String title;
    private String description;
    private File photoFile;
    private String ageCategory;
    private BigDecimal price;
    private String city;
    private String category;
    private String brand;

    public AdvertisementWriteModel(String title, String description, File photoFile, String ageCategory, BigDecimal price, String city, String category, String brand) {
        this.title = title;
        this.description = description;
        this.photoFile = photoFile;
        this.ageCategory = ageCategory;
        this.price = price;
        this.city = city;
        this.category = category;
        this.brand = brand;
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

    public File getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(File photoFile) {
        this.photoFile = photoFile;
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
