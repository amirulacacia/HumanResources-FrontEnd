package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>  {
    List<Department> findAll();
}

