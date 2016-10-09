package ro.gov.httpithub.infotransport.data.repository;

import java.util.List;

import ro.gov.httpithub.infotransport.data.Stop;
import rx.Observable;

public class ApiStopsRepository extends BaseRepository implements StopsRepository {
    public ApiStopsRepository(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public Observable<List<Stop>> get(String cityId) {
        return getContract(StopsRepository.class).get(cityId);
    }
}
