package ro.gov.httpithub.infotransport.route;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import ro.gov.httpithub.infotransport.data.Route;
import ro.gov.httpithub.infotransport.data.Stop;
import ro.gov.httpithub.infotransport.data.repository.RouteRepository;
import ro.gov.httpithub.infotransport.route.usecase.GetRoute;
import ro.gov.httpithub.infotransport.utils.schedulers.ImmediateSchedulerProvider;
import rx.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RoutePresenterTest {
    @Mock
    private RouteContract.View mRouteView;

    @Mock
    private GetRoute mGetRoute;

    private RoutePresenter mRoutePresenter;

    @Before
    public void setupRoutePresenter() {
        MockitoAnnotations.initMocks(this);

        mRoutePresenter = new RoutePresenter(mRouteView,
                mGetRoute,
                "sibiu", "42", "43",
                new ImmediateSchedulerProvider());
    }

    @Test
    public void subscribe() {
        Route route = new Route(new ArrayList<Stop>(0));

        when(mGetRoute.executeUseCase(any(GetRoute.RequestValues.class)))
                .thenReturn(Observable.just(route));

        mRoutePresenter.subscribe();

        verify(mRouteView).showRoute(route);
    }
}
