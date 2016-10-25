package com.tummsmedia;

import javax.persistence.*;

/**
 * Created by john.tumminelli on 10/24/16.
 */
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable =  false)
    String name;

    @Column(nullable =  false)
    String email;

    public Customer() {
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Customer(int id, String name, String email) {

    }

    public Customer(Customer firstById) {
    }
}
