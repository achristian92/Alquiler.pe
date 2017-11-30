package apps.construyendo.alquilerpe.presentacion.view;

import java.util.List;

import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;

/**
 * Created by Christian 24 on 29/11/2017.
 */

public interface AlquilerView extends LoadingView {
    void verDetalle(AlquilerModel alquilerModel);
    void agregarHab();
    void mostrarHabitaciones(List<AlquilerModel> alquilerModelList);
}
