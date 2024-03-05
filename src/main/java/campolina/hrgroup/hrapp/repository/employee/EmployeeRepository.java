package campolina.hrgroup.hrapp.repository.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.employee.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>  {
    List<Employee> findAll();

    Optional<Employee> findByEmail(String email);
}

