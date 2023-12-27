package com.devpob.learnspringframework02.examples.c1.services;

import java.util.Arrays;

// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Component
@Service
public class BusinessCalculationService {
    DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return this.dataService;
    }

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}