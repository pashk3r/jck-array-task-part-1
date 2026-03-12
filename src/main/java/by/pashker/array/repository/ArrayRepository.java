package by.pashker.array.repository;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
  void add(CustomArray array);
  void remove(CustomArray array);
  CustomArray findById(String id);
  List<CustomArray> findAll();
  List<CustomArray> sort(Comparator<CustomArray> comparator);
  List<CustomArray> findBySpecification(Specification specification);
}