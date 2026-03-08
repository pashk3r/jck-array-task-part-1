package by.pashker.array.reader;

import by.pashker.array.exception.CustomException;
import java.util.List;

public interface CustomFileReader {
    List<String> readFile(String filePath) throws CustomException;
}
