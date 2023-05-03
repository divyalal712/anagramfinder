package no.anagram.finder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AnagramFinder {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String filename = "ordbok.txt";
        List<String> words = readWordsFromFile(filename);
        Map<String, List<String>> anagramMap = findAnagrams(words);

        for (List<String> anagramList : anagramMap.values()) {
            if (anagramList.size() > 1) {
                System.out.println(anagramList);
            }
        }
    }

    public static Map<String, List<String>> findAnagrams(List<String> words) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!anagramMap.containsKey(sortedWord)) {
                anagramMap.put(sortedWord, new ArrayList<>());
            }
            anagramMap.get(sortedWord).add(word);
        }
        return anagramMap;
    }

    public static List<String> readWordsFromFile(String filename) throws IOException, URISyntaxException {
        List<String> words = new ArrayList<>();
        ClassLoader classLoader = AnagramFinder.class.getClassLoader();
        Path path = Paths.get(classLoader.getResource(filename).toURI());
        words = Files.readAllLines(path, StandardCharsets.UTF_8);
        return words;
    }
}
