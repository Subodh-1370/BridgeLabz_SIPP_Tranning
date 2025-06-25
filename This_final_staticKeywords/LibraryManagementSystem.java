// This class represents individual book details
public class LibraryManagementSystem {
    // Static variable shared by all book instances
    private static String libraryName;

    // Instance variables
    private String title;
    private String author;
    private final String isbn; // Final = cannot be changed after initialization

    // Constructor to initialize book details
    public LibraryManagementSystem(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method to set library name
    public static void setLibraryName(String name) {
        libraryName = name;
    }

    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("\n--- Book Details ---");
        System.out.println("Title:  " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN:   " + isbn);
    }

    // Getters (optional for external access)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    // Main method to test the system
    public static void main(String[] args) {
        // Set library name
        LibraryManagementSystem.setLibraryName("Knowledge Hub");

        // Display library name
        LibraryManagementSystem.displayLibraryName();

        // Create book instances
        LibraryManagementSystem book1 = new LibraryManagementSystem(
                "The Blue Knight", "By Abhishek Goswami", "978-01345991");

        LibraryManagementSystem book2 = new LibraryManagementSystem(
                "The power Seekers", "By Varun Singh", "978-01320884");

        // Display book details
        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}
