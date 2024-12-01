package com.example.demo.controller;

import com.example.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {
    @Autowired
    private RecordService recordService;

    public void processRecord(@RequestParam(defaultValue = "100") int batchSize){
        recordService.allRecordProcess(batchSize);
    }
}
