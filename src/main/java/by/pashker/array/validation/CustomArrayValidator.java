package by.pashker.array.validation;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;

public interface CustomArrayValidator {
    void validateArray(CustomArray array) throws CustomException;
}
