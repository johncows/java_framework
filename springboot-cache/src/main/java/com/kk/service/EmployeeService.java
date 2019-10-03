package com.kk.service;

import com.kk.entity.Employee;

public interface EmployeeService {
    Employee queryEmployeeById(Integer id);
    Employee updateEmployeeName(String name,Integer id);
    boolean deleteEmployee(Integer id);
}
