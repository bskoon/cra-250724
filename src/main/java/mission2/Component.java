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

    protected boolean checkTypeRange(int size, int type) {
        return 0 <= type && type <= size;
    }

    public boolean isValidTypeRange(int type) {
        return false;
    }
    public void setComponentType(int type) {
        // Do Nothing
    }

    public String getName() {
        return "";
    }

    public Enum getType() {
        return null;
    }
}
