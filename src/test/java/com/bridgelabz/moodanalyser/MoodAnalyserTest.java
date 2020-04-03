package com.bridgelabz.moodanalyser;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest
{
    @Test
    public void givenSadMessage_shouldReturnSadMood()
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenHappyMessage_shouldReturnHappyMood()
    {
        MoodAnalyser moodAnalyser=new MoodAnalyser("i am in happy mood");
        String mood=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }

}