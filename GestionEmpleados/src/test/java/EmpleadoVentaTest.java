import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.model.EmpleadoVenta;
import co.edu.uniquindio.poo.model.categoriaEmpleado;

public class EmpleadoVentaTest {

    @Test
    void testCalcularSalarioBrutoEmpleadoVenta() {


        float salarioBase = 1000f;
        float totalVentas = 2000f;
        float porcentajeComision = 10f;

        EmpleadoVenta empleado = new EmpleadoVenta("Ana",
                "123",
                25,
                salarioBase,
                0f,
                0f,
                null,
                categoriaEmpleado.JUNIOR,
                null,
                totalVentas,
                porcentajeComision);


        float resultado = empleado.calcularSalarioBruto();


        float comisionEsperada = totalVentas * porcentajeComision / 100;
        float bonificacion = empleado.calcularBonificacionCategoria();
        float esperado = salarioBase + bonificacion + comisionEsperada;

        assertEquals(esperado, resultado, 0.001);
    }
}
