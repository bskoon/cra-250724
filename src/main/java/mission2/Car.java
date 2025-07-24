package mission2;

import mission2.type.CarType;

public class Car {
    ComponentSet componentSet;
    private final String componentNameKor = "차량 타입";
    CarType carType;
    Printer printer;

    public Car(ComponentSet componentSet) {
        this.componentSet = componentSet;
        this.printer = Printer.getInstance();
    }

    boolean checkTypeRange(int size, int type) {
        return 1 <= type && type <= size;
    }

    public boolean isValidTypeRange(int type) {
        int typeRange = CarType.values().length;
        if (!checkTypeRange(typeRange, type)) {
            printer.printTypeRangeError(componentNameKor, typeRange);
            return false;
        }
        return true;
    }

    public void setComponentType(int type) {
        carType = CarType.of(type);
        printer.printSelectName(componentNameKor, carType.getName());
    }

    public CarType getType() {
        return carType;
    }

    public ComponentSet getComponentSet() {
        return componentSet;
    }
}
