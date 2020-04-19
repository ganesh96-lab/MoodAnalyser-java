package com.bridgelabz.moodanalyser;
import com.bridgelabz.moodanalyser.exceptions.MoodAnalysisException;
import factory.com.bridgelabz.moodanalyser.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserTest
{
    @Test
    public void givenSadMessage_shouldReturnSadMood() throws MoodAnalysisException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad");
        Class<?> cls = moodAnalyser.getClass();
        Method methodObject = cls.getDeclaredMethod("analyseMood");
        String mood = (String) methodObject.invoke(moodAnalyser);
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenHappyMessage_shouldReturnHappyMood() throws MoodAnalysisException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MoodAnalyser moodAnalyser=new MoodAnalyser("i am in happy mood");
        Class<?> cls = moodAnalyser.getClass();
        Method methodObject = cls.getDeclaredMethod("analyseMood");
        String mood = (String) methodObject.invoke(moodAnalyser);
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenNullMessage_whenNull_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser=new MoodAnalyser(null);
            String mood=moodAnalyser.analyseMood();
        }catch (MoodAnalysisException moodAnalysisException)
        {
            Assert.assertEquals("Invalid message", moodAnalysisException.getMessage());
        }
    }

    @Test
    public void givenMessage_whenEmpty_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            String mood = moodAnalyser.analyseMood();
        }catch (MoodAnalysisException moodAnalysisException) {
            Assert.assertEquals("Empty Mood", moodAnalysisException.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyser_whenProper_shouldReturnObject() {
            MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.getMoodAnalyserObject();
            MoodAnalyser moodAnalyser = new MoodAnalyser();
            Assert.assertTrue(moodAnalyser.equals(moodAnalyserObject));
    }

    @Test
    public void givenMoodAnalyser_whenImProper_shouldThrowMoodAnalysisException() {
        MoodAnalyser moodAnalyserObject = null;
        try{
            moodAnalyserObject = MoodAnalyserFactory.getMoodAnalyserObject("com.bridgelabz.MoodAnalyser");
            MoodAnalyser moodAnalyser = new MoodAnalyser();
        } catch (MoodAnalysisException moodAnalysisException){
            Assert.assertEquals("Invalid class name", moodAnalysisException.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyser_whenInvalidConstructor_shouldThrowNoSuchMethodException() {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser").getConstructor(
                    String.class, Integer.class);
            Object reflectionObject = constructor.newInstance("I am in sad mood", 2);
            MoodAnalyser moodAnalyser = (MoodAnalyser) reflectionObject;
            MoodAnalyser realMoodObject = new MoodAnalyser("I am in sad mood");
        } catch (NoSuchMethodException e) {
            try {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND,
                        "Invalid constructor");
            }catch (MoodAnalysisException moodAnalysisException) {
                Assert.assertEquals("Invalid constructor", moodAnalysisException.getMessage());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_whenImproperMethod_shouldThrowMoodAnalyserException() throws InvocationTargetException, IllegalAccessException {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("i am in happy");
            Class<?> cls = moodAnalyser.getClass();
            Method methodObject = cls.getDeclaredMethod("analyseMoo");
            String mood = (String) methodObject.invoke(moodAnalyser);
            Assert.assertEquals("SAD", mood);
        }catch (NoSuchMethodException e){
            try {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"NO_SUCH_METHOD");
            } catch (MoodAnalysisException ex) {
                Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,ex.type);
            }

        }
    }
}