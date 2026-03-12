package by.pashker.array.parser.impl;

import by.pashker.array.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomParserImplTest {
  private static final CustomParserImpl parser = new CustomParserImpl();

  @Test
  void testParseValidLine() throws CustomException {
    int[] expected = {1, 2, 3};
    int[] actual = parser.parseString("1; 2; 3");
    assertArrayEquals(expected, actual);
  }

  @Test
  void testParseValidLineNoSpaces() throws CustomException {
    int[] expected = {1, 2, 3};
    int[] actual = parser.parseString("1;2;3");
    assertArrayEquals(expected, actual);
  }

  @Test
  void testParseNegativeNumbers() throws CustomException {
    int[] expected = {-1, -2, 3};
    int[] actual = parser.parseString("-1; -2; 3");
    assertArrayEquals(expected, actual);
  }

  @Test
  void testParseSingleElement() throws CustomException {
    int[] expected = {42};
    int[] actual = parser.parseString("42");
    assertArrayEquals(expected, actual);
  }

  @Test
  void testParseInvalidElement() {
    assertThrows(CustomException.class, () -> parser.parseString("1; 2; x3"));
  }

  @Test
  void testParseNullLine() {
    assertThrows(CustomException.class, () -> parser.parseString(null));
  }

  @Test
  void testParseEmptyLine() {
    assertThrows(CustomException.class, () -> parser.parseString(""));
  }
}