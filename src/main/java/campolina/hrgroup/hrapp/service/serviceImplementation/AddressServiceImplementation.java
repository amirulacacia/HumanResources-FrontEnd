package campolina.hrgroup.hrapp.service.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import campolina.hrgroup.hrapp.model.Address;
import campolina.hrgroup.hrapp.repository.AddressRepository;
import campolina.hrgroup.hrapp.service.AddressService;

public class AddressServiceImplementation implements AddressService{
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Long addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public String deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
        return "Address with ID: " + addressId + " has been deleted successfully";
    }
}
