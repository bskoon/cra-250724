package mission2.type;

public enum SteeringType {
    BOSCH_S("BOSCH", 1),
    MOBIS("MOBIS", 2);

    final private String name;
    final private int typeNum;

    public String getName() {
        return name;
    }
    SteeringType(String name, int typeNum){
        this.name = name;
        this.typeNum = typeNum;
    }
}
