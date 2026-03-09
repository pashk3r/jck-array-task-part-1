package by.pashker.array.service.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortImplTest {
    private static final ArraySortImpl sort = new ArraySortImpl();
    private static final CustomArray UNSORTED = new CustomArray(new int[]{5, 3, 1, 4, 2});
    private static final CustomArray SORTED = new CustomArray(new int[]{1, 2, 3, 4, 5});
    private static final CustomArray SINGLE = new CustomArray(new int[]{42});

    @Test
    void testBubbleSort() throws CustomException {
        CustomArray actual = sort.bubbleSort(UNSORTED);
        assertEquals(SORTED, actual);
    }

    @Test
    void testBubbleSortSingleElement() throws CustomException {
        CustomArray actual = sort.bubbleSort(SINGLE);
        assertEquals(SINGLE, actual);
    }

    @Test
    void testBubbleSortNullArray() {
        assertThrows(CustomException.class, () -> sort.bubbleSort(null));
    }

    @Test
    void testBubbleSortEmptyArray() {
        assertThrows(CustomException.class, () -> sort.bubbleSort(new CustomArray(new int[0])));
    }

    @Test
    void testSelectionSort() throws CustomException {
        CustomArray actual = sort.selectionSort(UNSORTED);
        assertEquals(SORTED, actual);
    }

    @Test
    void testSelectionSortSingleElement() throws CustomException {
        CustomArray actual = sort.selectionSort(SINGLE);
        assertEquals(SINGLE, actual);
    }

    @Test
    void testSelectionSortNullArray() {
        assertThrows(CustomException.class, () -> sort.selectionSort(null));
    }

    @Test
    void testSelectionSortEmptyArray() {
        assertThrows(CustomException.class, () -> sort.selectionSort(new CustomArray(new int[0])));
    }
}