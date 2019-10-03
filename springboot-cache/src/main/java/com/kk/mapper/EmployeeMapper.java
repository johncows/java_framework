package com.kk.mapper;

import com.kk.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee queryEmployeeById(Integer id);


    @Insert("insert into employee(lastName,email,gender,d_Id) values(#{lastName},#{email},#{gender},#{dId})")
    boolean insertEmployee(Employee employee);

    @Update("update  employee set lastName=#{lastName},gender=#{gender} where id=#{id}")
    int updateEmployeeById(Employee employee);

}
