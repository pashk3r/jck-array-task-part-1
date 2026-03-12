package by.pashker.array.repository.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.observer.impl.WarehouseObserver;
import by.pashker.array.repository.ArrayRepository;
import by.pashker.array.specification.Specification;
import by.pashker.array.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {
  private static final Logger logger = LogManager.getLogger(ArrayRepositoryImpl.class);
  private static ArrayRepositoryImpl instance;
  private final List<CustomArray> arrays = new ArrayList<>();
  private final WarehouseObserver observer = new WarehouseObserver();

  private ArrayRepositoryImpl() {
  }

  public static ArrayRepositoryImpl getInstance() {
    if (instance == null) {
      instance = new ArrayRepositoryImpl();
    }
    return instance;
  }

  @Override
  public void add(CustomArray array) {
    array.addObserver(observer);
    ArrayWarehouse.getInstance().recalculate(array);
    arrays.add(array);
    logger.debug("Array {} added to repository", array.getId());
  }

  @Override
  public void remove(CustomArray array) {
    array.removeObserver(observer);
    ArrayWarehouse.getInstance().remove(array.getId());
    arrays.remove(array);
    logger.debug("Array {} removed from repository", array.getId());
  }

  @Override
  public CustomArray findById(String id) {
    for (CustomArray array : arrays) {
      if (array.getId().equals(id)) {
        return array;
      }
    }
    logger.warn("Array with id {} not found", id);
    return null;
  }

  @Override
  public List<CustomArray> findAll() {
    return new ArrayList<>(arrays);
  }

  @Override
  public List<CustomArray> sort(Comparator<CustomArray> comparator) {
    List<CustomArray> sorted = new ArrayList<>(arrays);
    sorted.sort(comparator);
    return sorted;
  }

  @Override
  public List<CustomArray> findBySpecification(Specification specification) {
    List<CustomArray> result = new ArrayList<>();
    for (CustomArray array : arrays) {
      if (specification.specify(array)) {
        result.add(array);
      }
    }
    logger.debug("Found {} arrays by specification", result.size());
    return result;
  }
}