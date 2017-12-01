package apps.construyendo.alquilerpe.presentacion.presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import apps.construyendo.alquilerpe.datos.entity.mapper.AlquilerEntityDataMapper;
import apps.construyendo.alquilerpe.datos.repository.AlquilerDataRepositorio;
import apps.construyendo.alquilerpe.datos.repository.datasource.AlquilerDatasourceFactory;
import apps.construyendo.alquilerpe.domian.executor.JobExecutor;
import apps.construyendo.alquilerpe.domian.executor.UIThread;
import apps.construyendo.alquilerpe.domian.model.Alquiler;
import apps.construyendo.alquilerpe.domian.repository.AlquilerRepositorio;
import apps.construyendo.alquilerpe.domian.usecase.GuardarAlquiler;
import apps.construyendo.alquilerpe.domian.usecase.UseCase;
import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;
import apps.construyendo.alquilerpe.presentacion.model.mapper.AlquilerModelDataMapper;
import apps.construyendo.alquilerpe.presentacion.view.AlquilerDetalleView;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public class AlquilerDetallePresenter extends BasePresenter<AlquilerDetalleView>{
    private static final String TAG = "AlquilerDetallePresenter";
    private final GuardarAlquiler guardarAlquiler;
    private final AlquilerModelDataMapper alquilerModelDataMapper;

    public AlquilerDetallePresenter(AlquilerDetalleView view) {
        super(view);

        this.alquilerModelDataMapper=new AlquilerModelDataMapper();

        AlquilerRepositorio alquilerRepositorio=new AlquilerDataRepositorio(
                new AlquilerDatasourceFactory(view.context()),
                new AlquilerEntityDataMapper()
        );

        this.guardarAlquiler=new GuardarAlquiler(
                new JobExecutor(),
                new UIThread(),
                alquilerRepositorio
        );
    }
    public void guardarAlquiler(AlquilerModel alquilerModel) {
        view.mostrarLoading();

        this.guardarAlquiler.setParams(alquilerModelDataMapper.transformar(alquilerModel));

        this.guardarAlquiler.ejecutar(new UseCase.Callback<Alquiler>() {
            @Override
            public void onSuccess(Alquiler response) {
                view.ocultarLoading();
                view.notificarNoticiaGuardada();
            }

            @SuppressLint("LongLogTag")
            @Override
            public void onError(Throwable t) {
                view.ocultarLoading();
                Log.e(TAG, "onError: ", t);
            }
        });
    }
}
