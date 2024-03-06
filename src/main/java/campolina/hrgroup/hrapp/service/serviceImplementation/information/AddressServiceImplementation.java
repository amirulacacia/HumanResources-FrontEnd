package campolina.hrgroup.hrapp.service.serviceImplementation.information;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campolina.hrgroup.hrapp.model.information.Address;
import campolina.hrgroup.hrapp.repository.applicant.ApplicantRepository;
import campolina.hrgroup.hrapp.repository.employee.EmployeeRepository;
import campolina.hrgroup.hrapp.repository.information.AddressRepository;
import campolina.hrgroup.hrapp.service.information.AddressService;

@Service
@Transactional
public class AddressServiceImplementation implements AddressService{
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Address createAddress(Address address, String user, Long userId) {
        switch (user) {
            case "employee":
                address.setEmployee(employeeRepository.findById(userId).get());
                break;
            case "applicant":
                address.setApplicant(applicantRepository.findById(userId).get());
                break;
            default:
                break;
        }
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(()-> new NoSuchElementException("There is no Address of this id"));
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(Address address, Long id) {
        Address addressDB = addressRepository.findById(id).get();

        if (Objects.nonNull(address.getCountry())) {
            addressDB.setCountry(address.getCountry());
        }

        if (Objects.nonNull(address.getState())) {
            addressDB.setState(address.getState());
        }

        if (Objects.nonNull(address.getAddressLine1())) {
            addressDB.setAddressLine1(address.getAddressLine1());
        }

        if (Objects.nonNull(address.getAddressLine1())) {
            addressDB.setAddressLine1(address.getAddressLine1());
        }

        if (Objects.nonNull(address.getAddressLine2())) {
            addressDB.setAddressLine2(address.getAddressLine2());
        }

        if (Objects.nonNull(address.getAddressLine3())) {
            addressDB.setAddressLine3(address.getAddressLine3());
        }

        if (Objects.nonNull(address.getCity())) {
            addressDB.setCity(address.getCity());
        }

        return addressRepository.save(addressDB);
    }

    @Override
    public String deleteAddress(Long id) {
        addressRepository.findById(id).orElseThrow(()-> new NoSuchElementException("There is no Address of this id to be delete"));
        addressRepository.deleteById(id);
        return "Address with ID: " + id + " has been deleted successfully";
    }
}
