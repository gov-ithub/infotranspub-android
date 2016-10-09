package ro.gov.httpithub.infotransport.route;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ro.gov.httpithub.infotransport.R;
import ro.gov.httpithub.infotransport.data.Route;
import ro.gov.httpithub.infotransport.data.Stop;

import static com.google.common.base.Preconditions.checkNotNull;

public class RouteFragment extends Fragment implements RouteContract.View {
    private RouteContract.Presenter mPresenter;
    private RouteAdapter mRouteAdapter;

    public static RouteFragment newInstance() {
        return new RouteFragment();
    }

    public RouteFragment() {
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
        View root = inflater.inflate(R.layout.fragment_route, container, false);
        initRecyclerView(root);

        return root;
    }

    @Override
    public void showRoute(Route route) {
        mRouteAdapter.replaceData(route);
    }

    @Override
    public void setPresenter(@NonNull RouteContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    private void initRecyclerView(View root) {
        RecyclerView mRecyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        int scrollPosition = 0;

        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);

        mRouteAdapter = new RouteAdapter();
        mRecyclerView.setAdapter(mRouteAdapter);
    }
}
