import java.util.ArrayList;

public class AlphabetMap {

    public static ArrayList<Character> createAlphabet() {
        ArrayList<Character> alphabet = new ArrayList<Character>() {
            {
                add('ё');
                for (char ch = 'а'; ch <= 'я'; ++ch)
                    add(ch);
            }
        };
        return alphabet;
    }
}
