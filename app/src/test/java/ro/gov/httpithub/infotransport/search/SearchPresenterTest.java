package ro.gov.httpithub.infotransport.search;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockAnnotationProcessor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class SearchPresenterTest {

    @Mock
    private SearchContract.View mSearchView;

    private SearchPresenter mSearchPresenter;

    @Before
    public void setupSearchPresenter() {
        MockitoAnnotations.initMocks(this);

        // mock view
        mSearchPresenter = new SearchPresenter(mSearchView);
    }

    @Test
    public void getRoute_showsRouteUI() {
        mSearchPresenter.getRoute();

        verify(mSearchView).showRoute();
    }
}
