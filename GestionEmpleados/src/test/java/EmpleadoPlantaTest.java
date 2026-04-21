
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.model.EmpleadoPlanta;

public class EmpleadoPlantaTest {

    @Test
    void testSalarioNetoMayorQueBase() {

        float salarioBase = 1000f;

        EmpleadoPlanta empleado = new EmpleadoPlanta(
                "Planta",
                "111",
                35,
                salarioBase,
                0f,
                0f,
                null,
                categoriaEmpleado.SENIOR,
                null
        );

        float salarioNeto = empleado.calcularSalarioNeto();

        assertTrue(salarioNeto > salarioBase);
    }


}
