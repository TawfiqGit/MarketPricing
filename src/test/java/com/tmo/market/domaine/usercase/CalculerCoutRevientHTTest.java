package com.tmo.market.domaine.usercase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class CalculerCoutRevientHTTest {

    @Mock
    CalculerCoutRevientHT calculerCoutRevientHT;
    CalculerCoutRevientHT calculerCoutRevientHT2;
    CalculerCoutRevientHT calculerCoutRevientHT3;


    @BeforeEach
    void setUp() {
        calculerCoutRevientHT = new CalculerCoutRevientHT(30.0,30.0,
                30.0,30.0,30.0,10);
        calculerCoutRevientHT2 = new CalculerCoutRevientHT(30.0,30.0,
                30.0,30.0,30,0);
        calculerCoutRevientHT3 = new CalculerCoutRevientHT(0.0,0.0,
                0.0,0.0,0,0);
    }

    @Test
    void calculerCoutRevient_devrait_retourner_OK() {
        //Given
        double coutRevient = calculerCoutRevientHT.calculerCoutRevient();
        //Then
        assertEquals(15.0,coutRevient);
    }

    @Test
    void calculerCoutRevient_devrait_retourner_NO_OK() {
        //Given
        double coutRevient = calculerCoutRevientHT.calculerCoutRevient();
        //Then
        assertNotEquals(10.0,coutRevient);
    }

    @Test
    void calculerCoutRevient_devrait_retourner_isNan_if_coutsRevietn_et_quantite_egale_zero() {
        //Given
        double coutRevient3 = calculerCoutRevientHT3.calculerCoutRevient();
        boolean naN = Double.isNaN(coutRevient3);
        //Then
        //ArithmeticException
        assertTrue(naN);
    }

    @Test
    void calculerCoutRevient_devrait_retourner_Infinity_if_quantite_egale_a_zero() {
        //Given
        double coutRevient2 = calculerCoutRevientHT2.calculerCoutRevient();
        boolean infinite = Double.isInfinite(coutRevient2);
        //Then
        assertTrue(infinite);
    }
}