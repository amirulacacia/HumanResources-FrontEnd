package campolina.hrgroup.hrapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import campolina.hrgroup.hrapp.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long>  {
    List<Address> findAll();
}

