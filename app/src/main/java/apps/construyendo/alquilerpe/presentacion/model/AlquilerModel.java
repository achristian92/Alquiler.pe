package apps.construyendo.alquilerpe.presentacion.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Christian 24 on 29/11/2017.
 */

public class AlquilerModel implements Parcelable {
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

    public AlquilerModel() {
    }

    public AlquilerModel(String nombre_inqui, String apellidos_inqui, String fecha_contrato) {
        this.nombre_inqui = nombre_inqui;
        this.apellidos_inqui = apellidos_inqui;
        this.fecha_contrato = fecha_contrato;
    }

    public AlquilerModel(String nombre_inqui, String apellidos_inqui, Integer num_hab, double precio, String fecha_pago_mensual, boolean estado_hab) {
        this.nombre_inqui = nombre_inqui;
        this.apellidos_inqui = apellidos_inqui;
        this.num_hab = num_hab;
        this.precio = precio;
        this.fecha_pago_mensual = fecha_pago_mensual;
        this.estado_hab = estado_hab;
    }

    public AlquilerModel(int id_hab, String nombre_inqui, String apellidos_inqui, int dni, Integer celular, Integer num_hab, double precio, String fecha_pago_mensual, String fecha_contrato, int id_usuario, boolean estado_hab) {
        this.id_hab = id_hab;
        this.nombre_inqui = nombre_inqui;
        this.apellidos_inqui = apellidos_inqui;
        this.dni = dni;
        this.celular = celular;
        this.num_hab = num_hab;
        this.precio = precio;
        this.fecha_pago_mensual = fecha_pago_mensual;
        this.fecha_contrato = fecha_contrato;
        this.id_usuario = id_usuario;
        this.estado_hab = estado_hab;
    }

    protected AlquilerModel(Parcel in) {
        id_hab = in.readInt();
        nombre_inqui = in.readString();
        apellidos_inqui = in.readString();
        dni = in.readInt();
        if (in.readByte() == 0) {
            celular = null;
        } else {
            celular = in.readInt();
        }
        if (in.readByte() == 0) {
            num_hab = null;
        } else {
            num_hab = in.readInt();
        }
        precio = in.readDouble();
        fecha_pago_mensual = in.readString();
        fecha_contrato = in.readString();
        id_usuario = in.readInt();
        estado_hab = in.readByte() != 0;
    }

    public static final Creator<AlquilerModel> CREATOR = new Creator<AlquilerModel>() {
        @Override
        public AlquilerModel createFromParcel(Parcel in) {
            return new AlquilerModel(in);
        }

        @Override
        public AlquilerModel[] newArray(int size) {
            return new AlquilerModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id_hab);
        parcel.writeString(nombre_inqui);
        parcel.writeString(apellidos_inqui);
        parcel.writeInt(dni);
        if (celular == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(celular);
        }
        if (num_hab == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(num_hab);
        }
        parcel.writeDouble(precio);
        parcel.writeString(fecha_pago_mensual);
        parcel.writeString(fecha_contrato);
        parcel.writeInt(id_usuario);
        parcel.writeByte((byte) (estado_hab ? 1 : 0));
    }
}
