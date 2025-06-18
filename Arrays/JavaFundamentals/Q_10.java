class Main {
    public static void main(String[] args) {
        double r = 6378.0;

        double volume = (4.0 / 3.0) * (22.0 / 7.0) * Math.pow(r, 3); 
        double volumeMiles = volume * 0.621;  
        System.out.println("Volume in Km³: " + volume);
        System.out.println("Volume in Miles³: " + volumeMiles);
    }
}
