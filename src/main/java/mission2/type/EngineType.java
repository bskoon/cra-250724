package mission2.type;

public enum EngineType {
    GM("GM"),
    TOYOTA("TOYOTA"),
    WIA("WIA"),
    BROKEN("고장난 엔진");

    final private String name;
    public String getName() {
        return name;
    }
    EngineType(String name){
        this.name = name;
    }
}
