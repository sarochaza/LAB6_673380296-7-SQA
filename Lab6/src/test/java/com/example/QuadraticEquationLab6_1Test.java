package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationLab6_1Test {

    private QuadraticEquation eq;

    @BeforeEach
    void setUp() {
        eq = new QuadraticEquation();
    }

    
     //Lab 6.1 (LEDT) - ทดสอบกรณีข้อมูลถูกต้อง (TC001 - TC005)
    
    @ParameterizedTest(name = "[{0}] Rule #{1}: a={2}, b={3}, c={4} => Expected: {5}")
    @CsvSource({
        // TC ID,  Rule#, a, b, c, Expected Enum Value
        "TC001,      2, 0, 5, 1, NOT_QUADRATIC",
        "TC002,      3, 0, 0, 5, NOT_QUADRATIC",
        "TC003,      6, 1, 5, 1, REAL_ROOTS",
        "TC004,      7, 1, 4, 4, EQUAL_ROOTS",
        "TC005,      8, 1, 2, 5, IMAGINARY_ROOTS"
    })
    @DisplayName("Lab 6.1 - Test Valid Cases (TC001 - TC005)")
    void testValidInputs(String tcId, int ruleNo, int a, int b, int c, RootNature expectedResult) {
        RootNature actualResult = eq.determineRootNature(a, b, c);
        assertEquals(expectedResult, actualResult);
    }

    
     //Lab 6.1 (LEDT) - ทดสอบกรณีข้อมูลอยู่นอกช่วงขอบเขต (TC006 - TC013)
     
    @ParameterizedTest(name = "[{0}] Rule #{1}: a={2}, b={3}, c={4} => Expected Exception")
    @CsvSource({
        // TC ID,  Rule#,   a,   b,   c
        "TC006,     10,  -1,   5,   1",  // a < 0
        "TC007,     11,  -1,   0,   5",  // a < 0
        "TC008,     14, 101,   5,   1",  // a > 100
        "TC009,     15, 101,   4,   4",  // a > 100
        "TC010,     16, 101,   2,   5",  // a > 100
        "TC011,     16,   1,  -1,   1",  // b < 0
        "TC012,     16,   1, 101,   1",  // b > 100
        "TC013,     16,   1,   1,  -1"   // c < 0
    })
    @DisplayName("Lab 6.1 - Test Invalid Inputs (TC006 - TC013)")
    void testInvalidInputs(String tcId, int ruleNo, int a, int b, int c) {
        assertThrows(IllegalArgumentException.class, () -> {
            eq.determineRootNature(a, b, c);
        });
    }
}