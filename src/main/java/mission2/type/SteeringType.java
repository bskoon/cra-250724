package mission2.type;

public enum SteeringType {
    BOSCH_S("BOSCH"),
    MOBIS("MOBIS");

    final private String name;
    public String getName() {
        return name;
    }
    SteeringType(String name){
        this.name = name;
    }
}
