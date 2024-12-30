package hw3.sort;

import exceptions.IndexException;

/**
 * An ArrayIndexedList that is able to report the number of
 * accesses and mutations, as well as reset those statistics.
 *
 * @param <T> The type of the array.
 */
public class MeasuredIndexedList<T> extends ArrayIndexedList<T>
    implements Measured<T> {

  private int accesses;
  private int mutations;

  /**
   * Constructor for a MeasuredIndexedList.
   *
   * @param size         The size of the array.
   * @param defaultValue The initial value to set every object to in the array..
   */
  public MeasuredIndexedList(int size, T defaultValue) {
    super(size, defaultValue);
    accesses = 0;
    mutations = 0;
  }

  @Override
  public int length() {
    return super.length();
  }

  @Override
  public T get(int index) throws IndexException {
    if (index < 0 || index >= length()) {
      throw new IndexException();
    }
    accesses++;
    return super.get(index);
  }

  @Override
  public void put(int index, T value) throws IndexException {
    try {
      super.put(index, value);
      mutations++;
    } catch (IndexOutOfBoundsException e) {
      return;
    }
  }

  @Override
  public void reset() {
    accesses = 0;
    mutations = 0;
  }

  @Override
  public int accesses() {
    return accesses;
  }

  @Override
  public int mutations() {
    return mutations;
  }

  @Override
  public int count(T value) {
    int count = 0;
    for (int i = 0; i < length(); i++) {
      if (get(i).equals(value)) {
        count++;
      }
    }
    return count;
  }
}
