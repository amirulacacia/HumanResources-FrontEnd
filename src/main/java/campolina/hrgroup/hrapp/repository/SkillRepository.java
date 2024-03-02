package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.Skill;

public interface SkillRepository extends CrudRepository<Skill, Long>  {
    List<Skill> findAll();
}

