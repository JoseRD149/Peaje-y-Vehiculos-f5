package peaje;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;

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
        StringBuilder summary = new StringBuilder();
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        summary.append("Estación de Peaje: ").append(name).append("\n")
               .append("Ciudad: ").append(city).append("\n")
               .append("Total Recopilado: ").append(currencyFormat.format(totalToll)).append("\n")
               .append("Número de Vehículos: ").append(vehicles.size()).append("\n");

        System.out.println(summary.toString());
    }

    
    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return String.format("Estación de Peaje: %s, Ciudad: %s, Total Recopilado: %s, Número de Vehículos: %d",
                name, city, currencyFormat.format(totalToll), vehicles.size());
    }
}
