package ro.gov.httpithub.infotransport.route;

import ro.gov.httpithub.infotransport.BasePresenter;
import ro.gov.httpithub.infotransport.BaseView;
import ro.gov.httpithub.infotransport.data.Route;

interface RouteContract {
    interface View extends BaseView<RouteContract.Presenter> {
        void showRoute(Route routes);
    }

    interface Presenter extends BasePresenter {
    }
}
