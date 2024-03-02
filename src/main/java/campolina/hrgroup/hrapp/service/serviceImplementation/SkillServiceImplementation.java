package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.Skill;
import campolina.hrgroup.hrapp.repository.SkillRepository;
import campolina.hrgroup.hrapp.service.SkillService;

@Service
@Transactional
public class SkillServiceImplementation implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill getSkillById(Long skillId) {
        return skillRepository.findById(skillId).orElse(null);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill updateSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public String deleteSkill(Long skillId) {
        skillRepository.deleteById(skillId);
        return "Skill with ID: " + skillId + " has been deleted successfully";
    }
}

