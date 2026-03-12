package by.pashker.array.parser.impl;

import by.pashker.array.exception.CustomException;
import by.pashker.array.parser.CustomParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomParserImpl implements CustomParser {
  private static final Logger logger = LogManager.getLogger();
  private static final String PATTERN = "\\s*;\\s*";

  @Override
  public int[] parseString(String line) throws CustomException {
    if (line == null || line.isEmpty()) {
      logger.error("Line is null or empty");
      throw new CustomException("Line is null or empty");
    }
    String[] parts = line.strip().split(PATTERN);
    int[] array = new int[parts.length];
    for (int i = 0; i < parts.length; i++) {
      try {
        array[i] = Integer.parseInt(parts[i]);
      } catch (NumberFormatException e) {
        logger.error("Failed to parse element: {}", parts[i]);
        throw new CustomException("Failed to parse element: " + parts[i]);
      }
    }
    logger.debug("Line parsed into array of {} elements", array.length);
    return array;
  }
}
