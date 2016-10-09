package ro.gov.httpithub.infotransport.route;

import java.util.List;

import ro.gov.httpithub.infotransport.BasePresenter;
import ro.gov.httpithub.infotransport.BaseView;
import ro.gov.httpithub.infotransport.data.Route;
import ro.gov.httpithub.infotransport.data.Stop;

interface RouteContract {
    interface View extends BaseView<RouteContract.Presenter> {
        void showRoute(Route routes);
    }

    interface Presenter extends BasePresenter {
    }
}
