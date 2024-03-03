package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.Employee;
import campolina.hrgroup.hrapp.model.Interview;
import campolina.hrgroup.hrapp.model.JobPosition;
import campolina.hrgroup.hrapp.repository.EmployeeRepository;
import campolina.hrgroup.hrapp.repository.InterviewRepository;
import campolina.hrgroup.hrapp.repository.JobPositionRepository;
import campolina.hrgroup.hrapp.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JobPositionRepository jobPositionRepository;
    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee employeeDB = employeeRepository.findById(id).get();

        if (Objects.nonNull(employee.getPassword())) {
            employeeDB.setPassword(employee.getPassword());
        }

        return employeeRepository.save(employeeDB);
    }

    @Override
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee with ID: " + id + " has been deleted successfully";
    }

    @Override
    public Employee assignPositionToEmployee(Long employeeId, Long positionId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        JobPosition jobPosition = jobPositionRepository.findById(positionId).get();

        employee.setJobPosition(jobPosition);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee removePositionToEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        employee.setJobPosition(null);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee assignInterviewToEmployee(Long id, Long interviewId) {
        Set<Interview> interviewSet = null;

        Employee employee = employeeRepository.findById(id).get();
        Interview interview = interviewRepository.findById(interviewId).get();

        interviewSet = employee.getAssignInterview();
        interviewSet.add(interview);

        employee.setAssignInterview(interviewSet);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee removeInterviewFromEmployee(Long id, Long interviewId) {
        Set<Interview> interviewSet = null;

        Employee employee = employeeRepository.findById(id).get();
        Interview interview = interviewRepository.findById(interviewId).get();

        interviewSet = employee.getAssignInterview();
        interviewSet.remove(interview);

        employee.setAssignInterview(interviewSet);

        return employeeRepository.save(employee);
    }

}

