package apps.construyendo.alquilerpe.domian.usecase;

import javax.security.auth.callback.Callback;

import apps.construyendo.alquilerpe.domian.executor.PostExecutionThread;
import apps.construyendo.alquilerpe.domian.executor.ThreadExecutor;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public abstract class UseCase<T> {
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private Callback<T> callback;

    protected UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    protected void notificarUseCaseSatisfactorio(final  T response){
        postExecutionThread.execute(new Runnable() {
            @Override
            public void run() {
                if(callback!=null){
                    callback.onSuccess(response);
                }
            }
        });
    }
    protected void notificarUseCaseError(final Throwable throwable){
        postExecutionThread.execute(new Runnable() {
            @Override
            public void run() {
                if(callback!=null){
                    callback.onError(throwable);
                }
            }
        });
    }

    public void ejecutar(final Callback<T> callback){
        this.callback=callback;
        threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                construirUseCase();
            }
        });
    }

    protected abstract void construirUseCase();

    public interface Callback<T> {
        void onSuccess(T response);

        void onError(Throwable t);
    }
}
