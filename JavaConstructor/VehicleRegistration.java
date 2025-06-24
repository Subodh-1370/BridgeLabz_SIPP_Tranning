public class VehicleRegistration {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 500.00;

    public VehicleRegistration(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        VehicleRegistration v1 = new VehicleRegistration("Subodh", "Bike");
        v1.displayVehicleDetails();
        updateRegistrationFee(650);
        v1.displayVehicleDetails();
    }
}