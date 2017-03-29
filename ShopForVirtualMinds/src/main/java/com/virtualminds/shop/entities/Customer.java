package com.virtualminds.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by jocopernicus on 3/14/2017.
 */
@Entity
@Table(name="CUSTOMERS")
public class Customer implements Serializable{
    @Id
    @SequenceGenerator(
            name="CUSTOMERS_SEQUENCE_GENERATOR",
            sequenceName="CUSTOMERS_SEQ"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CUSTOMERS_SEQUENCE_GENERATOR")
    private Long idCustomer;
    private String name;
    private String address;
    private String email;
    private String tel;
    @OneToMany(mappedBy = "customer")
    private Collection<Order> orders;

    public Customer() {
    }

    public Customer(String name, String address, String email, String tel) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.tel = tel;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}
