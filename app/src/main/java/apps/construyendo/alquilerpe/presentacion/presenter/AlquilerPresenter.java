package apps.construyendo.alquilerpe.presentacion.presenter;

import java.util.ArrayList;
import java.util.List;

import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;
import apps.construyendo.alquilerpe.presentacion.view.AlquilerView;

/**
 * Created by Christian 24 on 29/11/2017.
 */

public class AlquilerPresenter extends BasePresenter<AlquilerView> {
    public AlquilerPresenter(AlquilerView view) {
        super(view);
    }
    public void cargarNoticias(){
        view.mostrarLoading();
        List<AlquilerModel> noticiaList = new ArrayList<>();
        for(int i=0;i<10;i++){
            AlquilerModel noticia=new AlquilerModel();
            noticia.setNombre_inqui("Noticia " + (i + 1));
            noticia.setFecha_contrato("Detalle noticias" + (i + 1));
            noticia.setApellidos_inqui("http://noticia"+(i+1)+".com");
            noticiaList.add(noticia);
        }
        view.mostrarHabitaciones(noticiaList);
        view.ocultarLoading();
    }
}
