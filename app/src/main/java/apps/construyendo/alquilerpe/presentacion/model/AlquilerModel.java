package apps.construyendo.alquilerpe.presentacion.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Christian 24 on 29/11/2017.
 */

public class AlquilerModel implements Parcelable {
   // private int id_hab;
    private String nombre_inqui;
    private String apellidos_inqui;
    private int dni;
    private double precio;
    private String fecha_pago_mensual;
    private int celular;
    private int num_hab;



    // private boolean estado_hab;




   /*

    private String fecha_contrato;
    private int id_usuario;
   */

    public AlquilerModel() {
    }

    public AlquilerModel(String nombre_inqui, String apellidos_inqui, int dni, double precio, String fecha_pago_mensual, int celular, int num_hab) {
        this.nombre_inqui = nombre_inqui;
        this.apellidos_inqui = apellidos_inqui;
        this.dni = dni;
        this.precio = precio;
        this.fecha_pago_mensual = fecha_pago_mensual;
        this.celular = celular;
        this.num_hab = num_hab;
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNum_hab() {
        return num_hab;
    }

    public void setNum_hab(int num_hab) {
        this.num_hab = num_hab;
    }

    protected AlquilerModel(Parcel in) {
        nombre_inqui = in.readString();
        apellidos_inqui = in.readString();
        dni = in.readInt();
        precio = in.readDouble();
        fecha_pago_mensual = in.readString();
        celular = in.readInt();
        num_hab = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre_inqui);
        dest.writeString(apellidos_inqui);
        dest.writeInt(dni);
        dest.writeDouble(precio);
        dest.writeString(fecha_pago_mensual);
        dest.writeInt(celular);
        dest.writeInt(num_hab);
    }

    @Override
    public int describeContents() {
        return 0;
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
}
