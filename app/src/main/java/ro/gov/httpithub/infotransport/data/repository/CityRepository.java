package ro.gov.httpithub.infotransport.data.repository;

import java.util.List;

import retrofit2.http.GET;
import ro.gov.httpithub.infotransport.data.City;
import rx.Observable;

public interface CityRepository {
    @GET("/v0.1/cities")
    Observable<List<City>> get();
}
