package ro.gov.httpithub.infotransport.data.repository;

import java.util.List;

import ro.gov.httpithub.infotransport.data.Stop;
import rx.Observable;

public class ApiRouteRepository extends BaseRepository implements RouteRepository {
    public ApiRouteRepository(String baseUrl) {
        super(baseUrl);
    }

    public Observable<List<Stop>> routes(String cityId, String startStopId, String endStopId) {
        return getContract(RouteRepository.class).routes(cityId, startStopId, endStopId);
    }
}
