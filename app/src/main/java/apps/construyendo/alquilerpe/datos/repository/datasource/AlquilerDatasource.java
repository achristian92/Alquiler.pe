package apps.construyendo.alquilerpe.datos.repository.datasource;

import java.util.List;

import apps.construyendo.alquilerpe.datos.entity.AlquilerEntity;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public interface AlquilerDatasource {
    List<AlquilerEntity> alquilerEntityList() throws Exception;

    AlquilerEntity crearAlquiler(AlquilerEntity alquilerEntity) throws Exception;
}
