package com.springau.service;

import java.util.ArrayList;
import java.util.List;

import com.springau.model.Employee;

public class EmployeeService {

	List<Employee>emp=new ArrayList<Employee>();
	public void getAllEmployees()
	{
		System.out.println("Method  getAllEmployees() called");
		for(Employee e:emp)
			System.out.println(e);
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "EmployeeService [emp=" + emp + "]";
	}

}
