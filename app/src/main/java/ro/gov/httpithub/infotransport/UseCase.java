package ro.gov.httpithub.infotransport;

public abstract class UseCase<R, Q> {
    public abstract R executeUseCase(Q requestValues);
}
