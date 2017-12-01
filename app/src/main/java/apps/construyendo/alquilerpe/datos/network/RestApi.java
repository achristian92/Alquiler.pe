package apps.construyendo.alquilerpe.datos.network;

import java.util.List;

import apps.construyendo.alquilerpe.datos.entity.AlquilerEntity;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public interface RestApi {
    List<AlquilerEntity> listarAlquileres() throws Exception;

    AlquilerEntity guardarAlquiler(AlquilerEntity alquilerEntity) throws Exception;
}
