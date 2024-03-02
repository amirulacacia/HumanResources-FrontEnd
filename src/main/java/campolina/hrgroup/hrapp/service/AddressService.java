package campolina.hrgroup.hrapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import campolina.hrgroup.hrapp.model.Address;

@Service
public interface AddressService {
    
    Address createAddress(Address address);

    Address getAddressById(Long addressId);

    List<Address> getAllAddresses();

    Address updateAddress(Address address);

    String deleteAddress(Long addressId);

}
