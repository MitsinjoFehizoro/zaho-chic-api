package edu.mitsinjo.zahochic.exception;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String message) {
        super(message);
    }
}
