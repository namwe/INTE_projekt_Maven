package character;

public enum Enum {
    SWORD("sword"),
    DEFAULT("default");

    private final String type;

    Enum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
