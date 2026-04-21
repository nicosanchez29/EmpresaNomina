
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.model.EmpleadoTemporal;
import co.edu.uniquindio.poo.model.categoriaEmpleado;

public class EmpleadoTemporalTest {

    @Test
    void testSalarioNetoNoEsCero() {

        EmpleadoTemporal empleado = new EmpleadoTemporal(
                "Luis",
                "456",
                30,
                0f,
                0f,
                0f,
                null,
                categoriaEmpleado.JUNIOR,
                null,
                10,
                100f
        );

        float resultado = empleado.calcularSalarioNeto();

        assertTrue(resultado > 0);
    }

    @Test
    void testSalarioNetoTemporalMayorACero() {

        EmpleadoTemporal empleado = new EmpleadoTemporal(
                "Temporal",
                "222",
                30,
                0f,
                0f,
                0f,
                null,
                categoriaEmpleado.JUNIOR,
                null,
                10,     // días trabajados válidos
                100f    // valor día válido
        );

        float salarioNeto = empleado.calcularSalarioNeto();

        assertTrue(salarioNeto > 0);
    }
}
