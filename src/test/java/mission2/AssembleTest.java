package mission2;

import mission2.type.CarType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AssembleTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    Printer printer = spy(Printer.class);
    Assemble assemble;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        assemble = new Assemble(printer);
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void simpleTest() {
        Assemble assembleSimple = new Assemble();
        assertNotNull(assembleSimple);
    }

    @Test
    void exitTest() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("exit".getBytes());
        System.setIn(in);

        String expected = "바이바이";

        assemble.main(null);

        String allout = outputStreamCaptor.toString().trim();
        String actual = allout.substring(allout.length()-expected.length(), allout.length());
        assertEquals(expected, actual);
    }

    @Test
    void writeCharacter() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("a\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        verify(printer).printNotNumber();
    }

    @Test
    void underRangeCarSelect() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("0\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "ERROR :: 차량 타입은(는) 1 ~ 3 범위만 선택 가능";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void overRangeCarSelect() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("999\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "ERROR :: 차량 타입은(는) 1 ~ 3 범위만 선택 가능";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void selectCar() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "차량 타입으로 Sedan을 선택하셨습니다.";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void underRangeEngineSelect() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n-1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "ERROR :: 엔진은(는) 1 ~ 4 범위만 선택 가능";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void overRangeEngineSelect() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n999\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "ERROR :: 엔진은(는) 1 ~ 4 범위만 선택 가능";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void backwardEngine() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n0\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "ERROR :: 엔진은(는) 1 ~ 4 범위만 선택 가능";
        String allout = outputStreamCaptor.toString().trim();
        assertFalse(allout.contains(expected));
    }

    @Test
    void selectEngine() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "GM 엔진를(을) 선택하셨습니다.";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void underRangeBrakeSelect() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n-1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "ERROR :: 제동장치은(는) 1 ~ 3 범위만 선택 가능";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void overRangeBrakeSelect() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n999\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "ERROR :: 제동장치은(는) 1 ~ 3 범위만 선택 가능";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void backwardBrake() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n0\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "ERROR :: 제동장치은(는) 1 ~ 3 범위만 선택 가능";
        String allout = outputStreamCaptor.toString().trim();
        assertFalse(allout.contains(expected));
    }

    @Test
    void selectBrake() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "MANDO 제동장치를(을) 선택하셨습니다.";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void underRangeSteerSelect() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n1\n-1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "ERROR :: 조향장치은(는) 1 ~ 2 범위만 선택 가능";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void overRangeSteerSelect() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n1\n999\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "ERROR :: 조향장치은(는) 1 ~ 2 범위만 선택 가능";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void backwardSteer() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n0\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "ERROR :: 조향장치은(는) 1 ~ 2 범위만 선택 가능";
        String allout = outputStreamCaptor.toString().trim();
        assertFalse(allout.contains(expected));
    }

    @Test
    void selectSteer() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n1\n1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "BOSCH 조향장치를(을) 선택하셨습니다.";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void runCarTest() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n1\n1\n1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "자동차가 동작됩니다.";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void noRunCarTest1() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n2\n1\n1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "자동차가 동작되지 않습니다";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void noRunCarTest2() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2\n2\n2\n1\n1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "자동차가 동작되지 않습니다";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void noRunCarTest3() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("3\n3\n2\n1\n1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "자동차가 동작되지 않습니다";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void noRunCarTest4() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("3\n1\n1\n1\n1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "자동차가 동작되지 않습니다";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void noRunCarTest5() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n3\n2\n1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "자동차가 동작되지 않습니다";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void noRunCarTest6() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n4\n1\n1\n1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "자동차가 움직이지 않습니다.";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void testCarTest() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n1\n1\n2\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "자동차 부품 조합 테스트 결과 : PASS";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void noTestCarTest11() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n2\n1\n2\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "Sedan에는 Continental제동장치 사용 불가";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void noTestCarTest22() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2\n2\n2\n1\n2\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "SUV에는 TOYOTA엔진 사용 불가";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void noTestCarTest33() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("3\n3\n2\n1\n2\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "Truck에는 WIA엔진 사용 불가";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void noTestCarTest44() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("3\n1\n1\n1\n2\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "Truck에는 Mando제동장치 사용 불가";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }

    @Test
    void noTestCarTest55() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n3\n2\n2\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        String expected = "Bosch제동장치에는 Bosch조향장치 이외 사용 불가";
        String allout = outputStreamCaptor.toString().trim();
        assertTrue(allout.contains(expected));
    }
}