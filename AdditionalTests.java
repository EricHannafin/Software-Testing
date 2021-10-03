import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdditionalTests {

    //Here I wanted to test the NumberFormatException but was unable to get working because I think the exception
    //would need to be thrown in the clock class for me to test it

    @Test
    public void testNonIntHour(){
        int i = Integer.parseInt("T");
        assertThrows(NumberFormatException.class, () -> {
            Clock clock = new Clock(i, 58,58);
        });
    }

    @Test
    public void testNonIntMinute(){
        int i = Integer.parseInt("T");
        assertThrows(NumberFormatException.class, () -> {
            Clock clock = new Clock(22, i,58);
        });
    }

    @Test
    public void testNonIntSeconds(){
        int i = Integer.parseInt("T");
        assertThrows(NumberFormatException.class, () -> {
            Clock clock = new Clock(22, 58,i);
        });
    }
}
