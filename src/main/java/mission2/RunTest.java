package mission2;

import mission2.type.SteeringType;

public class RunTest {
    public static final int RUN = 1, TEST = 2;

    private Printer printer;

    public RunTest() {
        this.printer = Printer.getInstance();
    }

    public RunTest(Printer printer) {
        this.printer = printer;
    }

    public boolean isValidTypeRange(int type) {
        //int typeRange = SteeringType.values().length;
        if (!checkTypeRange(2, type)) {
            printTypeRangeError();
            return false;
        }
        return true;
    }
    boolean checkTypeRange(int size, int type) {
        return 0 <= type && type <= size;
    }
    void printTypeRangeError() {
        System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
    }

    public void runTestJob(int type, Car car) {
        if (type == RUN) {
            runCar(car);
        } else if (type == TEST) {
            testCar(car);
        }
    }
    public void runCar(Car car) {
        if (!checkMatchValidation()) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        }
        if (car.getComponentSet().getEachComponent("Engine").equals("고장난 엔진")) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return;
        }

        printer.showRunnableCar(car);

        printer.delay(2000);
    }

    public void testCar(Car car) {
        System.out.println("Test...");
        printer.delay(1500);
        testProducedCar();
        printer.delay(2000);
    }

    private boolean checkMatchValidation() {
        if (ContinentalBreakOnSEDAN()) return false;
        if (ToyotaEngineOnSUV())       return false;
        if (WIAEngineOnTRUCK())          return false;
        if (MANDOBreakOnTRUCK())  return false;
        if (BOSCHSteeringWhenBOSCHBreak()) return false;
        return true;
    }

    private void testProducedCar() {
        if (ContinentalBreakOnSEDAN()) {
            printer.fail("Sedan에는 Continental제동장치 사용 불가");
        } else if (ToyotaEngineOnSUV()) {
            printer.fail("SUV에는 TOYOTA엔진 사용 불가");
        } else if (WIAEngineOnTRUCK()) {
            printer.fail("Truck에는 WIA엔진 사용 불가");
        } else if (MANDOBreakOnTRUCK()) {
            printer.fail("Truck에는 Mando제동장치 사용 불가");
        } else if (BOSCHSteeringWhenBOSCHBreak()) {
            printer.fail("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
        } else {
            System.out.println("자동차 부품 조합 테스트 결과 : PASS");
        }
    }

    private static boolean ContinentalBreakOnSEDAN() {
        return stack[CarType_Q] == SEDAN && stack[BrakeSystem_Q] == CONTINENTAL;
    }

    private static boolean ToyotaEngineOnSUV() {
        return stack[CarType_Q] == SUV && stack[Engine_Q] == TOYOTA;
    }

    private static boolean WIAEngineOnTRUCK() {
        return stack[CarType_Q] == TRUCK && stack[Engine_Q] == WIA;
    }

    private static boolean MANDOBreakOnTRUCK() {
        return stack[CarType_Q] == TRUCK && stack[BrakeSystem_Q] == MANDO;
    }

    private static boolean BOSCHSteeringWhenBOSCHBreak() {
        return stack[BrakeSystem_Q] == BOSCH_B && stack[SteeringSystem_Q] != BOSCH_S;
    }
}
