package apps.construyendo.alquilerpe.domian.model;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public class Alquiler {
    private int id_hab;
    private String nombre_inqui;
    private String apellidos_inqui;
    private int dni;
    private Integer celular;
    private Integer num_hab;
    private double precio;
    private String fecha_pago_mensual;
    private String fecha_contrato;
    private int id_usuario;
    private boolean estado_hab;

    public int getId_hab() {
        return id_hab;
    }

    public void setId_hab(int id_hab) {
        this.id_hab = id_hab;
    }

    public String getNombre_inqui() {
        return nombre_inqui;
    }

    public void setNombre_inqui(String nombre_inqui) {
        this.nombre_inqui = nombre_inqui;
    }

    public String getApellidos_inqui() {
        return apellidos_inqui;
    }

    public void setApellidos_inqui(String apellidos_inqui) {
        this.apellidos_inqui = apellidos_inqui;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Integer getNum_hab() {
        return num_hab;
    }

    public void setNum_hab(Integer num_hab) {
        this.num_hab = num_hab;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha_pago_mensual() {
        return fecha_pago_mensual;
    }

    public void setFecha_pago_mensual(String fecha_pago_mensual) {
        this.fecha_pago_mensual = fecha_pago_mensual;
    }

    public String getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(String fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isEstado_hab() {
        return estado_hab;
    }

    public void setEstado_hab(boolean estado_hab) {
        this.estado_hab = estado_hab;
    }
}
