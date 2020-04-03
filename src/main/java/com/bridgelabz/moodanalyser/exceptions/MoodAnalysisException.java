package com.bridgelabz.moodanalyser.exceptions;

public class MoodAnalysisException extends Exception
{
    public enum ExceptionType
    {
        NULL,EMPTY
    };
    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type,String message)
    {
        super(message);
        this.type = type;
    }
}
