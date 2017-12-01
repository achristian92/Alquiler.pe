package apps.construyendo.alquilerpe.datos.repository.datasource;

import java.util.List;

import apps.construyendo.alquilerpe.datos.entity.AlquilerEntity;
import apps.construyendo.alquilerpe.datos.network.RestApi;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public class NetworkAlquilerDatasource implements AlquilerDatasource {

    private final RestApi restApi;

    public NetworkAlquilerDatasource(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public List<AlquilerEntity> alquilerEntityList() throws Exception {
        return restApi.listarAlquileres();
    }

    @Override
    public AlquilerEntity crearAlquiler(AlquilerEntity alquilerEntity) throws Exception {
        return restApi.guardarAlquiler(alquilerEntity);
    }
}
