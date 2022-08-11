package dao;

import model.Address;

import java.util.List;

public interface AddressDAO {
    int save(Address address);

    int update(Address address);
    int delete(Address address);
    Address findAddressById(int id);
    List<Address> findAll();
}
