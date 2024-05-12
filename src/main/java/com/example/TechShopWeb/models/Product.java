package com.example.TechShopWeb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private int productId;
    private String name;
    private String type;
    private String shelving;
    private int launchYear;

    public enum Shelving {
        RED("red"),
        GREEN("green"),
        BLUE("blue"),
        YELLOW("yellow"),
        WHITE("white"),
        BLACK("black");

        private String value;

        Shelving(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.getValue();
        }
    }

    public Product(int id, String name, String type, String shelving, int launchYear) {
        this.productId = id;
        this.name = name;
        this.type = type;
        this.shelving = shelving;
        this.launchYear = launchYear;
    }

    public Product(String name, String type, String shelving, int launchYear) {
        this.name = name;
        this.type = type;
        this.shelving = shelving;
        this.launchYear = launchYear;
    }

    public Product() {}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShelving() {
        return shelving;
    }

    public void setShelving(String shelving) {
        this.shelving = shelving;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", shelving='" + shelving + '\'' +
                ", launchYear=" + launchYear +
                '}';
    }
}
