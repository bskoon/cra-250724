package mission2;

import java.util.Scanner;

public class Assemble {
    private static final String CLEAR_SCREEN = "\033[H\033[2J";

    private static final int CarType_Q      = 0;
    private static final int Engine_Q       = 1;
    private static final int BrakeSystem_Q  = 2;
    private static final int SteeringSystem_Q = 3;
    private static final int Run_Test       = 4;

    private static final int BACKWARD = 0;
    private static final int SEDAN = 1, SUV = 2, TRUCK = 3;
    private static final int GM = 1, TOYOTA = 2, WIA = 3, BROKEN = 4;
    private static final int MANDO = 1, CONTINENTAL = 2, BOSCH_B = 3;
    private static final int BOSCH_S = 1, MOBIS = 2;
    public static final int RUN = 1, TEST = 2;

    private static int[] stack = new int[5];
    private static int currentStep;


    public static void main(String[] args) {
        // Pseudo Code for assemble
        // 1. select type
        // 2. select components
        // 3. test


        Scanner sc = new Scanner(System.in);
        currentStep = CarType_Q;

        while (true) {
            showCurrentStep();

            System.out.print("INPUT > ");
            String buf = sc.nextLine().trim();

            if (buf.equalsIgnoreCase("exit")) {
                System.out.println("바이바이");
                break;
            }

            int type;
            try {
                type = Integer.parseInt(buf);
            } catch (NumberFormatException e) {
                System.out.println("ERROR :: 숫자만 입력 가능");
                delay(800);
                continue;
            }

            if (!isValidTypeRange(type)) {
                delay(800);
                continue;
            }

            if (type == BACKWARD) {
                goBackwardStep();
                continue;
            }

            doStepJob(type);
        }

        sc.close();
    }

    private static void goBackwardStep() {
        if (currentStep == Run_Test) {
            currentStep = CarType_Q;
        } else {
            currentStep = currentStep - 1;
        }
    }

    private static void doStepJob(int type) {
        if (currentStep == Run_Test) {
            if (type == RUN) {
                runProducedCar();
                delay(2000);
            } else if (type == TEST) {
                System.out.println("Test...");
                delay(1500);
                testProducedCar();
                delay(2000);
            }
        }
        else {
            setCurrentStepType(type);
            delay(800);
            currentStep++;
        }
    }

    private static void showCurrentStep() {
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

    private static void showCarTypeMenu() {
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
    private static void showEngineMenu() {
        System.out.println("어떤 엔진을 탑재할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. GM");
        System.out.println("2. TOYOTA");
        System.out.println("3. WIA");
        System.out.println("4. 고장난 엔진");
        System.out.println("===============================");
    }
    private static void showBrakeMenu() {
        System.out.println("어떤 제동장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. MANDO");
        System.out.println("2. CONTINENTAL");
        System.out.println("3. BOSCH");
        System.out.println("===============================");
    }
    private static void showSteeringMenu() {
        System.out.println("어떤 조향장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. BOSCH");
        System.out.println("2. MOBIS");
        System.out.println("===============================");
    }
    private static void showRunTestMenu() {
        System.out.println("멋진 차량이 완성되었습니다.");
        System.out.println("어떤 동작을 할까요?");
        System.out.println("0. 처음 화면으로 돌아가기");
        System.out.println("1. RUN");
        System.out.println("2. Test");
        System.out.println("===============================");
    }

    private static void setCurrentStepType(int type) {
        stack[currentStep] = type;
        switch (currentStep) {
            case CarType_Q:
                String carType = type == SEDAN ? "Sedan" : type == SUV ? "SUV" : "Truck";
                System.out.printf("차량 타입으로 %s을 선택하셨습니다.\n", carType);
                break;
            case Engine_Q:
                String engineName = type == GM ? "GM" : type == TOYOTA ? "TOYOTA" : type == WIA ? "WIA" : "고장난 엔진";
                System.out.printf("%s 엔진을 선택하셨습니다.\n", engineName);
                break;
            case BrakeSystem_Q:
                String breakName = type == MANDO ? "MANDO" : type == CONTINENTAL ? "CONTINENTAL" : "BOSCH";
                System.out.printf("%s 제동장치를 선택하셨습니다.\n", breakName);
                break;
            case SteeringSystem_Q:
                String steeringName = type == BOSCH_S ? "BOSCH" : "MOBIS";
                System.out.printf("%s 조향장치를 선택하셨습니다.\n", steeringName);
                break;
        }
    }

    private static boolean isValidTypeRange(int type) {
        switch (currentStep) {
            case CarType_Q:
                if (type < 1 || type > 3) {
                    System.out.println("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
                    return false;
                }
                break;
            case Engine_Q:
                if (type < 0 || type > 4) {
                    System.out.println("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
                    return false;
                }
                break;
            case BrakeSystem_Q:
                if (type < 0 || type > 3) {
                    System.out.println("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능");
                    return false;
                }
                break;
            case SteeringSystem_Q:
                if (type < 0 || type > 2) {
                    System.out.println("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능");
                    return false;
                }
                break;
            case Run_Test:
                if (type < 0 || type > 2) {
                    System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
                    return false;
                }
                break;
        }
        return true;
    }

    private static void runProducedCar() {
        if (!checkMatchValidation()) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        }
        if (stack[Engine_Q] == BROKEN) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return;
        }

        showRunnableCar();
    }

    private static void showRunnableCar() {
        String[] carNames = {"", "Sedan", "SUV", "Truck"};
        String[] engNames = {"", "GM", "TOYOTA", "WIA"};
        System.out.printf("Car Type : %s\n", carNames[stack[CarType_Q]]);
        System.out.printf("Engine   : %s\n", engNames[stack[Engine_Q]]);
        System.out.printf("Brake    : %s\n",
                stack[BrakeSystem_Q]==MANDO? "Mando":
                        stack[BrakeSystem_Q]==CONTINENTAL? "Continental":"Bosch");
        System.out.printf("Steering : %s\n",
                stack[SteeringSystem_Q]==BOSCH_S? "Bosch":"Mobis");
        System.out.println("자동차가 동작됩니다.");
    }

    private static boolean checkMatchValidation() {
        if (ContinentalBreakOnSEDAN()) return false;
        if (ToyotaEngineOnSUV())       return false;
        if (WIAEngineOnTRUCK())          return false;
        if (MANDOBreakOnTRUCK())  return false;
        if (BOSCHSteeringWhenBOSCHBreak()) return false;
        return true;
    }

    private static void testProducedCar() {
        if (ContinentalBreakOnSEDAN()) {
            fail("Sedan에는 Continental제동장치 사용 불가");
        } else if (ToyotaEngineOnSUV()) {
            fail("SUV에는 TOYOTA엔진 사용 불가");
        } else if (WIAEngineOnTRUCK()) {
            fail("Truck에는 WIA엔진 사용 불가");
        } else if (MANDOBreakOnTRUCK()) {
            fail("Truck에는 Mando제동장치 사용 불가");
        } else if (BOSCHSteeringWhenBOSCHBreak()) {
            fail("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
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

    private static void fail(String msg) {
        System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
        System.out.println(msg);
    }


    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}
