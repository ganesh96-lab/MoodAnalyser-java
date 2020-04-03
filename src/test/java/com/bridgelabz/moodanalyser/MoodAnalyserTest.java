package com.bridgelabz.moodanalyser;
import com.bridgelabz.moodanalyser.exceptions.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest
{
    @Test
    public void givenSadMessage_shouldReturnSadMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenHappyMessage_shouldReturnHappyMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser=new MoodAnalyser("i am in happy mood");
        String mood=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenNullMessage_whenNull_shouldThrowMoodAnalysisException()
    {
        try
        {
            MoodAnalyser moodAnalyser=new MoodAnalyser(null);
            String mood=moodAnalyser.analyseMood();
        }catch (MoodAnalysisException moodAnalysisException)
        {
            Assert.assertEquals("Invalid message", moodAnalysisException.getMessage());
        }

    }
}