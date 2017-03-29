package com.virtualminds.shop.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by jocopernicus on 3/14/2017.
 */
@Entity
@Table(name="CATEGORIES")
public class Category implements Serializable {
    @Id
    @SequenceGenerator(
            name="CATEGORIES_SEQUENCE_GENERATOR",
            sequenceName="CATEGORIES_SEQ"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CATEGORIES_SEQUENCE_GENERATOR")
    private Long idCategory;
    @NotEmpty
    @Size(min=4,max=15)
    private String name;
    private String description;
    @Lob
    private byte[] photo;
    private String photoName;
    @OneToMany(mappedBy = "category")
    private Collection<Product> products;

    public Category() {
    }

    public Category(String name, String description, byte[] photo, String photoName) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.photoName = photoName;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
