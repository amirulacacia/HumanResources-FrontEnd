package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.Employee;
import campolina.hrgroup.hrapp.repository.EmployeeRepository;
import campolina.hrgroup.hrapp.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public String deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Employee with ID: " + employeeId + " has been deleted successfully";
    }
}

