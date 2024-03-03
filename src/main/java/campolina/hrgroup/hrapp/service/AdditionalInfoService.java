package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.AdditionalInfo;

@Service
public interface AdditionalInfoService {
    
    AdditionalInfo createAdditionalInfo(AdditionalInfo additionalInfo, String user, Long userId);

    AdditionalInfo getAdditionalInfoById(Long id);

    List<AdditionalInfo> getAllAdditionalInfo();

    AdditionalInfo updateAdditionalInfo(AdditionalInfo additionalInfo, Long id);

    String deleteAdditionalInfo(Long id);

}


