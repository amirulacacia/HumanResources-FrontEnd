package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>  {
    List<Employee> findAll();
}

