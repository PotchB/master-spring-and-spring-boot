package com.devpob.springboot.simplerestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devpob.springboot.simplerestapi.config.CurrencyServiceConfiguration;

@RestController
public class CurrencyConfigurationController {
    
    @Autowired
    CurrencyServiceConfiguration config;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveConfiguration() {
        return config;
    }
}
