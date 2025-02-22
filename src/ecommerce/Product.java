package ecommerce;

public class Product {
    private final String name;
    private final int id;
    private final double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.price = price;
        this.name = name;

    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}


