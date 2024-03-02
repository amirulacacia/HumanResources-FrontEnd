package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.AdditionalInfo;

@Service
public interface AdditionalInfoService {
    
    AdditionalInfo createAdditionalInfo(AdditionalInfo additionalInfo);

    AdditionalInfo getAdditionalInfoById(Long additionalInfoId);

    List<AdditionalInfo> getAllAdditionalInfo();

    AdditionalInfo updateAdditionalInfo(AdditionalInfo additionalInfo);

    String deleteAdditionalInfo(Long additionalInfoId);

}


