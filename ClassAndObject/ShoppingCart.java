import java.util.ArrayList;
import java.util.Scanner;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalCost() {
        return price * quantity;
    }

    void displayItem() {
        System.out.println(itemName + " - ₹" + price + " x " + quantity + " = ₹" + getTotalCost());
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CartItem> cart = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Shopping Cart Menu ---");
            System.out.println("1. Add Item\n2. Remove Item\n3. View Cart\n4. Checkout\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    cart.add(new CartItem(name, price, qty));
                    System.out.println("Item added to cart.");
                    break;

                case 2:
                    System.out.print("Enter Item Name to Remove: ");
                    String removeName = sc.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < cart.size(); i++) {
                        if (cart.get(i).itemName.equalsIgnoreCase(removeName)) {
                            cart.remove(i);
                            System.out.println("Item removed.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        double total = 0;
                        System.out.println("\n--- Cart Items ---");
                        for (CartItem item : cart) {
                            item.displayItem();
                            total += item.getTotalCost();
                        }
                        System.out.println("Total Cost: ₹" + total);
                    }
                    break;

                case 4:
                    double total = 0;
                    for (CartItem item : cart) {
                        total += item.getTotalCost();
                    }
                    System.out.println("Checkout completed. Total payable: ₹" + total);
                    cart.clear();
                    break;

                case 5:
                    System.out.println("Exiting Shopping Cart.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
