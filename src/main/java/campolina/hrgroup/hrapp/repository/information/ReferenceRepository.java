package campolina.hrgroup.hrapp.repository.information;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.information.Reference;

public interface ReferenceRepository extends CrudRepository<Reference, Long>{
    List<Reference> findAll();
}
