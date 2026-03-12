package by.pashker.array.entity;

import by.pashker.array.exception.CustomException;
import by.pashker.array.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CustomArray {
  private static final Logger logger = LogManager.getLogger(CustomArray.class);
  private final String id;
  private int[] array;
  private final List<ArrayObserver> observers = new ArrayList<>();

  public CustomArray(int[] array) {
    this.id = UUID.randomUUID().toString();
    this.array = Arrays.copyOf(array, array.length);
    logger.debug("Array has been created. It has {} elements", array.length);
  }

  public void addObserver(ArrayObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(ArrayObserver observer) {
    observers.remove(observer);
  }

  private void notifyObservers() {
    for (ArrayObserver observer : observers) {
      observer.update(this);
    }
  }

  public String getId() {
    return id;
  }

  public int[] getArray() {
    return Arrays.copyOf(array, array.length);
  }

  public void setArray(int[] array) {
    this.array = Arrays.copyOf(array, array.length);
    notifyObservers();
  }

  public int getElement(int index) throws CustomException {
    if (index < 0 || index >= array.length) {
      logger.error("We can't get the element. Index must be between 0 and array.length-1");
      throw new CustomException("Out of bounds");
    }
    return array[index];
  }

  public void setElement(int index, int value) throws CustomException {
    if (index < 0 || index >= array.length) {
      logger.error("We can't set the element. Index must be between 0 and array.length-1");
      throw new CustomException("Out of bounds");
    }
    array[index] = value;
    notifyObservers();
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
    if (!id.equals(that.id)) {
      return false;
    }
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
    int result = id.hashCode();
    result = 31 * result + Arrays.hashCode(array);
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CustomArray{id='");
    sb.append(id);
    sb.append("', array={");
    for (int i = 0; i < array.length; i++) {
      sb.append(array[i]);
      if (i < array.length - 1) {
        sb.append(", ");
      }
    }
    sb.append("}}");
    return sb.toString();
  }
}