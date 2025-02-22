package ecommerce;


import java.util.Date;
import java.util.List;

class Order {
     private List<Product> products;
     private double totalAmount;
     private Date orderDate;

     public Order(List<Product> products, double totalAmount) {
         this.products = products;
         this.totalAmount = totalAmount;
         this.orderDate = new Date();


     }
     public void displayOrder(){
         System.out.println("\n📦 Order Details:");
         System.out.println("Order Date: " + orderDate);
         for (Product product : products) {
             System.out.println("- " + product.getName() + " | Price: $" + product.getPrice());
         }
         System.out.println("Total: $" + totalAmount);
     }
 }
