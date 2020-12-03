import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Anatree tree = new Anatree();
        tree.addWords();
        Scanner input = new Scanner(System.in);
        System.out.print("Введи слово: ");
        String userWord = input.next().toLowerCase();
        tree.findAnagrams(userWord);
    }
}
