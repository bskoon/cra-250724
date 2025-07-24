package mission2;

import mission2.type.BrakeType;

public class BrakeSystem extends Component {
    private final String componentNameKor = "제동장치";
    BrakeType breakName;

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
        breakName = BrakeType.of(type);
        printer.printSelectName(componentNameKor, breakName.getName());
    }

    @Override
    public String getName() {
        return breakName.getName();
    }
}
