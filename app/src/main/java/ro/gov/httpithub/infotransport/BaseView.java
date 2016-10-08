package ro.gov.httpithub.infotransport;

public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);
}
