package ro.gov.httpithub.infotransport.data;

public final class Stop {
    private final String id;

    private final String name;

    private final int sequence;

    public Stop(String id, String name, int sequence) {
        this.id = id;
        this.name = name;
        this.sequence = sequence;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSequence() {
        return sequence;
    }
}
