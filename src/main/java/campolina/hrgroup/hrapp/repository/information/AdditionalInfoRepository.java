package campolina.hrgroup.hrapp.repository.information;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.information.AdditionalInfo;

public interface AdditionalInfoRepository extends CrudRepository<AdditionalInfo, Long>  {
    List<AdditionalInfo> findAll();
}

