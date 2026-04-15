package co.edu.uniquindio.poo.model;

public abstract class  Empleado {

    //ATRIBUTOS

    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected float descuentoSalud;
    protected float descuentoPension;

    //RELACIONES

    private Empresa ownedByEmpresa;
    private categoriaEmpleado categoriaEmpleado;
    private ResumenPago resumenPago;

    //CONTRUCTOR


    public Empleado(String nombre, String documento, int edad, float salarioBase, float descuentoSalud, float descuentoPension, Empresa ownedByEmpresa, categoriaEmpleado categoriaEmpleado, ResumenPago resumenPago) {

        if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo");
        }

        if (descuentoSalud < 0 || descuentoSalud > 100) {
            throw new IllegalArgumentException("Descuento de salud inválido");
        }

        if (descuentoPension < 0 || descuentoPension > 100) {
            throw new IllegalArgumentException("Descuento de pensión inválido");
        }

        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
        this.ownedByEmpresa = ownedByEmpresa;
        this.categoriaEmpleado = categoriaEmpleado;
        this.resumenPago = resumenPago;
    }

    public Empleado() {

    }

    //SETS Y GETS


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getDescuentoSalud() {
        return descuentoSalud;
    }

    public void setDescuentoSalud(float descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    public float getDescuentoPension() {
        return descuentoPension;
    }

    public void setDescuentoPension(float descuentoPension) {
        this.descuentoPension = descuentoPension;
    }

    public Empresa getOwnedByEmpresa() {
        return ownedByEmpresa;
    }

    public void setOwnedByEmpresa(Empresa ownedByEmpresa) {
        this.ownedByEmpresa = ownedByEmpresa;
    }

    public categoriaEmpleado getCategoriaEmpleado() {
        return categoriaEmpleado;
    }

    public void setCategoriaEmpleado(categoriaEmpleado categoriaEmpleado) {
        this.categoriaEmpleado = categoriaEmpleado;
    }

    public ResumenPago getResumenPago() {
        return resumenPago;
    }

    public void setResumenPago(ResumenPago resumenPago) {
        this.resumenPago = resumenPago;
    }

    //METODO TOSTRING


    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", salarioBase=" + salarioBase +
                ", descuentoSalud=" + descuentoSalud +
                ", descuentoPension=" + descuentoPension +
                ", ownedByEmpresa=" + ownedByEmpresa +
                ", categoriaEmpleado=" + categoriaEmpleado +
                ", resumenPago=" + resumenPago +
                '}';
    }

    //METODOS

    public abstract void actualizarDatos(Empleado empleado);

    public abstract float calcularSalarioBruto();

    public float calcularBonificacionCategoria() {

        switch (categoriaEmpleado) {
            case JUNIOR:
                return salarioBase * 0.05f;
            case SEMI_SENIOR:
                return salarioBase * 0.10f;
            case SENIOR:
                return salarioBase * 0.15f;
            default:
                return 0;
        }
    }

    public float calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDescuentos();
    }

    public float calcularDescuentos() {
        return salarioBase * (descuentoSalud / 100f)
                + salarioBase * (descuentoPension / 100f);
    }

    public ResumenPago generarResumenPago() {
        return new ResumenPago(
                documento,
                nombre,
                this.getClass().getSimpleName(),
                calcularSalarioBruto(),
                calcularDescuentos(),
                calcularSalarioNeto()
        );
    }



}
