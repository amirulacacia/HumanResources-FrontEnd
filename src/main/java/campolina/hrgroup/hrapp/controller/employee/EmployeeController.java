package campolina.hrgroup.hrapp.controller.employee;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import campolina.hrgroup.hrapp.model.employee.Employee;
import campolina.hrgroup.hrapp.service.employee.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
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
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee,
            @PathVariable Long employeeId) {
        return employeeService.updateEmployee(employee, employeeId);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/{employeeId}/position/{positionId}")
    public Employee assignPositionToEmployee(@PathVariable("employeeId") Long employeeId,
            @PathVariable("positionId") Long positionId) {
        return employeeService.assignPositionToEmployee(employeeId, positionId);
    }

    @PutMapping("/{employeeId}/position")
    public Employee removePositionToEmployee(@PathVariable Long employeeId) {
        return employeeService.removePositionToEmployee(employeeId);
    }

    @PutMapping("/{employeeId}/interview/{interviewId}")
    public Employee assignInterviewToEmployee(@PathVariable("employeeId") Long employeeId,
            @PathVariable("interviewId") Long interviewId) {
        return employeeService.assignInterviewToEmployee(employeeId, interviewId);
    }

    @PutMapping("/{employeeId}/remove-interview/{interviewId}")
    public Employee removeInterviewFromEmployee(@PathVariable("employeeId") Long employeeId,
            @PathVariable("interviewId") Long interviewId) {
        return employeeService.removeInterviewFromEmployee(employeeId, interviewId);
    }

    @PostMapping("/login")
    public Boolean checkPasswordEmployee(@RequestBody Map<String,String> map){
        return employeeService.isEmployeeHaveTruePassword(map);
    }

    @PostMapping("/register")
    public Employee registerEmployee(@RequestBody Map<String,String> map){
        return employeeService.registerEmployee(map);
    }
}
