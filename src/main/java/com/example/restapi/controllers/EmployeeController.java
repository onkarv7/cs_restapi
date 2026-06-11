package com.example.restapi.controllers;

import com.example.restapi.dto.EmployeeDTO;
import com.example.restapi.entities.EmployeeEntity;
import com.example.restapi.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// req mapping, input and validations exception handling.
// ResponseBody body + controller
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping(path = "/")
    public String hello (){
        return "Hello World!";
    }

//    @GetMapping("/{employeeID}")
//    public EmployeeDTO getEmployeeById(@PathVariable Long employeeID){
//        return new EmployeeDTO(employeeID , "onkar", "ov@gmail.com", 27, LocalDate.of(1998, 10, 15),  true);
//    }

    @GetMapping("/{employeeID}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeID){
        return employeeRepository.findById(employeeID).orElse(null);
    }

//    @GetMapping
//    public String getEmployees(@RequestParam (required = false) Integer age,
//                               @RequestParam (required = false) String sortBy){
//        return  "age is " + age + sortBy;
//    }

    @GetMapping
    public List<EmployeeEntity> getEmployees(@RequestParam (required = false) Integer age,
                                             @RequestParam (required = false) String sortBy){
        return  employeeRepository.findAll();
    }


//    @PostMapping
//    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee){
//        employee.setId(100L);
//        return employee;
//    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee){
        return employeeRepository.save(employee);
    }
}
