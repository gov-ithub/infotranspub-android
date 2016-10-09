package ro.gov.httpithub.infotransport.search;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ro.gov.httpithub.infotransport.data.City;
import ro.gov.httpithub.infotransport.data.Stop;
import ro.gov.httpithub.infotransport.data.repository.CityRepository;
import ro.gov.httpithub.infotransport.data.repository.StopsRepository;
import ro.gov.httpithub.infotransport.search.usecase.GetCities;
import ro.gov.httpithub.infotransport.search.usecase.GetStops;
import ro.gov.httpithub.infotransport.utils.schedulers.BaseSchedulerProvider;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.google.common.base.Preconditions.checkNotNull;

class SearchPresenter implements SearchContract.Presenter {
    private static final String TAG = "SEARCH_PRESENTER";

    private List<City> mCities;
    private List<Stop> mStops;

    private int mStartPosition;
    private int mEndPosition;
    private int mCityPosition;

    @NonNull
    private final SearchContract.View mSearchView;

    @NonNull
    private final CityRepository mCityRepository;

    @NonNull
    private final StopsRepository mStopsRepository;

    @NonNull
    private final BaseSchedulerProvider mSchedulerProvider;

    private CompositeSubscription mSubscriptions;

    SearchPresenter(@NonNull SearchContract.View searchView,
                    @NonNull CityRepository cityRepository,
                    @NonNull StopsRepository stopsRepository,
                    @NonNull BaseSchedulerProvider schedulerProvider) {
        mSearchView = searchView;
        mCityRepository = checkNotNull(cityRepository);
        mStopsRepository = checkNotNull(stopsRepository);
        mSchedulerProvider = schedulerProvider;

        mSearchView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        mSubscriptions = new CompositeSubscription();

        Subscription subscription = new GetCities(mCityRepository).executeUseCase(new GetCities.RequestValues())
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<List<City>>() {
                    @Override
                    public void onCompleted() {
                        // Todo: handle complete
                        Log.e(TAG, "City request completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Todo: handle error
                        Log.e(TAG, e.toString());
                    }

                    @Override
                    public void onNext(List<City> cities) {
                        // Todo add lambda support and retrolamda, and eliminate duplication
                        mCities = cities;
                        List<String> cityNames = new ArrayList<>();
                        for (City city : cities) {
                            cityNames.add(city.getName());
                        }

                        mSearchView.populateCities(cityNames);
                    }
                });
        mSubscriptions.add(subscription);
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.unsubscribe();
    }

    @Override
    public void showRoute() {
        String cityId = mCities.get(mCityPosition).getId();
        String startId = mStops.get(mStartPosition).getId();
        String stopId = mStops.get(mEndPosition).getId();

        mSearchView.showRoute(cityId, startId, stopId);
    }

    @Override
    public void getStops(int position) {
        mCityPosition = position;
        City city = mCities.get(mCityPosition);

        Subscription subscription = new GetStops(mStopsRepository).executeUseCase(new GetStops.RequestValues(city.getId()))
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<List<Stop>>() {
                    @Override
                    public void onCompleted() {
                        // Todo: handle complete
                        Log.e(TAG, "City request completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Todo: handle error
                        Log.e(TAG, e.toString());
                    }

                    @Override
                    public void onNext(List<Stop> stops) {
                        mStops = stops;
                        // Todo add lambda support and retrolamda
                        List<String> stopNames = new ArrayList<>();
                        for (Stop stop : stops) {
                            stopNames.add(stop.getName());
                        }

                        mSearchView.populateStops(stopNames);
                    }
                });
        mSubscriptions.add(subscription);
    }

    @Override
    public void setStartPosition(int position) {
        mStartPosition = position;
    }

    @Override
    public void setEndPosition(int position) {
        mEndPosition = position;
    }
}
