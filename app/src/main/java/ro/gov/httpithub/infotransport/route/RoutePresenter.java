package ro.gov.httpithub.infotransport.route;

public class RoutePresenter implements RouteContract.Presenter {

    public RoutePresenter(RouteContract.View view) {
        view.setPresenter(this);
    }

    @Override
    public void start() {
    }
}
