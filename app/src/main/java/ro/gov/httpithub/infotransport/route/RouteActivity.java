package ro.gov.httpithub.infotransport.route;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ro.gov.httpithub.infotransport.R;
import ro.gov.httpithub.infotransport.utils.ActivityUtils;

public class RouteActivity extends AppCompatActivity {
    private RoutePresenter mRoutePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        RouteFragment routeFragment =
                (RouteFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (routeFragment == null) {
            routeFragment = RouteFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), routeFragment, R.id.contentFrame);
        }

        this.mRoutePresenter = new RoutePresenter(routeFragment);
    }
}
