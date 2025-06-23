import java.util.Scanner;

class MovieTicket {
    String movieName;
    String seatNumber;
    double price;

    // Constructor
    MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = "Not Booked";
        this.price = 0.0;
    }

    // Method to book a ticket
    void bookTicket(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket successfully booked!");
    }

    // Method to display ticket details
    void displayTicket() {
        System.out.println("\n--- Ticket Details ---");
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price      : ₹" + price);
    }
}

public class MovieTicketSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Movie Name: ");
        String movieName = sc.nextLine();

        MovieTicket ticket = new MovieTicket(movieName);

        System.out.print("Enter Seat Number to Book: ");
        String seat = sc.nextLine();

        System.out.print("Enter Ticket Price: ");
        double price = sc.nextDouble();

        ticket.bookTicket(seat, price);
        ticket.displayTicket();
    }
}
