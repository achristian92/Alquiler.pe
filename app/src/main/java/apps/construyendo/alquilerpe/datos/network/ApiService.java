package apps.construyendo.alquilerpe.datos.network;

import java.util.List;

import apps.construyendo.alquilerpe.datos.entity.AlquilerEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Christian 24 on 30/11/2017.
 */

public interface ApiService {
    @GET("data/Alquiler_habitacion")
    Call<List<AlquilerEntity>> listaalquileres();

    @POST("data/Alquiler_habitacion")
    Call<AlquilerEntity> guardarAlquiler(@Body AlquilerEntity alquilerEntity);

  //  @PUT("/data/News/{id}") //update
  //  Call<NoticiaEntity> updateUser(@Path("id") String id , @Body NoticiaEntity noticiaEntity);
}
