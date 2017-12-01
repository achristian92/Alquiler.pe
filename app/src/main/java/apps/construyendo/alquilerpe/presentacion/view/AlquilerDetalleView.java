package apps.construyendo.alquilerpe.presentacion.view;

import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;
import apps.construyendo.alquilerpe.presentacion.view.LoadingView;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public interface AlquilerDetalleView extends LoadingView{
    void  guardarAlquiler(AlquilerModel alquilerModel);

    void notificarNoticiaGuardada();

    void actualizaNoticia(AlquilerModel alquilerModel);
}
