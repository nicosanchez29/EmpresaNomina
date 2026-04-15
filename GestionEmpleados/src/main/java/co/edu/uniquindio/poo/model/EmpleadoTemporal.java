package co.edu.uniquindio.poo.model;

public class EmpleadoTemporal extends Empleado {

    private int diasTrabajados;
    private float valorDia;

    //CONSTRUCTOR


    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase, float descuentoSalud, float descuentoPension, Empresa ownedByEmpresa, categoriaEmpleado categoriaEmpleado, ResumenPago resumenPago, int diasTrabajados, float valorDia) {
        super(nombre, documento, edad, salarioBase, descuentoSalud, descuentoPension, ownedByEmpresa, categoriaEmpleado, resumenPago);

        if (diasTrabajados < 0) {
            throw new IllegalArgumentException("Los días trabajados no pueden ser negativos");
        }

        if (valorDia < 0) {
            throw new IllegalArgumentException("El valor por día no puede ser negativo");
        }

        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }

    public EmpleadoTemporal(int diasTrabajados, float valorDia) {
        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }

    //SETS Y GETS


    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public float getValorDia() {
        return valorDia;
    }

    public void setValorDia(float valorDia) {
        this.valorDia = valorDia;
    }

    //METODO TOSTRING


    @Override
    public String toString() {
        return "EmpleadoTemporal{" +
                "diasTrabajados=" + diasTrabajados +
                ", valorDia=" + valorDia +
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

        EmpleadoTemporal aux = (EmpleadoTemporal) empleado;

            this.setDiasTrabajados(aux.getDiasTrabajados());
            this.setValorDia(aux.getValorDia());
        }

    @Override
    public float calcularSalarioBruto() {

        return (diasTrabajados * valorDia)
                + calcularBonificacionCategoria();
    }
}

