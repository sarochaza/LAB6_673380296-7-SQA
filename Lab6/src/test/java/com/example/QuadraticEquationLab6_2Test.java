package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationLab6_2Test {

    private QuadraticEquation eq;

    @BeforeEach
    void setUp() {
        eq = new QuadraticEquation();
    }

    /**
     * Lab 6.2 (EEDT) - ทดสอบกรณีข้อมูลถูกต้อง (TC001 - TC004, TC011 - TC013)
     */
    @ParameterizedTest(name = "[{0}] {1}: a={2}, b={3}, c={4} => Expected: {5}")
    @CsvSource({
        // TC ID,  Rule#,    a,   b,   c, Expected Enum Value
        "TC001,   Rule #1,   0,   5,   5, NOT_QUADRATIC",
        "TC002,   Rule #2,   1,   5,   1, REAL_ROOTS",
        "TC003,   Rule #3,   1,   4,   4, EQUAL_ROOTS",
        "TC004,   Rule #4,   1,   2,   5, IMAGINARY_ROOTS",
        "TC011,   Rule #1,   0,   0,   0, NOT_QUADRATIC",
        "TC012,   Rule #2, 100, 100,   1, REAL_ROOTS",
        "TC013,   Rule #3,   2,   4,   2, EQUAL_ROOTS"
    })
    @DisplayName("Lab 6.2 - Test Valid Cases")
    void testValidInputs(String tcId, String rule, int a, int b, int c, RootNature expectedResult) {
        RootNature actualResult = eq.determineRootNature(a, b, c);
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Lab 6.2 (EEDT) - ทดสอบกรณีข้อมูลอยู่นอกช่วงขอบเขต (TC005 - TC010)
     */
    @ParameterizedTest(name = "[{0}] {1}: a={2}, b={3}, c={4} => Expected Exception")
    @CsvSource({
        // TC ID,  Rule#,    a,   b,   c
        "TC005,   Rule #5,  -1,   5,   5",  // a < 0
        "TC006,   Rule #5, 101,   5,   5",  // a > 100
        "TC007,   Rule #5,   5,  -1,   5",  // b < 0
        "TC008,   Rule #5,   5, 101,   5",  // b > 100
        "TC009,   Rule #5,   5,   5,  -1",  // c < 0
        "TC010,   Rule #5,   5,   5, 101"   // c > 100
    })
    @DisplayName("Lab 6.2 - Test Invalid Inputs Out of Range [0, 100]")
    void testInvalidInputs(String tcId, String rule, int a, int b, int c) {
        assertThrows(IllegalArgumentException.class, () -> {
            eq.determineRootNature(a, b, c);
        });
    }
}