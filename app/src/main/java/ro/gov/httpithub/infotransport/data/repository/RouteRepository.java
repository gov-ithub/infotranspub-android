package ro.gov.httpithub.infotransport.data.repository;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ro.gov.httpithub.infotransport.data.Stop;
import rx.Observable;

public interface RouteRepository {
    @GET("/v0.1/{city_id}/route")
    Observable<List<Stop>> routes(@Path("city_id") String cityId, @Query("start_stop_id") String startStopId, @Query("end_stop_id") String endStopId);
}
