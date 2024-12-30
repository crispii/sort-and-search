package hw3.sort;


/**
 * The Insertion Sort algorithm, with minimizing swaps optimization.
 *
 * @param <T> Element type.
 */
public final class InsertionSort<T extends Comparable<T>>
    implements SortingAlgorithm<T> {

  @Override
  public void sort(IndexedList<T> indexedList) {
    int i = 1;
    int length = indexedList.length();
    while (i < length) {
      T x = indexedList.get(i);
      int j = i;
      while (j > 0 && x.compareTo(indexedList.get(j - 1)) < 0) {
        indexedList.put(j, indexedList.get(j - 1));
        j--;
      }
      indexedList.put(j, x);
      i++;
    }
  }

  @Override
  public String name() {
    return "Insertion Sort";
  }
}
