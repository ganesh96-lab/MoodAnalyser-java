package com.bridgelabz.moodanalyser;

import jdk.internal.vm.compiler.collections.EconomicMap;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {
    @Test
    public void givenSadMessage_shouldReturnSadMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("i am in sad");
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenHappyMessage_shouldReturnHappyMood()
    {
        MoodAnalyser moodAnalyser=new MoodAnalyser();
        String mood=moodAnalyser.analyseMood("i am in any mood");
        Assert.assertEquals("HAPPY", mood);
    }

}