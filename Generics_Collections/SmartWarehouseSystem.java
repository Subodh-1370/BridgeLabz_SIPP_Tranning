import java.util.*;

// Abstract base class
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract void displayDetails();
}

// Subclasses
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics: " + getName() + ", Brand: " + brand + ", Price: " + getPrice());
    }
}

class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Groceries: " + getName() + ", Expiry: " + expiryDate + ", Price: " + getPrice());
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture: " + getName() + ", Material: " + material + ", Price: " + getPrice());
    }
}

// Generic Storage class
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public void displayAll() {
        for (T item : items) {
            item.displayDetails();
        }
    }
}

// Wildcard Utility
class DisplayUtil {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}

// Main Class
public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 75000, "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", 30000, "Samsung"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apples", 150, "2025-01-01"));
        groceriesStorage.addItem(new Groceries("Milk", 50, "2024-08-15"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 1200, "Wood"));
        furnitureStorage.addItem(new Furniture("Table", 3000, "Metal"));

        System.out.println("=== Electronics ===");
        electronicsStorage.displayAll();

        System.out.println("\n=== Groceries ===");
        groceriesStorage.displayAll();

        System.out.println("\n=== Furniture ===");
        furnitureStorage.displayAll();

        System.out.println("\n=== Displaying all items using Wildcard Method ===");
        DisplayUtil.displayAllItems(electronicsStorage.getItems());
        DisplayUtil.displayAllItems(groceriesStorage.getItems());
        DisplayUtil.displayAllItems(furnitureStorage.getItems());
    }
}
