package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.AdditionalInfo;

public interface AdditionalInfoRepository extends CrudRepository<AdditionalInfo, Long>  {
    List<AdditionalInfo> findAll();
}

