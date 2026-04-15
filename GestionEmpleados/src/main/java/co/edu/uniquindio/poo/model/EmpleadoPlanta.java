package co.edu.uniquindio.poo.model;

public class EmpleadoPlanta extends Empleado {

    //ATRIBUTOS

    private String cargo;
    private int horasExtras;
    private float valorHoraExtra;
    private float auxilioTransporte;

    //CONSTRUCTOR


    public EmpleadoPlanta(String nombre, String documento, int edad, float salarioBase, float descuentoSalud, float descuentoPension, Empresa ownedByEmpresa, categoriaEmpleado categoriaEmpleado, ResumenPago resumenPago, String cargo, int horasExtras, float valorHoraExtra, float auxilioTransporte) {
        super(nombre, documento, edad, salarioBase, descuentoSalud, descuentoPension, ownedByEmpresa, categoriaEmpleado, resumenPago);

        if (horasExtras < 0) {
            throw new IllegalArgumentException("Las horas extra no pueden ser negativas");
        }

        if (valorHoraExtra < 0) {
            throw new IllegalArgumentException("El valor de la hora extra no puede ser negativo");
        }

        if (auxilioTransporte < 0) {
            throw new IllegalArgumentException("El auxilio de transporte no puede ser negativo");
        }

        this.cargo = cargo;
        this.horasExtras = horasExtras;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    public EmpleadoPlanta(String cargo, int horasExtras, float valorHoraExtra, float auxilioTransporte) {
        this.cargo = cargo;
        this.horasExtras = horasExtras;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    //SETS Y GETS


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public float getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(float valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    public float getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(float auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    //METODO TOSTRING


    @Override
    public String toString() {
        return "EmpleadoPlanta{" +
                "cargo='" + cargo + '\'' +
                ", horasExtras=" + horasExtras +
                ", valorHoraExtra=" + valorHoraExtra +
                ", auxilioTransporte=" + auxilioTransporte +
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

        EmpleadoPlanta aux = (EmpleadoPlanta) empleado;

        this.setCargo(aux.getCargo());
        this.setHorasExtras(aux.getHorasExtras());
        this.setValorHoraExtra(aux.getValorHoraExtra());
        this.setAuxilioTransporte(aux.getAuxilioTransporte());
    }

    @Override
    public float calcularSalarioBruto() {
        return salarioBase + calcularBonificacionCategoria() + (horasExtras * valorHoraExtra) + auxilioTransporte;
    }
}
