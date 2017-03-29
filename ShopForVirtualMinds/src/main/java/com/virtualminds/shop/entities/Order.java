package com.virtualminds.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by jocopernicus on 3/14/2017.
 */
@Entity
@Table(name="ORDERS")
public class Order implements Serializable {
    @Id
    @SequenceGenerator(
            name="ORDERS_SEQUENCE_GENERATOR",
            sequenceName="ORDERS_SEQ"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ORDERS_SEQUENCE_GENERATOR")
    private Long idOrder;
    private Date dateOrder;
    @OneToMany(mappedBy = "order")
    private Collection<OrderLine> orderLines;
    @ManyToOne
    @JoinColumn(name="idCustomer")
    private Customer customer;

    public Order() {
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Collection<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Collection<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
