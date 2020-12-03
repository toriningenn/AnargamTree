import java.util.HashMap;

public class LetterFrequencyHistogram {

    public static HashMap<Character, Integer> count(String word) {
        HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        for (int i = 0; i < word.length(); i++) {
            if (!frequencyMap.containsKey(word.charAt(i))) {
                frequencyMap.put(word.charAt(i), 1);
            } else {
                frequencyMap.put(word.charAt(i), frequencyMap.get(word.charAt(i)) + 1);
            }
        }
        return frequencyMap;
    }
}