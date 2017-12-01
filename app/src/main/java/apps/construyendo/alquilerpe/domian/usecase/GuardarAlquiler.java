package apps.construyendo.alquilerpe.domian.usecase;

import apps.construyendo.alquilerpe.domian.executor.PostExecutionThread;
import apps.construyendo.alquilerpe.domian.executor.ThreadExecutor;
import apps.construyendo.alquilerpe.domian.model.Alquiler;
import apps.construyendo.alquilerpe.domian.repository.AlquilerRepositorio;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public class GuardarAlquiler extends UseCase<Alquiler> {
    private final AlquilerRepositorio alquilerRepositorio;
    private Alquiler alquiler;

    @Override
    protected void construirUseCase() {
        try {
            Alquiler alquiler=this.alquilerRepositorio.crearAlquiler(this.alquiler);
            notificarUseCaseSatisfactorio(alquiler);
        }catch (Exception e){
            notificarUseCaseError(e);
        }
    }

    public GuardarAlquiler(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, AlquilerRepositorio alquilerRepositorio) {
        super(threadExecutor, postExecutionThread);
        this.alquilerRepositorio = alquilerRepositorio;
    }
    public void setParams(Alquiler alquiler){
        this.alquiler=alquiler;
    }
}
