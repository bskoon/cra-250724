package mission2.type;

public enum CarType {
    SEDAN("Sedan"),
    SUV("SUV"),
    TRUCK("Truck");

    final private String name;
    public String getName() {
        return name;
    }
    CarType(String name){
        this.name = name;
    }
}
