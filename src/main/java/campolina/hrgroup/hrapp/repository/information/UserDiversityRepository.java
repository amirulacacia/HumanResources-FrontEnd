package campolina.hrgroup.hrapp.repository.information;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.information.UserDiversity;

public interface UserDiversityRepository extends CrudRepository<UserDiversity, Long>  {
    List<UserDiversity> findAll();
}

