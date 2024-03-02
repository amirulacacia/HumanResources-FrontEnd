package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.UserDiversity;

public interface UserDiversityRepository extends CrudRepository<UserDiversity, Long>  {
    List<UserDiversity> findAll();
}

