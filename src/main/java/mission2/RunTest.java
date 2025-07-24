package mission2;

import mission2.type.CarType;

import static mission2.type.BrakeType.*;
import static mission2.type.EngineType.*;
import static mission2.type.SteeringType.BOSCH_S;

public class RunTest {
    public static final int RUN = 1;
    public static final int TEST = 2;
    public static final int RUNTEST_RANGE = 2;

    private Printer printer;

    public RunTest() {
        this.printer = Printer.getInstance();
    }

    public RunTest(Printer printer) {
        this.printer = printer;
    }

    public boolean isValidTypeRange(int type) {
        if (!checkTypeRange(RUNTEST_RANGE, type)) {
            printer.printTypeRangeErrorRunTest();
            return false;
        }
        return true;
    }

    public boolean checkTypeRange(int size, int type) {
        return 0 <= type && type <= size;
    }

    public void runTestJob(int type, Car car) {
        if (type == RUN) {
            runCar(car);
        } else if (type == TEST) {
            testCar(car);
        }
    }
    private void runCar(Car car) {
        if (!checkMatchValidation(car)) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        }
        if (car.getComponentSet().getEachComponent("Engine")
                .equals(BROKEN.getName())) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return;
        }

        printer.showRunnableCar(car);
    }

    private void testCar(Car car) {
        System.out.println("Test...");
        printer.delay(1500);
        testProducedCar(car);
        printer.delay(2000);
    }

    private boolean checkMatchValidation(Car car) {
        if (ContinentalBreakOnSEDAN(car)) return false;
        if (ToyotaEngineOnSUV(car))       return false;
        if (WIAEngineOnTRUCK(car))          return false;
        if (MANDOBreakOnTRUCK(car))  return false;
        if (BOSCHSteeringWhenBOSCHBreak(car)) return false;
        return true;
    }

    private void testProducedCar(Car car) {
        if (ContinentalBreakOnSEDAN(car)) {
            printer.fail("Sedan에는 Continental제동장치 사용 불가");
        } else if (ToyotaEngineOnSUV(car)) {
            printer.fail("SUV에는 TOYOTA엔진 사용 불가");
        } else if (WIAEngineOnTRUCK(car)) {
            printer.fail("Truck에는 WIA엔진 사용 불가");
        } else if (MANDOBreakOnTRUCK(car)) {
            printer.fail("Truck에는 Mando제동장치 사용 불가");
        } else if (BOSCHSteeringWhenBOSCHBreak(car)) {
            printer.fail("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
        } else {
            System.out.println("자동차 부품 조합 테스트 결과 : PASS");
        }
    }

    private static boolean ContinentalBreakOnSEDAN(Car car) {
        return car.getType() == CarType.SEDAN &&
                car.getComponentSet().getEachComponent("Brake") .equals( CONTINENTAL.getName());
    }

    private static boolean ToyotaEngineOnSUV(Car car) {
        return car.getType() == CarType.SUV &&
                car.getComponentSet().getEachComponent("Engine").equals( TOYOTA.getName());
    }

    private static boolean WIAEngineOnTRUCK(Car car) {
        return car.getType() == CarType.TRUCK &&
                car.getComponentSet().getEachComponent("Engine").equals( WIA.getName());
    }

    private static boolean MANDOBreakOnTRUCK(Car car) {
        return car.getType() == CarType.TRUCK &&
                car.getComponentSet().getEachComponent("Brake").equals( MANDO.getName());
    }

    private static boolean BOSCHSteeringWhenBOSCHBreak(Car car) {
        return car.getComponentSet().getEachComponent("Brake").equals(BOSCH_B.getName()) &&
                !car.getComponentSet().getEachComponent("Steering").equals(BOSCH_S.getName());
    }
}
