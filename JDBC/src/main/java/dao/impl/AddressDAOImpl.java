package dao.impl;

import dao.AddressDAO;
import model.Address;
import util.DBUtil;
import util.SQLCommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    @Override
    public int save(Address address) {
        try(Connection connection = DBUtil.getInstance().getConnection();){
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.ADDRESS_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement, address.getCity(), address.getDistrict(),
                                address.getSubDistrict(), address.getPostalCode(), address.getDeliveryFee());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                return id;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Address address) {
        try(Connection connection = DBUtil.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_ADDRESS);

            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement,address.getCity(),
                    address.getDistrict(),address.getSubDistrict(),address.getPostalCode(),address.getDeliveryFee(),address.getId());

            return preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Address address) {
        try(Connection connection = DBUtil.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.DELETE_ADDRESS);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement,address.getId());
            return preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Address findAddressById(int id) {
        try(Connection connection = DBUtil.getInstance().getConnection();){
            String sql = "SELECT * FROM ADDRESS WHERE ADDRESS_ID = " + id + "";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            Address address = null;
            while (resultSet.next()){
                String city = resultSet.getString("CITY");
                String district = resultSet.getString("DISTRICT");
                String subDistrict = resultSet.getString("SUB_DISTRICT");
                String postalCode = resultSet.getString("POSTAL_CODE");
                Double deliveryFee = resultSet.getDouble("DELIVERY_FEE");
                address = new Address(id, city, district, subDistrict, postalCode, deliveryFee);
            }
            return address;
        } catch (Exception e){
            e.printStackTrace();
            return new Address();
        }
    }

    @Override
    public List<Address> findAll() {
        try(Connection connection = DBUtil.getInstance().getConnection();){
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.SELECT_ALL_ADDRESS);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Address> addresses = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("ADDRESS_ID");
                String city = resultSet.getString("CITY");
                String district = resultSet.getString("DISTRICT");
                String subDistrict = resultSet.getString("SUB_DISTRICT");
                String postalCode = resultSet.getString("POSTAL_CODE");
                Double deliveryFee = resultSet.getDouble("DELIVERY_FEE");
                addresses.add(new Address(id, city, district, subDistrict, postalCode, deliveryFee));
            }
            return addresses;
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
