package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ApiService {
    public CompletableFuture<String> fetchApi1(){
        try{
            Thread.sleep(100);
            return CompletableFuture.completedFuture("Api1");
        }catch (InterruptedException e){
            return CompletableFuture.failedFuture(new RuntimeException("error api 1"));
        }
    }

    @Async
    public CompletableFuture<String> fetchApi2(){
        try{
            Thread.sleep(500);
            return CompletableFuture.completedFuture("Api2");
        }catch (InterruptedException e){
            return  CompletableFuture.failedFuture(new RuntimeException("error api 2"));
        }
    }

    public String fetchDataBoth(){
        CompletableFuture<String> api1=fetchApi1();
        CompletableFuture<String> api2=fetchApi2();
        return CompletableFuture.allOf(api1,api2).thenApplyAsync(e->{
            try{
                String api1data=api1.get();
                String api2data=api2.get();
                return api1data+"  -  "+api2data;
            }catch(InterruptedException eec){
                throw  new RuntimeException("error both", eec);
            } catch (ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        }).join();
    }
}
