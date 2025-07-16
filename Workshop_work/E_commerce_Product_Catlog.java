import java.util.*;
import java.util.stream.Collectors;

// Custom Exception
class ProductException extends Exception {
    public ProductException(String message) {
        super(message);
    }
}

// Product class
class Product {
    private String name;
    private String category;
    private double price;
    private int stock;

    public static final int MAX_STOCK = 1000;

    public Product(String name, String category, double price, int stock) throws ProductException {
        if (stock < 0 || stock > MAX_STOCK) {
            throw new ProductException("Stock must be between 0 and " + MAX_STOCK);
        }
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Getters & Setters
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void updateStock(int newStock) throws ProductException {
        if (newStock < 0 || newStock > MAX_STOCK) {
            throw new ProductException("Invalid stock. Must be 0 - " + MAX_STOCK);
        }
        this.stock = newStock;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Category: %s | Price: ₹%.2f | Stock: %d",
                name, category, price, stock);
    }
}

// Catalog Manager
class ProductCatalog {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("✔ Product added: " + product.getName());
    }

    public List<Product> searchByName(String name) {
        return productList.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Product> searchByCategory(String category) {
        return productList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public void updateProductStock(String name, int newStock) throws ProductException {
        Optional<Product> product = productList.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();
        if (product.isPresent()) {
            product.get().updateStock(newStock);
            System.out.println("✔ Stock updated for: " + name);
        } else {
            throw new ProductException("❌ Product not found: " + name);
        }
    }

    public void displaySortedByPrice(boolean ascending) {
        List<Product> sortedList = new ArrayList<>(productList);
        sortedList.sort(Comparator.comparingDouble(Product::getPrice));
        if (!ascending) Collections.reverse(sortedList);

        System.out.println("\n📦 Products sorted by price (" + (ascending ? "Low to High" : "High to Low") + "):");
        sortedList.forEach(System.out::println);
    }
}

public class E_commerce_Product_Catlog {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        try {
            // Adding products
            catalog.addProduct(new Product("Laptop", "Electronics", 50000, 50));
            catalog.addProduct(new Product("Shirt", "Clothing", 1500, 200));
            catalog.addProduct(new Product("Smartphone", "Electronics", 30000, 70));
            catalog.addProduct(new Product("Book", "Stationery", 500, 100));
            catalog.addProduct(new Product("Headphones", "Electronics", 2500, 150));

            System.out.println("\n🔍 Search by name 'Laptop':");
            catalog.searchByName("Laptop").forEach(System.out::println);

            System.out.println("\n🔍 Search by category 'Electronics':");
            catalog.searchByCategory("Electronics").forEach(System.out::println);

            catalog.updateProductStock("Laptop", 60);

            catalog.displaySortedByPrice(true);  // Ascending
            catalog.displaySortedByPrice(false); // Descending

        } catch (ProductException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
