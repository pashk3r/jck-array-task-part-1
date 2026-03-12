package by.pashker.array;

import by.pashker.array.comparator.CustomArrayComparators;
import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;
import by.pashker.array.factory.impl.CustomArrayFactoryImpl;
import by.pashker.array.parser.impl.CustomParserImpl;
import by.pashker.array.reader.impl.CustomFileReaderImpl;
import by.pashker.array.repository.impl.ArrayRepositoryImpl;
import by.pashker.array.specification.CompareType;
import by.pashker.array.specification.impl.FindByMaxSpecification;
import by.pashker.array.specification.impl.FindBySumSpecification;
import by.pashker.array.warehouse.ArrayWarehouse;
import by.pashker.array.warehouse.WarehouseData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
  private static final Logger logger = LogManager.getLogger(Main.class);
  private static final String FILE_PATH = "data/data.txt";

  public static void main(String[] args) throws CustomException {
    CustomFileReaderImpl reader = new CustomFileReaderImpl();
    CustomParserImpl parser = new CustomParserImpl();
    CustomArrayFactoryImpl factory = new CustomArrayFactoryImpl();
    ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();

    logger.info("Reading file: {}", FILE_PATH);
    List<String> lines = reader.readFile(FILE_PATH);
    for (String line : lines) {
      try {
        int[] arr = parser.parseString(line);
        CustomArray array = factory.createCustomArray(arr);
        repository.add(array);
      } catch (CustomException e) {
        logger.warn("Invalid line, skipping: {}", line);
      }
    }
    logger.info("Repository contains {} arrays", repository.findAll().size());

    logger.info("------------------------------");
    logger.info("ALL ARRAYS:");
    for (CustomArray array : repository.findAll()) {
      WarehouseData data = ArrayWarehouse.getInstance().getData(array.getId());
      logger.info("Array: {}", array);
      logger.info("Warehouse: {}", data);
    }

    logger.info("------------------------------");
    logger.info("SORT BY SIZE:");
    for (CustomArray array : repository.sort(CustomArrayComparators.bySize())) {
      logger.info("{}", array);
    }

    logger.info("------------------------------");
    logger.info("SORT BY SUM:");
    for (CustomArray array : repository.sort(CustomArrayComparators.bySum())) {
      logger.info("{}", array);
    }

    logger.info("------------------------------");
    logger.info("SORT BY FIRST ELEMENT:");
    for (CustomArray array : repository.sort(CustomArrayComparators.byFirstElement())) {
      logger.info("{}", array);
    }

    logger.info("------------------------------");
    logger.info("ARRAYS WHERE SUM > 10:");
    for (CustomArray array : repository.findBySpecification(
            new FindBySumSpecification(10, CompareType.GREATER))) {
      logger.info("{}", array);
    }

    logger.info("------------------------------");
    logger.info("ARRAYS WHERE MAX > 10:");
    for (CustomArray array : repository.findBySpecification(
            new FindByMaxSpecification(10, CompareType.GREATER))) {
      logger.info("{}", array);
    }

    logger.info("------------------------------");
    logger.info("OBSERVER DEMO:");
    CustomArray first = repository.findAll().getFirst();
    logger.info("Before change: {}", ArrayWarehouse.getInstance().getData(first.getId()));
    first.setElement(0, 999);
    logger.info("After change: {}", ArrayWarehouse.getInstance().getData(first.getId()));
  }
}