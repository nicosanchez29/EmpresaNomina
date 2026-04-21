import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.categoriaEmpleado;
public class EmpleadoTest {

    @Test
    void testBonificacionJuniorMayorQueCero() {

        Empleado empleado = new Empleado(
                "Carlos",
                "789",
                28,
                1000f,
                0f,
                0f,
                null,
                categoriaEmpleado.JUNIOR,
                null
        )

        float bonificacion = empleado.calcularBonificacionCategoria();

        assertTrue(bonificacion > 0);
    }

    @Test
    void testSalarioNetoNuncaNegativo() {

        Empleado empleado = new Empleado(
                "Laura",
                "999",
                30,
                1000f,
                2000f,
                2000f,
                null,
                categoriaEmpleado.JUNIOR,
                null
        );

        float salarioNeto = empleado.calcularSalarioNeto();

        assertTrue(salarioNeto >= 0);
    }

    @Test
    void testSalarioBaseNegativoLanzaExcepcion() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Empleado(
                    "Error",
                    "000",
                    25,
                    -1000f,
                    0f,
                    0f,
                    null,
                    categoriaEmpleado.JUNIOR,
                    null
            );

        });
    }


}
