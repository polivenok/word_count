package com.lohika.words;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Please specify  path to the file and integer number which indicates the amount of words to output as command arguments. E.g.:");
            System.out.println("java wordCount lyrics.txt 5");
            System.exit(0);
        }
        List<String> words = WordCounter.readWordsFromFile(args[0]);
        Map<String, Long> countedWords = WordCounter.countWords(words);
        Map<String, Long> nWordsCount = WordCounter.getNWordsCount(countedWords, Integer.parseInt(args[1]));
        for (Map.Entry<String, Long> entry : nWordsCount.entrySet()) {
            System.out.printf("%s=%d" + System.getProperty("line.separator"), entry.getKey(), entry.getValue());
        }
    }

}
