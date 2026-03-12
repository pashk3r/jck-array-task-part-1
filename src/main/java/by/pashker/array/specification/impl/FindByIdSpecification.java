package by.pashker.array.specification.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.specification.Specification;

public class FindByIdSpecification implements Specification {
  private final String id;

  public FindByIdSpecification(String id) {
    this.id = id;
  }

  @Override
  public boolean specify(CustomArray array) {
    return array.getId().equals(id);
  }
}