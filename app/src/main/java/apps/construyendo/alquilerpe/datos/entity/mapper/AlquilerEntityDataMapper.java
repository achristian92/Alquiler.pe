package apps.construyendo.alquilerpe.datos.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import apps.construyendo.alquilerpe.datos.entity.AlquilerEntity;
import apps.construyendo.alquilerpe.domian.model.Alquiler;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public class AlquilerEntityDataMapper {
    public Alquiler transformar(AlquilerEntity alquilerEntity){
        Alquiler alquiler=new Alquiler();
        alquiler.setId_hab(alquilerEntity.getId_hab());
        alquiler.setNombre_inqui(alquilerEntity.getNombre_inqui());
        alquiler.setApellidos_inqui(alquilerEntity.getApellidos_inqui());
        alquiler.setDni(alquilerEntity.getDni());
        alquiler.setCelular(alquilerEntity.getCelular());
        alquiler.setNum_hab(alquilerEntity.getNum_hab());
        alquiler.setPrecio(alquilerEntity.getPrecio());
        alquiler.setFecha_pago_mensual(alquilerEntity.getFecha_pago_mensual());
        alquiler.setFecha_contrato(alquilerEntity.getFecha_contrato());
        alquiler.setId_usuario(alquilerEntity.getId_usuario());
        alquiler.setEstado_hab(alquilerEntity.isEstado_hab());
        return alquiler;
    }
    public AlquilerEntity transformar(Alquiler alquiler){
        AlquilerEntity alquilerEntity=new AlquilerEntity();
        alquilerEntity.setId_hab(alquiler.getId_hab());
        alquilerEntity.setNombre_inqui(alquiler.getNombre_inqui());
        alquilerEntity.setApellidos_inqui(alquiler.getApellidos_inqui());
        alquilerEntity.setDni(alquiler.getDni());
        alquilerEntity.setCelular(alquiler.getCelular());
        alquilerEntity.setNum_hab(alquiler.getNum_hab());
        alquilerEntity.setPrecio(alquiler.getPrecio());
        alquilerEntity.setFecha_pago_mensual(alquiler.getFecha_pago_mensual());
        alquilerEntity.setFecha_contrato(alquiler.getFecha_contrato());
        alquilerEntity.setId_usuario(alquiler.getId_usuario());
        alquilerEntity.setEstado_hab(alquiler.isEstado_hab());
        return alquilerEntity;
    }
    public List<Alquiler> transformar(List<AlquilerEntity> alquilerEntities) {
        List<Alquiler> alquilerList = new ArrayList<>();
        for (AlquilerEntity noticiaEntity : alquilerEntities) {
            Alquiler alquiler = transformar(noticiaEntity);
            alquilerList.add(alquiler);
        }
        return alquilerList;
    }
}
