package by.pashker.array.specification.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.specification.CompareType;
import by.pashker.array.specification.Specification;
import by.pashker.array.warehouse.ArrayWarehouse;
import by.pashker.array.warehouse.WarehouseData;

public class FindByMaxSpecification implements Specification {
  private final int max;
  private final CompareType compareType;

  public FindByMaxSpecification(int max, CompareType compareType) {
    this.max = max;
    this.compareType = compareType;
  }

  @Override
  public boolean specify(CustomArray array) {
    WarehouseData data = ArrayWarehouse.getInstance().getData(array.getId());
    return switch (compareType) {
      case GREATER -> data.getMax() > max;
      case LESS -> data.getMax() < max;
      case EQUALS -> data.getMax() == max;
    };
  }
}