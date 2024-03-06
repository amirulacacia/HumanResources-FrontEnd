package campolina.hrgroup.hrapp.service.serviceImplementation.job;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.job.Department;
import campolina.hrgroup.hrapp.repository.job.DepartmentRepository;
import campolina.hrgroup.hrapp.service.job.DepartmentService;

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
    public Department updateDepartment(Department department, Long id) {
        Department departmentDB = departmentRepository.findById(id).get();

        if (Objects.nonNull(department.getName())) {
            departmentDB.setName(department.getName());
        }
        
        return departmentRepository.save(departmentDB);
    }

    @Override
    public String deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return "Department with ID: " + departmentId + " has been deleted successfully";
    }
}

