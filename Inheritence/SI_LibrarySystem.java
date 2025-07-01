// Superclass
class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass
class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo();  // call Book's displayInfo()
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

// Main class to test the inheritance
public class SI_LibrarySystem {
    public static void main(String[] args) {
        Author book1 = new Author(
                "The Java Handbook",
                2020,
                "Abhishek",
                "Software Developer and Java Enthusiast"
        );

        book1.displayInfo();
    }
}
