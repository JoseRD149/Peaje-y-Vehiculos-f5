package peaje;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VehicleTest {

    @Test
    void carTollFeeShouldBe100() {
        Car car = new Car("ABC123");
        assertEquals(100, car.getTollFee());
    }

    @Test
    void motorcycleTollFeeShouldBe50() {
        Motorcycle moto = new Motorcycle("XYZ789");
        assertEquals(50, moto.getTollFee());
    }

    @Test
    void truckTollFeeShouldBeCalculatedCorrectly() {
        Truck truck = new Truck("JKL456", 3);
        assertEquals(150, truck.getTollFee());
    }
}
