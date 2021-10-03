import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;


class ClockTestPositive {

    Clock clock = new Clock(23, 59, 59);
    Clock clock1 = new Clock(25, 61, 61);
    Clock clock2 = new Clock();

    @Test
    public void testGetHours() {

        assertEquals(23, clock.getHours());
    }

    @Test
    public void testGetMinutes() {

        assertEquals(59, clock.getMinutes());
    }

    @Test
    public void testGetSeconds() {

        assertEquals(59, clock.getSeconds());
    }

    @Test
    void incrementHours() {
        clock.incrementHours();
        assertEquals(0, clock.getHours());
    }

    @Test
    void incrementMinutes() {
        clock.incrementMinutes();
        assertEquals(0, clock.getMinutes());
    }

    @Test
    void incrementSeconds() {
        clock.incrementSeconds();
        assertEquals(0, clock.getSeconds());
    }

    @Test
    public void testReturnHourMinuteSecondsAboveTen() throws IOException {
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

    @Test
    public void testReturnHourMinuteSecondsUnderTen() throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        Clock clock2 = new Clock(5, 5, 5);
        clock2.returnTime();
        outStream.flush();
        String expectedOutput = new String(outStream.toByteArray());
        String[] linesOfOutput = expectedOutput.split(
                System.getProperty("line.separator"));
        assertEquals("05:05:05", linesOfOutput[0]);

    }

    @Test
    public void testPrintHourMinuteSecondsAboveTen() throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        Clock clock2 = new Clock(22, 58, 58);
        clock2.printTime();
        outStream.flush();
        String expectedOutput = new String(outStream.toByteArray());
        String[] linesOfOutput = expectedOutput.split(
                System.getProperty("line.separator"));
        assertEquals("The current time is : 22:58:58", linesOfOutput[0]);

    }

    @Test
    public void testPrintHourMinuteSecondsUnderTen() throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        Clock clock2 = new Clock(6, 7, 8);
        clock2.printTime();
        outStream.flush();
        String expectedOutput = new String(outStream.toByteArray());
        String[] linesOfOutput = expectedOutput.split(
                System.getProperty("line.separator"));
        assertEquals("The current time is : 06:07:08", linesOfOutput[0]);

    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


    //Black Box valid boundary tests


    @ParameterizedTest
    @CsvSource({"0,00", "1,01 ", "22, 22", "23,23"})
    void validHourBoundaries(int hour, int expected) {
        Clock clock = new Clock(hour, 58, 58);
        assertEquals(expected, clock.getHours());
    }

    @ParameterizedTest
    @CsvSource({"0,00", "1,01 ", "58, 58", "59,59"})
    void validMinuteBoundaries(int minutes, int expected) {
        Clock clock = new Clock(22, minutes, 58);
        assertEquals(expected, clock.getMinutes());
    }

    @ParameterizedTest
    @CsvSource({"0,00", "1,01 ", "58, 58", "59,59"})
    void validSecondBoundaries(int seconds, int expected) {
        Clock clock = new Clock(22, 58, seconds);
        assertEquals(expected, clock.getSeconds());
    }

}