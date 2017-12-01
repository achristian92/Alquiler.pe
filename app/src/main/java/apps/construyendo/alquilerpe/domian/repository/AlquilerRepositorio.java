package apps.construyendo.alquilerpe.domian.repository;

import java.util.List;

import apps.construyendo.alquilerpe.domian.model.Alquiler;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public interface AlquilerRepositorio {
    List<Alquiler> listarAlquiler() throws Exception;
    Alquiler crearAlquiler(Alquiler alquiler) throws Exception;
    Alquiler actualizarAlquiler(Alquiler alquiler) throws Exception;
}
