package ro.gov.httpithub.infotransport.data.repository;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import ro.gov.httpithub.infotransport.data.Stop;
import rx.Observable;

public interface RouteRepository {
    @GET("/v0.1/route")
    Observable<List<Stop>> routes(@Query("start_stop_id") int startStopId, @Query("end_stop_id") int endStopId);
}
