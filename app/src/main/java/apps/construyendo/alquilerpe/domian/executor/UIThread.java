package apps.construyendo.alquilerpe.domian.executor;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;



/**
 * Created by Christian 24 on 30/11/2017.
 */

public class UIThread implements PostExecutionThread {
    private Handler uiHandler=new Handler(Looper.getMainLooper());

    @Override
    public void execute(@NonNull Runnable runnable) {
        uiHandler.post(runnable);
    }
}
