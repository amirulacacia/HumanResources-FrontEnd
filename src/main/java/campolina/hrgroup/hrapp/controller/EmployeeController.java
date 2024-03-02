package campolina.hrgroup.hrapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.Employee;
import campolina.hrgroup.hrapp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee,
                                   @PathVariable long employeeId) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}

