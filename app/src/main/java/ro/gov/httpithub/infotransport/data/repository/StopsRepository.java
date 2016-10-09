package ro.gov.httpithub.infotransport.data.repository;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import ro.gov.httpithub.infotransport.data.Stop;
import rx.Observable;

public interface StopsRepository {
    @GET("/v0.1/{city_id}/stops")
    Observable<List<Stop>> get(@Path("city_id") String cityId);
}
