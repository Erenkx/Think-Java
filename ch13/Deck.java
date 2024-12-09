import java.util.Random;

/**
 * A deck of playing cards (of fixed length).
 */
public class Deck {

    // This is a class variable, so we don't have to create
    // a new Random object every time we call randomInt.
    private static Random random = new Random();

    private Card[] cards;

    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    /**
     * Constructs a deck of n cards (all null).
     */
    public Deck(int n) {
        this.cards = new Card[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Card card : this.cards) {
            str.append(card);
            str.append("\n");
        }

        return str.toString().strip();
    }

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle() {
        int randomIndex;
        int length = this.cards.length;
        for (int i = 0; i < length; i++) {
            randomIndex = randomInt(i, length - 1);
            this.swapCards(i, randomIndex);
        }
    }

    /**
     * Chooses a random number between low and high, including both.
     */
    private static int randomInt(int low, int high) {
        return random.nextInt(high - low + 1) + low;
    }

    /**
     * Swaps the cards at indexes i and j.
     */
    private void swapCards(int i, int j) {
        Card temp = this.cards[i];
        this.cards[i] = this.cards[j];
        this.cards[j] = temp;
    }

    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
        int lowest;
        int length = this.cards.length;
        for (int i = 0; i < length; i++) {
            lowest = indexLowest(i, length - 1);
            this.swapCards(i, lowest);
        }
    }

    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    private int indexLowest(int low, int high) {
        int lowest = low;
        for (int i = low + 1; i <= high; i++) {
            if (this.cards[i].compareTo(this.cards[lowest]) == -1) {
                lowest = i;
            }
        }

        return lowest;
    }

    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }

        return sub;
    }

    /**
     * Combines two previously sorted subdecks.
     */
    private static Deck merge(Deck d1, Deck d2) {
        int length1 = d1.cards.length;
        int length2 = d2.cards.length;
        Deck d3 = new Deck(length1 + length2);

        // use the index i to keep track of where we are at in the first
        // deck, and the index j for the second deck
        int i = 0;
        int j = 0;

        // the index k traverses the result deck
        for (int k = 0; k < d3.cards.length; k++) {
            if (length1 == 0) {
                d3.cards[k] = d2.cards[j];
                j++;
                length2--;
            } else if (length2 == 0) {
                d3.cards[k] = d1.cards[i];
                i++;
                length1--;
            } else {
                if (d1.cards[i].compareTo(d2.cards[j]) <= 0) {
                    d3.cards[k] = d1.cards[i];
                    i++;
                    length1--;
                } else {
                    d3.cards[k] = d2.cards[j];
                    j++;
                    length2--;
                }
            }
        }

        return d3;
    }

    /**
     * Returns a sorted copy of the deck using selection sort.
     */
    public Deck almostMergeSort() {
        int length = this.cards.length;

        // divide the deck into two subdecks
        Deck d1 = this.subdeck(0, length / 2 - 1);
        Deck d2 = this.subdeck(length / 2, length - 1);

        // sort the subdecks using selectionSort
        d1.selectionSort();
        d2.selectionSort();

        // merge the subdecks, return the result
        return merge(d1, d2);
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
        int length = this.cards.length;

        // if the deck has 0 or 1 cards, return it
        if (length <= 1) {
            return this;
        }

        // otherwise, divide the deck into two subdecks
        Deck subdeck1 = this.subdeck(0, length / 2 - 1);
        Deck subdeck2 = this.subdeck(length / 2, length - 1);

        // sort the subdecks using mergeSort
        subdeck1 = subdeck1.mergeSort();
        subdeck2 = subdeck2.mergeSort();

        // merge the subdecks, return the result
        return merge(subdeck1, subdeck2);
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
    }

    /**
     * Helper method for insertion sort.
     */
    private void insert(Card card, int i) {
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck);

        System.out.println();

        deck.selectionSort();
        System.out.println(deck);

        System.out.println();

        deck.shuffle();
        Deck mergedDeck = deck.almostMergeSort();
        System.out.println(mergedDeck);

        System.out.println();

        deck.shuffle();
        Deck sortedDeck = deck.mergeSort();
        System.out.println(sortedDeck);
    }

}
