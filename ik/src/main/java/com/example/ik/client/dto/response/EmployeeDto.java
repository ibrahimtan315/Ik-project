package com.example.ik.client.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeDto {

    private Long id;

    private String name;
    private String lastName;

    private String email;

    private DepartmentDto department;

}
