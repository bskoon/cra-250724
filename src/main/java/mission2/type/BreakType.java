package mission2.type;

public enum BreakType {
    MANDO("MANDO"),
    CONTINENTAL("CONTINENTAL"),
    BOSCH_B("BOSCH");

    final private String name;
    public String getName() {
        return name;
    }
    BreakType(String name){
        this.name = name;
    }
}
