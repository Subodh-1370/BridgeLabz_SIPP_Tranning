import java.util.Scanner;

// Interface: Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class: Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation (getters/setters)
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Abstract method
    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID : " + productId);
        System.out.println("Name       : " + name);
        System.out.println("Price      : ₹" + price);
    }
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    public String getTaxDetails() {
        return "18% GST on Electronics";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    public String getTaxDetails() {
        return "5% GST on Clothing";
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main class
public class E_CommercePlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many products do you want to enter? ");
        int n = scanner.nextInt();
        Product[] products = new Product[n];

        for (int i = 0; i < products.length; i++) {
            System.out.println("\nEnter details for product " + (i + 1));

            System.out.print("Product Type (Electronics/Clothing/Groceries): ");
            String type = scanner.next();

            System.out.print("Product ID: ");
            int id = scanner.nextInt();

            System.out.print("Product Name: ");
            String name = scanner.next();

            System.out.print("Product Price: ");
            double price = scanner.nextDouble();

            switch (type.toLowerCase()) {
                case "electronics":
                    products[i] = new Electronics(id, name, price);
                    break;
                case "clothing":
                    products[i] = new Clothing(id, name, price);
                    break;
                case "groceries":
                    products[i] = new Groceries(id, name, price);
                    break;
                default:
                    System.out.println("❌ Invalid product type. Please try again.");
                    i--; // retry current index
            }
        }

        // Display all product billing info
        System.out.println("\n=========== Final Billing Summary ===========");
        for (Product p : products) {
            printFinalPrice(p);
        }

        scanner.close();
    }

    // Method to print final price (polymorphism)
    public static void printFinalPrice(Product p) {
        p.displayDetails();

        double discount = p.calculateDiscount();
        double tax = 0;

        if (p instanceof Taxable) {
            tax = ((Taxable) p).calculateTax();
            System.out.println("Tax        : ₹" + tax);
            System.out.println("Tax Info   : " + ((Taxable) p).getTaxDetails());
        } else {
            System.out.println("Tax        : ₹0 (Non-taxable item)");
        }

        System.out.println("Discount   : ₹" + discount);

        double finalPrice = p.getPrice() + tax - discount;
        System.out.println("Final Price: ₹" + finalPrice);
        System.out.println("---------------------------------------------");
    }
}
