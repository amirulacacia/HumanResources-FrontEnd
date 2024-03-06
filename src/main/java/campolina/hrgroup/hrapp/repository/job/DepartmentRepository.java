package campolina.hrgroup.hrapp.repository.job;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.job.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>  {
    List<Department> findAll();
}

