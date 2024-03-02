package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.User;

public interface UserRepository extends CrudRepository<User, Long>  {
    List<User> findAll();
}

