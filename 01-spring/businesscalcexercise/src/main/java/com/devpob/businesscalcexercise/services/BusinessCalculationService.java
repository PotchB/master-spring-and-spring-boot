package com.devpob.businesscalcexercise.services;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {
    private DataService dataService;

    public BusinessCalculationService(/* @Qualifier("mySQLDataService")  */DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}