package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.spring.dao.EmployeeDAO;
import com.spring.entity.Employee;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDao;
	
	@RequestMapping(value="/employee", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addEmployee(@RequestBody Employee employee) {
		employeeDao.save(employee);
		return "{ \"result\": \"Success\"}";
	}
}
