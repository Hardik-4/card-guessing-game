package griffith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/** A standard 13-rank deck used by the higher/lower card game. */
public class Deck {
    private final List<Integer> cards = new ArrayList<>();
    private int index;

    public Deck(Random random) {
        for (int rank = 1; rank <= 13; rank++) {
            cards.add(rank);
        }
        Collections.shuffle(cards, random);
        index = 0;
    }

    public int current() {
        return cards.get(index);
    }

    public boolean hasNext() {
        return index + 1 < cards.size();
    }

    public int drawNext() {
        index++;
        return cards.get(index);
    }

    public int remaining() {
        return cards.size() - index - 1;
    }
}
