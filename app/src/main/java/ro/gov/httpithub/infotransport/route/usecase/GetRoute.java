package ro.gov.httpithub.infotransport.route.usecase;

import java.util.List;

import ro.gov.httpithub.infotransport.UseCase;
import ro.gov.httpithub.infotransport.data.Route;
import ro.gov.httpithub.infotransport.data.Stop;
import ro.gov.httpithub.infotransport.data.repository.RouteRepository;
import rx.Observable;
import rx.functions.Func1;

public class GetRoute extends UseCase<Observable<Route>, GetRoute.RequestValues> {
    public static final class RequestValues {
        private final String cityId;

        private final String startId;

        private final String endId;

        public RequestValues(String cityId, String startId, String endId) {
            this.cityId = cityId;
            this.startId = startId;
            this.endId = endId;
        }

        public String getCityId() { return cityId; }

        String getStartId() { return startId; }

        String getEndId() { return endId; }
    }

    private RouteRepository mRouteRepository;

    public GetRoute(RouteRepository routeRepository) {
        mRouteRepository = routeRepository;
    }

    @Override
    public Observable<Route> executeUseCase(final GetRoute.RequestValues requestValues) {
        return mRouteRepository.routes(requestValues.getCityId(), requestValues.getStartId(), requestValues.getEndId())
                .map(new Func1<List<Stop>, Route>() {
                    @Override
                    public Route call(List<Stop> stops) {
                        return new Route(stops);
                    }
                });
    }
}

