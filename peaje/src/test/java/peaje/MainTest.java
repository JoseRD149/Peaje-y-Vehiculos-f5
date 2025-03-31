package peaje;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {
    @Test
    void testMainExecution() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{});

        String output = outContent.toString();

        assertTrue(output.contains("Peaje Central"), "Debe contener el nombre de la estación.");
        assertTrue(output.contains("Madrid"), "Debe contener la ciudad.");
        assertTrue(output.contains("Número de Vehículos: 3"), "Debe indicar 3 vehículos registrados.");
    }
}
