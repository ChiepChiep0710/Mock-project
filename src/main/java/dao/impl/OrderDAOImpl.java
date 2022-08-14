package dao.impl;

import dao.OrderDAO;
import model.Order;
import model.OrderDetail;
import util.DBUtil;
import util.SQLCOMMAND.OrderDetailSQLCommand;
import util.SQLCOMMAND.OrderSQLCommand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public int save(Order order) {
        try(Connection connection = DBUtil.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(OrderSQLCommand.INSERT_ORDER);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement,order.getName(), order.getPhoneNumber(),
                    order.getDetailAddress(), order.getTotal(), order.getOrderDate(), order.getStatus(), order.getCustomerID(), order.getAddressID());
            return preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Order order) {
        try(Connection connection = DBUtil.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(OrderSQLCommand.UPDATE_ORDER);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement,order.getName(), order.getPhoneNumber(),
                    order.getDetailAddress(), order.getTotal(), order.getOrderDate(), order.getStatus(), order.getCustomerID(),
                    order.getAddressID(), order.getOrderID());

            return preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Order order) {
        try(Connection connection = DBUtil.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(OrderSQLCommand.DELETE_ORDER);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement, order.getOrderID());

            return preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Order> findAll() {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM [ORDER]";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                int orderId = resultSet.getInt("ORDER_ID");
                String name = resultSet.getString("NAME");
                String phoneNumber = resultSet.getString("PHONE_NUMBER");
                String detailAddress = resultSet.getString("DETAIL_ADDRESS");
                double total = resultSet.getDouble("TOTAL");
                Date orderDate = resultSet.getDate("ORDER_DATE");
                int customerID = resultSet.getInt("CUSTOMER_ID");
                int addressID = resultSet.getInt("ADDRESS_ID");
                int status = resultSet.getInt("STATUS");

                orders.add(new Order(orderId, name, phoneNumber, detailAddress, total, orderDate, status, customerID, addressID));
            }

            return orders;
        } catch (Exception e) {
            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
