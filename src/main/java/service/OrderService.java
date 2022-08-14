package service;

import model.Order;
import model.OrderDetail;

import java.util.List;

public interface OrderService {
    boolean save(Order order);

    boolean update(Order order);

    boolean delete(Order order);

    List<Order> findAll();
}
