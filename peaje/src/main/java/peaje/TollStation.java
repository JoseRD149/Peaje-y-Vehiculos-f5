package peaje;
import java.util.ArrayList;
import java.util.List;

public class TollStation {
    private String name;
    private String city;
    private int totalToll;
    private List<Vehicle> vehicles;

    public TollStation(String name, String city) {
        this.name = name;
        this.city = city;
        this.totalToll = 0;
        this.vehicles = new ArrayList<>();
    }

    public void registerVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        totalToll += vehicle.getTollFee(); 
    }

    public int getTotalToll() {
        return totalToll;
    }
    public void printTollSummary() {
        System.out.println("Estación de Peaje: " + name);
        System.out.println("Ciudad: " + city);
        System.out.println("Total Recopilado: $" + totalToll);
        System.out.println("Número de Vehículos: " + vehicles.size());
    }
}

   