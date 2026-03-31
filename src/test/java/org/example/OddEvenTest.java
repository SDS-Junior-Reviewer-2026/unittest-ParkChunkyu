package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OddEvenTest {

    @Test
    void normal_1_10() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        OddEven oe = new OddEven();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("X", "O", "X", "O", "X", "O", "X", "O", "X", "O"));
        assertEquals(oe.getResult(list), expected);
    }

    @Test
    void empty() {
        ArrayList<Integer> list = new ArrayList<>();
        OddEven oe = new OddEven();
        assertNull(oe.getResult(list));
    }

    @Test
    void allOdd() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        OddEven oe = new OddEven();
        assertNull(oe.getResult(list));
    }

    @Test
    void allEven() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        OddEven oe = new OddEven();
        assertNull(oe.getResult(list));
    }
}