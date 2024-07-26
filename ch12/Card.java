/**
 * A standard playing card.
 */
public class Card {

    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"
    };

    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"
    };

    private final int rank;

    private final int suit;

    /**
     * Constructs a card of the given rank and suit.
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns a string representation of the card.
     */
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }

    /**
     * Returns true if the given card has the same
     * rank AND same suit; otherwise returns false.
     */
    public boolean equals(Card that) {
        return this.rank == that.rank
            && this.suit == that.suit;
    }

    /**
     * Returns a negative integer if this card comes before
     * the given card, zero if the two cards are equal, or
     * a positive integer if this card comes after the card.
     */
    public int compareTo(Card that) {
        int leftSuit = this.suit;
        int leftRank = this.rank;
        int rightSuit = that.suit;
        int rightRank = that.rank;

        if (leftSuit < rightSuit) {
            return -1;
        }
        if (leftSuit > rightSuit) {
            return 1;
        }

        // Aces are ranked higher than Kings
        if (leftRank == 1) {
            leftRank += 13;
        }
        if (rightRank == 1) {
            rightRank += 13;
        }

        if (leftRank < rightRank) {
            return -1;
        }
        if (leftRank > rightRank) {
            return 1;
        }

        return 0;
    }

    /**
     * Gets the card's rank.
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * Gets the card's suit.
     */
    public int getSuit() {
        return this.suit;
    }

    /**
     * Returns a fully populated array of cards.
     */
    public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }

        return cards;
    }

    /**
     * Returns the index of a card in an array of cards using sequential
     * search; otherwise return -1.
     */
    public static int sequentialSearch(Card[] cards, Card target) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns the index of a card in an array of cards using binary
     * search; otherwise return -1.
     */
    public static int binarySearch(Card[] cards, Card target) {
        int low = 0;
        int high = cards.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comp = cards[mid].compareTo(target);

            if (comp == 0) {
                return mid;
            } else if (comp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Card[] cards = makeDeck();
        Card card = new Card(11, 0);
        System.out.println(card);
        System.out.println(binarySearch(cards, card));

        Card card2 = new Card(1, 2);
        Card card3 = new Card(13, 2);
        int comp = card2.compareTo(card3);
        if (comp > 0) {
            System.out.printf("%s is ranked higher than %s\n",
                card2, card3);
        }
    }

}
