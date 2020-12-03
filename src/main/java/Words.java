import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Words {
    private static final String myPath = "russian.txt";

    static List<String> getList() {
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(Paths.get(myPath));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

