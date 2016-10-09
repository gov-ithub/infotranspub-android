package ro.gov.httpithub.infotransport.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

import ro.gov.httpithub.infotransport.R;
import ro.gov.httpithub.infotransport.route.RouteActivity;

import static com.google.common.base.Preconditions.checkNotNull;

public class SearchFragment extends Fragment implements SearchContract.View {
    private SearchContract.Presenter mPresenter;

    private Spinner mCitySpinner;
    private Spinner mStopSpinner;
    private Spinner mStartSpinner;

    public SearchFragment() {
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        // Setup spinners
        mCitySpinner = (Spinner) root.findViewById(R.id.citySpn);
        mCitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.getStops(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // we don't care for now
            }
        });

        mStopSpinner = (Spinner) root.findViewById(R.id.stopSpn);
        mStopSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.setEndPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        mStartSpinner = (Spinner) root.findViewById(R.id.startSpn);
        mStartSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.setStartPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Setup search action button
        Button searchButton = (Button) root.findViewById(R.id.searchBtn);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.showRoute();
            }
        });

        return root;
    }

    @Override
    public void setPresenter(@NonNull SearchContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showRoute(String cityId, String startId, String stopId) {
        Intent intent = new Intent(getContext(), RouteActivity.class);
        intent.putExtra(RouteActivity.EXTRA_CITY_ID, cityId);
        intent.putExtra(RouteActivity.EXTRA_START_ID, startId);
        intent.putExtra(RouteActivity.EXTRA_END_ID, stopId);
        startActivityForResult(intent, SearchActivity.REQUEST_ROUTE);
    }

    @Override
    public void populateCities(List<String> cities) {
        mCitySpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, cities));
    }

    @Override
    public void populateStops(List<String> stopNames) {
        mStartSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, stopNames));
        mStopSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, stopNames));
    }
}
