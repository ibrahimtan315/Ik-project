package com.example.ik.client.dto.response.base;

import com.example.ik.client.dto.response.DepartmentDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class BaseEmployeeRequest {

    @NotBlank(message = "Name can not empty")
    private String name;

    @NotBlank(message = "Last name con not empty")
    private String lastName;

    @Size(min = 10, max = 12, message = "TC must be 11 numbers")
    private String tc;

    public String getTc() {
        return tc;
    }

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfCommencement;

    @Email(regexp = "^(.+)@(.+)$", message = "Email is not valid. Please follow the example: turkcell@mail.com")
    @NotBlank(message = "Email must not be null")
    private String email;

    @Size(min = 10, max = 12, message = "Phone number must be 11 numbers like 0(...) ... .. ..")
    private String phoneNumber;

    private String paying;

    private DepartmentDto department;


}
