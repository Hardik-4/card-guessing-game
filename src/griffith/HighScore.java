package griffith;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** Persists the best score between sessions. */
public class HighScore {
    private static final String FILE = "highscore.txt";

    public static int load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            return Integer.parseInt(reader.readLine().trim());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void saveIfBest(int score) {
        if (score > load()) {
            try (FileWriter writer = new FileWriter(FILE)) {
                writer.write(Integer.toString(score));
            } catch (IOException e) {
                System.out.println("Could not save high score.");
            }
        }
    }
}
