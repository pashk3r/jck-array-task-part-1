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
    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_PATH = "data/data.txt";

    @Override
    public List<String> readFile(String filePath) throws CustomException {
        if (filePath == null || filePath.isEmpty()) {
            logger.error("File path is null or empty");
            throw new CustomException("File path is null or empty");
        }
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            logger.warn("File not found: {}. Using default path: {}", filePath, DEFAULT_PATH);
            filePath = DEFAULT_PATH;
            path = Paths.get(filePath);
        }
        try {
            List<String> lines = Files.readAllLines(path);
            logger.info("File has been read. {} lines found", lines.size());
            return lines;
        } catch (IOException e) {
            logger.error("Failed to read file: {}", filePath);
            throw new CustomException("Failed to read file: " + filePath);
        }
    }
}