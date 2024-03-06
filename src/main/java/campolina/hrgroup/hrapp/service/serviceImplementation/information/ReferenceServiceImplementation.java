package campolina.hrgroup.hrapp.service.serviceImplementation.information;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.information.Reference;
import campolina.hrgroup.hrapp.repository.information.AdditionalInfoRepository;
import campolina.hrgroup.hrapp.repository.information.ReferenceRepository;
import campolina.hrgroup.hrapp.service.information.ReferenceService;

@Service
@Transactional
public class ReferenceServiceImplementation implements ReferenceService{

    @Autowired
    private ReferenceRepository referenceRepository;
    @Autowired
    private AdditionalInfoRepository additionalInfoRepository;

    @Override
    public Reference createReference(Reference reference, Long additionalInfoId) {
        reference.setAdditionalInfo(additionalInfoRepository.findById(additionalInfoId).get());
        return referenceRepository.save(reference);
    }

    @Override
    public Reference getReferenceById(Long id) {
        return referenceRepository.findById(id).get();
    }

    @Override
    public List<Reference> getAllReference() {
        return referenceRepository.findAll();
    }

    @Override
    public Reference updateReference(Reference reference, Long id) {
        Reference referenceDB = referenceRepository.findById(id).get();

        if (Objects.nonNull(reference.getName())) {
            referenceDB.setName(reference.getName());
        }

        if (Objects.nonNull(reference.getPosition())) {
            referenceDB.setPosition(reference.getPosition());
        }

        if (Objects.nonNull(reference.getEmail())) {
            referenceDB.setEmail(reference.getEmail());
        }

        if (Objects.nonNull(reference.getContactNumber())) {
            referenceDB.setContactNumber(reference.getContactNumber());
        }

        return referenceRepository.save(referenceDB);
    }

    @Override
    public String deleteReference(Long id) {
        referenceRepository.deleteById(id);
        return "Reference with ID: " + id + " has been deleted successfully";
    }
    
}
