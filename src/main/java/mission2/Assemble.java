package mission2;

import mission2.type.ComponentType;

import java.util.Scanner;

public class Assemble {
    private static final int CarType_Q      = 0;
    private static final int Run_Test       = 4;

    private static final int BACKWARD = 0;
    private static final String EXIT = "exit";

    private int currentStep;
    private Printer printer;
    private Car car;
    private RunTest runTest;
    private Component component;

    public Assemble() {
        this.printer = Printer.getInstance();
    }

    public Assemble(Printer printer) {
        this.printer = printer;
    }

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        currentStep = CarType_Q;

        assembleCar(sc);

        sc.close();
    }

    private void assembleCar(Scanner sc) {
        while (true) {
            printer.showCurrentStep(currentStep);

            System.out.print("INPUT > ");
            String buf = sc.nextLine().trim();

            if (buf.equalsIgnoreCase(EXIT)) {
                printer.bye();
                break;
            }

            int type;
            try {
                type = Integer.parseInt(buf);
            } catch (NumberFormatException e) {
                printer.printNotNumber();
                continue;
            }

            try {
                doCurrentStep(type);
            } catch (Exception e) {

            }
        }
    }

    private void doCurrentStep(int type) throws InstantiationException, IllegalAccessException {
        createCurrentJobInstance(type);
        if (!isValidTypeRange(type)) {
            printer.delay(800);
            return;
        }
        if (type == BACKWARD) {
            goBackwardStep();
            return;
        }
        doStepWork(type);
    }

    private void createCurrentJobInstance(int type) throws InstantiationException, IllegalAccessException {
        if (currentStep == Run_Test) {
            if (runTest == null) runTest = new RunTest();
        }
        else if (currentStep == CarType_Q) {
            ComponentSet componentSet;
            if (car == null) {
                componentSet = new ComponentSet();
            } else {
                componentSet = car.getComponentSet();
            }
            car = new Car(componentSet);
        }
        else {
            ComponentType componentType = ComponentType.of(type);
            component = (Component) componentType.getClassType().newInstance();
        }
    }

    private boolean isValidTypeRange(int type) {
        if (type == CarType_Q) {
            return car.isValidTypeRange(type);
        } else if (type == Run_Test) {
            return runTest.isValidTypeRange(type);
        }
        return component.isValidTypeRange(type);
    }

    private void goBackwardStep() {
        if (currentStep == Run_Test) {
            currentStep = CarType_Q;
        } else {
            currentStep = currentStep - 1;
        }
    }

    private void doStepWork(int type) {
        if (currentStep == Run_Test) {
            runTest.runTestJob(type, car);
            return;
        }

        if (currentStep == CarType_Q) {
            car.setComponentType(type);
        }
        else {
            component.setComponentType(type);
            car.getComponentSet().setComponents(ComponentType.of(type).getName(), component.getName());
        }
        currentStep++;
    }
}