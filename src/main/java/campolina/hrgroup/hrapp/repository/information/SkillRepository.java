package campolina.hrgroup.hrapp.repository.information;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.information.Skill;

public interface SkillRepository extends CrudRepository<Skill, Long>  {
    List<Skill> findAll();
}

