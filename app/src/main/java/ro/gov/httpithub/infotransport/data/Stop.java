package ro.gov.httpithub.infotransport.data;

public final class Stop {
    private final String name;

    private final int sequence;

    public Stop(String name, int sequence) {
        this.name = name;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public int getSequence() {
        return sequence;
    }
}
