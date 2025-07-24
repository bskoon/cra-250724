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
        verify(printer).printTypeRangeError("차량 타입", CarType.values().length);
    }

    @Test
    void overRangeCarSelect() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("999\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        verify(printer).printTypeRangeError("차량 타입", CarType.values().length);
    }

    @Test
    void selectCar() {
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\nexit".getBytes());
        System.setIn(in);

        assemble.main(null);

        // verify using Car class
        verify(printer).printSelectName("차량 타입", CarType.of(1).getName());
    }
}