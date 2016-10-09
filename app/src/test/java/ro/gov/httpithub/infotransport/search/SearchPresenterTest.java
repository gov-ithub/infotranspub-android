package ro.gov.httpithub.infotransport.search;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class SearchPresenterTest {

    @Mock
    private SearchContract.View mSearchView;

    private SearchPresenter mSearchPresenter;

    @Before
    public void setupSearchPresenter() {
        MockitoAnnotations.initMocks(this);

        mSearchPresenter = new SearchPresenter(mSearchView, null, null, null);
    }

    @Test
    public void getRoute_showsRouteUI() {
        mSearchPresenter.setStartPosition(42);
        mSearchPresenter.setEndPosition(43);
        mSearchPresenter.getStops(42);

        mSearchPresenter.showRoute();

        verify(mSearchView).showRoute("sibiu", "42", "44");
    }
}
