package com.bridgelabz.moodanalyser;

import com.bridgelabz.moodanalyser.exceptions.MoodAnalysisException;

public class MoodAnalyser
{
    String message;

    public MoodAnalyser(String message)
    {
        this.message=message;
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

}
