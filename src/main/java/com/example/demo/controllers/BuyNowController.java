package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 *
 *
 */

@Controller
public class BuyNowController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") Long theId, Model theModel) {
        Product productBuy = productRepository.findById(theId).orElse(null);

        if (productBuy != null) {
            if (productBuy.getInv() > 0) {
                productBuy.setInv(productBuy.getInv() - 1);
                productRepository.save(productBuy);
                return "/buysuccess";
            } else {
                return "/buyfail";
            }
        } else {
            return "/buyfail";
        }
    }
}
