package uz.najottalim.appexam.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.appexam.entity.Employee;
import uz.najottalim.appexam.entity.Statistic;
import uz.najottalim.appexam.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/statistics/{id}")
    public List<Statistic> findStatistics(@PathVariable Long id){
        return employeeService.findStatistics(id);
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployeeById(@PathVariable Long id){
        return employeeService.findEmployeeByID(id);
    }

}
