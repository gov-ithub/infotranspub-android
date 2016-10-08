package ro.gov.httpithub.infotransport.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ro.gov.httpithub.infotransport.R;

import static com.google.common.base.Preconditions.checkNotNull;

public class SearchFragment extends Fragment implements SearchContract.View {
    private SearchContract.Presenter mPresenter;

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
        mPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    public void setPresenter(@NonNull SearchContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
