package ro.gov.httpithub.infotransport.route.usecase;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ro.gov.httpithub.infotransport.data.repository.RouteRepository;

public class GetRouteTest {
    @Mock
    public RouteRepository mockRouteRepository;

    private GetRoute mGetRoute;

    @Before
    public void setupGetRoute() {
        MockitoAnnotations.initMocks(this);

        mGetRoute = new GetRoute(mockRouteRepository);
    }

    public void executeUseCaseWillReturnARoute() {

    }
}
