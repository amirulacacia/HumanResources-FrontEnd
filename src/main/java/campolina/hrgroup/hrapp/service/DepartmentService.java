package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Department;

@Service
public interface DepartmentService {
    
    Department createDepartment(Department department);

    Department getDepartmentById(Long departmentId);

    List<Department> getAllDepartments();

    Department updateDepartment(Department department);

    String deleteDepartment(Long departmentId);
}
