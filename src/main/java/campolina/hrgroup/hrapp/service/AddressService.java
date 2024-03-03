package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Address;

@Service
public interface AddressService {
    
    Address createAddress(Address address, String user, Long userId);

    Address getAddressById(Long id);

    List<Address> getAllAddresses();

    Address updateAddress(Address address, Long id);

    String deleteAddress(Long id);
}
