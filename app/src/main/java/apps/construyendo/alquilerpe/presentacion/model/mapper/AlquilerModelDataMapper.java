package apps.construyendo.alquilerpe.presentacion.model.mapper;

import java.util.ArrayList;
import java.util.List;

import apps.construyendo.alquilerpe.domian.model.Alquiler;
import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public class AlquilerModelDataMapper {
    public AlquilerModel transformar(Alquiler alquiler) {
        AlquilerModel alquilerModel = new AlquilerModel();
        alquilerModel.setId_hab(alquiler.getId_hab());
        alquilerModel.setNombre_inqui(alquiler.getNombre_inqui());
        alquilerModel.setApellidos_inqui(alquiler.getApellidos_inqui());
        alquilerModel.setDni(alquiler.getDni());
        alquilerModel.setCelular(alquiler.getCelular());
        alquilerModel.setNum_hab(alquiler.getNum_hab());
        alquilerModel.setPrecio(alquiler.getPrecio());
        alquilerModel.setFecha_pago_mensual(alquiler.getFecha_pago_mensual());
        alquilerModel.setFecha_contrato(alquiler.getFecha_contrato());
        alquilerModel.setId_usuario(alquiler.getId_usuario());
        alquilerModel.setEstado_hab(alquiler.isEstado_hab());
        return alquilerModel;
    }

    public Alquiler transformar(AlquilerModel alquilerModel) {
        Alquiler alquiler = new Alquiler();
        alquiler.setId_hab(alquilerModel.getId_hab());
        alquiler.setNombre_inqui(alquilerModel.getNombre_inqui());
        alquiler.setApellidos_inqui(alquilerModel.getApellidos_inqui());
        alquiler.setDni(alquilerModel.getDni());
        alquiler.setCelular(alquilerModel.getCelular());
        alquiler.setNum_hab(alquilerModel.getNum_hab());
        alquiler.setPrecio(alquilerModel.getPrecio());
        alquiler.setFecha_pago_mensual(alquilerModel.getFecha_pago_mensual());
        alquiler.setFecha_contrato(alquilerModel.getFecha_contrato());
        alquiler.setId_usuario(alquilerModel.getId_usuario());
        alquiler.setEstado_hab(alquilerModel.isEstado_hab());
        return alquiler;
    }

    public List<AlquilerModel> transformar(List<Alquiler> alquilerList) {
        List<AlquilerModel> alquilerModels = new ArrayList<>();
        for (Alquiler alquiler : alquilerList) {
            AlquilerModel alquilerModel = transformar(alquiler);
            alquilerModels.add(alquilerModel);
        }
        return alquilerModels;
    }
}
