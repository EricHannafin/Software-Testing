import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BlackBoxTestsPositive {

    Clock clock = new Clock(22,58,58);

    @Test
    public void returnValidHour() {

        assertEquals(22, clock.getHours());
    }

    @Test
    public void returnValidMinutes() {

        assertEquals(58, clock.getMinutes());
    }

    @Test
    public void returnValidSeconds() {

        assertEquals(58, clock.getSeconds());
    }

    @Test
    public void returnValidTime() throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        Clock clock2 = new Clock(22, 58, 58);
        clock2.returnTime();
        outStream.flush();
        String expectedOutput = new String(outStream.toByteArray());
        String[] linesOfOutput = expectedOutput.split(
                System.getProperty("line.separator"));
        assertEquals("22:58:58", linesOfOutput[0]);

    }

    @ParameterizedTest
    @CsvSource({"0,0", "23,23 "})
    void validHourBoundaries(int hour, int expected) {
        Clock clock = new Clock(hour,58,58);
        assertEquals(expected, clock.getHours());
    }

    @ParameterizedTest
    @CsvSource({"0,0", "59,59 "})
    void validMinuteBoundaries(int minutes, int expected) {
        Clock clock = new Clock(22,minutes,58);
        assertEquals(expected, clock.getMinutes());
    }

    @ParameterizedTest
    @CsvSource({"0,0", "59,59 "})
    void validSecondBoundaries(int seconds, int expected) {
        Clock clock = new Clock(22,58,seconds);
        assertEquals(expected, clock.getSeconds());
    }

}