package by.pashker.array.service;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;

public interface ArraySort {
    CustomArray bubbleSort(CustomArray array) throws CustomException;
    CustomArray selectionSort(CustomArray array) throws CustomException;
}
