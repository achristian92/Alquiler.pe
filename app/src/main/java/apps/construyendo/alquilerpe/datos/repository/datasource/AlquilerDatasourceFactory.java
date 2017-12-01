package apps.construyendo.alquilerpe.datos.repository.datasource;

import android.content.Context;

import apps.construyendo.alquilerpe.datos.network.RestApi;
import apps.construyendo.alquilerpe.datos.network.RestApiImpl;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public class AlquilerDatasourceFactory {

    private final Context context;

    public AlquilerDatasourceFactory(Context context) {
        this.context = context;
    }
    public AlquilerDatasource crearNetworkDatasource(){
        RestApi restApi=new RestApiImpl(context);
        return new NetworkAlquilerDatasource(restApi);
    }

}
