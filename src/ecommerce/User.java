package ecommerce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private Cart cart;
    private List<Order> orderHistory;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.cart = new Cart();
        this.orderHistory = new LinkedList<>();
    }
    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("\n📜 No past orders found.");
            return;
        }
        System.out.println("\n📜 Order History:");
        for (Order order : orderHistory) {
            order.displayOrder();
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Cart getCart() {
        return cart;
    }

    public void displayUserinfo() {
        System.out.println("Name:" + name);
        System.out.println("Email:" + email);
    }
}
