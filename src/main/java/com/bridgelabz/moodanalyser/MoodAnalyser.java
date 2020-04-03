package com.bridgelabz.moodanalyser;

import com.bridgelabz.moodanalyser.exceptions.MoodAnalysisException;

import java.util.Objects;

public class MoodAnalyser
{
    String message;

    public MoodAnalyser(String message)
    {
        this.message=message;
    }

    public MoodAnalyser()
    {

    }

    public String analyseMood()throws MoodAnalysisException
    {
        try
        {
            if (this.message.length() < 1)
            {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EMPTY,"Empty Mood");
            }
            if (this.message.contains("sad"))
                return "SAD";
            return "HAPPY";
        }catch (NullPointerException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL,"Invalid message");
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message);
    }

}
