package by.pashker.array.validation.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;
import by.pashker.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayValidatorImpl implements CustomArrayValidator {
    private static final Logger logger = LogManager.getLogger();

    public void validateArray(CustomArray array) throws CustomException {
        if (array == null) {
            logger.error("Array is null");
            throw new CustomException("Array is null");
        }
        if (array.size() == 0) {
            logger.error("Array is empty");
            throw new CustomException("Array is empty");
        }
    }
}
