public class ProductInventory {
    private String productName;
    private double price;
    private static int totalProducts = 0;

    public ProductInventory(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        ProductInventory p1 = new ProductInventory("Laptop", 45000);
        ProductInventory p2 = new ProductInventory("Phone", 20000);

        p1.displayProductDetails();
        p2.displayProductDetails();
        displayTotalProducts();
    }
}