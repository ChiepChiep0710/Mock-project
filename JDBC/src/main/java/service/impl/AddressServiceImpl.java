package service.impl;

import dao.AddressDAO;
import dao.impl.AddressDAOImpl;
import model.Address;
import service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDAO addressDAO = new AddressDAOImpl();
    @Override
    public boolean save(Address address) {
        return addressDAO.save(address) > 0;
    }

    @Override
    public Address findAddressById(int id) {
        return addressDAO.findAddressById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressDAO.findAll();
    }

}
