package griffith;

/** Helpers for displaying card ranks. */
public final class Card {
    private Card() {}

    public static String name(int rank) {
        switch (rank) {
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return Integer.toString(rank);
        }
    }
}
