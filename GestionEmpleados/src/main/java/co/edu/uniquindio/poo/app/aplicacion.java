package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;
import co.edu.uniquindio.poo.model.Empresa;

import javax.swing.*;

public class aplicacion {

    public static void main(String[] args) {

        Empresa empresa = new Empresa("Mi Empresa");
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "===== MENÚ =====\n" +
                            "1. Registrar Empleado Planta\n" +
                            "2. Registrar Empleado Ventas\n" +
                            "3. Registrar Empleado Temporal\n" +
                            "4. Mostrar Empleados\n" +
                            "5. Calcular Nómina Total\n" +
                            "6. Empleado que más gana\n" +
                            "7. Generar Resúmenes\n" +
                            "8. Mostrar Resúmenes\n" +
                            "9. Salir"
            ));

            switch (opcion) {

                case 1:
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    String documento = JOptionPane.showInputDialog("Documento:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                    float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Salario base:"));
                    float salud = Float.parseFloat(JOptionPane.showInputDialog("Descuento salud:"));
                    float pension = Float.parseFloat(JOptionPane.showInputDialog("Descuento pensión:"));

                    int cat = Integer.parseInt(JOptionPane.showInputDialog("Categoría:\n1. JUNIOR\n2. SEMI_SENIOR\n3. SENIOR"));
                    categoriaEmpleado categoria = categoriaEmpleado.values()[cat - 1];

                    String cargo = JOptionPane.showInputDialog("Cargo:");
                    int horas = Integer.parseInt(JOptionPane.showInputDialog("Horas extras:"));
                    float valorHora = Float.parseFloat(JOptionPane.showInputDialog("Valor hora extra:"));
                    float aux = Float.parseFloat(JOptionPane.showInputDialog("Auxilio transporte:"));

                    EmpleadoPlanta planta = new EmpleadoPlanta(
                            nombre, documento, edad, salarioBase,
                            salud, pension, empresa, categoria, null,
                            cargo, horas, valorHora, aux
                    );

                    JOptionPane.showMessageDialog(null, empresa.registrarEmpleado(planta));
                    break;

                case 2:
                    nombre = JOptionPane.showInputDialog("Nombre:");
                    documento = JOptionPane.showInputDialog("Documento:");
                    edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                    salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Salario base:"));
                    salud = Float.parseFloat(JOptionPane.showInputDialog("Descuento salud:"));
                    pension = Float.parseFloat(JOptionPane.showInputDialog("Descuento pensión:"));

                    cat = Integer.parseInt(JOptionPane.showInputDialog("Categoría:\n1. JUNIOR\n2. SEMI_SENIOR\n3. SENIOR"));
                    categoria = categoriaEmpleado.values()[cat - 1];

                    float ventas = Float.parseFloat(JOptionPane.showInputDialog("Total ventas:"));
                    float comision = Float.parseFloat(JOptionPane.showInputDialog("Porcentaje comisión:"));

                    EmpleadoVenta ventasEmp = new EmpleadoVenta(
                            nombre, documento, edad, salarioBase,
                            salud, pension, empresa, categoria, null,
                            ventas, comision
                    );

                    JOptionPane.showMessageDialog(null, empresa.registrarEmpleado(ventasEmp));
                    break;

                case 3:
                    nombre = JOptionPane.showInputDialog("Nombre:");
                    documento = JOptionPane.showInputDialog("Documento:");
                    edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                    salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Salario base:"));
                    salud = Float.parseFloat(JOptionPane.showInputDialog("Descuento salud:"));
                    pension = Float.parseFloat(JOptionPane.showInputDialog("Descuento pensión:"));

                    cat = Integer.parseInt(JOptionPane.showInputDialog("Categoría:\n1. JUNIOR\n2. SEMI_SENIOR\n3. SENIOR"));
                    categoria = categoriaEmpleado.values()[cat - 1];

                    int dias = Integer.parseInt(JOptionPane.showInputDialog("Días trabajados:"));
                    float valorDia = Float.parseFloat(JOptionPane.showInputDialog("Valor por día:"));

                    EmpleadoTemporal temporal = new EmpleadoTemporal(
                            nombre, documento, edad, salarioBase,
                            salud, pension, empresa, categoria, null,
                            dias, valorDia
                    );

                    JOptionPane.showMessageDialog(null, empresa.registrarEmpleado(temporal));
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, empresa.getListaEmpleados());
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Nómina total: " + empresa.calcularNominaEmpresa());
                    break;

                case 6:
                    Empleado mayor = empresa.obtenerEmpleadoMayorSalario();
                    if (mayor != null) {
                        JOptionPane.showMessageDialog(null, "Empleado que más gana:\n" + mayor);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay empleados");
                    }
                    break;

                case 7:
                    empresa.mostrarResumenesPago();
                    JOptionPane.showMessageDialog(null, "Resúmenes generados");
                    break;

                case 8:
                    JOptionPane.showMessageDialog(null, empresa.mostrarResumenesPago());
                    break;

                case 9:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 9);
    }
}
