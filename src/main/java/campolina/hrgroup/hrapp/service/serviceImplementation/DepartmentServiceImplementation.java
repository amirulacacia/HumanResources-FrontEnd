package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.Department;
import campolina.hrgroup.hrapp.repository.DepartmentRepository;
import campolina.hrgroup.hrapp.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public String deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return "Department with ID: " + departmentId + " has been deleted successfully";
    }
}

