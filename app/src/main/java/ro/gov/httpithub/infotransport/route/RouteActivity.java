package ro.gov.httpithub.infotransport.route;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ro.gov.httpithub.infotransport.R;
import ro.gov.httpithub.infotransport.data.repository.MockRouteRepository;
import ro.gov.httpithub.infotransport.utils.ActivityUtils;
import ro.gov.httpithub.infotransport.utils.schedulers.SchedulerProvider;

public class RouteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        // Set fragment
        RouteFragment routeFragment =
                (RouteFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (routeFragment == null) {
            routeFragment = RouteFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), routeFragment, R.id.contentFrame);
        }

        // Todo: use dagger2 for injection
        new RoutePresenter(routeFragment, new MockRouteRepository(), SchedulerProvider.getInstance());
    }
}
