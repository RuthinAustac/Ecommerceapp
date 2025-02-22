//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package ecommerce;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Austaz's E-commerce Application");

        // Get user input and create user profile
        User user = getUserInput(scanner);

        // Handle menu options
        handleMenu(user, scanner);
    }

    public static User getUserInput(Scanner scanner) {
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your email: ");
        String userEmail = scanner.nextLine();

        User user = new User(userName, userEmail);
        System.out.println("\nUser Profile Created Successfully!");
        user.displayUserinfo();
        return user;
    }

    public static void handleMenu(User user, Scanner scanner) {
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. View Order History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProductToCart(user, scanner);
                    break;

                case 2:
                    removeProductFromCart(user, scanner);
                    break;

                case 3:
                    user.getCart().viewCart();
                    break;

                case 4:
                    checkout(user);
                    break;

                case 5:
                    user.viewOrderHistory();
                    break;

                case 6:
                    System.out.println("Thank you for shopping with us! Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void addProductToCart(User user, Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(id, name, price);
        user.getCart().addProduct(product);
    }

    public static void removeProductFromCart(User user, Scanner scanner) {
        System.out.print("Enter Product Name to Remove: ");
        String removeName = scanner.nextLine();
        user.getCart().removeProductByName(removeName);
    }

    public static void checkout(User user) {
        double total = user.getCart().calculateTotal();
        System.out.println("Total amount: $" + total);
        System.out.println("Proceeding to checkout...");
        user.getCart().checkout();
    }
}