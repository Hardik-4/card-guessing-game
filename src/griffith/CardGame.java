package griffith;

import java.util.Random;
import java.util.Scanner;

/**
 * Higher / lower card guessing game.
 * Guess whether the next card is higher or lower; wrong guess ends the round.
 */
public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printWelcome();

        boolean playAgain = true;
        while (playAgain) {
            int score = playRound(scanner);
            HighScore.saveIfBest(score);
            System.out.println("High score: " + HighScore.load());
            System.out.print("Play again? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            playAgain = answer.equals("y") || answer.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void printWelcome() {
        System.out.println("======================================");
        System.out.println("     Higher / Lower Card Game");
        System.out.println("======================================");
        System.out.println("Guess if the next card is higher (h) or lower (l).");
        System.out.println("Wrong guess ends the round. Type 'q' to quit early.");
        System.out.println();
    }

    private static int playRound(Scanner scanner) {
        Deck deck = new Deck(new Random());
        int score = 0;

        while (true) {
            int current = deck.current();
            System.out.println("Current card: " + Card.name(current)
                    + "  (cards left: " + deck.remaining() + ")");
            System.out.print("Higher (h), lower (l), or quit (q): ");
            String guess = scanner.nextLine().trim().toLowerCase();

            if (guess.equals("q")) {
                System.out.println("You quit with score: " + score);
                return score;
            }
            if (!guess.equals("h") && !guess.equals("l")) {
                System.out.println("Please enter h, l, or q.");
                continue;
            }
            if (!deck.hasNext()) {
                System.out.println("No more cards left. Final score: " + score);
                return score;
            }

            int next = deck.drawNext();
            System.out.println("Next card: " + Card.name(next));

            boolean correct = (guess.equals("h") && next > current)
                    || (guess.equals("l") && next < current);
            if (next == current) {
                System.out.println("Tie on rank — free pass, no point.");
                continue;
            }
            if (correct) {
                score++;
                System.out.println("Correct! Score: " + score);
            } else {
                System.out.println("Wrong guess. Final score: " + score);
                return score;
            }
        }
    }
}
