import java.util.Scanner;

class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : ₹" + price);
    }

    double getTotalCost(int quantity) {
        return price * quantity;
    }
}

public class InventoryTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Item Code: ");
        int code = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        Item item = new Item(code, name, price);
        item.displayDetails();
        System.out.println("Total Cost for " + quantity + " item(s): ₹" + item.getTotalCost(quantity));
    }
}
