package ro.gov.httpithub.infotransport.search;

class SearchPresenter implements SearchContract.Presenter {
    private SearchContract.View mSearchView;

    SearchPresenter(SearchContract.View searchView) {
        this.mSearchView = searchView;

        mSearchView.setPresenter(this);
    }

    @Override
    public void start() {
        // do something
    }
}
