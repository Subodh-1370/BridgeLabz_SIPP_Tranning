import java.util.ArrayList;

// Book class
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Display book info
    public void displayInfo() {
        System.out.println("Book: " + title + " by " + author);
    }
}

// Library class (Aggregation)
class Library {
    private String libraryName;
    private ArrayList<Book> books;

    // Constructor
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    // Add a book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books in library
    public void showBooks() {
        System.out.println("Library: " + libraryName);
        for (Book book : books) {
            book.displayInfo();
        }
        System.out.println(); // for spacing
    }
}

// Main class to demonstrate aggregation
public class LibraryAndBooks {
    public static void main(String[] args) {
        // Create some book objects (independent of any library)
        Book book1 = new Book("Java Programming", "XYZ");
        Book book2 = new Book("Effective Java", "ABC");
        Book book3 = new Book("Clean Code", "UVW");

        // Create libraries
        Library library1 = new Library("Central Library");
        Library library2 = new Library("Community Library");

        // Add books to libraries (aggregation)
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2); // book2 added to both libraries
        library2.addBook(book3);

        // Show books in each library
        library1.showBooks();
        library2.showBooks();
    }
}
