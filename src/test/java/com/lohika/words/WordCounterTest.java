package com.lohika.words;

import com.lohika.words.WordCounter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WordCounterTest {

    private static List<String> WORDS = Arrays.asList("pairs","indicates", "word", "java", "java", "indicates", "java", "java", "word", "java");

    @Test
    public void wordCountingTest() {
        Map<String, Long> wordsCount = WordCounter.countWords(WORDS);
        Assert.assertEquals(4, wordsCount.size());
        Assert.assertEquals(Long.valueOf(5L), wordsCount.get("java"));
        Assert.assertEquals(Long.valueOf(2L), wordsCount.get("indicates"));
        Assert.assertEquals(Long.valueOf(2L), wordsCount.get("word"));
        Assert.assertEquals(Long.valueOf(1L), wordsCount.get("pairs"));
    }

    @Test
    public void wordCountingTestWithSortingAndLimit(){
        Map<String, Long> wordsCount = WordCounter.countWords(WORDS);
        Map<String, Long> sortedWordsCount = WordCounter.getNWordsCount(wordsCount, 3);
        Assert.assertEquals(3, sortedWordsCount.size());
        Assert.assertArrayEquals(new String[] {"java", "indicates", "word"}, sortedWordsCount.keySet().toArray());


    }

    @Test
    public void wordCountingTestWithSortingAndLargeLimit(){
        Map<String, Long> wordsCount = WordCounter.countWords(WORDS);
        Map<String, Long> sortedWordsCount = WordCounter.getNWordsCount(wordsCount, 10);
        Assert.assertEquals(4, sortedWordsCount.size());

    }
}
