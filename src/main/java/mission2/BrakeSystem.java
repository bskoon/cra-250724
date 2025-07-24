package mission2;

import mission2.type.BrakeType;

public class BrakeSystem extends Component {
    private final String componentNameKor = "제동장치";
    private BrakeType brakeType;

    @Override
    public boolean isValidTypeRange(int type) {
        int typeRange = BrakeType.values().length;
        if (!checkTypeRange(typeRange, type)) {
            printer.printTypeRangeError(componentNameKor, typeRange);
            return false;
        }

        return true;
    }

    @Override
    public void setComponentType(int type) {
        brakeType = BrakeType.of(type);
        printer.printSelectName(componentNameKor, brakeType.getName());
    }

    @Override
    public String getName() {
        return brakeType.getName();
    }

    @Override
    public Enum getType() {
        return brakeType;
    }
}
