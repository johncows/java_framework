package com.kk.controller;

import com.kk.entity.Employee;
import com.kk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/queryEmployee/{id}")
    public Employee queryEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeService.queryEmployeeById(id);
        return employee;
    }

    @RequestMapping("/updateEmployee/{id}")
    public Employee updateEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeService.updateEmployeeName("wang", 1);
        return employee;
    }

    @RequestMapping("/cleanCache/{id}")
    public String cleanEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "成功";
    }

}
