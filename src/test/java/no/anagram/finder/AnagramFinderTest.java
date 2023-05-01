package no.anagram.finder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AnagramFinderTest {


    @Test
    public void testFindAnagramsEmpty() {
        List<String> words = Arrays.asList();
        Map<String, List<String>> expected = new HashMap<>();
        Map<String, List<String>> result = AnagramFinder.findAnagrams(words);
        assertEquals(expected, result);
    }

    @Test
    public void testNoAnagrams() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        Map<String, List<String>> result = AnagramFinder.findAnagrams(words);
        for (List<String> anagramList : result.values()) {
            if (anagramList.size() > 1) {
               Assert.fail();
            }
        }
        assertEquals(3, result.size());
    }

    @Test
    public void testFindAnagramsMultipleAnagrams() {
        List<String> words = Arrays.asList("cat", "tac", "atc");

        Map<String, List<String>> result = AnagramFinder.findAnagrams(words);
        for (List<String> anagramList : result.values()) {
            if (anagramList.size() < 1) {
                Assert.fail();
            }
        }
    }
}
