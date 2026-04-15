package co.edu.uniquindio.poo.model;

public class EmpleadoVenta extends Empleado {

    //ATRIBUTOS

    private float totalVentas;
    private float porcentajeComision;

    //CONSTRUCTOR


    public EmpleadoVenta(String nombre, String documento, int edad, float salarioBase, float descuentoSalud, float descuentoPension, Empresa ownedByEmpresa, categoriaEmpleado categoriaEmpleado, ResumenPago resumenPago, float totalVentas, float porcentajeComision) {
        super(nombre, documento, edad, salarioBase, descuentoSalud, descuentoPension, ownedByEmpresa, categoriaEmpleado, resumenPago);


        if (totalVentas < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser negativas");
        }

        if (porcentajeComision < 0 || porcentajeComision > 100) {
            throw new IllegalArgumentException("El porcentaje de comisión debe estar entre 0 y 100");
        }

        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }

    public EmpleadoVenta(float totalVentas, float porcentajeComision) {
        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }

    //SETS Y GETS


    public float getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(float totalVentas) {
        this.totalVentas = totalVentas;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    //METODO TOSTRING


    @Override
    public String toString() {
        return "EmpleadoVenta{" +
                "totalVentas=" + totalVentas +
                ", porcentajeComision=" + porcentajeComision +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", salarioBase=" + salarioBase +
                ", descuentoSalud=" + descuentoSalud +
                ", descuentoPension=" + descuentoPension +
                '}';
    }

    //METODOS

    @Override
    public void actualizarDatos(Empleado empleado) {
        EmpleadoVenta aux = (EmpleadoVenta) empleado;

        this.setTotalVentas(aux.getTotalVentas());
        this.setPorcentajeComision(aux.getPorcentajeComision());
    }

    @Override
    public float calcularSalarioBruto() {
        float comision = totalVentas * porcentajeComision / 100;
        return salarioBase
                + calcularBonificacionCategoria()
                + comision;
    }
}
