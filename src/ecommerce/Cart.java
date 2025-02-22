package ecommerce;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " has been added to the cart");
    }

    public void removeProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
            System.out.println(product.getName() + "removed from cart");
        } else {
            System.out.println("product not found");

        }
    }

    public void viewCart() {
        if (products.isEmpty()) {
            System.out.println("cart is empty");
        } else {
            System.out.println("cart contains");
        }
        for (Product product : products) {
            System.out.println("-" + product.getName() + "| price: $" + product.getPrice());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();

        }
        return total;

    }
    public void checkout(){
        if(products.isEmpty()){
            System.out.println("your cart is empty add something -_-");
            return;
        }
        double total=calculateTotal();
        System.out.println("Total amount :$"+total);
        System.out.println("processing payment......");
        System.out.println("payment Successful!!! Thank uuu *_*");

        products.clear();

    }
    public void removeProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                products.remove(product);
                System.out.println(name + " removed from the cart.");
                return;
            }
        }
        System.out.println("Product not found in the cart.");
    }

    // add product

}

