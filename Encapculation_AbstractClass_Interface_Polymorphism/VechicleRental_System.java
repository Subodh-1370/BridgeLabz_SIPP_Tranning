interface IInsurable{
    double calculateRentalCost(int days);
    double calculateInsurance(double value);
    String getInsuranceDetails();
}

abstract class Vehicle implements IInsurable {
    private String vehicleNumber;
    private String type;
    private double rentalPrice;
    private int days;

    //constructor
    public Vehicle(String vehicleNumber, String type, double rentalPrice, int days) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalPrice = rentalPrice;
        this.days = days;
    }

    //getters and setters
    public String getVehicleNumber(){
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getRentalPrice() {
        return rentalPrice;
    }
    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }

    //abstract method
    public abstract double calculateRentalCost(int days);

    //interface methods
    public abstract double calculateInsurance(double value);
    public abstract String getInsuranceDetails();
}

class Car extends Vehicle{
    public double value;

    public Car(String vehicleNumber, String type, double rentalPrice, int days, double value) {
        super(vehicleNumber, type, rentalPrice, days);
        this.value = value;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalPrice() * days;
    }
    @Override
    public double calculateInsurance(double value) {
        return value * 0.05;
    }
    @Override
    public String getInsuranceDetails() {
        return "Insurance for " + getType() + " (Vehicle Number: " + getVehicleNumber() + "): " + calculateInsurance(value);
    }

}

class Bike extends Vehicle{
    public double value;

    public Bike(String vehicleNumber, String type, double rentalPrice, int days, double value) {
        super(vehicleNumber, type, rentalPrice, days);
        this.value = value;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalPrice() * days;
    }
    @Override
    public double calculateInsurance(double value) {
        return value * 0.10;
    }
    @Override
    public String getInsuranceDetails() {
        return "Insurance for " + getType() + " (Vehicle Number: " + getVehicleNumber() + "): " + calculateInsurance(value);
    }

}

class Truck extends Vehicle{
    public double value;

    public Truck(String vehicleNumber, String type, double rentalPrice, int days, double value) {
        super(vehicleNumber, type, rentalPrice, days);
        this.value = value;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalPrice() * days;
    }
    @Override
    public double calculateInsurance(double value) {
        return value * 0.05;
    }
    @Override
    public String getInsuranceDetails() {
        return "Insurance for " + getType() + " (Vehicle Number: " + getVehicleNumber() + "): " + calculateInsurance(value);
    }
}

class VehicleRental_System {
    public static void main(String[] args) {
        Vehicle car = new Car("UP85CM0001", "Car", 2500.0, 5, 1500000.0);
        Vehicle bike = new Bike("UP70HP4626", "Bike", 1000.0, 3, 224000.0);
        Vehicle truck = new Truck("NL01AT2354", "Truck", 8000.0, 7, 7000000.0);

        System.out.println("Rental Cost for " + car.getType() + ", " + "\nNumber : " + car.getVehicleNumber() +" : " + "\nCost : " + car.calculateRentalCost(car.getDays()) + "  For days : " + car.getDays());
        System.out.println(car.getInsuranceDetails());

        System.out.println("Rental Cost for " + bike.getType() + ", " + "\nNumber : " + bike.getVehicleNumber() +" : " + "\nCost : " + bike.calculateRentalCost(bike.getDays()) +"  For days : " + bike.getDays());
        System.out.println(bike.getInsuranceDetails());

        System.out.println("Rental Cost for " + truck.getType() + ", " + "\nNumber : " + truck.getVehicleNumber() +" : " + "\nCost : " + truck.calculateRentalCost(truck.getDays()) + "  For days : " + truck.getDays());
        System.out.println(truck.getInsuranceDetails());
    }
}