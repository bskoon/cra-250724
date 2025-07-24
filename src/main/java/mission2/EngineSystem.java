package mission2;

import mission2.type.EngineType;

public class EngineSystem extends Component {
    private final String componentNameKor = "엔진";
    EngineType engineName;

    @Override
    public boolean isValidTypeRange(int type) {
        int typeRange = EngineType.values().length;
        if (!checkTypeRange(typeRange, type)) {
            printTypeRangeError(typeRange);
            return false;
        }

        return true;
    }

    @Override
    public void setComponentType(int type) {
        engineName = EngineType.of(type);
        printSelectName(engineName.getName());
    }
}
