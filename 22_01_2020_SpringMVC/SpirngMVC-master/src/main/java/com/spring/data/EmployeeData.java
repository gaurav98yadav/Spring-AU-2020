package com.spring.data;
import com.spring.model.Employee;
import java.util.List;

public interface EmployeeData {

    public void saveOrUpdate(Employee employee);
    
    public void delete(int employeeId);
     
    public Employee get(int employeeId);
     
    public List<Employee> list();
	
}