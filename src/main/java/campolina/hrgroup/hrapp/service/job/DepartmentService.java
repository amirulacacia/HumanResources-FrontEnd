package campolina.hrgroup.hrapp.service.job;

import java.util.List;
import org.springframework.stereotype.Service;

import campolina.hrgroup.hrapp.model.job.Department;

@Service
public interface DepartmentService {
    
    Department createDepartment(Department department);

    Department getDepartmentById(Long departmentId);

    List<Department> getAllDepartments();

    Department updateDepartment(Department department, Long id);

    String deleteDepartment(Long departmentId);
}
