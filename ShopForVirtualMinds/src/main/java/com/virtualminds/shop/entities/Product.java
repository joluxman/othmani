package com.virtualminds.shop.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by jocopernicus on 3/14/2017.
 */
@Entity
@Table(name="PRODUCTS")
public class Product implements Serializable {
    @Id
    @SequenceGenerator(
            name="PRODUCTS_SEQUENCE_GENERATOR",
            sequenceName="PRODUCTS_SEQ"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRODUCTS_SEQUENCE_GENERATOR")
    private Long idProduct;
    @NotEmpty
    @Size(min=5,max=15)
    private String name;
    private String description;
    private double price;
    private boolean selected;
    private int stockQuantity;
    private String photo;
    @ManyToOne
    @JoinColumn(name="idCategory")
    private Category category;

    public Product() {
    }

    public Product(String name, String description, double price, boolean selected, int stockQuantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.selected = selected;
        this.stockQuantity = stockQuantity;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
