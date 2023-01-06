package com.example.ik.mapper;

import com.example.ik.client.dto.request.CreateEmployeeRequest;
import com.example.ik.client.dto.response.EmployeeDto;
import com.example.ik.model.Employee;
import org.mapstruct.Mapper;

@Mapper(implementationName = "EmployeeMapperImpl", componentModel = "spring")
public interface EmployeeMapper {

    Employee toEmployee(EmployeeDto employeeDto);

    EmployeeDto toEmployeeDto(Employee employee);

    Employee toEmployeeFromCreateEmployeeRequest(CreateEmployeeRequest employeeRequest);

}
