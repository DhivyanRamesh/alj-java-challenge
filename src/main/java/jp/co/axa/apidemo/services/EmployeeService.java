package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.models.BulkEmployeeRequest;
import jp.co.axa.apidemo.models.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    public List<Employee> retrieveEmployees();

    public Employee getEmployee(Long employeeId);

    public void saveEmployee(EmployeeRequest request);
    
    public void saveBulkEmployee(BulkEmployeeRequest bulkRequest);

    public void deleteEmployee(Long employeeId);
    
    public void deleteAllEmployee();

    public void updateEmployee(Employee employee, EmployeeRequest updateRequest);
}