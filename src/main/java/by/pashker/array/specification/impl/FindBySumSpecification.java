package by.pashker.array.specification.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.specification.CompareType;
import by.pashker.array.specification.Specification;
import by.pashker.array.warehouse.ArrayWarehouse;
import by.pashker.array.warehouse.WarehouseData;

public class FindBySumSpecification implements Specification {
  private final int sum;
  private final CompareType compareType;

  public FindBySumSpecification(int sum, CompareType compareType) {
    this.sum = sum;
    this.compareType = compareType;
  }

  @Override
  public boolean specify(CustomArray array) {
    WarehouseData data = ArrayWarehouse.getInstance().getData(array.getId());
    return switch (compareType) {
      case GREATER -> data.getSum() > sum;
      case LESS -> data.getSum() < sum;
      case EQUALS -> data.getSum() == sum;
    };
  }
}