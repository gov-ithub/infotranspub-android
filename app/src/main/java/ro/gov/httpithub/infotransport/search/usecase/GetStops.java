package ro.gov.httpithub.infotransport.search.usecase;

import java.util.List;

import ro.gov.httpithub.infotransport.UseCase;
import ro.gov.httpithub.infotransport.data.Stop;
import ro.gov.httpithub.infotransport.data.repository.StopsRepository;
import rx.Observable;

public class GetStops extends UseCase<Observable<List<Stop>>, GetStops.RequestValues> {
    public static class RequestValues {
        private final String cityId;

        public RequestValues(String cityId) {
            this.cityId = cityId;
        }

        public String getCityId() {
            return cityId;
        }
    }

    private StopsRepository stopsRepository;

    public GetStops(StopsRepository stopsRepository) {
        this.stopsRepository = stopsRepository;
    }

    @Override
    public Observable<List<Stop>> executeUseCase(GetStops.RequestValues requestValues) {
        return stopsRepository.get(requestValues.getCityId());
    }
}
