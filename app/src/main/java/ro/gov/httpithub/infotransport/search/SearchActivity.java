package ro.gov.httpithub.infotransport.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ro.gov.httpithub.infotransport.R;
import ro.gov.httpithub.infotransport.utils.ActivityUtils;

public class SearchActivity extends AppCompatActivity {

    private SearchContract.Presenter mSearchPresenter;

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

        this.mSearchPresenter = new SearchPresenter(searchFragment);
    }
}
