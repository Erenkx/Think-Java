import java.util.Arrays;

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
     * search; otherwise returns -1.
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
     * search; otherwise returns -1.
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

    /**
     * Returns a histogram of the suits in the hand.
     */
    public static int[] suitHist(Card[] cards) {
        int[] hist = {0, 0, 0, 0};
        for (Card card : cards) {
            hist[card.getSuit()] += 1;
        }

        return hist;
    }

    /**
     * Returns true if the hand contains a flush; otherwise returns false.
     */
    public static boolean hasFlush(Card[] cards) {
        int[] hist = suitHist(cards);
        for (int i : hist) {
            if (i >= 5) {
                return true;
            }
        }

        return false;
    }

    /**
     * Sorts the cards using bubble sort.
     */
    public static Card[] sort(Card[] cards) {
        int len = cards.length;
        Card[] sortedCards = new Card[len];
        for (int i = 0; i < len; i++) {
            sortedCards[i] = cards[i];
        }

        for (int i = 0; i < len - 1; i++) {
            int swap = 0;
            for (int j = 0; j < len - 1 - i; j++) {

                if (sortedCards[j].compareTo(sortedCards[j + 1]) > 0) {
                    Card temp = sortedCards[j];
                    sortedCards[j] = sortedCards[j + 1];
                    sortedCards[j + 1] = temp;
                    swap += 1;
                }
            }

            if (swap == 0) {
                break;
            }
        }

        return sortedCards;
    }

    /**
     * Returns true if the hand contains a royal flush;
     * otherwise returns false.
     */
    public static boolean hasRoyal(Card[] cards) {
        if (!hasFlush(cards)) {
            return false;
        }

        Card[] sortedCards = sort(cards);
        int[] hist = suitHist(sortedCards);
        for (int i = 0; i < hist.length; i++) {
            if (hist[i] >= 5) {
                for (int rank = 10; rank <= 13; rank++) {
                    Card target = new Card(rank, i);
                    if (binarySearch(sortedCards, target) == -1) {
                        return false;
                    }
                }

                Card target = new Card(1, i);
                if (binarySearch(sortedCards, target) == -1) {
                    return false;
                }
            }
        }

        return true;
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

        Card[] cards2 = {card, card2, card3};
        System.out.println(Arrays.toString(suitHist(cards)));
        System.out.println(Arrays.toString(suitHist(cards2)));

        Card card4 = new Card(3, 2);
        Card card5 = new Card(12, 1);
        Card card6 = new Card(1, 2);
        Card card7 = new Card(7, 2);
        Card card8 = new Card(2, 3);
        Card card9 = new Card(9, 2);
        Card card10 = new Card(2, 2);
        Card[] hand1 = {card4, card5, card6, card7, card8};
        Card[] hand2 = {card4, card9, card6, card7, card10};
        System.out.println(hasFlush(hand1));    // false
        System.out.println(hasFlush(hand2));    // true

        System.out.println(Arrays.toString(hand1));
        System.out.println(Arrays.toString(sort(hand1)));
        System.out.println(Arrays.toString(hand2));
        System.out.println(Arrays.toString(sort(hand2)));

        Card card11 = new Card(13, 2);
        Card card12 = new Card(10, 2);
        Card card13 = new Card(1, 2);
        Card card14 = new Card(11, 2);
        Card card15 = new Card(12, 2);
        Card[] hand3 = {card11, card12, card13, card14, card15};
        System.out.println(hasRoyal(hand1));    // false
        System.out.println(hasRoyal(hand2));    // false
        System.out.println(hasRoyal(hand3));    // true
    }

}
