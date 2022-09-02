package com.computime.assessment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.computime.assessment.model.CustomerData;
import com.computime.assessment.service.ApplicationService;

@RestController
@RequestMapping("/customers")
public class ApplicationController {
    
    @Autowired
    public ApplicationService appService;
    
    @GetMapping(value = "/metadata")
    public Object customerMetadata() {
        return appService.customerMetadata();
    }
    
    @GetMapping(value = "/list")
    public Object customerData() {
        return appService.customerData();
    }
    
    @PostMapping("/{customerId}")
    public String updateCustomerData(@PathVariable("customerId") String customerId,@RequestBody CustomerData customerData) {
        return appService.updateCustoemrData(customerId, customerData).toString();
    }
    
}
