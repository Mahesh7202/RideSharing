package com.example.geektrust;



import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.regex.Pattern;


class GeekTrustTest{
    private final PrintStream standardOut = System.out;

    private static final Pattern LINE_SEPARATOR_PATTERN = Pattern.compile("\\R");

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private String[] argument;
    private String expectedOutput;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor,true));
    }



    @Test
    @DisplayName("Integration Test #1")
    void runTest1() throws IOException {
        // Arrange
        argument = new String[]{"sample_input/input1.txt"};
        expectedOutput = "DRIVERS_MATCHED D1 D3\n" +
                "RIDE_STARTED RIDE-001\n" +
                "RIDE_STOPPED RIDE-001\n" +
                "BILL RIDE-001 D3 186.72";

        // Act
        GeekTrust.main(argument);

        // Assert
        Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));
    }


    @Test
    @DisplayName("Integration Test #2")
    void runTest2(){
        //Arrange
        argument = new String[]{"sample_input/input2.txt"};
        expectedOutput = "DRIVERS_MATCHED D2 D3 D1\n" +
                "DRIVERS_MATCHED D1 D2 D3\n" +
                "RIDE_STARTED RIDE-101\n" +
                "RIDE_STARTED RIDE-102\n" +
                "RIDE_STOPPED RIDE-101\n" +
                "RIDE_STOPPED RIDE-102\n" +
                "BILL RIDE-101 D2 234.64\n" +
                "BILL RIDE-102 D1 258.00";
        // Act
        GeekTrust.main(argument);

        // Assert
        Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));
    }


    @Test
    @DisplayName("Integration Test #3")
    void runTest3(){
        //Arrange
        argument = new String[]{"sample_input/input3.txt"};
        expectedOutput = "NO_DRIVERS_AVAILABLE\n" +
                "DRIVERS_MATCHED D13 D4 D2\n" +
                "RIDE_STARTED RIDE-001\n" +
                "RIDE_STOPPED RIDE-001\n" +
                "BILL RIDE-001 D13 268.36";

        // Act
        GeekTrust.main(argument);

        // Assert
        Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));
    }

    @Test
    @DisplayName("Integration Test #4")
    void runTest4(){
        //Arrange
        argument = new String[]{"sample_input/input4.txt"};
        expectedOutput = "NO_DRIVERS_AVAILABLE\n" +
                "DRIVERS_MATCHED D1\n" +
                "DRIVERS_MATCHED D2 D1\n" +
                "DRIVERS_MATCHED D14 D15 D16 D1\n" +
                "DRIVERS_MATCHED D15 D2 D1\n" +
                "RIDE_STARTED RIDE-001\n" +
                "DRIVERS_MATCHED D14 D16 D17 D1\n" +
                "RIDE_STOPPED RIDE-001\n" +
                "BILL RIDE-001 D15 327.20\n" +
                "RIDE_STARTED RIDE-002\n" +
                "RIDE_STOPPED RIDE-002\n" +
                "INVALID_RIDE\n" +
                "BILL RIDE-002 D17 440.26\n" +
                "INVALID_RIDE\n" +
                "BILL RIDE-002 D17 440.26";
        // Act
        GeekTrust.main(argument);

        // Assert
        Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));

    }

    @Test
    @DisplayName("Integration Test #5")
    void runTest5(){
        //Arrange
        argument = new String[]{"sample_input/input5.txt"};
        expectedOutput = "DRIVERS_MATCHED D1\n" +
                "DRIVERS_MATCHED D3 D1 D2\n" +
                "RIDE_STARTED RIDE-001\n" +
                "DRIVERS_MATCHED D6 D7 D5 D3 D4\n" +
                "DRIVERS_MATCHED D5 D6 D7 D3\n" +
                "RIDE_STOPPED RIDE-001\n" +
                "RIDE_STARTED RIDE-002\n" +
                "RIDE_STARTED RIDE-003\n" +
                "BILL RIDE-001 D1 96.67\n" +
                "RIDE_STOPPED RIDE-002\n" +
                "RIDE_STOPPED RIDE-003\n" +
                "BILL RIDE-003 D6 62.40\n" +
                "BILL RIDE-002 D7 79.80";
        //Act
        GeekTrust.main(argument);

        // Assert
        Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));

    }


    @Test
    @DisplayName("Integration Test #6")
    void runTest6(){
        //Arrange
        argument = new String[]{"sample_input/input6.txt"};
        expectedOutput = "NO_DRIVERS_AVAILABLE\n" +
                "INVALID_RIDE\n" +
                "INVALID_RIDE\n" +
                "INVALID_RIDE";
        //Act
        GeekTrust.main(argument);

        // Assert
        Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));

    }


    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    private String normalizeLineSeparators(String str) {
        return LINE_SEPARATOR_PATTERN.matcher(str).replaceAll("\n");
    }


}