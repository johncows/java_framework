package com.kk.service.impl;

import com.kk.entity.Employee;
import com.kk.mapper.EmployeeMapper;
import com.kk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
//@CacheConfig(cacheNames = "empl" )
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    @Cacheable(cacheNames = "empl",keyGenerator = "myKeyGenerator")  //将方法返回结果作为缓存
    public Employee queryEmployeeById(Integer id) {
        Employee employee = employeeMapper.queryEmployeeById(id);
        System.out.println("执行了一次查询 职员id为"+id);
        return employee;
    }

    @Caching(
            cacheable = {@Cacheable(keyGenerator = "myKeyGenerator",cacheNames = "empl")},
            put = {
                    @CachePut(cacheNames ="empl",key = "#result.id"),
                    @CachePut(cacheNames ="empl",key = "#result.email")
            }
    )
    public Employee updateEmployeeName(String name,Integer id){
        Employee employee = employeeMapper.queryEmployeeById(id);
        employee.setLastName(name);
        employee.setGender(employee.getGender()==1?0:1);
        employeeMapper.updateEmployeeById(employee);
        return employeeMapper.queryEmployeeById(id);
    }

    @CacheEvict(cacheNames = "empl",keyGenerator = "myKeyGenerator",allEntries = true,beforeInvocation = true)
    public boolean deleteEmployee(Integer id){
        System.out.println("删除职员"+id);
        return true;
    }





}
