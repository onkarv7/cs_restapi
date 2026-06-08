package com.example.restapi.controllers;

import com.example.restapi.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

// req mapping, input and validations exception handling.
// ResponseBody body + controller
@RestController
public class EmployeeController {


    @GetMapping(path = "/")
    public String hello (){
        return "Hello World!";
    }

    @GetMapping("/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeID){
        return new EmployeeDTO(employeeID , "onkar", "ov@gmail.com", 27, LocalDate.of(1998, 10, 15),  true);
    }

}
