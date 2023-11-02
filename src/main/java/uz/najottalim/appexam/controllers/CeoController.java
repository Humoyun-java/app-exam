package uz.najottalim.appexam.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.appexam.entity.Employee;
import uz.najottalim.appexam.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("/ceo")
public class CeoController {
    private final EmployeeService employeeService;

    public CeoController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/late-employee")
    public List<Employee> findLateEmployee(){
        return employeeService.findLateEmployee();
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.findEmployee();
    }
}
