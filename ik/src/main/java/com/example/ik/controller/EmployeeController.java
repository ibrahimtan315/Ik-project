package com.example.ik.controller;

import com.example.ik.client.dto.request.CreateEmployeeRequest;
import com.example.ik.client.dto.request.UpdateEmployeeRequest;
import com.example.ik.client.dto.response.EmployeeDto;
import com.example.ik.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //create employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody CreateEmployeeRequest employeeRequest){
        return ResponseEntity.ok(employeeService.createEmployee(employeeRequest));
    }

    //delete employee
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    //update employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
                                                      @RequestBody UpdateEmployeeRequest employeeRequest){
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeRequest));
    }

    //izin al
    //izin sil
    //izin degis

    //harcama gir
    //harcama sil
    //harcama guncelle

}
