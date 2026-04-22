package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

public class Empresa {

    //ATRIBUTOS

    private String nombre;

    //RELACIONES

    private List<Empleado> ListaEmpleados;

    //CONSTRUCTOR

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.ListaEmpleados = new ArrayList<>();
    }


     //SETS Y GETS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getListaEmpleados() {
        return ListaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        ListaEmpleados = listaEmpleados;
    }

    //METODO TOSTRING


    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", ListaEmpleados=" + ListaEmpleados +
                '}';
    }

    //CRUD DE EMPLEADO

    /**
     * Este metodo sirve para registrar un empleado
     * @param empleado
     * @return
     */

    public String registrarEmpleado (Empleado empleado){
        String respuesta = "";

        Optional<Empleado> empleadoEncontrado = buscarEmpleado (empleado.getDocumento());
        if (empleadoEncontrado.isPresent()){
            respuesta = "El empleado existe";
        }else{
            ListaEmpleados.add(empleado);
            respuesta = "Empleado registrado correctamente";
        }
        return respuesta;
    }

    /**
     * Este metodo sirve para buscar a un empleado por medio de su documento
     * @param documento
     * @return
     */

    public Optional<Empleado> buscarEmpleado (String documento) {
        return ListaEmpleados.stream()
                .filter(empleado -> empleado.getDocumento().equals(documento))
                .findAny();
    }


    /**
     * Este metodo sirve para actualizar la informacion de un empleado
     * @param empleado
     * @return
     */

    public String actualizarEmpleado (Empleado empleado){

        Optional<Empleado> empleadoEncontrado = buscarEmpleado(empleado.getDocumento());
        if (empleadoEncontrado.isEmpty()) {
            return "El empleado no existe";
        }

        Empleado existente = empleadoEncontrado.get();

        existente.setNombre(empleado.getNombre());
        existente.setSalarioBase(empleado.getSalarioBase());
        existente.setCategoriaEmpleado(empleado.getCategoriaEmpleado());

        existente.actualizarDatos(empleado);

        return "Empleado actualizado correctamente";

    }

    /**
     * Este metodo sirve para eliminar a un empleado
     * @param empleado
     * @return
     */

    public String eliminarEmpleado (Empleado empleado){
        Optional<Empleado> empleadoEncontrado = buscarEmpleado(empleado.getDocumento());

        if (empleadoEncontrado.isEmpty()) {
            return "El empleado no existe";
        }

        ListaEmpleados.remove(empleadoEncontrado.get());

        return "Empleado eliminado correctamente";
    }

    //OTROS METODOS


    public String mostrarResumenesPago() {

        if (ListaEmpleados.isEmpty()) {
            return "No hay empleados registrados";
        }

        String resultado = "";

        for (Empleado e : ListaEmpleados) {
            resultado += e.getResumenPago() + "\n\n";
        }

        return resultado;
    }

    public Empleado obtenerEmpleadoMayorSalario() {

        if (ListaEmpleados.isEmpty()) {
            return null;
        }

        Empleado mayor = ListaEmpleados.get(0);

        for (Empleado e : ListaEmpleados) {
            if (e.calcularSalarioNeto() > mayor.calcularSalarioNeto()) {
                mayor = e;
            }
        }

        return mayor;
    }

    public float calcularNominaEmpresa() {

        float total = 0;

        for (Empleado e : ListaEmpleados) {
            total += e.calcularSalarioNeto();
        }

        return total;
    }

    public List<Empleado> obtenerEmpleadosMayorSalarioA(float salarioMinimo) {
        List<Empleado> resultado = new ArrayList<>();

        for (Empleado e : ListaEmpleados) {
            if (e.calcularSalarioNeto() > salarioMinimo) {
                resultado.add(e);
            }
        }

        return resultado;
    }

    public float obtenerEltotalDelSalarioDePlanta (){
        float total = 0;

        for (Empleado e : ListaEmpleados) {
            if (e instanceof EmpleadoPlanta) {
                total += e.calcularSalarioNeto();
            }
        }

        return total;
    }

    public List<EmpleadoTemporal> obtenerTemporalesMasDe100Dias() {
        List<EmpleadoTemporal> resultado = new ArrayList<>();

        for (Empleado e : ListaEmpleados) {
            if (e instanceof EmpleadoTemporal) {
                EmpleadoTemporal temp = (EmpleadoTemporal) e;

                if (temp.getDiasTrabajados() * 8 > 100) {
                    resultado.add(temp);
                }
            }
        }

        return resultado;
    }

}




