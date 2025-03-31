package peaje;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testLicensePlate() {
        Vehicle car = new Car("ABC123");
        assertEquals("ABC123", car.getLicensePlate(), "La matrícula del vehículo debería ser ABC123");
    }

    @Test
    void testTollFeeForCar() {
        Vehicle car = new Car("XYZ789");
        assertEquals(100, car.getTollFee(), "El peaje para un coche debe ser 100");
    }

    @Test
    void testDifferentLicensePlates() {
        Vehicle car1 = new Car("AAA111");
        Vehicle car2 = new Car("BBB222");
        assertNotEquals(car1.getLicensePlate(), car2.getLicensePlate(), "Las matrículas deberían ser diferentes");
    }

    @Test
    void testTollFeeForMultipleCars() {
        Vehicle car1 = new Car("CCC333");
        Vehicle car2 = new Car("DDD444");
        assertEquals(100, car1.getTollFee(), "El peaje para car1 debe ser 100");
        assertEquals(100, car2.getTollFee(), "El peaje para car2 debe ser 100");
    }

    @Test
    void testVehicleInheritance() {
        Vehicle car = new Car("EEE555");
        assertTrue(car instanceof Vehicle, "Car debería ser una instancia de Vehicle");
    }


    @Test
    void testLongLicensePlate() {
        Vehicle car = new Car("ABCDEFGHIJ"); 
        assertEquals("ABCDEFGHIJ", car.getLicensePlate(), "Debería permitir matrículas largas");
    }


    @Test
    void testNotEqualsWithDifferentLicensePlates() {
        Vehicle car1 = new Car("TEST123");
        Vehicle car2 = new Car("DIFF456");
        assertNotEquals(car1, car2, "Dos vehículos con matrículas diferentes no deben ser iguales");
    }

    @Test
    void testMultipleVehiclesCreation() {
        for (int i = 0; i < 1000; i++) {
            Vehicle car = new Car("CAR" + i);
            assertEquals("CAR" + i, car.getLicensePlate(), "Cada vehículo debe tener una matrícula única");
        }
    }
}
