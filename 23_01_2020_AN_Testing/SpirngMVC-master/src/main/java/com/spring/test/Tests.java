package com.spring.test;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.spring.data.DataManipulation;
import com.spring.model.Employee;



@RunWith(MockitoJUnitRunner.class)
public class Tests {
	@Mock
	DataManipulation temp = mock(DataManipulation.class);
	
	@Mock
	Employee employee;

	private Employee testEmp1 = new Employee("Aaryan", "Yerter", "aaryan@gmail.com", "2329991991");
	private Employee testEmp = new Employee();

	private List<Employee> employeeList = new ArrayList<>();

	@Test
	public void testEmployeeDao() throws SQLException {
		this.employeeList.add(new Employee("Omkar", "Raykar", "omkarraykar@gmail.com", "8874558746"));
		doAnswer(invocation -> {
			testEmp = (Employee) invocation;
			Assert.assertNotNull(this.testEmp.getId());
			return null;
		}).when(temp).saveOrUpdate(employee);


		when(temp.get(0)).thenReturn(this.testEmp1);
		when(temp.list()).thenReturn(this.employeeList);
		temp.saveOrUpdate(new Employee("Gaurav", "Yadav", "gaurav98yadav@gmail.com", "9665417664"));
		Employee employee = temp.get(0);
		List<Employee> list = temp.list();
		Assert.assertEquals(list.size(), 1);
	}

}