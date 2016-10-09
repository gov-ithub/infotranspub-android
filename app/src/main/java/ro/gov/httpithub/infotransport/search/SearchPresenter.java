package ro.gov.httpithub.infotransport.search;

class SearchPresenter implements SearchContract.Presenter {
    private SearchContract.View mSearchView;

    SearchPresenter(SearchContract.View searchView) {
        this.mSearchView = searchView;

        mSearchView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        // do something
    }

    @Override
    public void unsubscribe() {
        // do something
    }

    @Override
    public void getRoute() {
        // TODO: get the route via an api call
        mSearchView.showRoute();
    }
}
