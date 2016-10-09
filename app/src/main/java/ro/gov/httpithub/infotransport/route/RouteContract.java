package ro.gov.httpithub.infotransport.route;

import ro.gov.httpithub.infotransport.BasePresenter;
import ro.gov.httpithub.infotransport.BaseView;

interface RouteContract {
    interface View extends BaseView<RouteContract.Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
