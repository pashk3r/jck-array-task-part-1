package by.pashker.array;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;
import by.pashker.array.factory.impl.CustomArrayFactoryImpl;
import by.pashker.array.parser.impl.CustomParserImpl;
import by.pashker.array.reader.impl.CustomFileReaderImpl;
import by.pashker.array.service.impl.ArrayOperationImpl;
import by.pashker.array.service.impl.ArraySortImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String FILE_PATH = "data/dat.txt";

    public static void main(String[] args) throws CustomException {
        CustomFileReaderImpl reader = new CustomFileReaderImpl();
        CustomParserImpl parser = new CustomParserImpl();
        CustomArrayFactoryImpl factory = new CustomArrayFactoryImpl();
        ArrayOperationImpl operation = new ArrayOperationImpl();
        ArraySortImpl sort = new ArraySortImpl();

        List<String> lines = reader.readFile(FILE_PATH);

        List<CustomArray> arrays = new ArrayList<>();
        for (String line : lines) {
            try {
                int[] arr = parser.parseString(line);
                arrays.add(factory.createCustomArray(arr));
            } catch (CustomException e) {
                logger.warn("Invalid line - {}", line);
            }
        }

        logger.info("Created {} arrays from file", arrays.size());
        for (CustomArray array : arrays) {
            logger.info("-------------------------------------------------------");
            logger.info("Array: {}", array);
            logger.info("Min: {}", operation.min(array));
            logger.info("Max: {}", operation.max(array));
            logger.info("Sum: {}", operation.sum(array));
            logger.info("Bubble sort: {}", sort.bubbleSort(array));
            logger.info("Selection sort: {}", sort.selectionSort(array));
        }
    }
}