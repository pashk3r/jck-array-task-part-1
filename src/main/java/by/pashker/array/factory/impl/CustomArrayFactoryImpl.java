package by.pashker.array.factory.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;
import by.pashker.array.factory.CustomArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayFactoryImpl implements CustomArrayFactory {
    private static final Logger logger = LogManager.getLogger();

    public CustomArray createCustomArray(int[] array) throws CustomException {
        if (array == null) {
            logger.error("You created null array");
            throw new CustomException("Array is null");
        }
        if (array.length == 0) {
            logger.error("You created empty array");
            throw new CustomException("Array is empty");
        }
        return new CustomArray(array);
    }
}
