package dao;

import model.Address;
import model.Customer;
import model.Order;
import model.OrderDetail;

import java.util.List;

public interface OrderDAO {
    int create(Order order);
    int save(Order order);

    int update(Order order);

    int delete(Order order);
    List<Order> findAll();
}
