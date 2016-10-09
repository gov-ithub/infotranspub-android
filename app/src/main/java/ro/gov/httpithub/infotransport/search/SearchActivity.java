package ro.gov.httpithub.infotransport.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ro.gov.httpithub.infotransport.R;
import ro.gov.httpithub.infotransport.data.repository.ApiCityRepository;
import ro.gov.httpithub.infotransport.data.repository.ApiStopsRepository;
import ro.gov.httpithub.infotransport.utils.ActivityUtils;
import ro.gov.httpithub.infotransport.utils.schedulers.SchedulerProvider;

public class SearchActivity extends AppCompatActivity {

    public static final int REQUEST_ROUTE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchFragment searchFragment=
                (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (searchFragment == null) {
            // Create the fragment
            searchFragment = SearchFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), searchFragment, R.id.contentFrame);
        }

        String baseUrl = "http://193.230.8.27:28031/";
        new SearchPresenter(searchFragment,
                new ApiCityRepository(baseUrl),
                new ApiStopsRepository(baseUrl),
                SchedulerProvider.getInstance());
    }
}
