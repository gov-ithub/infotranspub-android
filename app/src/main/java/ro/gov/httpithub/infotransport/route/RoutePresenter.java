package ro.gov.httpithub.infotransport.route;

import android.support.annotation.NonNull;

import java.util.List;

import ro.gov.httpithub.infotransport.data.Route;
import ro.gov.httpithub.infotransport.data.Stop;
import ro.gov.httpithub.infotransport.data.repository.RouteRepository;
import ro.gov.httpithub.infotransport.route.usecase.GetRoute;
import ro.gov.httpithub.infotransport.utils.schedulers.BaseSchedulerProvider;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.google.common.base.Preconditions.checkNotNull;

class RoutePresenter implements RouteContract.Presenter {

    private String mCityId;
    private String mStartId;
    private String mEndId;

    @NonNull
    private final BaseSchedulerProvider mSchedulerProvider;

    @NonNull
    private final RouteContract.View mView;

    @NonNull
    private final GetRoute mGetRoute;

    private CompositeSubscription mSubscriptions;

    RoutePresenter(@NonNull RouteContract.View view,
                   @NonNull GetRoute getRoute,
                   String cityId, String startId, String endId,
                   @NonNull BaseSchedulerProvider schedulerProvider) {
        mView = view;
        mCityId = cityId;
        mStartId = startId;
        mEndId = endId;
        mSchedulerProvider = checkNotNull(schedulerProvider, "schedulerProvider cannot be null");
        mGetRoute = checkNotNull(getRoute, "getRoute use case should be ");

        view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        mSubscriptions = new CompositeSubscription();

        GetRoute.RequestValues requestValues = new GetRoute.RequestValues(mCityId, mStartId, mEndId);
        Subscription subscription = mGetRoute.executeUseCase(requestValues)
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<Route>() {
                    @Override
                    public void onCompleted() {
                        // Todo: handle complete
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Todo: handle error
                    }

                    @Override
                    public void onNext(Route route) {
                        mView.showRoute(route);
                    }
                });
        mSubscriptions.add(subscription);
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.unsubscribe();
    }
}
