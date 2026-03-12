package by.pashker.array.warehouse;

public class WarehouseData {
  private final int min;
  private final int max;
  private final int sum;
  private final double avg;

  public WarehouseData(int min, int max, int sum, double avg) {
    this.min = min;
    this.max = max;
    this.sum = sum;
    this.avg = avg;
  }

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }

  public int getSum() {
    return sum;
  }

  public double getAvg() {
    return avg;
  }

  @Override
  public String toString() {
    return "WarehouseData {min = " + min + ", max = " + max +
            ", sum = " + sum + ", avg = " + avg + "}";
  }
}