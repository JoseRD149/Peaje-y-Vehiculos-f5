package peaje;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TollStationTest {
    private TollStation station;

    @BeforeEach
    void setup() {
        station = new TollStation("Peaje Norte", "Barcelona"); 
    }

    @Test
    void totalTollShouldBeZeroInitially() {
        assertEquals(0, station.getTotalToll());
    }

    @Test
    void registeringVehiclesShouldIncreaseTotalToll() {
        station.registerVehicle(new Car("ABC123"));
        station.registerVehicle(new Motorcycle("XYZ789"));
        station.registerVehicle(new Truck("JKL456", 2));

        assertEquals(100 + 50 + (2 * 50), station.getTotalToll());
    }
}
