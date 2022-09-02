package com.computime.assessment.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerData {
    
    private String customerId;
    
    private String customerName;
    
    private String dateOfBirth;
    
    private String country;
    
    private String nationality;
    
    private Boolean ageVerified;
    
    private String sourceOfFunds;
    
    private String idExpiry;
    
    private String customerType;
    
    private String expectedIncome;

}
