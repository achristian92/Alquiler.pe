package apps.construyendo.alquilerpe.presentacion.presenter;

import apps.construyendo.alquilerpe.presentacion.view.BaseView;

/**
 * Created by Christian 24 on 29/11/2017.
 */

public class BasePresenter <V extends BaseView>  {
    protected V view;

    public BasePresenter(V view) {
        this.view = view;
    }
}
