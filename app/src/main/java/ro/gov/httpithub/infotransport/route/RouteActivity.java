package ro.gov.httpithub.infotransport.route;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ro.gov.httpithub.infotransport.R;
import ro.gov.httpithub.infotransport.utils.ActivityUtils;

public class RouteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        // Set fragment
        RouteFragment routeFragment =
                (RouteFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (routeFragment == null) {
            routeFragment = RouteFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), routeFragment, R.id.contentFrame);
        }

        new RoutePresenter(routeFragment);
    }
}
