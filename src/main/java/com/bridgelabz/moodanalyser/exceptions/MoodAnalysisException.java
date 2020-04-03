package com.bridgelabz.moodanalyser.exceptions;

public class MoodAnalysisException extends Exception {
    public enum ExceptionType {
        NULL, CLASS_NOT_FOUND, EMPTY
    };
    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type,String message) {
        super(message);
        this.type = type;
    }
}
