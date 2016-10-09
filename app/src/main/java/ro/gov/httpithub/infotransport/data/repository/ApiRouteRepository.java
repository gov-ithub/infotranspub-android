package ro.gov.httpithub.infotransport.data.repository;

import java.util.List;

import ro.gov.httpithub.infotransport.data.Stop;
import rx.Observable;

public class ApiRouteRepository extends BaseRepository implements RouteRepository {
    private String mBaseUrl;

    public ApiRouteRepository(String baseUrl) {
        super(baseUrl);
    }

    public Observable<List<Stop>> routes(int startStopId, int endStopId) {
        return getContract(RouteRepository.class).routes(startStopId, endStopId);
    }
}
