package com.example.demo.controller;

import com.example.demo.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    public String getProduct(@RequestParam String id){
        if("1".equals(id)){
            return "Product available"+ id;
        }else{
            throw new ProductNotFoundException("product not available" +id);
        }
    }

}
