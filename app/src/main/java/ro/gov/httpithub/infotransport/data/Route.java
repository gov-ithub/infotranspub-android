package ro.gov.httpithub.infotransport.data;

import android.support.annotation.NonNull;

import java.util.List;

public class Route {
    private final List<Stop> mStops;

    public Route(@NonNull List<Stop> stops) {
        mStops = stops;
    }

    public List<Stop> getStops() {
        return mStops;
    }
}
