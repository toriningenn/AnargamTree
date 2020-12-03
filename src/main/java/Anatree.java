import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Anatree {
    Node root = new Node(null);
    ArrayList<Character> alphabet = AlphabetMap.createAlphabet();

    public void addWords() {
        List<String> words = Words.getList();
        for (String word : words) {
            word = word.toLowerCase();
            Node currentNode = root;
            for (Character ch : alphabet) {
                currentNode.data = ch;
                int f;
                if (LetterFrequencyHistogram.count(word).get(ch) != null) {
                    f = LetterFrequencyHistogram.count(word).get(ch);
                } else {
                    f = 0;
                }
                if (currentNode.children.containsKey(f)) {
                    currentNode = currentNode.children.get(f);
                } else {
                    Node childNode = new Node(ch);
                    currentNode.children.put(f, childNode);
                    currentNode = childNode;
                }
            }
            currentNode.wordsMap.add(word);
        }
    }


    public void findAnagrams(String userWord) {
        ArrayList<Node> frontierSet = new ArrayList<Node>();
        HashSet<String> anagrams = new HashSet<String>();
        frontierSet.add(root);
        for (Character ch : alphabet) {
            int f;
            if (LetterFrequencyHistogram.count(userWord).get(ch) != null) {
                f = LetterFrequencyHistogram.count(userWord).get(ch);
            } else {
                f = 0;
            }
            ArrayList<Node> newFrontierSet = new ArrayList<Node>();

            for (Node node : frontierSet) {
                for (int i = 0; i <= f; i++) {
                    if (node.children.containsKey(i)) {
                        newFrontierSet.add(node.children.get(i));
                    }
                }
            }
            frontierSet = newFrontierSet;
        }
        for (Node node : frontierSet) {
            for (String s : node.wordsMap) {
                anagrams.add(s);
            }
        }
        for (String s : anagrams) {
            if (!s.equals(userWord))
                System.out.println(s);
        }
    }

    public class Node {
        Character data;
        HashMap<Integer, Node> children;
        ArrayList<String> wordsMap;


        public Node(Character data) {
            this.data = data;
            this.wordsMap = new ArrayList<String>();
            this.children = new HashMap<Integer, Node>();
        }
    }
}
