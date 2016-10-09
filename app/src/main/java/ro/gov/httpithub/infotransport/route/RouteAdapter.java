package ro.gov.httpithub.infotransport.route;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ro.gov.httpithub.infotransport.R;
import ro.gov.httpithub.infotransport.data.Route;
import ro.gov.httpithub.infotransport.data.Stop;

import static com.google.common.base.Preconditions.checkNotNull;

class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.ViewHolder> {
    private static final String TAG = "RouteAdapter";

    private List<Stop> mRoutes;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            textView = (TextView) v.findViewById(R.id.textView);
        }

        TextView getTextView() {
            return textView;
        }
    }

    RouteAdapter() {
        mRoutes = new ArrayList<>(0);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_route_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Stop route = mRoutes.get(position);
        holder.getTextView().setText(route.getName());
    }

    @Override
    public int getItemCount() {
        return mRoutes.size();
    }

    void replaceData(Route route) {
        setList(route.getStops());
        notifyDataSetChanged();
    }

    private void setList(List<Stop> routes) {
        mRoutes = checkNotNull(routes);
    }
}
