package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Employee;

@Service
public interface EmployeeService {
    
    Employee createEmployee(Employee employee);

    Employee getEmployeeById(long employeeId);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee);

    String deleteEmployee(long employeeId);
}
