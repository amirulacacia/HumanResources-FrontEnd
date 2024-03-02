package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Skill;

@Service
public interface SkillService {
    
    Skill createSkill(Skill skill);

    Skill getSkillById(Long skillId);

    List<Skill> getAllSkills();

    Skill updateSkill(Skill skill);

    String deleteSkill(Long skillId);
}
