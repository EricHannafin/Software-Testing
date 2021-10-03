import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BlackBoxTestsNegative {
    Clock clock = new Clock(24,61,61);

    @Test
    public void returnInvalidHour() {

        assertEquals(0, clock.getHours());
    }

    @Test
    public void returnInvalidMinutes() {

        assertEquals(0, clock.getMinutes());
    }

    @Test
    public void returnInvalidSeconds() {

        assertEquals(0, clock.getSeconds());
    }

    @Test
    public void returnInvalidTime() throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        Clock clock2 = new Clock(24, 61, 61);
        clock2.returnTime();
        outStream.flush();
        String expectedOutput = new String(outStream.toByteArray());
        String[] linesOfOutput = expectedOutput.split(
                System.getProperty("line.separator"));
        assertEquals("00:00:00", linesOfOutput[0]);

    }


    @ParameterizedTest
    @CsvSource({"-1,0", "24,0 "})
    void invalidHourBoundaries(int hour, int expected) {
        Clock clock = new Clock(hour,58,58);
        assertEquals(expected, clock.getHours());
    }

    @ParameterizedTest
    @CsvSource({"-1,0", "60,0 "})
    void invalidMinuteBoundaries(int minutes, int expected) {
        Clock clock = new Clock(22,minutes,58);
        assertEquals(expected, clock.getMinutes());
    }

    @ParameterizedTest
    @CsvSource({"-1,0", "60,0 "})
    void invalidSecondBoundaries(int seconds, int expected) {
        Clock clock = new Clock(22,58,seconds);
        assertEquals(expected, clock.getSeconds());
    }
}
