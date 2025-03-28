package peaje;

public class Main {
    public static void main(String[] args) {
        TollStation station = new TollStation("Peaje Central", "Madrid");

        Vehicle car = new Car("ABC123");
        Vehicle motorcycle = new Motorcycle("XYZ789");
        Vehicle truck = new Truck("JKL456", 3);

        station.registerVehicle(car);
        station.registerVehicle(motorcycle);
        station.registerVehicle(truck);

        station.printTollSummary();
    }
}
