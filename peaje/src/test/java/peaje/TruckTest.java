package peaje;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    @Test
    void truckWithZeroAxlesShouldHaveZeroTollFee() {
        Truck truck = new Truck("TEST000", 0);
        assertEquals(0, truck.getTollFee());
    }

    @Test
    void truckWithOneAxleShouldHave50TollFee() {
        Truck truck = new Truck("TEST001", 1);
        assertEquals(50, truck.getTollFee());
    }

    @Test
    void truckWithMultipleAxlesShouldCalculateCorrectFee() {
        Truck truck = new Truck("TEST002", 5);
        assertEquals(250, truck.getTollFee()); // 5 ejes * 50
    }
}
