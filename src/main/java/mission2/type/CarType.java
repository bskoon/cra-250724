package mission2.type;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CarType {
    SEDAN("Sedan", 1),
    SUV("SUV", 2),
    TRUCK("Truck", 3);

    private final String name;
    private final int typeNum;

    private static final Map<Integer, String> CODE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(CarType::getTypeNum, CarType::name))
    );

    public int getTypeNum() {
        return typeNum;
    }

    public String getName() {
        return name;
    }
    CarType(String name, int typeNum){
        this.name = name;
        this.typeNum = typeNum;
    }

    public static CarType of(final int type) {
        return CarType.valueOf(CODE_MAP.get(type));
    }
}
