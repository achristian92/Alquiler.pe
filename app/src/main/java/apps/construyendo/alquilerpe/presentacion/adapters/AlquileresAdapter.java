package apps.construyendo.alquilerpe.presentacion.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import apps.construyendo.alquilerpe.R;
import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;

/**
 * Created by Christian 24 on 29/11/2017.
 */

public class AlquileresAdapter extends RecyclerView.Adapter<AlquileresAdapter.ViewHolerAlquileres> implements View.OnClickListener {
    List<AlquilerModel> listaalquiler;
    private View.OnClickListener listener;

    public AlquileresAdapter(List<AlquilerModel> listaalquiler) {
        this.listaalquiler = listaalquiler;
    }

    @Override
    public ViewHolerAlquileres onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_picture,null,false);
        view.setOnClickListener(this);
        return new ViewHolerAlquileres(view);
    }

    @Override
    public void onBindViewHolder(ViewHolerAlquileres holder, int position) {
        holder.txt_num_hab.setText(listaalquiler.get(position).getNum_hab().toString());
        holder.txt_nombre_inqui.setText(listaalquiler.get(position).getNombre_inqui()+" " + listaalquiler.get(position).getApellidos_inqui().toString());
        holder.txt_fecha_pago.setText(listaalquiler.get(position).getFecha_pago_mensual().toString());
       // holder.txt_precio.setText((int) listaalquiler.get(position).getPrecio());
        holder.aSwitch.setChecked(listaalquiler.get(position).isEstado_hab());
        if(listaalquiler.get(position).isEstado_hab()==true){
            holder.aSwitch.setChecked(true);
        }else{
            holder.aSwitch.setChecked(false);
        }

    }

    @Override
    public int getItemCount() {
        return listaalquiler.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
    if(listener!=null){
        listener.onClick(view);
    }
    }

    public class ViewHolerAlquileres extends RecyclerView.ViewHolder {

    TextView txt_num_hab,txt_nombre_inqui,txt_fecha_pago,txt_precio;
    Switch aSwitch;



        public ViewHolerAlquileres(View itemView) {
            super(itemView);
            txt_num_hab=itemView.findViewById(R.id.txt_num_hab);
            txt_nombre_inqui=itemView.findViewById(R.id.text_inqui);
            txt_fecha_pago=itemView.findViewById(R.id.txt_fecha_prox_pago);
            txt_precio=itemView.findViewById(R.id.txt_precio);
            aSwitch=itemView.findViewById(R.id.switch1);
        }
    }
}
