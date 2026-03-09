package by.pashker.array.service.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;
import by.pashker.array.service.ArrayOperation;
import by.pashker.array.validation.impl.CustomArrayValidatorImpl;

public class ArrayOperationImpl implements ArrayOperation {
    private final CustomArrayValidatorImpl validator = new CustomArrayValidatorImpl();

    @Override
    public int min(CustomArray array) throws CustomException {
        validator.validateArray(array);
        int min = array.getElement(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.getElement(i) < min) {
                min = array.getElement(i);
            }
        }
        return min;
    }

    @Override
    public int max(CustomArray array) throws CustomException {
        validator.validateArray(array);
        int max = array.getElement(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.getElement(i) > max) {
                max = array.getElement(i);
            }
        }
        return max;
    }

    @Override
    public int sum(CustomArray array) throws CustomException {
        validator.validateArray(array);
        int sum = 0;
        for (int element : array.getArray()) {
            sum += element;
        }
        return sum;
    }
}