import java.util.Scanner;

// MovieList class with all doubly linked list functionalities
class MovieList {
    class Node {
        String title;
        String director;
        int year;
        double rating;
        Node next;
        Node prev;

        Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    private Node head;
    private Node tail;

    // Add movie at end
    public void addLast(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add movie at beginning
    public void addFirst(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add at specific position (1-based)
    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        if (pos == 1) {
            addFirst(title, director, year, rating);
            return;
        }

        Node newNode = new Node(title, director, year, rating);
        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addLast(title, director, year, rating);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        Node temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (temp == head && temp == tail) {
            head = tail = null;
        } else if (temp == head) {
            head = head.next;
            head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie '" + title + "' removed.");
    }

    // Search by director
    public void searchByDirector(String director) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movie found by Director: " + director);
    }

    // Search by rating
    public void searchByRating(double rating) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movie found with Rating: " + rating);
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        Node temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Updated rating for movie: " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display all movies (forward)
    public void displayForward() {
        Node temp = head;
        System.out.println("\n--- Movie List (Forward) ---");
        if (temp == null) {
            System.out.println("No movies to display.");
            return;
        }
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Display all movies (reverse)
    public void displayReverse() {
        Node temp = tail;
        System.out.println("\n--- Movie List (Reverse) ---");
        if (temp == null) {
            System.out.println("No movies to display.");
            return;
        }
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // Display one movie node
    private void displayMovie(Node m) {
        System.out.println("Title: " + m.title + ", Director: " + m.director +
                ", Year: " + m.year + ", Rating: " + m.rating);
    }
}
public class DLL_MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList movies = new MovieList();
        int choice;

        do {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at End");
            System.out.println("2. Add Movie at Beginning");
            System.out.println("3. Add Movie at Specific Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display All Movies (Forward)");
            System.out.println("9. Display All Movies (Reverse)");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            String title, director;
            int year, pos;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.next();
                    director = sc.next();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    movies.addLast(title, director, year, rating);
                    break;

                case 2:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.next();
                    director = sc.next();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    movies.addFirst(title, director, year, rating);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.next();
                    director = sc.next();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    movies.addAtPosition(pos, title, director, year, rating);
                    break;

                case 4:
                    System.out.print("Enter Movie Title to Remove: ");
                    title = sc.next();
                    movies.removeByTitle(title);
                    break;

                case 5:
                    System.out.print("Enter Director Name to Search: ");
                    director = sc.next();
                    movies.searchByDirector(director);
                    break;

                case 6:
                    System.out.print("Enter Rating to Search: ");
                    rating = sc.nextDouble();
                    movies.searchByRating(rating);
                    break;

                case 7:
                    System.out.print("Enter Movie Title to Update Rating: ");
                    title = sc.next();
                    System.out.print("Enter New Rating: ");
                    rating = sc.nextDouble();
                    movies.updateRating(title, rating);
                    break;

                case 8:
                    movies.displayForward();
                    break;

                case 9:
                    movies.displayReverse();
                    break;

                case 0:
                    System.out.println("Exiting Movie Management System.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        sc.close();;
    }
}