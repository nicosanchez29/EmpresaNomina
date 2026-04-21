

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.categoriaEmpleado;
import co.edu.uniquindio.poo.model.ResumenPago;
import co.edu.uniquindio.poo.model.EmpleadoTemporal;

public class EmpresaTest {

    @Test
    void testEmpleadosAlmacenadosCorrectamente() {

        Empresa empresa = new Empresa("Mi empresa");

        Empleado e1 = new Empleado(
                "Juan",
                "1",
                25,
                1000f,
                0f,
                0f,
                null,
                categoriaEmpleado.JUNIOR,
                null
        ) {
            @Override
            public void actualizarDatos(Empleado empleado) {

            }

            @Override
            public float calcularSalarioBruto() {
                return 0;
            }
        };


    };
        Empleado e2 = new Empleado("Ana", "2", 30, 2000f, 0f, 0f, null, categoriaEmpleado.SENIOR, null) {
            @Override
            public void actualizarDatos(Empleado empleado) {

            }

            @Override
            public float calcularSalarioBruto() {
                return 0;
            }
        };

        Empresa.registrarEmpleado(e1);
        Empresa.registrarEmpleado(e2);

        ArrayList<Empleado> lista = Empresa.getListaEmpleados();

        assertEquals(2, lista.size());
        assertTrue(lista.contains(e1));
        assertTrue(lista.contains(e2));
    }

@Test
void testBuscarEmpleadoInexistente() {

    Empresa empresa = new Empresa("Mi empresa");

    Optional<Empleado> resultado = empresa.buscarEmpleado("999");

    assertTrue(resultado.isEmpty());
}

@Test
void testEmpleadosConSalarioMayorA() {

    Empresa empresa = new Empresa("Mi empresa");

    Empleado e1 = new Empleado("Juan", "1", 25, 1000f, 0f, 0f, null, categoriaEmpleado.JUNIOR, null);
    Empleado e2 = new Empleado("Ana", "2", 30, 2000f, 0f, 0f, null, categoriaEmpleado.SENIOR, null);
    Empleado e3 = new Empleado("Luis", "3", 28, 3000f, 0f, 0f, null, categoriaEmpleado.SEMI_SENIOR, null);

    empresa.registrarEmpleado(e1);
    empresa.registrarEmpleado(e2);
    empresa.registrarEmpleado(e3);

    // ACT
    List<Empleado> resultado = empresa.obtenerEmpleadosMayorSalarioA(1500f);

    // ASSERT
    assertEquals(2, resultado.size());
    assertEquals(e2, resultado.get(0)); // orden correcto
    assertEquals(e3, resultado.get(1));
}

@Test
void testBuscarPorDocumentoInexistente() {

    Empresa empresa = new Empresa("Mi empresa");

    Optional<Empleado> resultado = empresa.buscarEmpleado("999");

    assertTrue(resultado.isEmpty());
}
@Test
void testNoPermitirEmpleadosDuplicados() {

    Empresa empresa = new Empresa("Mi empresa");

    Empleado e1 = new Empleado("Juan", "1", 25, 1000f, 0f, 0f, null, categoriaEmpleado.JUNIOR, null);
    Empleado e2 = new Empleado("Pedro", "1", 30, 2000f, 0f, 0f, null, categoriaEmpleado.SENIOR, null); // mismo documento

    String respuesta1 = empresa.registrarEmpleado(e1);
    String respuesta2 = empresa.registrarEmpleado(e2);


    assertEquals("Empleado registrado correctamente", respuesta1);
    assertEquals("El empleado existe", respuesta2);
    assertEquals(1, empresa.getListaEmpleados().size());
}
@Test
void testObtenerEmpleadoMayorSalario() {

    Empresa empresa = new Empresa("Mi empresa");

    Empleado e1 = new Empleado("Juan", "1", 25, 1000f, 0f, 0f, null, categoriaEmpleado.JUNIOR, null);
    Empleado e2 = new Empleado("Ana", "2", 30, 3000f, 0f, 0f, null, categoriaEmpleado.SENIOR, null);
    Empleado e3 = new Empleado("Luis", "3", 28, 2000f, 0f, 0f, null, categoriaEmpleado.MID, null);

    empresa.registrarEmpleado(e1);
    empresa.registrarEmpleado(e2);
    empresa.registrarEmpleado(e3);

    // ACT
    Empleado mayor = empresa.obtenerEmpleadoMayorSalario();

    // ASSERT
    assertNotNull(mayor);
    assertEquals(e2, mayor);
}
@Test
void testObtenerTemporalesMasDe100Dias() {

    Empresa empresa = new Empresa("Mi empresa");

    EmpleadoTemporal e1 = new EmpleadoTemporal("Temp1", "1", 25, 0f, 0f, 0f, null, categoriaEmpleado.JUNIOR, null, 120, 100f);
    EmpleadoTemporal e2 = new EmpleadoTemporal("Temp2", "2", 30, 0f, 0f, 0f, null, categoriaEmpleado.JUNIOR, null, 80, 100f);
    Empleado e3 = new Empleado("Planta", "3", 28, 2000f, 0f, 0f, null, categoriaEmpleado.SENIOR, null);

    empresa.registrarEmpleado(e1);
    empresa.registrarEmpleado(e2);
    empresa.registrarEmpleado(e3);

    // ACT
    List<EmpleadoTemporal> resultado = empresa.obtenerTemporalesMasDe100Dias();

    // ASSERT
    assertEquals(1, resultado.size());
    assertEquals(e1, resultado.get(0));
}



}