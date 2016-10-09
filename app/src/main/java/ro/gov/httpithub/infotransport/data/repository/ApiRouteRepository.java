package ro.gov.httpithub.infotransport.data.repository;

import java.util.List;

import retrofit2.Retrofit;
import ro.gov.httpithub.infotransport.data.Stop;
import rx.Observable;

public class ApiRouteRepository {
    private String mBaseUrl;

    public ApiRouteRepository(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    public Observable<List<Stop>> routes(int startStopId, int endStopId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .build();

        RouteRepository contract = retrofit.create(RouteRepository.class);

        return contract.routes(startStopId, endStopId);
    }
}
