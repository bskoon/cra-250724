package mission2.type;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BrakeType {
    MANDO("MANDO", 1),
    CONTINENTAL("CONTINENTAL", 2),
    BOSCH_B("BOSCH",3);

    private final String name;
    private final int typeNum;

    private static final Map<Integer, String> CODE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(BrakeType::getTypeNum, BrakeType::name))
    );

    public int getTypeNum() {
        return typeNum;
    }

    public String getName() {
        return name;
    }

    public static BrakeType of(final int type) {
        return BrakeType.valueOf(CODE_MAP.get(type));
    }

    BrakeType(String name, int typeNum){
        this.name = name;
        this.typeNum = typeNum;
    }
}
