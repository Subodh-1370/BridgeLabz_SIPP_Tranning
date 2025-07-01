class Device{
    String deviceid;
    String status;

    Device(String deviceid , String status){
        this.deviceid=deviceid;
        this.status=status;
    }
    void displayInfo(){
        System.out.println("Deviceid :"+ deviceid );
        System.out.println("Status :"+ status);
    }
}
class Thermosatat extends Device{
    String temperatureSetting;
    Thermosatat(String deviceid , String status , String temperatureSetting){
        super(deviceid ,status);
        this.temperatureSetting = temperatureSetting;

    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("temperatureSetting :"+ temperatureSetting);
    }
}
class SI_SmartDevice {
    public static void main(String[] args) {
        Device D1 =new Thermosatat("EDD23" , "Good" , "Hot");

        D1.displayInfo();
    }
}
