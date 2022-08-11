package service;

import model.Address;

import java.util.List;

public interface AddressService {
    boolean save(Address address);

    Address findAddressById(int id);

    List<Address> findAll();
}
