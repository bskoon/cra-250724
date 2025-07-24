package mission2.type;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum SteeringType {
    BOSCH_S("BOSCH", 1),
    MOBIS("MOBIS", 2);

    private final String name;
    private final int typeNum;

    private static final Map<Integer, String> CODE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(SteeringType::getTypeNum, SteeringType::name))
    );

    public int getTypeNum() {
        return typeNum;
    }
    public String getName() {
        return name;
    }
    public static SteeringType of(final int type) {
        return SteeringType.valueOf(CODE_MAP.get(type));
    }

    SteeringType(String name, int typeNum){
        this.name = name;
        this.typeNum = typeNum;
    }
}
