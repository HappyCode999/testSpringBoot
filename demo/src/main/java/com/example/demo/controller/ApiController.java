package com.example.demo.controller;

import com.example.demo.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    private ApiService apiService;

    public String getDataFromBothApi(){
        return apiService.fetchDataBoth();
    }
}
