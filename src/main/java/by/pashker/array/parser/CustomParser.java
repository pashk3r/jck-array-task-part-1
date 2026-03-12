package by.pashker.array.parser;

import by.pashker.array.exception.CustomException;

public interface CustomParser {
  int[] parseString(String line) throws CustomException;
}
