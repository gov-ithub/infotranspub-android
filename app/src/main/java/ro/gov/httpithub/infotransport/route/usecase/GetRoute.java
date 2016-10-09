package ro.gov.httpithub.infotransport.route.usecase;

import java.util.List;

import ro.gov.httpithub.infotransport.data.Stop;
import ro.gov.httpithub.infotransport.data.repository.RouteRepository;
import rx.Observable;

public class GetRoute {
    public static final class RequestValues {
        private final String cityId;

        private final int startId;

        private final int endId;

        public RequestValues(String cityId, int startId, int endId) {
            this.cityId = cityId;
            this.startId = startId;
            this.endId = endId;
        }

        public String getCityId() { return cityId; }

        public int getStartId() { return startId; }

        public int getEndId() { return endId; }
    }

    private RouteRepository mRouteRepository;

    public GetRoute(RouteRepository routeRepository) {
        mRouteRepository = routeRepository;
    }

    public Observable<List<Stop>> executeUseCase(final GetRoute.RequestValues requestValues) {
        return mRouteRepository.routes(requestValues.getCityId(), requestValues.getStartId(), requestValues.getEndId());
    }
}
