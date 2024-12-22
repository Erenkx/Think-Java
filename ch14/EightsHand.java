/**
 * A hand of cards in a game of crazy eights.
 */
public class EightsHand extends Hand {

    /**
     * Constructs a hand for the player.
     */
    public EightsHand(String name) {
        super(name);
    }

    /**
     * Returns the score of the hand.
     */
    public int scoreHand() {
        int sum = 0;
        for (int i = 0; i < size(); i++) {
            EightsCard card = (EightsCard) getCard(i);
            sum += card.scoreCard();
        }

        return sum;
    }

}
