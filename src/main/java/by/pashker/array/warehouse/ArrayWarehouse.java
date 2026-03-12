package by.pashker.array.warehouse;

import by.pashker.array.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouse {
  private static final Logger logger = LogManager.getLogger(ArrayWarehouse.class);
  private static ArrayWarehouse instance;
  private final Map<String, WarehouseData> data = new HashMap<>();

  private ArrayWarehouse() {
  }

  public static ArrayWarehouse getInstance() {
    if (instance == null) {
      instance = new ArrayWarehouse();
    }
    return instance;
  }

  public void recalculate(CustomArray array) {
    int[] arr = array.getArray();
    int min = arr[0];
    int max = arr[0];
    int sum = 0;
    for (int element : arr) {
      if (element < min) {
        min = element;
      }
      if (element > max) {
        max = element;
      }
      sum += element;
    }
    double avg = (double) sum / arr.length;
    WarehouseData warehouseData = new WarehouseData(min, max, sum, avg);
    data.put(array.getId(), warehouseData);
    logger.debug("Recalculated for array {}: {}", array.getId(), warehouseData);
  }

  public WarehouseData getData(String id) {
    return data.get(id);
  }

  public void remove(String id) {
    data.remove(id);
    logger.debug("Removed warehouse data for array {}", id);
  }
}