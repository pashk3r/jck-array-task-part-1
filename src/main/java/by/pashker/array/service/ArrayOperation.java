package by.pashker.array.service;

import by.pashker.array.entity.CustomArray;
import by.pashker.array.exception.CustomException;

public interface ArrayOperation {
    int min(CustomArray array) throws CustomException;
    int max(CustomArray array) throws CustomException;
    int sum(CustomArray array) throws CustomException;
}
