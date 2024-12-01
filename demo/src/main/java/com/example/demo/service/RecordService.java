package com.example.demo.service;

import ch.qos.logback.core.CoreConstants;
import com.example.demo.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    public List<Record> fetchRecord(int pageNum,int pageSize){
        PageRequest pageable= PageRequest.of(pageNum,pageSize);
        return recordRepository.findAll(pageable).getContent();
    }
    public void allRecordProcess(int batchSize){
        int pageNum=0;
        while (true){
            List<Record> records = fetchRecord(pageNum, batchSize);
            if(records.isEmpty())
                break;

            records.forEach(record -> {
                System.out.println(record);
            });
            pageNum++;
        }
    }
}
