package by.pashker.array.observer.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.observer.ArrayObserver;
import by.pashker.array.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarehouseObserver implements ArrayObserver {
  private static final Logger logger = LogManager.getLogger(WarehouseObserver.class);

  @Override
  public void update(CustomArray array) {
    logger.debug("Array {} has been changed. Recalculating warehouse", array.getId());
    ArrayWarehouse.getInstance().recalculate(array);
  }
}