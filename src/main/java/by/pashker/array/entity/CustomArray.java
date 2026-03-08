package by.pashker.array.entity;

import by.pashker.array.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class CustomArray {
    private static final Logger logger = LogManager.getLogger();
    private int[] array;

    public CustomArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        logger.debug("Array has been created. It has {} elements", array.length);
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getElement(int index) throws CustomException {
        if  (index < 0 || index >= array.length) {
            logger.error("We can't get the element. Index must be between 0 and array.length-1");
            throw new CustomException("Out of bounds");
        }
        return array[index];
    }

    public void setElement(int index, int value) throws CustomException {
        if  (index < 0 || index >= array.length) {
            logger.error("We can't set the element. Index must be between 0 and array.length-1");
            throw new CustomException("Out of bounds");
        }
        array[index] = value;
    }

    public int size() {
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray that = (CustomArray) o;
        if (array.length != that.array.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != that.array[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int element : array) {
            result = 31 * result + element;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CustomArray array = {");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}