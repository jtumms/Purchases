package com.tummsmedia;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by john.tumminelli on 10/24/16.
 */
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
    List<Purchase> findByCategory(String category);

}
