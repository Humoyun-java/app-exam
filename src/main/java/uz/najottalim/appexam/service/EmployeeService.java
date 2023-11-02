package uz.najottalim.appexam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najottalim.appexam.entity.Employee;
import uz.najottalim.appexam.entity.Statistic;
import uz.najottalim.appexam.repository.EmployeeRepository;
import uz.najottalim.appexam.repository.StatisticRepository;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final StatisticRepository statisticRepository;
    private final EmployeeRepository employeeRepository;
    private EntityManager entityManager;


    public void setSalary() {
        List<Employee> employees = employeeRepository.findAll();

        employees = employees.stream().map((employee) -> {
            Long salary = employee.getSalary();
            double minuteSalary = salary / 20 / 8 / 60;
            double lateMinut = statisticRepository.findSumLate(employee.getID());
            double fine = salary - minuteSalary * lateMinut;
            salary = (long) (salary - fine);
            employee.setSalary(salary);
            return employee;
        }).collect(Collectors.toList());
    }

    public List<Statistic> findAllStatistics() {
        return statisticRepository.findAll();
    }


    public List<Statistic> findStatistics(Long employeeId) {
        return statisticRepository.findStatisticByEmployeeId(employeeId);
    }


    public List<Employee> findEmployee() {
        return employeeRepository.findAll();
    }


    public Employee findEmployeeByID(Long id) {
        return employeeRepository.findById(id).get();
    }


    public List<Employee> findEmployeeByDepartment(String department) {
        return employeeRepository.findAllByDepartment(department);
    }


    public List<Employee> findLateEmployee() {
        String query = "select e.ID, e.name, s.late from Employee e, Statistic s " + "where s.late>0";
        return entityManager.createQuery(query, Employee.class).getResultList();
    }


    public List<Employee> findLateEmployeeDepartment(String departmentName) {
        String query = String.format("select e.ID, e.name, s.late from Employee e, Statistic s " + "where s.late>0 and " + "e.department=%s", departmentName);
        return entityManager.createQuery(query, Employee.class).getResultList();
    }

    public List<Employee> findMonthStatistics() {
        String query = "select e.ID, sum(s.late) from Employee e, Statistic s " + "group by e.ID";
        return entityManager.createQuery(query, Employee.class).getResultList();
    }
}
