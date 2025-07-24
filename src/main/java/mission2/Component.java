package mission2;

import mission2.type.EngineType;

public class Component {
    private final String componentNameKor = "없음";

    boolean checkTypeRange(int size, int type) {
        return 0 <= type && type <= size;
    }
    void printTypeRangeError(int range) {
        String msg = "ERROR :: " + componentNameKor + "는(은) 1 ~ " + range + " 범위만 선택 가능";
        System.out.println(msg);
    }
    void printSelectName(String typeName) {
        String msg = typeName + " " +  componentNameKor + "를(을) 선택하셨습니다.";
        System.out.println(msg);
    }


    boolean isValidTypeRange(int type) {
        return false;
    }
    void setComponentType(int type) {
        // Do Nothing
    }
}
