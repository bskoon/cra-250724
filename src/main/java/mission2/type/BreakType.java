package mission2.type;

public enum BreakType {
    MANDO("MANDO", 1),
    CONTINENTAL("CONTINENTAL", 2),
    BOSCH_B("BOSCH",3);

    final private String name;
    final private int typeNum;

    public String getName() {
        return name;
    }

    BreakType(String name, int typeNum){
        this.name = name;
        this.typeNum = typeNum;
    }
}
