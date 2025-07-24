package mission2.type;

public enum EngineType {
    GM("GM",1),
    TOYOTA("TOYOTA", 2),
    WIA("WIA", 3),
    BROKEN("고장난 엔진", 4);

    final private String name;
    final private int typeNum;

    public String getName() {
        return name;
    }
    EngineType(String name, int typeNum){
        this.name = name;
        this.typeNum = typeNum;
    }
}
