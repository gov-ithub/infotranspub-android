package ro.gov.httpithub.infotransport.search.usecase;

import java.util.List;

import ro.gov.httpithub.infotransport.UseCase;
import ro.gov.httpithub.infotransport.data.City;
import ro.gov.httpithub.infotransport.data.repository.CityRepository;
import rx.Observable;

public class GetCities extends UseCase<Observable<List<City>>, GetCities.RequestValues> {
    public static final class RequestValues {
    }

    private CityRepository mCityRepository;

    public GetCities(CityRepository cityRepository) {
        this.mCityRepository = cityRepository;
    }

    @Override
    public rx.Observable<List<City>> executeUseCase(RequestValues requestValues) {
        return mCityRepository.get();
    }
}
