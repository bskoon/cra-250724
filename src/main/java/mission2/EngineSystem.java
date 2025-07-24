package mission2;

import mission2.type.EngineType;

public class EngineSystem extends Component {
    private final String componentNameKor = "엔진";
    private EngineType engineType;

    @Override
    public boolean isValidTypeRange(int type) {
        int typeRange = EngineType.values().length;
        if (!checkTypeRange(typeRange, type)) {
            printer.printTypeRangeError(componentNameKor, typeRange);
            return false;
        }

        return true;
    }

    @Override
    public void setComponentType(int type) {
        engineType = EngineType.of(type);
        printer.printSelectName(componentNameKor, engineType.getName());
    }

    @Override
    public String getName() {
        return engineType.getName();
    }
}
