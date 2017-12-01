package apps.construyendo.alquilerpe.domian.executor;

import android.support.annotation.NonNull;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public class JobExecutor implements ThreadExecutor {
    private static final int NUMERO_DE_CORES =Runtime.getRuntime().availableProcessors();
    private static final int KEEP_ALIVE_TIME = 10;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private final ThreadPoolExecutor threadPoolExecutor;

    public JobExecutor() {
        this.threadPoolExecutor=new ThreadPoolExecutor(
                NUMERO_DE_CORES,
                NUMERO_DE_CORES,
                KEEP_ALIVE_TIME,
                TIME_UNIT,
                new LinkedBlockingDeque<Runnable>()
        );
    }

    @Override
    public void execute(@NonNull Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);
    }
}
