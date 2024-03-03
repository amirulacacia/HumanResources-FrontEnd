package campolina.hrgroup.hrapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import campolina.hrgroup.hrapp.model.Reference;

public interface ReferenceRepository extends CrudRepository<Reference, Long>{
    List<Reference> findAll();
}
