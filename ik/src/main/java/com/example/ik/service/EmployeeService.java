package com.example.ik.service;

import com.example.ik.client.dto.request.CreateEmployeeRequest;
import com.example.ik.client.dto.request.UpdateEmployeeRequest;
import com.example.ik.client.dto.response.EmployeeDto;
import com.example.ik.exception.EmployeeNotFoundException;
import com.example.ik.mapper.EmployeeMapper;
import com.example.ik.model.Employee;
import com.example.ik.model.enums.Department;
import com.example.ik.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    //create employee
    public EmployeeDto createEmployee(CreateEmployeeRequest employeeRequest){

        Employee employee = employeeMapper.toEmployeeFromCreateEmployeeRequest(employeeRequest);

        return employeeMapper.toEmployeeDto(employeeRepository.save(employee));
    }

    //delete employee
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    //update employee (we can changes; name, last name, phone number, paying and department)
    public EmployeeDto updateEmployee(Long id, UpdateEmployeeRequest employeeRequest){

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        employeeOptional.ifPresent(employee -> {
            employee.setName(employeeRequest.getName());
            employee.setLastName(employeeRequest.getLastName());
            employee.setPhoneNumber(employeeRequest.getPhoneNumber());
            employee.setPaying(employeeRequest.getPaying());
            employee.setDepartment(Department.valueOf(employeeRequest.getDepartment().name()));
            employeeRepository.save(employee);
        });

        return employeeOptional.map(employeeMapper::toEmployeeDto)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found!"));
    }


    //izin al
    //izin sil

    //harcama gir
    //harcama sil


}
