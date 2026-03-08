package by.pashker.array.reader.impl;

import by.pashker.array.exception.CustomException;
import by.pashker.array.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {
    private static final Logger logger = LogManager.getLogger(CustomFileReaderImpl.class);
    private static final String DEFAULT_PATH = "data/data.txt";

    @Override
    public List<String> readFile(String filePath) throws CustomException {
        String path = filePath.isEmpty() ? DEFAULT_PATH : filePath;
        List<String> list;
        try {
            Path file = Paths.get(path);
            list = Files.readAllLines(file);
            logger.info("The file has been read successfully. {} lines in file", list.size());
        } catch (IOException e) {
            logger.error("Impossible to read file: {}", path);
            throw new CustomException("Failed to read file", e);
        }
        return list;
    }
}