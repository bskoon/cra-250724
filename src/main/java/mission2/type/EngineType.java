package mission2.type;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EngineType {
    GM("GM",1),
    TOYOTA("TOYOTA", 2),
    WIA("WIA", 3),
    BROKEN("고장난 엔진", 4);

    private final String name;
    private final int typeNum;

    private static final Map<Integer, String> CODE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(EngineType::getTypeNum, EngineType::name))
    );

    public int getTypeNum() {
        return typeNum;
    }

    public String getName() {
        return name;
    }

    public static EngineType of(final int type) {
        return EngineType.valueOf(CODE_MAP.get(type));
    }

    EngineType(String name, int typeNum){
        this.name = name;
        this.typeNum = typeNum;
    }
}
