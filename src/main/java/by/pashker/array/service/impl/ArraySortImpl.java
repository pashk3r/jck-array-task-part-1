package by.pashker.array.service.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;
import by.pashker.array.service.ArraySort;
import by.pashker.array.validation.impl.CustomArrayValidatorImpl;

public class ArraySortImpl implements ArraySort {
  private final CustomArrayValidatorImpl validator = new CustomArrayValidatorImpl();

  @Override
  public CustomArray bubbleSort(CustomArray array) throws CustomException {
    validator.validateArray(array);
    int[] arr = array.getArray();
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return new CustomArray(arr);
  }

  @Override
  public CustomArray selectionSort(CustomArray array) throws CustomException {
    validator.validateArray(array);
    int[] arr = array.getArray();
    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
    return new CustomArray(arr);
  }
}