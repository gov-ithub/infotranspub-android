package ro.gov.httpithub.infotransport.route;

import android.support.annotation.NonNull;

import java.util.List;

import ro.gov.httpithub.infotransport.data.Route;
import ro.gov.httpithub.infotransport.data.Stop;
import ro.gov.httpithub.infotransport.data.repository.RouteRepository;
import ro.gov.httpithub.infotransport.utils.schedulers.BaseSchedulerProvider;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.google.common.base.Preconditions.checkNotNull;

class RoutePresenter implements RouteContract.Presenter {

    @NonNull
    private CompositeSubscription mSubscriptions;

    @NonNull
    private final BaseSchedulerProvider mSchedulerProvider;

    @NonNull
    private final RouteRepository mRouteRepository;

    @NonNull
    private final RouteContract.View mView;

    RoutePresenter(@NonNull RouteContract.View view,
                   @NonNull RouteRepository routeRepository,
                   @NonNull BaseSchedulerProvider schedulerProvider) {
        mView = view;
        mRouteRepository = checkNotNull(routeRepository, "routeRepository cannot be null, at least send the mock one");
        mSchedulerProvider = checkNotNull(schedulerProvider, "schedulerProvider cannot be null");

        mSubscriptions = new CompositeSubscription();

        view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        mSubscriptions.clear();

        Subscription subscription = mRouteRepository.routes(0, 0)
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<List<Stop>>() {
                    @Override
                    public void onCompleted() {
                        // Todo: handle complete
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Todo: handle error
                    }

                    @Override
                    public void onNext(List<Stop> stops) {
                        mView.showRoute(new Route(stops));
                    }
                });
        mSubscriptions.add(subscription);
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.unsubscribe();
    }
}
