package by.pashker.array.specification.impl;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.repository.impl.ArrayRepositoryImpl;
import by.pashker.array.specification.CompareType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindBySumSpecificationTest {
  private static final CustomArray ARRAY = new CustomArray(new int[]{1, 2, 3}); // sum = 6

  @BeforeEach
  void setUp() {
    ArrayRepositoryImpl.getInstance().add(ARRAY);
  }

  @Test
  void testSpecifySumGreater() {
    FindBySumSpecification specification = new FindBySumSpecification(5, CompareType.GREATER);
    boolean actual = specification.specify(ARRAY);
    assertTrue(actual);
  }

  @Test
  void testSpecifySumGreaterFalse() {
    FindBySumSpecification specification = new FindBySumSpecification(10, CompareType.GREATER);
    boolean actual = specification.specify(ARRAY);
    assertFalse(actual);
  }

  @Test
  void testSpecifySumLess() {
    FindBySumSpecification specification = new FindBySumSpecification(10, CompareType.LESS);
    boolean actual = specification.specify(ARRAY);
    assertTrue(actual);
  }

  @Test
  void testSpecifySumLessFalse() {
    FindBySumSpecification specification = new FindBySumSpecification(5, CompareType.LESS);
    boolean actual = specification.specify(ARRAY);
    assertFalse(actual);
  }

  @Test
  void testSpecifySumEquals() {
    FindBySumSpecification specification = new FindBySumSpecification(6, CompareType.EQUALS);
    boolean actual = specification.specify(ARRAY);
    assertTrue(actual);
  }

  @Test
  void testSpecifySumEqualsFalse() {
    FindBySumSpecification specification = new FindBySumSpecification(5, CompareType.EQUALS);
    boolean actual = specification.specify(ARRAY);
    assertFalse(actual);
  }
}