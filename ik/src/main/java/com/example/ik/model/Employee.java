package com.example.ik.model;


import com.example.ik.model.enums.Department;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
@ToString
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String tc;

    private LocalDate birthDate;

    // starting job of date
    private LocalDate dateOfCommencement;

    private String email;

    private String phoneNumber;

    // payment
    private String paying;

    @Enumerated
    private Department department;

//    @OneToMany(mappedBy = "employees", fetch = FetchType.LAZY)
//    public Set<Expense> expenses = new HashSet<>();

}
