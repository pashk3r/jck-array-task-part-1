package by.pashker.array.specification.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.repository.impl.ArrayRepositoryImpl;
import by.pashker.array.specification.CompareType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindByMaxSpecificationTest {
  private static final CustomArray ARRAY = new CustomArray(new int[]{1, 2, 10});

  @BeforeEach
  void setUp() {
    ArrayRepositoryImpl.getInstance().add(ARRAY);
  }

  @Test
  void testSpecifyMaxGreater() {
    FindByMaxSpecification specification = new FindByMaxSpecification(5, CompareType.GREATER);
    boolean actual = specification.specify(ARRAY);
    assertTrue(actual);
  }

  @Test
  void testSpecifyMaxGreaterFalse() {
    FindByMaxSpecification specification = new FindByMaxSpecification(15, CompareType.GREATER);
    boolean actual = specification.specify(ARRAY);
    assertFalse(actual);
  }

  @Test
  void testSpecifyMaxLess() {
    FindByMaxSpecification specification = new FindByMaxSpecification(15, CompareType.LESS);
    boolean actual = specification.specify(ARRAY);
    assertTrue(actual);
  }

  @Test
  void testSpecifyMaxLessFalse() {
    FindByMaxSpecification specification = new FindByMaxSpecification(5, CompareType.LESS);
    boolean actual = specification.specify(ARRAY);
    assertFalse(actual);
  }

  @Test
  void testSpecifyMaxEquals() {
    FindByMaxSpecification specification = new FindByMaxSpecification(10, CompareType.EQUALS);
    boolean actual = specification.specify(ARRAY);
    assertTrue(actual);
  }

  @Test
  void testSpecifyMaxEqualsFalse() {
    FindByMaxSpecification specification = new FindByMaxSpecification(5, CompareType.EQUALS);
    boolean actual = specification.specify(ARRAY);
    assertFalse(actual);
  }
}