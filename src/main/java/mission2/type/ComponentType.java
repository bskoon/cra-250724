package mission2.type;

import mission2.BreakSystem;
import mission2.EngineSystem;
import mission2.StreeingSystem;

public enum ComponentType {
    ENGINE(EngineSystem.class, 1),
    BREAK(BreakSystem.class, 2),
    STEERING(StreeingSystem.class, 3);

    final private Class classType;
    final private int typeNum;

    ComponentType(Class classType, int typeNum){
        this.classType = classType;
        this.typeNum = typeNum;
    }
}
