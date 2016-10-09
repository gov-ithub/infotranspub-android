package ro.gov.httpithub.infotransport.data.repository;

import java.util.Arrays;
import java.util.List;

import retrofit2.http.Query;
import ro.gov.httpithub.infotransport.data.Stop;
import rx.Observable;

public class MockRouteRepository implements RouteRepository {
    @Override
    public Observable<List<Stop>> routes(@Query("start_stop_id") int startStopId, @Query("end_stop_id") int endStopId) {
        return Observable.just(Arrays.asList(new Stop("Name", 1), new Stop("Other name", 2)));
    }
}
