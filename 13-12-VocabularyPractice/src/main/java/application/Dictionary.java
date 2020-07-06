package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Dictionary {
    enum AddWordResponse {
        NEW_ENTRY, UPDATED, FAILED
    }
    private final List<String> words = new ArrayList<>();
    private final Map<String, String> dict = new HashMap<>();
    private final Random rand = new Random();

    public String getRandomWord() {
        if (words.size() == 0) {
            return "error";
        }
        return words.get(rand.nextInt(words.size()));
    }

    public String translate(String word) {
        String result = dict.get(word);
        return result == null ? "error" : result;
    }

    public AddWordResponse addPair(String word, String translation) {
        if (word.isEmpty() || translation.isEmpty()) {
            return AddWordResponse.FAILED;
        }
        AddWordResponse response = dict.containsKey(word)
                ? AddWordResponse.UPDATED : AddWordResponse.NEW_ENTRY;
        if (response == AddWordResponse.NEW_ENTRY) {
            words.add(word);
        }
        dict.put(word, translation);
        return response;
    }
}
