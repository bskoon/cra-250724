package mission2.type;

public enum CarType {
    SEDAN("Sedan", 1),
    SUV("SUV", 2),
    TRUCK("Truck", 3);

    final private String name;
    final private int typeNum;

    public String getName() {
        return name;
    }
    CarType(String name, int typeNum){
        this.name = name;
        this.typeNum = typeNum;
    }
}
