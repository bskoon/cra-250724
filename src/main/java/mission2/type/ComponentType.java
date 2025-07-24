package mission2.type;

import mission2.BrakeSystem;
import mission2.EngineSystem;
import mission2.StreeingSystem;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ComponentType {
    ENGINE(EngineSystem.class, "Engine", 1),
    BREAK(BrakeSystem.class, "Brake", 2),
    STEERING(StreeingSystem.class, "Steering", 3);

    private final Class classType;
    private final String name;
    private final int typeNum;

    private static final Map<Integer, String> CODE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(ComponentType::getTypeNum, ComponentType::name))
    );

    public int getTypeNum() {
        return typeNum;
    }

    public String getName() {
        return name;
    }

    public Class getClassType() {
        return classType;
    }

    public static ComponentType of(final int type) {
        return ComponentType.valueOf(CODE_MAP.get(type));
    }

    ComponentType(Class classType, String name, int typeNum){
        this.classType = classType;
        this.name = name;
        this.typeNum = typeNum;
    }
}
