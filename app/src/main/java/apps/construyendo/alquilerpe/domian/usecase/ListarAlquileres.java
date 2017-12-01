package apps.construyendo.alquilerpe.domian.usecase;

import java.util.List;

import apps.construyendo.alquilerpe.domian.executor.PostExecutionThread;
import apps.construyendo.alquilerpe.domian.executor.ThreadExecutor;
import apps.construyendo.alquilerpe.domian.model.Alquiler;
import apps.construyendo.alquilerpe.domian.repository.AlquilerRepositorio;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public class ListarAlquileres extends UseCase<List<Alquiler>>{

    private final AlquilerRepositorio alquilerRepositorio;


    @Override
    protected void construirUseCase() {
        try {
            List<Alquiler> alquilerList=this.alquilerRepositorio.listarAlquiler();
            notificarUseCaseSatisfactorio(alquilerList);
        }catch (Exception e){
            notificarUseCaseError(e);
        }

    }

    public ListarAlquileres(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, AlquilerRepositorio alquilerRepositorio) {
        super(threadExecutor, postExecutionThread);
        this.alquilerRepositorio = alquilerRepositorio;
    }
}
