package campolina.hrgroup.hrapp.service.information;

import java.util.List;

import org.springframework.stereotype.Service;

import campolina.hrgroup.hrapp.model.information.Reference;

@Service
public interface ReferenceService {

    Reference createReference(Reference reference, Long additionalInfoId);

    Reference getReferenceById(Long id);

    List<Reference> getAllReference();

    Reference updateReference(Reference reference, Long id);

    String deleteReference(Long id);
}
