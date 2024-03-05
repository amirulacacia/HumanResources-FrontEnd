package campolina.hrgroup.hrapp.repository.information;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.information.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long>  {
    List<UserInfo> findAll();
}

