package ro.gov.httpithub.infotransport.route;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import ro.gov.httpithub.infotransport.data.Stop;
import ro.gov.httpithub.infotransport.data.repository.RouteRepository;
import ro.gov.httpithub.infotransport.utils.schedulers.ImmediateSchedulerProvider;
import rx.Observable;

import static org.mockito.Mockito.when;

public class RoutePresenterTest {
    @Mock
    private RouteContract.View mRouteView;

    @Mock
    private RouteRepository mRouteRepository;

    private RoutePresenter mRoutePresenter;

    @Before
    public void setupRoutePresenter() {
        MockitoAnnotations.initMocks(this);

        mRoutePresenter = new RoutePresenter(mRouteView, mRouteRepository, "sibiu", "42", "43", new ImmediateSchedulerProvider());
    }

    @Test
    public void subscribe() {
        List<Stop> mockStops = new ArrayList<>(0);

        when(mRouteRepository.routes("sibiu", "42", "43")).thenReturn(Observable.just(mockStops));

        mRoutePresenter.subscribe();
    }
}
