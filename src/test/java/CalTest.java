import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalTest {
    @Test
    void getSum() {
        Cal cal = mock(Cal.class);//new Cal();
        when(cal.getSum(10,20)).thenReturn(999);
        int actual = cal.getSum(10,20);
        assertEquals(999, actual);
    }
}