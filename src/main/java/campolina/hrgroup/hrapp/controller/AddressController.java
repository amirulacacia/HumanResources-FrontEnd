package campolina.hrgroup.hrapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.Address;
import campolina.hrgroup.hrapp.service.AddressService;

@RestController
@RequestMapping("/address") 
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @GetMapping("/{addressId}")
    public Address getAddressById(@PathVariable Long addressId) {
        return addressService.getAddressById(addressId);
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PutMapping("/{addressId}")
    public Address updateAddress(@PathVariable Long addressId, @RequestBody Address address) {
        address.setAddressId(addressId);
        return addressService.updateAddress(address);
    }

    @DeleteMapping("/{addressId}")
    public String deleteAddress(@PathVariable Long addressId) {
        return addressService.deleteAddress(addressId);
    }
}

