package uz.najottalim.appexam.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.appexam.entity.Employee;
import uz.najottalim.appexam.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("/head-department")
public class HeadDepartmentController {
    private final EmployeeService myService;

    public HeadDepartmentController(EmployeeService myService) {
        this.myService = myService;
    }

    @GetMapping("/employee/{departmentName}")
    public List<Employee> findEmployeeDepartment(@PathVariable String departmentName){
        return myService.findEmployeeByDepartment(departmentName);
    }

    @GetMapping("/statistic/{departmentName}")
    public List<Employee> findLateEmployeeDepartment(@PathVariable String departmentName){
        return myService.findLateEmployeeDepartment(departmentName);
    }
}
