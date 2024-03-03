package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Skill;

@Service
public interface SkillService {
    
    Skill createSkill(Skill skill, String user, Long userId);

    Skill getSkillById(Long id);

    List<Skill> getAllSkills();

    Skill updateSkill(Skill skill, Long id);

    String deleteSkill(Long id);
}
