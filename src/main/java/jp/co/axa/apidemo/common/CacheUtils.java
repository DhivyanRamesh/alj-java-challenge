package jp.co.axa.apidemo.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;

@Component
public class CacheUtils {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@CacheEvict(value="Employee_Cache", key="'messages_Employee'", 
			condition = "#isCacheable == null || !#isCacheable", beforeInvocation = true )
	@Cacheable(value="Employee_Cache", key="'messages_Employee'", 
			condition = "#isCacheable != null && #isCacheable")
	public List<Employee> getEmployees(boolean isCacheable) {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

}
