import java.util.ArrayList;

/**
 * A pile of playing cards (of variable size).
 */
public class Pile {

    private ArrayList<Card> cards;

    /**
     * Constructs an empty pile of cards.
     */
    public Pile() {
        this.cards = new ArrayList<Card>();
    }

    /**
     * Gets the internal cards array.
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * Adds a card to the bottom of the pile.
     */
    public void addCard(Card card) {
        this.cards.add(card);
    }

    /**
     * Removes a card from the top of the pile.
     */
    public Card popCard() {
        return this.cards.remove(0);
    }

    /**
     * Returns true if this pile has no cards.
     */
    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    /**
     * Copies an entire deck into the pile.
     */
    public void addDeck(Deck deck) {
        for (Card card : deck.getCards()) {
            addCard(card);
        }
    }

}
