package ro.gov.httpithub.infotransport.data;

public final class Stop {
    private final int id;

    private final String name;

    private final int sequence;

    public Stop(int id, String name, int sequence) {
        this.id = id;
        this.name = name;
        this.sequence = sequence;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSequence() {
        return sequence;
    }
}
