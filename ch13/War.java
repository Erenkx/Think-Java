/**
 * Simulates a simple card game.
 */
public class War {

    public static void main(String[] args) {

        // create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        // divide the deck into piles
        Pile p1 = new Pile();
        p1.addDeck(deck.subdeck(0, 25));
        Pile p2 = new Pile();
        p2.addDeck(deck.subdeck(26, 51));

        // while both piles are not empty
        while (!p1.isEmpty() && !p2.isEmpty()) {
            Card c1 = p1.popCard();
            Card c2 = p2.popCard();
            int rank1 = c1.getRank();
            int rank2 = c2.getRank();
            if (rank1 == 1) {
                rank1 += 13;
            }
            if (rank2 == 1) {
                rank2 += 13;
            }

            // compare the cards
            int diff = rank1 - rank2;
            if (diff > 0) {
                p1.addCard(c1);
                p1.addCard(c2);
            } else if (diff < 0) {
                p2.addCard(c1);
                p2.addCard(c2);
            } else {
                Pile temp = new Pile();
                temp.addCard(c1);
                temp.addCard(c2);

                boolean tie = true;
                while (tie) {
                    if (p1.getCards().size() < 4) {
                        System.out.println("Player 2 wins!");
                        return;
                    }
                    if (p2.getCards().size() < 4) {
                        System.out.println("Player 1 wins!");
                        return;
                    }

                    for (int i = 0; i < 3; i++) {
                        temp.addCard(p1.popCard());
                        temp.addCard(p2.popCard());
                    }

                    Card c3 = p1.popCard();
                    Card c4 = p2.popCard();
                    temp.addCard(c3);
                    temp.addCard(c4);
                    if (c3.getRank() != c4.getRank()) {
                        int rank3 = c3.getRank();
                        int rank4 = c4.getRank();
                        if (rank3 == 1) {
                            rank3 += 13;
                        }
                        if (rank4 == 1) {
                            rank4 += 13;
                        }

                        diff = rank3 - rank4;
                        if (diff > 0) {
                            for (Card card : temp.getCards()) {
                                p1.addCard(card);
                            }
                        } else {
                            for (Card card : temp.getCards()) {
                                p2.addCard(card);
                            }
                        }

                        tie = false;
                    }
                }
            }
        }

        // display the winner
        if (p2.isEmpty()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

}