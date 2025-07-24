package mission2;

import mission2.type.EngineType;

public class Component {
    private final String componentNameKor = "없음";
    protected Printer printer;

    public Component() {
        this.printer = Printer.getInstance();
    }

    public Component(Printer printer) {
        this.printer = printer;
    }

    boolean checkTypeRange(int size, int type) {
        return 0 <= type && type <= size;
    }


    boolean isValidTypeRange(int type) {
        return false;
    }
    void setComponentType(int type) {
        // Do Nothing
    }

    String getName() {
        return "";
    }
}
