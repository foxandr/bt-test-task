package test.models;

public enum OperationType {
    INCOME("Income"),
    OUTCOME("Outcome");

    private final String name;

    OperationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
