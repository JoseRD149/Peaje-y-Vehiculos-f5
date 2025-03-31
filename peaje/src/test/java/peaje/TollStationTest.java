package peaje;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TollStationTest {
    private TollStation station;

    @BeforeEach
    void setup() {
        station = new TollStation("Peaje Norte", "Barcelona");
    }

    @Test
    void totalTollShouldBeZeroInitially() {
        assertEquals(0, station.getTotalToll(), "El total de peajes debe ser 0 al inicio.");
    }

    @Test
    void registeringVehiclesShouldIncreaseTotalToll() {
        station.registerVehicle(new Car("ABC123"));
        station.registerVehicle(new Motorcycle("XYZ789"));
        station.registerVehicle(new Truck("JKL456", 2));

        assertEquals(100 + 50 + (2 * 50), station.getTotalToll(), "El total de peajes no coincide con lo esperado.");
    }

    @Test
    void shouldRegisterCorrectNumberOfVehicles() {
        station.registerVehicle(new Car("ABC123"));
        station.registerVehicle(new Car("DEF456"));
        station.registerVehicle(new Car("GHI789"));

        assertEquals(3, station.getTotalToll() / 100, "Se registraron 3 autos, cada uno con peaje 100.");
    }

    @Test
    void shouldHandleVehiclesWithSameLicensePlate() {
        Vehicle car1 = new Car("DUP123");
        Vehicle car2 = new Car("DUP123");

        station.registerVehicle(car1);
        station.registerVehicle(car2);

        assertEquals(200, station.getTotalToll(), "Incluso si las matrículas son iguales, cada registro debe sumar peaje.");
    }

    @Test
    void testToStringFormat() {
        station.registerVehicle(new Car("ABC123"));
        String output = station.toString();
        
        assertTrue(output.contains("Peaje Norte"), "Debe contener el nombre de la estación.");
        assertTrue(output.contains("Barcelona"), "Debe contener la ciudad.");
        assertTrue(output.contains("100"), "Debe reflejar el peaje acumulado correctamente.");
    }

    @Test
    void testPrintTollSummary() {
        station.registerVehicle(new Car("XYZ789"));
        station.registerVehicle(new Truck("TRK111", 3));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        station.printTollSummary();

        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("Peaje Norte"), "El resumen debe incluir el nombre de la estación.");
        assertTrue(output.contains("Barcelona"), "El resumen debe incluir la ciudad.");
        assertTrue(output.contains("250"), "El total de peaje debe aparecer en el resumen.");
    }

    @Test
    void testNoVehiclesRegistered() {
        String output = station.toString();
        assertTrue(output.contains("0"), "Cuando no hay vehículos, el total debe ser 0.");
    }
}
