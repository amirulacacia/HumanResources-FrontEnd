package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Employee;

@Service
public interface EmployeeService {
    
    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee, Long id);

    String deleteEmployee(Long id);

    Employee assignPositionToEmployee(Long id, Long positionId);

    Employee removePositionToEmployee(Long id);

    Employee assignInterviewToEmployee(Long id, Long interviewId);

    Employee removeInterviewFromEmployee(Long id, Long interviewId);
}
