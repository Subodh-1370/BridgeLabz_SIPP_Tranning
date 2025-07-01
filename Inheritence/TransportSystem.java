// Superclass
class Vehicle {
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Subclass Car
class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type: Car");
        System.out.println("Seat Capacity: " + seatCapacity);
        System.out.println();
    }
}

// Subclass Truck
class Truck extends Vehicle {
    int loadCapacity; // in tons

    Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type: Truck");
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println();
    }
}

// Subclass Motorcycle
class Motorcycle extends Vehicle {
    boolean hasStorage;

    Motorcycle(int maxSpeed, String fuelType, boolean hasStorage) {
        super(maxSpeed, fuelType);
        this.hasStorage = hasStorage;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type: Motorcycle");
        System.out.println("Has Storage: " + (hasStorage ? "Yes" : "No"));
        System.out.println();
    }
}

// Main class
public class TransportSystem {
    public static void main(String[] args) {
        // Polymorphic array of Vehicle
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10);
        vehicles[2] = new Motorcycle(150, "Petrol", true);

        // Dynamic method dispatch
        for (Vehicle v : vehicles) {
            v.displayInfo();  // calls appropriate subclass method
        }
    }
}
