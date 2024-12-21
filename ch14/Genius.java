/**
 * A smarter player in a game of crazy eights.
 */
public class Genius extends Player {

    /**
     * Constructs a smarter player.
     */
    public Genius(String name) {
        super(name);
    }

    /**
     * Overrides the play method to minimize the penalty points.
     * 
     * The strategy is:
     * - Play an 8 if one is available.
     * - Otherwise, play the card with the highest rank that matches.
     */
    @Override
    public Card play(Eights eights, Card prev) {
        Card bestCard = null;
        int bestIndex = -1;

        // loop through the hand to find the best card
        for (int i = 0; i < getHand().size(); i++) {
            Card card = getHand().getCard(i);

            // check if the card matches the previous card
            if (cardMatches(card, prev)) {
                // prioritize playing an 8
                if (card.getRank() == 8) {
                    return getHand().popCard(i);
                }

                // otherwise, find the highest-rank matching card
                if (bestCard == null || card.getRank() > bestCard.getRank()) {
                    bestCard = card;
                    bestIndex = i;
                }
            }
        }

        // play the best card if found
        if (bestCard != null) {
            return getHand().popCard(bestIndex);
        }

        // if no matching card is found, draw for a match
        return drawForMatch(eights, prev);
    }

}
