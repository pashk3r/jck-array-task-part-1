package by.pashker.array.repository.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.specification.impl.FindByIdSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRepositoryImplTest {
  private ArrayRepositoryImpl repository;
  private static final CustomArray ARRAY_1 = new CustomArray(new int[]{1, 2, 3});
  private static final CustomArray ARRAY_2 = new CustomArray(new int[]{10, 20, 30});
  private static final CustomArray ARRAY_3 = new CustomArray(new int[]{5, 5, 5});

  @BeforeEach
  void setUp() {
    repository = ArrayRepositoryImpl.getInstance();
    repository.findAll().forEach(repository::remove);
    repository.add(ARRAY_1);
    repository.add(ARRAY_2);
    repository.add(ARRAY_3);
  }

  @Test
  void testFindAll() {
    int expected = 3;
    int actual = repository.findAll().size();
    assertEquals(expected, actual);
  }

  @Test
  void testAdd() {
    CustomArray array = new CustomArray(new int[]{7, 8, 9});
    int expectedSize = 4;
    repository.add(array);
    assertEquals(expectedSize, repository.findAll().size());
  }

  @Test
  void testRemove() {
    int expectedSize = 2;
    repository.remove(ARRAY_1);
    assertEquals(expectedSize, repository.findAll().size());
  }

  @Test
  void testFindById() {
    String id = ARRAY_1.getId();
    List<CustomArray> result = repository.findBySpecification(
            new FindByIdSpecification(id)
    );
    assertEquals(1, result.size());
    assertEquals(ARRAY_1, result.get(0));
  }

  @Test
  void testFindByIdNotFound() {
    List<CustomArray> result = repository.findBySpecification(
            new FindByIdSpecification("non-existent-id")
    );
    assertTrue(result.isEmpty());
  }
}