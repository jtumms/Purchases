package com.tummsmedia;

import javax.persistence.*;

/**
 * Created by john.tumminelli on 10/24/16.
 */
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String cardNumber;

    @Column(nullable = false)
    int cvv;

    @Column(nullable = false)
    String category;

    @ManyToOne
    Customer customer;

    public Purchase() {
    }

    public Purchase(String date, String cardNumber, int cvv, String category, Customer customer) {
        this.date = date;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
    }

//    public Purchase(int id, String date, String cardNumber, int cvv, String category, Customer customer) {
//        this.id = id;
//        this.date = date;
//        this.cardNumber = cardNumber;
//        this.cvv = cvv;
//        this.category = category;
//        this.customer = customer;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
