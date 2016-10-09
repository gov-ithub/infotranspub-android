package ro.gov.httpithub.infotransport.data.repository;

import java.util.Arrays;
import java.util.List;

import retrofit2.http.Query;
import ro.gov.httpithub.infotransport.data.Stop;
import rx.Observable;

public class MockRouteRepository implements RouteRepository {
    @Override
    public Observable<List<Stop>> routes(String cityId, @Query("start_stop_id") String startStopId, @Query("end_stop_id") String endStopId) {
        return Observable.just(Arrays.asList(new Stop("1", "Name", 1), new Stop("2", "Other name", 2)));
    }
}
