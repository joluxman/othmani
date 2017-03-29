package com.virtualminds.shop.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jocopernicus on 3/14/2017.
 */
@Entity
@Table(name="ORDERLINES")
public class OrderLine implements Serializable {
    @Id
    @SequenceGenerator(
            name="ORDERLINES_SEQUENCE_GENERATOR",
            sequenceName="ORDERLINES_SEQ"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ORDERLINES_SEQUENCE_GENERATOR")
    private Long idOrderLine;
    @ManyToOne
    @JoinColumn(name="idProduct")
    private Product product;
    private int quantity;
    private double price;
    @ManyToOne
    @JoinColumn(name="idOrder")
    private Order order;

    public OrderLine() {
    }

    public OrderLine(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Long getIdOrderLine() {
        return idOrderLine;
    }

    public void setIdOrderLine(Long idOrderLine) {
        this.idOrderLine = idOrderLine;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
