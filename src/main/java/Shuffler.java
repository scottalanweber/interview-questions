import java.util.ArrayList;
import java.util.List;

/**
 * Shuffle a list of objects such that no item is next to its previous neighbors (excluding front and end)
 *
 * @author Scott Weber
 */
class Shuffler
{
  private static final int HALF = 2;

  private boolean alreadyShuffled = false;

  public List<Object> shuffle(List<Object> items) {
    List shuffledDeck = new ArrayList();

    if(items != null) {
      int sizeOfSplitDeck = items.size() / HALF;

      for (int i = 0; i < sizeOfSplitDeck; i++) {
        shuffledDeck.add(items.get(i + sizeOfSplitDeck));
        shuffledDeck.add(items.get(i));
      }

      if (items.size() % HALF != 0) {
        shuffledDeck.add(items.get(items.size() - 1));
      }

      if (!items.isEmpty() && items.size() % HALF == 0 && !alreadyShuffled) {
        alreadyShuffled = true;
        shuffledDeck = shuffle(shuffledDeck);
      }
    }

    return shuffledDeck;
  }
}
