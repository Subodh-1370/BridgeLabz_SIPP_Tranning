public class BookLibrarySystem {
    public String ISBN;
    protected String title;
    private String author;

    public BookLibrarySystem(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends BookLibrarySystem {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
    }

    public static void main(String[] args) {
        EBook ebook = new EBook("123-456", "Java Basics", "John Doe");
        ebook.displayInfo();
        System.out.println("Author: " + ebook.getAuthor());
    }
}