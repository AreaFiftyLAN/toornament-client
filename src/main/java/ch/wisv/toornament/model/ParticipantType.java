package ch.wisv.toornament.model;

public enum ParticipantType {
    TEAM("team"), SINGLE("single");

    private String name;

    ParticipantType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
