package by.pashker.array.service.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOperationImplTest {
    private static final ArrayOperationImpl operation = new ArrayOperationImpl();
    private static final CustomArray ARRAY = new CustomArray(new int[]{3, 1, 5, 2, 4});
    private static final CustomArray NEGATIVE = new CustomArray(new int[]{-5, -1, -3});
    private static final CustomArray SINGLE = new CustomArray(new int[]{42});

    @Test
    void testMin() throws CustomException {
        int expected = 1;
        int actual = operation.min(ARRAY);
        assertEquals(expected, actual);
    }

    @Test
    void testMinNegative() throws CustomException {
        int expected = -5;
        int actual = operation.min(NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void testMinSingleElement() throws CustomException {
        int expected = 42;
        int actual = operation.min(SINGLE);
        assertEquals(expected, actual);
    }

    @Test
    void testMinNullArray() {
        assertThrows(CustomException.class, () -> operation.min(null));
    }

    @Test
    void testMinEmptyArray() {
        assertThrows(CustomException.class, () -> operation.min(new CustomArray(new int[0])));
    }

    @Test
    void testMax() throws CustomException {
        int expected = 5;
        int actual = operation.max(ARRAY);
        assertEquals(expected, actual);
    }

    @Test
    void testMaxNegative() throws CustomException {
        int expected = -1;
        int actual = operation.max(NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void testMaxSingleElement() throws CustomException {
        int expected = 42;
        int actual = operation.max(SINGLE);
        assertEquals(expected, actual);
    }

    @Test
    void testMaxNullArray() {
        assertThrows(CustomException.class, () -> operation.max(null));
    }

    @Test
    void testMaxEmptyArray() {
        assertThrows(CustomException.class, () -> operation.max(new CustomArray(new int[0])));
    }

    @Test
    void testSum() throws CustomException {
        int expected = 15;
        int actual = operation.sum(ARRAY);
        assertEquals(expected, actual);
    }

    @Test
    void testSumNegative() throws CustomException {
        int expected = -9;
        int actual = operation.sum(NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void testSumSingleElement() throws CustomException {
        int expected = 42;
        int actual = operation.sum(SINGLE);
        assertEquals(expected, actual);
    }

    @Test
    void testSumNullArray() {
        assertThrows(CustomException.class, () -> operation.sum(null));
    }

    @Test
    void testSumEmptyArray() {
        assertThrows(CustomException.class, () -> operation.sum(new CustomArray(new int[0])));
    }
}