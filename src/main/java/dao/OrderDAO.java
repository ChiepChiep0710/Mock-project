package dao;

import model.Order;
import model.OrderDetail;

import java.util.List;

public interface OrderDAO {
    int save(Order order);

    int update(Order order);

    int delete(Order order);

    List<Order> findAll();
}
