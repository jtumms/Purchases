package com.tummsmedia;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by john.tumminelli on 10/24/16.
 */
@Controller
public class PurchasesApplicationController {
    @Autowired
    CustomerRepository customers;
    @Autowired
    PurchaseRepository purchases;

    @PostConstruct
    public void init()throws IOException {
        List<Customer> custList;
        custList = (List) customers.findAll();
        if (custList.isEmpty()) {
            File custFile = new File("customers.csv");
            Scanner fileScanner = new Scanner(custFile);
            int fileSize = (int) custFile.length();
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String content = fileScanner.nextLine();
                String[] fileSplit = content.split(",");
                Customer customer = new Customer(fileSplit[0], fileSplit[1]);
                customers.save(customer);
            }
        }
        List<Purchase> purchaseList;
        custList.clear();
        purchaseList = (List) purchases.findAll();
        custList = (List) customers.findAll();
        if (purchaseList.isEmpty() && (!custList.isEmpty())) {
            File purchaseFile = new File("purchases.csv");
            Scanner fileScanner = new Scanner(purchaseFile);
            int fileSize = (int) purchaseFile.length();
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String content = fileScanner.nextLine();
                String[] fileSplit = content.split(",");
                int fieldOne = Integer.parseInt(fileSplit[0]);
                Customer customer = customers.findFirstById(fieldOne);
                Purchase purchase = new Purchase(fileSplit[1], fileSplit[2], Integer.valueOf(fileSplit[3]), fileSplit[4], customer);
                purchases.save(purchase);
            }

        }
    }
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String category) {
        List<Purchase> purchaseList;
        if (category != null) {
            purchaseList = purchases.findByCategory(category);
        }
        else{
            purchaseList = (List<Purchase>) purchases.findAll();
        }
        model.addAttribute("purchases", purchaseList);
        return "home";
    }
}
