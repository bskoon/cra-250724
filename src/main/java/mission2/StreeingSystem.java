package mission2;

import mission2.type.SteeringType;

public class StreeingSystem extends Component {
    private final String componentNameKor = "조향장치";
    SteeringType steeringName;

    @Override
    public boolean isValidTypeRange(int type) {
        int typeRange = SteeringType.values().length;
        if (!checkTypeRange(typeRange, type)) {
            printer.printTypeRangeError(componentNameKor, typeRange);
            return false;
        }
        return true;
    }

    @Override
    public void setComponentType(int type) {
        steeringName = SteeringType.of(type);
        printer.printSelectName(componentNameKor, steeringName.getName());
    }

    @Override
    public String getName() {
        return steeringName.getName();
    }
}
