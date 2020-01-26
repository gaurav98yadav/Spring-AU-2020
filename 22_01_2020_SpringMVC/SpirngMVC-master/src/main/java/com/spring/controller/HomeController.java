package com.spring.controller;

import java.io.IOException;   
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.data.EmployeeData;
import com.spring.model.Employee;


@Controller
public class HomeController {
	 @Autowired
	    private EmployeeData ed;
	 
	 @RequestMapping(value="/home")
	 public ModelAndView listEmployee(ModelAndView model) throws IOException{
	     List<Employee> listEmployee = ed.list();
	     model.addObject("listEmployee", listEmployee);
	     model.setViewName("home");
	  
	     return model;
	 }
	
	 @RequestMapping(value = "/EmployeeForm", method = RequestMethod.GET)
	 public ModelAndView newEmployee(ModelAndView model) {
	     Employee newEmployee = new Employee();
	     model.addObject("employee", newEmployee);
	     model.setViewName("EmployeeForm");
	     return model;
	 }
	 
	 @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	 public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
	     ed.saveOrUpdate(employee);
	     
	     return new ModelAndView("redirect:/");
	 }
	 
	 @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	 public ModelAndView deleteEmployee(HttpServletRequest request) {
	     int employeeId = Integer.parseInt(request.getParameter("id"));
	     ed.delete(employeeId);
	     
	     return new ModelAndView("redirect:/");
	 }
	 
	 @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	 public ModelAndView editEmployee(HttpServletRequest request) {
	     int employeeId = Integer.parseInt(request.getParameter("id"));
	     Employee employee = ed.get(employeeId);
	     ModelAndView model = new ModelAndView("EmployeeForm");
	     model.addObject("employee", employee);
	  
	     return model;
	 }
	 @ExceptionHandler(Exception404.class)
	 public String urlNotFound() {
	 return "404";
	 }

	 @RequestMapping("**")
	 public void notFoundError(ModelAndView modelAndView) {
	 throw new Exception404();

	 }
}