package by.pashker.array.specification.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.repository.impl.ArrayRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindByIdSpecificationTest {
  private static final CustomArray ARRAY = new CustomArray(new int[]{1, 2, 3});

  @BeforeEach
  void setUp() {
    ArrayRepositoryImpl.getInstance().add(ARRAY);
  }

  @Test
  void testSpecifyValidId() {
    FindByIdSpecification specification = new FindByIdSpecification(ARRAY.getId());
    boolean actual = specification.specify(ARRAY);
    assertTrue(actual);
  }

  @Test
  void testSpecifyInvalidId() {
    FindByIdSpecification specification = new FindByIdSpecification("invalid-id");
    boolean actual = specification.specify(ARRAY);
    assertFalse(actual);
  }
}