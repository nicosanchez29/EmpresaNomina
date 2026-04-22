package co.edu.uniquindio.poo.model;


import co.edu.uniquindio.poo.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmpresaTest {

    Empresa empresa = new Empresa("Test");

    // 🔹 1. Salario bruto ventas
    @Test
    void salarioBrutoVentasTest() {
        EmpleadoVenta e = new EmpleadoVenta("Kevin", "1", 18, 1000,
                10, 10, empresa, categoriaEmpleado.JUNIOR, null,
                10000, 10);

        assertTrue(e.calcularSalarioBruto() > 1000);
    }

    // 🔹 2. Salario neto temporal != 0
    @Test
    public void salarioTemporalNoCeroTest() {
        EmpleadoTemporal e = new EmpleadoTemporal("Kevin", "2", 18, 0,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                10, 100);

        assertNotEquals(0, e.calcularSalarioNeto());
    }

    // 🔹 3. Empleados almacenados
    @Test
    public void empleadosGuardadosTest() {
        EmpleadoTemporal e = new EmpleadoTemporal("Kevin", "3", 20, 0,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                5, 100);

        empresa.registrarEmpleado(e);

        assertEquals(1, empresa.getListaEmpleados().size());
    }

    // 🔹 4. Bonificación JUNIOR > 0
    @Test
    public void bonificacionJuniorTest() {
        EmpleadoTemporal e = new EmpleadoTemporal("Kevin", "4", 20, 1000,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                5, 100);

        assertTrue(e.calcularBonificacionCategoria() > 0);
    }

    // 🔹 5. Salario neto nunca negativo
    @Test
    public void salarioNoNegativoTest() {
        EmpleadoTemporal e = new EmpleadoTemporal("Kevin", "5", 20, 1000,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                5, 100);

        assertTrue(e.calcularSalarioNeto() >= 0);
    }

    // 🔹 6. Buscar inexistente
    @Test
    public void buscarInexistenteTest() {
        assertTrue(empresa.buscarEmpleado("999").isEmpty());
    }

    // 🔹 7. Excepción salario negativo
    @Test
    public void salarioNegativoExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EmpleadoTemporal("Kevin", "6", 20, -1000,
                    0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                    5, 100);
        });
    }

    // 🔹 8. empleadosConSalarioMayorA
    @Test
    public void empleadosMayorSalarioTest() {

        EmpleadoTemporal e1 = new EmpleadoTemporal("A", "7", 20, 0,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                10, 100);

        EmpleadoTemporal e2 = new EmpleadoTemporal("B", "8", 20, 0,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                1, 10);

        empresa.registrarEmpleado(e1);
        empresa.registrarEmpleado(e2);

        List<Empleado> lista = empresa.obtenerEmpleadosMayorSalarioA(500);

        assertEquals(1, lista.size());
    }

    // 🔹 9. No duplicados
    @Test
    public void noDuplicadosTest() {
        EmpleadoTemporal e = new EmpleadoTemporal("Kevin", "9", 20, 0,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                5, 100);

        empresa.registrarEmpleado(e);
        empresa.registrarEmpleado(e);

        assertEquals(1, empresa.getListaEmpleados().size());
    }

    // 🔹 10. Empleado que más gana
    @Test
    public void empleadoMasGanaTest() {

        EmpleadoTemporal e1 = new EmpleadoTemporal("Nico", "10", 20, 0,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                10, 100);

        EmpleadoTemporal e2 = new EmpleadoTemporal("Kevin", "11", 20, 0,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                1, 10);

        empresa.registrarEmpleado(e1);
        empresa.registrarEmpleado(e2);

        assertEquals(e1, empresa.obtenerEmpleadoMayorSalario());
    }

    // 🔹 11. Temporales > 100 horas
    @Test
    public void temporalesMas100HorasTest() {

        EmpleadoTemporal e = new EmpleadoTemporal("Kevin", "12", 20, 0,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                13, 10);

        empresa.registrarEmpleado(e);

        List<EmpleadoTemporal> lista = empresa.obtenerTemporalesMasDe100Dias();

        assertEquals(1, lista.size());
    }

    // 🔹 12. Planta neto > base
    @Test
    public void plantaMayorBaseTest() {

        EmpleadoPlanta e = new EmpleadoPlanta("Kevin", "13", 20, 1000,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                "Dev", 10, 50, 100);

        assertTrue(e.calcularSalarioNeto() > 1000);
    }

    // 🔹 13. Temporal neto > 0
    @Test
    public void temporalMayorCeroTest() {

        EmpleadoTemporal e = new EmpleadoTemporal("Kevin", "14", 20, 0,
                0, 0, empresa, categoriaEmpleado.JUNIOR, null,
                10, 100);

        assertTrue(e.calcularSalarioNeto() > 0);
    }
}