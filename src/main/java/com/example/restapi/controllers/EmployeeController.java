package com.example.restapi.controllers;

import com.example.restapi.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

// req mapping, input and validations exception handling.
// ResponseBody body + controller
@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @GetMapping(path = "/")
    public String hello (){
        return "Hello World!";
    }

    @GetMapping("/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeID){
        return new EmployeeDTO(employeeID , "onkar", "ov@gmail.com", 27, LocalDate.of(1998, 10, 15),  true);
    }

    @GetMapping
    public String getEmployees(@RequestParam (required = false) Integer age,
                               @RequestParam (required = false) String sortBy){
        return  "age is " + age + sortBy;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee){
        employee.setId(100L);
        return employee;
    }
}
