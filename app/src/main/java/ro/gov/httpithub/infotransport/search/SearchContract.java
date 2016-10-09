package ro.gov.httpithub.infotransport.search;

import java.util.List;

import ro.gov.httpithub.infotransport.BasePresenter;
import ro.gov.httpithub.infotransport.BaseView;

interface SearchContract {
    interface View extends BaseView<SearchContract.Presenter> {
        void showRoute(String cityId, String startId, String stopId);

        void populateCities(List<String> cities);

        void populateStops(List<String> stopNames);
    }

    interface Presenter extends BasePresenter {
        void showRoute();

        void getStops(int position);

        void setStartPosition(int position);

        void setEndPosition(int position);
    }
}
