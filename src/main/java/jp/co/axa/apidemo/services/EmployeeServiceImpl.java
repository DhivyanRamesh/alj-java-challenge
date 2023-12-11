package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.models.BulkEmployeeRequest;
import jp.co.axa.apidemo.models.EmployeeRequest;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Get the list of all employee details
     */
    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    /**
     * Get the employee details by employee ID
     */
    public Employee getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return optEmp.get();
    }

    /**
     * Save the employee detail
     */
    public void saveEmployee(EmployeeRequest request){
    	
    	Employee employee = new Employee();
    	
//    	Function to map the entities
    	mapEmpDetails(employee, request);
    	    	
    	if (employeeRepository.save(employee) != null) {
    		request.setId(employee.getId());
		}
    }
    
    /**
     * @param employee
     * @param request
     */
    private void mapEmpDetails(Employee employee, EmployeeRequest request) {
		// TODO Auto-generated method stub
    	Date currentTime = Calendar.getInstance().getTime();
    	employee.setDepartment(request.getDepartment());
    	employee.setName(request.getName());
    	employee.setSalary(request.getSalary());
//    	Audit columns
    	employee.setCreatedBy(request.getName());
    	employee.setUpdatedBy(request.getName());
    	employee.setCreatedDate(currentTime);
    	employee.setUpdatedDate(currentTime);
	}

	/**
	 * Save all the employee details
	 */
	public void saveBulkEmployee(BulkEmployeeRequest bulkRequest){
    	
    	List<EmployeeRequest> empList = bulkRequest.getEmployeeList();
    	List<Employee> saveEmpList = new ArrayList<Employee>();
    	if(!CollectionUtils.isEmpty(empList)) {
    		for(EmployeeRequest empRequest: empList) {
        		Employee employee = new Employee();
        		mapEmpDetails(employee, empRequest);
            	saveEmpList.add(employee);
        	}
            employeeRepository.saveAll(saveEmpList);
    	}
    }

    /**
     * Delete one employee by ID
     */
    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }
    
    /**
     * Delete all the employees
     */
    public void deleteAllEmployee(){
        employeeRepository.deleteAll();
    }

    /**
     * Update one employee by ID
     */
    public void updateEmployee(Employee employee, EmployeeRequest request) {
    	
    	Date currentTime = Calendar.getInstance().getTime();
    	employee.setName(request.getName());
    	employee.setDepartment(request.getName());
    	employee.setSalary(request.getSalary());
//    	Audit columns update details only
    	employee.setUpdatedDate(currentTime);
    	employee.setUpdatedBy(request.getName());
        employeeRepository.save(employee);
    }
}