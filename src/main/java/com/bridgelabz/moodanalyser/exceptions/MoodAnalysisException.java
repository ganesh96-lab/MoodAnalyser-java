package com.bridgelabz.moodanalyser.exceptions;

public class MoodAnalysisException extends Exception {
    public enum ExceptionType {
        NULL,
        CLASS_NOT_FOUND,
        EMPTY,
        NO_SUCH_METHOD,
         NO_SUCH_FIELD;
    };
    public ExceptionType type;
    public MoodAnalysisException(ExceptionType type,String message) {
        super(message);
        this.type = type;
    }
}
