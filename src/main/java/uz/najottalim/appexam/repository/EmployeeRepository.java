package uz.najottalim.appexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.najottalim.appexam.entity.Employee;


import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select department, ID, name, surname from Employee where department=?1")
    List<Employee> findAllByDepartment(String departmentName);
}
