package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.Skill;
import campolina.hrgroup.hrapp.repository.ApplicantRepository;
import campolina.hrgroup.hrapp.repository.EmployeeRepository;
import campolina.hrgroup.hrapp.repository.SkillRepository;
import campolina.hrgroup.hrapp.service.SkillService;

@Service
@Transactional
public class SkillServiceImplementation implements SkillService {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Skill createSkill(Skill skill, String user, Long userId) {
        switch (user) {
            case "employee":
                skill.setEmployee(employeeRepository.findById(userId).get());
                break;
            case "applicant":
                skill.setApplicant(applicantRepository.findById(userId).get());
                break;
            default:
                break;
        }
        return skillRepository.save(skill);
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill updateSkill(Skill skill, Long id) {
        Skill skillDB = skillRepository.findById(id).get();

        if (Objects.nonNull(skill.getSkill())) {
            skillDB.setSkill(skill.getSkill());
        }

        return skillRepository.save(skillDB);
    }

    @Override
    public String deleteSkill(Long id) {
        skillRepository.deleteById(id);
        return "Skill with ID: " + id + " has been deleted successfully";
    }
}

