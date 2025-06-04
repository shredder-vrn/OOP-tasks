package vsu.cs.Task9;

public enum LocationType {
    CITY("Городская территория"),
    COASTAL("Прибрежная зона");

    private final String description;

    LocationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
