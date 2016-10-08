package ro.gov.httpithub.infotransport.search;

import ro.gov.httpithub.infotransport.BasePresenter;
import ro.gov.httpithub.infotransport.BaseView;

interface SearchContract {
    interface View extends BaseView<SearchContract.Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
