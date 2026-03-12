package by.pashker.array.factory;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;

public interface CustomArrayFactory {
  CustomArray createCustomArray(int[] array) throws CustomException;
}
