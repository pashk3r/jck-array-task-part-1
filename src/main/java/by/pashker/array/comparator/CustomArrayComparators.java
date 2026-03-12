package by.pashker.array.comparator;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.warehouse.ArrayWarehouse;
import by.pashker.array.warehouse.WarehouseData;

import java.util.Comparator;

public class CustomArrayComparators {
  private CustomArrayComparators() {
  }

  public static Comparator<CustomArray> byId() {
    return Comparator.comparing(CustomArray::getId);
  }

  public static Comparator<CustomArray> bySize() {
    return Comparator.comparingInt(CustomArray::size);
  }

  public static Comparator<CustomArray> byFirstElement() {
    return (a, b) -> {
      try {
        return Integer.compare(a.getElement(0), b.getElement(0));
      } catch (Exception e) {
        return 0;
      }
    };
  }

  public static Comparator<CustomArray> bySum() {
    return (a, b) -> {
      WarehouseData dataA = ArrayWarehouse.getInstance().getData(a.getId());
      WarehouseData dataB = ArrayWarehouse.getInstance().getData(b.getId());
      return Integer.compare(dataA.getSum(), dataB.getSum());
    };
  }

  public static Comparator<CustomArray> byMin() {
    return (a, b) -> {
      WarehouseData dataA = ArrayWarehouse.getInstance().getData(a.getId());
      WarehouseData dataB = ArrayWarehouse.getInstance().getData(b.getId());
      return Integer.compare(dataA.getMin(), dataB.getMin());
    };
  }

  public static Comparator<CustomArray> byMax() {
    return (a, b) -> {
      WarehouseData dataA = ArrayWarehouse.getInstance().getData(a.getId());
      WarehouseData dataB = ArrayWarehouse.getInstance().getData(b.getId());
      return Integer.compare(dataA.getMax(), dataB.getMax());
    };
  }

  public static Comparator<CustomArray> byAvg() {
    return (a, b) -> {
      WarehouseData dataA = ArrayWarehouse.getInstance().getData(a.getId());
      WarehouseData dataB = ArrayWarehouse.getInstance().getData(b.getId());
      return Double.compare(dataA.getAvg(), dataB.getAvg());
    };
  }
}