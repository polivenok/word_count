package com.lohika.words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility methods for words counting
 */
public class WordCounter {

    /**
     * Count words
     *
     * @param words list of words
     * @return map with words and their count
     */
    public static Map<String, Long> countWords(List<String> words) {
        if (words == null) {
            throw new IllegalArgumentException("Words shouldn't be null!");
        }
        return words.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
    }

    /**
     * Method returns exactly N pairs if the amount of unique words is greater or equal to N; all pairs otherwise.
     * if there are more than one word with the same frequency, the words will be ordered alphabetically within corresponding.
     *
     * @param wordsCount map with words and their count
     * @param n
     * @return map with words and their count
     */
    public static LinkedHashMap<String, Long> getNWordsCount(Map<String, Long> wordsCount, Integer n) {
        if (wordsCount == null) {
            throw new IllegalArgumentException("words count shouldn't be null!");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("N should be positive integer!");
        }
        LinkedHashMap<String, Long> sortedWordsCount = new LinkedHashMap<>();
        wordsCount.entrySet().stream()
                .sorted(Entry.<String, Long>comparingByValue().reversed().thenComparing(Entry.comparingByKey()))
                .forEachOrdered(e -> sortedWordsCount.put(e.getKey(), e.getValue()));
        if (sortedWordsCount.size() >= n) {
            LinkedHashMap<String, Long> limitedSortedWordsCount = new LinkedHashMap<>(n);
            Iterator<Entry<String, Long>> iterator = sortedWordsCount.entrySet().iterator();
            for (int i = 0; i < n; i++) {
                Entry<String, Long> entry = iterator.next();
                limitedSortedWordsCount.put(entry.getKey(), entry.getValue());

            }
            return limitedSortedWordsCount;
        } else {
            return sortedWordsCount;
        }

    }

    /**
     * Reads words from file
     *
     * @param filePath path to file
     * @return words
     * @throws IOException in case of IO errors
     */
    public static List<String> readWordsFromFile(String filePath) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            return stream
                    .filter(s -> !s.trim().isEmpty())
                    .flatMap(s -> Arrays.stream(s.split("\\W+")))
                    .collect(Collectors.toList());
        }
    }

}
