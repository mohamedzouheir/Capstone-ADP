package za.ac.cput.Repository;
//Aaniquah Dicks 222641495

import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImp implements IOrderRepository<Order,String>{

    private final List<Order> orders = new ArrayList<>();
    @Override
    public Order create(Order order) {
        if (order != null) {
            orders.add(order);
            return order;
        }
        return null;
    }


    @Override
    public Order read(String id) {
        for (Order order : orders) {
            if (order.getOrderID().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order update(Order updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getOrderID().equals(updatedOrder.getOrderID())) {
                orders.set(i, updatedOrder);
                return updatedOrder;
            }
        }
        return null;
    }

    @Override
    public Order delete(Order orderToDelete) {
        Order foundOrder = read(orderToDelete.getOrderID());
        if (foundOrder != null) {
            orders.remove(foundOrder);
        }
        return foundOrder;
    }


    @Override
    public List<Order> getAll() {
        return new ArrayList<>(orders);
    }
}
