/**
 * A card in a game of crazy eights.
 */
public class EightsCard extends Card {
    
    /**
     * Constructs a card for the game.
     */
    public EightsCard(int rank, int suit) {
        super(rank, suit);
    }

    /**
     * Checks whether this card matches another card according to 
     * the rules of Crazy Eights.
     */    
    public boolean match(Card card) {
        return getSuit() == card.getSuit()
            || getRank() == card.getRank()
            || getRank() == 8;
    }

    /**
     * Returns the card's score value.
     */
    public int scoreCard() {
        int rank = getRank();
        if (rank == 8) {
            return -20;
        } else if (rank > 10) {
            return -10;
        } else {
            return -rank;
        }
    }

}
