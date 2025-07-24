package mission2;

public class Printer {
    private static final String CLEAR_SCREEN = "\033[H\033[2J";
    private static final int CarType_Q      = 0;
    private static final int Engine_Q       = 1;
    private static final int BrakeSystem_Q  = 2;
    private static final int SteeringSystem_Q = 3;
    private static final int Run_Test       = 4;

    private static Printer object;

    private Printer() {
    }

    public static  Printer getInstance() {
        if (object == null) {
            object = new Printer();
        }
        return object;
    }

    public void showCurrentStep(int currentStep) {
        System.out.print(CLEAR_SCREEN);
        System.out.flush();

        switch (currentStep) {
            case CarType_Q:
                showCarTypeMenu(); break;
            case Engine_Q:
                showEngineMenu(); break;
            case BrakeSystem_Q:
                showBrakeMenu(); break;
            case SteeringSystem_Q:
                showSteeringMenu(); break;
            case Run_Test:
                showRunTestMenu(); break;
        }
    }

    private void showCarTypeMenu() {
        System.out.println("        ______________");
        System.out.println("       /|            |");
        System.out.println("  ____/_|_____________|____");
        System.out.println(" |                      O  |");
        System.out.println(" '-(@)----------------(@)--'");
        System.out.println("===============================");
        System.out.println("어떤 차량 타입을 선택할까요?");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        System.out.println("3. Truck");
        System.out.println("===============================");
    }
    private void showEngineMenu() {
        System.out.println("어떤 엔진을 탑재할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. GM");
        System.out.println("2. TOYOTA");
        System.out.println("3. WIA");
        System.out.println("4. 고장난 엔진");
        System.out.println("===============================");
    }
    private void showBrakeMenu() {
        System.out.println("어떤 제동장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. MANDO");
        System.out.println("2. CONTINENTAL");
        System.out.println("3. BOSCH");
        System.out.println("===============================");
    }
    private void showSteeringMenu() {
        System.out.println("어떤 조향장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. BOSCH");
        System.out.println("2. MOBIS");
        System.out.println("===============================");
    }
    private void showRunTestMenu() {
        System.out.println("멋진 차량이 완성되었습니다.");
        System.out.println("어떤 동작을 할까요?");
        System.out.println("0. 처음 화면으로 돌아가기");
        System.out.println("1. RUN");
        System.out.println("2. Test");
        System.out.println("===============================");
    }

    public void printNotNumber() {
        System.out.println("ERROR :: 숫자만 입력 가능");
        delay(800);
    }

    public void showRunnableCar(Car car) {
        System.out.printf("Car Type : %s\n", car.getName());
        System.out.printf("Engine   : %s\n",
                car.getComponentSet().getEachComponent("Engine"));
        System.out.printf("Brake    : %s\n",
                car.getComponentSet().getEachComponent("Brake"));
        System.out.printf("Steering : %s\n",
                car.getComponentSet().getEachComponent("Steering"));
        System.out.println("자동차가 동작됩니다.");
        delay(2000);
    }

    public void printTypeRangeError(String name, int range) {
        String msg = "ERROR :: " + name + "은(는) 1 ~ " + range + " 범위만 선택 가능";
        System.out.println(msg);
        delay(800);
    }
    public void printSelectName(String name, String typeName) {
        String msg = typeName + " " +  name + "를(을) 선택하셨습니다.";
        System.out.println(msg);
        delay(800);
    }
    public void printSelectNameCar(String typeName) {
        String msg = "차량 타입으로 " + typeName + "을 선택하셨습니다.";
        System.out.println(msg);
        delay(800);
    }

    public void printTypeRangeErrorRunTest() {
        System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
    }

    public void fail(String msg) {
        System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
        System.out.println(msg);
    }

    public void bye() {
        System.out.println("바이바이");
    }

    public void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}
