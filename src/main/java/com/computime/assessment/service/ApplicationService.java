package com.computime.assessment.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import com.computime.assessment.model.CustomerData;

@Service
public class ApplicationService {
    
    String path = Paths.get("").toAbsolutePath().toString();
    List<CustomerData> customerData = new ArrayList<CustomerData>();;
    
    public Object customerMetadata() {
        try {
            JSONParser customDataStructure = new JSONParser(new FileReader(path + "\\CustomerDataStructure.json.txt"));
            return customDataStructure.parse();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("Something wrong with the inputs in the file.");
            e.printStackTrace();
        }
        return null;
    }

    public Object customerData() {
        try {
            customerData.clear();
            File customerDataTxt = new File(path+ "\\CustomerData.txt");
            Scanner readCustomerData = new Scanner(customerDataTxt);
            while(readCustomerData.hasNextLine()) {
                String customerDataEachLine = readCustomerData.nextLine();
//                System.out.println(" test " +customerDataEachLine.replace("|", " "));
//                String replaceCommaInCustomerData = customerDataEachLine.replace(",", " ");
//                String replaceDashInCustomerData = replaceCommaInCustomerData.replace("|", ",");
                String[] splitCustomerData = customerDataEachLine.split("\\|");
                customerData.add(CustomerData.builder()
                        .customerId((splitCustomerData[0]))
                        .customerName(splitCustomerData[1])
                        .dateOfBirth(splitCustomerData[2])
                        .country(splitCustomerData[3])
                        .nationality(splitCustomerData[4])
                        .ageVerified(Boolean.parseBoolean(splitCustomerData[5]))
                        .sourceOfFunds(splitCustomerData[6])
                        .idExpiry(splitCustomerData[7])
                        .customerType(splitCustomerData[8])
                        .expectedIncome((splitCustomerData[9]))
                        .build());
                    }
            return customerData;
        } catch (FileNotFoundException e) {
          System.out.println("File not found.");
          e.printStackTrace();
      }   
        return null;

    }

    public CustomerData updateCustoemrData(String custdId, CustomerData custData) {
       customerData.forEach(customer ->
        {
            if (customer.getCustomerId().equals(custdId)) {
                customer.setAgeVerified(custData.getAgeVerified());
                customer.setSourceOfFunds(custData.getSourceOfFunds());
                customer.setCustomerType(custData.getCustomerType());
                customer.setExpectedIncome(custData.getExpectedIncome());  
            } 
        });
       System.out.println(" updated data " +custData.toString());
        return custData;
    }

}
