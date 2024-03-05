package campolina.hrgroup.hrapp.repository.employee;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.employee.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>  {
    List<Employee> findAll();
}

