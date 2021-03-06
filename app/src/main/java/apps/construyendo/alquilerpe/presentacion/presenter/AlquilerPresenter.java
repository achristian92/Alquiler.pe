package apps.construyendo.alquilerpe.presentacion.presenter;

import java.util.ArrayList;
import java.util.List;

import apps.construyendo.alquilerpe.datos.entity.mapper.AlquilerEntityDataMapper;
import apps.construyendo.alquilerpe.datos.repository.AlquilerDataRepositorio;
import apps.construyendo.alquilerpe.datos.repository.datasource.AlquilerDatasourceFactory;
import apps.construyendo.alquilerpe.domian.executor.JobExecutor;
import apps.construyendo.alquilerpe.domian.executor.UIThread;
import apps.construyendo.alquilerpe.domian.model.Alquiler;
import apps.construyendo.alquilerpe.domian.repository.AlquilerRepositorio;
import apps.construyendo.alquilerpe.domian.usecase.ListarAlquileres;
import apps.construyendo.alquilerpe.domian.usecase.UseCase;
import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;
import apps.construyendo.alquilerpe.presentacion.model.mapper.AlquilerModelDataMapper;
import apps.construyendo.alquilerpe.presentacion.view.AlquilerView;

/**
 * Created by Christian 24 on 29/11/2017.
 */

public class AlquilerPresenter extends BasePresenter<AlquilerView> {

    private final ListarAlquileres listarAlquileres;
    private final AlquilerModelDataMapper alquilerModelDataMapper;

    public AlquilerPresenter(AlquilerView view) {
        super(view);
        this.alquilerModelDataMapper=new AlquilerModelDataMapper();

        AlquilerRepositorio alquilerRepositorio=new AlquilerDataRepositorio(
                new AlquilerDatasourceFactory(view.context()),
                new AlquilerEntityDataMapper()
        );
        this.listarAlquileres=new ListarAlquileres(
                new JobExecutor(),
                new UIThread(),
                alquilerRepositorio
        );
    }
    public void cargarAlquileres(){
        view.mostrarLoading();
        this.listarAlquileres.ejecutar(new UseCase.Callback<List<Alquiler>>() {
            @Override
            public void onSuccess(List<Alquiler> response) {
                view.ocultarLoading();
                view.mostrarHabitaciones(alquilerModelDataMapper.transformar(response));
            }

            @Override
            public void onError(Throwable t) {
            view.ocultarLoading();
            }
        });
    }

}
