package peaje;
import java.util.ArrayList;
import java.util.List;

public class TollStation {
    private String name;
    private String city;
    private int totalCollected;
    private List<Vehicle> vehiclesList;

    public TollStation(String name,String city){
        this.name = name;
        this.city = city;
        this.totalCollected = 0;
        this.vehiclesList = new ArrayList<>();

    }
    public void registerVehicle(Vehicle vehicle) {
        vehiclesList.add(vehicle);
        totalCollected += vehicle.getTollFee();
    }
    
    public int getTotalToll(){
        return totalCollected;
    }
    public void printTollSummary() {
        System.out.println("Toll Station: " + name + " - " + city);
        for (Vehicle v : vehiclesList) {
            System.out.println("Vehicle: " + v.getLicensePlate() + " | Toll: $" + v.getTollFee());
        }
        System.out.println("Total Collected: $" + totalCollected);
    }
}