package uz.najottalim.appexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "employee_id")
    Employee employee;
    LocalDate visited;
    LocalDate leaved;
    Integer late;
}
