package uz.najottalim.appexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.najottalim.appexam.entity.Statistic;

import java.util.List;


public interface StatisticRepository extends JpaRepository<Statistic, Long> {
    @Query(value = "select sum(late) from statistic group by employee having employee=?1")
    Integer findSumLate(Long employeeId);

    @Query(value = "select employee,visit,late from statistic group by employee having employee=?1")
    List<Statistic> findStatisticByEmployeeId(Long employeeId);
}
