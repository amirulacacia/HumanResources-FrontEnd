package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import campolina.hrgroup.hrapp.model.AdditionalInfo;
import campolina.hrgroup.hrapp.repository.AdditionalInfoRepository;
import campolina.hrgroup.hrapp.service.AdditionalInfoService;

public class AdditionalInfoServiceImplementation implements AdditionalInfoService {
    @Autowired
    private AdditionalInfoRepository additionalInfoRepository;

    @Override
    public AdditionalInfo createAdditionalInfo(AdditionalInfo additionalInfo) {
        return additionalInfoRepository.save(additionalInfo);
    }

    @Override
    public AdditionalInfo getAdditionalInfoById(Long additionalInfoId) {
        return additionalInfoRepository.findById(additionalInfoId).orElse(null);
    }

    @Override
    public List<AdditionalInfo> getAllAdditionalInfo() {
        return additionalInfoRepository.findAll();
    }

    @Override
    public AdditionalInfo updateAdditionalInfo(AdditionalInfo additionalInfo) {
        return additionalInfoRepository.save(additionalInfo);
    }

    @Override
    public String deleteAdditionalInfo(Long additionalInfoId) {
        additionalInfoRepository.deleteById(additionalInfoId);
        return "AdditionalInfo with ID: " + additionalInfoId + " has been deleted successfully";
    }
}
