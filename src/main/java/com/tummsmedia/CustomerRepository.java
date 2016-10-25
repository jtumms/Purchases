package com.tummsmedia;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by john.tumminelli on 10/24/16.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findFirstById(int id);

}
