package ro.gov.httpithub.infotransport.route;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ro.gov.httpithub.infotransport.R;

import static com.google.common.base.Preconditions.checkNotNull;

public class RouteFragment extends Fragment implements RouteContract.View {
    private RouteContract.Presenter mPresenter;

    public RouteFragment() {
    }

    public static RouteFragment newInstance() {
        return new RouteFragment();
    }

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
        View root = inflater.inflate(R.layout.fragment_route, container, false);
        initRecyclerView(root);

        return root;
    }

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

        String[] mDataSet = { "Stop1", "Stop2", "Stop3", "Stop4" };
        RouteAdapter mAdapter = new RouteAdapter(mDataSet);
        mRecyclerView.setAdapter(mAdapter);
    }
}
