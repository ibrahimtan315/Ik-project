package com.example.ik.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Table(name = "Expenses")
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "employees_to_expense",
//    joinColums = @JoinColumn(name = "expense_id", referencedColumnName = "expense_id", nullable = false, updatable = false),
//    inverseJoin)
//    public Set<Employee> employees = new HashSet<>();

}
