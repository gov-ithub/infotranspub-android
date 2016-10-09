package ro.gov.httpithub.infotransport.data.repository;

import java.util.List;

import ro.gov.httpithub.infotransport.data.City;
import rx.Observable;

public class ApiCityRepository extends BaseRepository implements CityRepository {

    public ApiCityRepository(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public Observable<List<City>> get() {
        CityRepository contract = getContract(CityRepository.class);
        return contract.get();
    }
}
