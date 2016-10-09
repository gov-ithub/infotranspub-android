package ro.gov.httpithub.infotransport.route;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ro.gov.httpithub.infotransport.R;
import ro.gov.httpithub.infotransport.data.repository.ApiRouteRepository;
import ro.gov.httpithub.infotransport.route.usecase.GetRoute;
import ro.gov.httpithub.infotransport.utils.ActivityUtils;
import ro.gov.httpithub.infotransport.utils.schedulers.SchedulerProvider;

public class RouteActivity extends AppCompatActivity {
    public static final String EXTRA_CITY_ID = "CITY_ID";
    public static final String EXTRA_START_ID = "START_ID";
    public static final String EXTRA_END_ID = "END_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        // Get params
        String cityId = getIntent().getStringExtra(EXTRA_CITY_ID);
        String startId = getIntent().getStringExtra(EXTRA_START_ID);
        String endId = getIntent().getStringExtra(EXTRA_END_ID);

        // Set fragment
        RouteFragment routeFragment =
                (RouteFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (routeFragment == null) {
            routeFragment = RouteFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), routeFragment, R.id.contentFrame);
        }

        // Todo: use dagger2 for injection
        String baseUrl = "http://193.230.8.27:28031/";
        ApiRouteRepository routeRepository = new ApiRouteRepository(baseUrl);
        new RoutePresenter(routeFragment,
                new GetRoute(routeRepository),
                cityId, startId, endId,
                SchedulerProvider.getInstance());
    }
}
