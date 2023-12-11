package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.models.BulkEmployeeRequest;
import jp.co.axa.apidemo.models.EmployeeRequest;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * @return
     */
    @Cacheable("employeesCache")
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        try {
			List<Employee> employees = employeeService.retrieveEmployees();
			return employees;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve the employee list", e);
		}
    }

    /**
     * @param employeeId
     * @return
     */
    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(name="employeeId")Long employeeId) {
    	
    	try {
			Employee employee = employeeService.getEmployee(employeeId);
			if(null!=employee) {
				return ResponseEntity.ok(employee);
			}else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			
    	} catch (Exception e) {
    		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }

    /**
     * @param request
     * @return
     */
    @PostMapping("/employees")
    public ResponseEntity<EmployeeRequest> saveEmployee(@RequestBody EmployeeRequest request){
        try {
			employeeService.saveEmployee(request);
			return ResponseEntity.ok(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save the employee", e);
		}
        
    }
    
    /**
     * @param bulkRequest
     */
    @PostMapping("/bulk-employees")
    public ResponseEntity<String> saveBulkEmployee(@RequestBody BulkEmployeeRequest bulkRequest){
        try {
			employeeService.saveBulkEmployee(bulkRequest);
			return ResponseEntity.ok("Employees Saved Successfully");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save the employee list", e);
		}
    }

    /**
     * @param employeeId
     * @return
     */
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        try {
			employeeService.deleteEmployee(employeeId);
		    return ResponseEntity.ok("Employee Deleted Successfully: "+employeeId);
        } catch (NoSuchElementException e) {
          return ResponseEntity.notFound().build();
        } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    
    /**
     * 
     */
    @DeleteMapping("/employees")
    public ResponseEntity<String> deleteAllEmployee(){
        try {
			employeeService.deleteAllEmployee();
			return ResponseEntity.ok("Employees Deleted Successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete the employee list", e);
		}
    }

    /**
     * @param employee
     * @param employeeId
     * @return
     */
    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeRequest updateRequest,
                               @PathVariable(name="employeeId")Long employeeId){
        try {
			Employee emp = employeeService.getEmployee(employeeId);
			if(emp != null){
			    employeeService.updateEmployee(emp, updateRequest);
		        return ResponseEntity.ok("Employee Updated Successfully :"+employeeId);
			} else {
		        return ResponseEntity.notFound().build();
		    }
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

    }

}
