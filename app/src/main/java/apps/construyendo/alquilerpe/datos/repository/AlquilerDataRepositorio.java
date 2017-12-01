package apps.construyendo.alquilerpe.datos.repository;

import java.util.List;

import apps.construyendo.alquilerpe.datos.entity.AlquilerEntity;
import apps.construyendo.alquilerpe.datos.entity.mapper.AlquilerEntityDataMapper;
import apps.construyendo.alquilerpe.datos.repository.datasource.AlquilerDatasource;
import apps.construyendo.alquilerpe.datos.repository.datasource.AlquilerDatasourceFactory;
import apps.construyendo.alquilerpe.domian.model.Alquiler;
import apps.construyendo.alquilerpe.domian.repository.AlquilerRepositorio;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public class AlquilerDataRepositorio implements AlquilerRepositorio {

    private final AlquilerDatasourceFactory alquilerDatasourceFactory;
    private final AlquilerEntityDataMapper alquilerEntityDataMapper;

    public AlquilerDataRepositorio(AlquilerDatasourceFactory alquilerDatasourceFactory, AlquilerEntityDataMapper alquilerEntityDataMapper) {
        this.alquilerDatasourceFactory = alquilerDatasourceFactory;
        this.alquilerEntityDataMapper = alquilerEntityDataMapper;
    }

    @Override
    public List<Alquiler> listarAlquiler() throws Exception {
        final AlquilerDatasource alquilerDatasource=alquilerDatasourceFactory.crearNetworkDatasource();
        List<AlquilerEntity> alquilerEntityList=alquilerDatasource.alquilerEntityList();
        return alquilerEntityDataMapper.transformar(alquilerEntityList);
    }

    @Override
    public Alquiler crearAlquiler(Alquiler alquiler) throws Exception {
        final AlquilerDatasource alquilerDatasource=alquilerDatasourceFactory.crearNetworkDatasource();
        AlquilerEntity alquilerEntity=alquilerDatasource.crearAlquiler(alquilerEntityDataMapper.transformar(alquiler));
        return alquilerEntityDataMapper.transformar(alquilerEntity);
    }

    @Override
    public Alquiler actualizarAlquiler(Alquiler alquiler) throws Exception {
        return null;
    }
}
