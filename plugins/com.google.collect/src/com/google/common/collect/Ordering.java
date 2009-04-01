/*
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.collect;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * A base class for {@link Serializable} {@link Comparator comparators} that
 * provides convenience methods for common uses.
 *
 * @author Jesse Wilson
 */
public abstract class Ordering<T> implements Comparator<T>, Serializable {

  /**
   * Returns an ordering that uses the natural order of the values. The ordering
   * throws a {@link NullPointerException} when passed a null parameter.
   * 
   * <p>The type specification is {@code <T extends Comparable>}, instead of
   * the more specific {@code <T extends Comparable<? super T>>}, to support
   * classes defined without generics.
   */
  @SuppressWarnings("unchecked")   // see explanation in method Javadoc
  public static <T extends Comparable> Ordering<T> natural() {
    return Comparators.naturalOrder();
  }
  
  /**
   * Returns an ordering for {@code comparator}.
   *
   * @param comparator the comparator that defines the order
   */
  public static <T> Ordering<T> forComparator(final Comparator<T> comparator) {
    return new ComparatorOrdering<T>(comparator);
  }

  private static final class ComparatorOrdering<T> extends Ordering<T> {
    private final Comparator<T> comparator;

    private ComparatorOrdering(Comparator<T> comparator) {
      this.comparator = checkNotNull(comparator);
    }

    public int compare(T a, T b) {
      return comparator.compare(a, b);
    }
    
    @Override public boolean equals(Object other) {
      return other instanceof ComparatorOrdering
          && comparator.equals(((ComparatorOrdering<?>) other).comparator);
    }
    
    @Override public int hashCode() {
      return comparator.hashCode();
    }

    @Override public String toString() {
      return comparator.toString();
    }
    
    private static final long serialVersionUID = 0;
  }

  /**
   * Returns the ordering that is the {@link
   * Collections#reverseOrder(Comparator) reverse} of this ordering.
   */
  public Ordering<T> reverseOrder() {
    return new ReverseOrdering<T>(this);
  }

  /**
   * A reverse view of another ordering. Prefer this over {@link 
   * Collections#reverseOrder(Comparator)}, which does not implement
   * {@code equals()} or {@code hashCode()}.
   */
  private static class ReverseOrdering<T> extends Ordering<T> {
    final Ordering<T> forwardOrder;
    public ReverseOrdering(Ordering<T> forwardOrder) {
      this.forwardOrder = checkNotNull(forwardOrder);
    }

    @Override public Ordering<T> reverseOrder() {
      return forwardOrder;
    }

    public int compare(T a, T b) {
      return forwardOrder.compare(b, a);
    }

    @Override public int hashCode() {
      return -forwardOrder.hashCode();
    }

    @Override public boolean equals(Object other) {
      return other instanceof ReverseOrdering
          && forwardOrder.equals(((ReverseOrdering<?>) other).forwardOrder);
    }
    
    @Override public String toString() {
      return "reverseOrder(" + forwardOrder + ")";
    }
    
    private static final long serialVersionUID = 0;
  }

  /**
   * {@link Collections#binarySearch(List, Object, Comparator) Searches}
   * {@code sortedList} for {@code key} using the binary search algorithm. The
   * list must be sorted using this ordering.
   *
   * @param sortedList the list to be searched
   * @param key the key to be searched for
   */
  public int binarySearch(List<? extends T> sortedList, T key) {
    return Collections.binarySearch(sortedList, key, this);
  }

  /**
   * {@link Collections#sort(List, Comparator) Sorts} {@code list} according
   * to this ordering.
   *
   * @param list the list to be sorted
   */
  public void sort(List<? extends T> list) {
    Collections.sort(list, this);
  }

  /**
   * Returns a copy of the given iterable sorted by this ordering. The input is
   * not modified. The returned list is modifiable, serializable, and has random
   * access.
   *
   * <p>Unlike {@link Sets#newTreeSet(Comparator, Iterable)}, this method does
   * not collapse elements that compare as zero, and the resulting collection 
   * does not maintain its own sort order.
   *
   * @param iterable the elements to be copied and sorted
   * @return a new list containing the given elements in sorted order
   */  
  public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
    List<E> list = Lists.newArrayList(iterable);
    sort(list);
    return list;
  }

  /**
   * Returns the largest of the specified values according to this ordering. If
   * there are multiple largest values, the first of those is returned.
   *
   * @param iterable the iterable whose maximum element is to be determined
   * @throws java.util.NoSuchElementException if {@code iterable} is empty
   * @throws ClassCastException if the parameters are not <i>mutually
   *     comparable</i> under this ordering.
   */
  public <E extends T> E max(Iterable<E> iterable) {
    Iterator<E> iterator = iterable.iterator();
    
    // let this throw NoSuchElementException as necessary
    E maxSoFar = iterator.next();
    
    while (iterator.hasNext()) {
      maxSoFar = max(maxSoFar, iterator.next());
    }
    
    return maxSoFar;
  }

  /**
   * Returns the largest of the specified values according to this ordering. If
   * there are multiple largest values, the first of those is returned.
   *
   * @param a value to compare, returned if greater than or equal to the rest.
   * @param b value to compare
   * @param c value to compare
   * @param rest values to compare
   * @throws ClassCastException if the parameters are not <i>mutually
   *     comparable</i> under this ordering.
   */
  public <E extends T> E max(E a, E b, E c, E... rest) {
    E maxSoFar = max(max(a, b), c);
    
    for (E r : rest) {
      maxSoFar = max(maxSoFar, r);
    }
    
    return maxSoFar;
  }

  /**
   * Returns the larger of the two values according to this ordering. If the
   * values compare as 0, the first is returned.
   *
   * @param a value to compare, returned if greater than or equal to b.
   * @param b value to compare.
   * @throws ClassCastException if the parameters are not <i>mutually
   *     comparable</i> under this ordering.
   */
  public <E extends T> E max(E a, E b) {
    return compare(a, b) >= 0 ? a : b;
  }

  /**
   * Returns the smallest of the specified values according to this ordering. If
   * there are multiple smallest values, the first of those is returned.
   * 
   * @param iterable the iterable whose minimum element is to be determined
   * @throws java.util.NoSuchElementException if {@code iterable} is empty
   * @throws ClassCastException if the parameters are not <i>mutually
   *     comparable</i> under this ordering.
   */
  public <E extends T> E min(Iterable<E> iterable) {
    Iterator<E> iterator = iterable.iterator();
    
    // let this throw NoSuchElementException as necessary
    E minSoFar = iterator.next();
    
    while (iterator.hasNext()) {
      minSoFar = min(minSoFar, iterator.next());
    }
    
    return minSoFar;
  }

  /**
   * Returns the smallest of the specified values according to this ordering. If
   * there are multiple smallest values, the first of those is returned.
   *
   * @param a value to compare, returned if less than or equal to the rest.
   * @param b value to compare
   * @param c value to compare
   * @param rest values to compare
   * @throws ClassCastException if the parameters are not <i>mutually
   *     comparable</i> under this ordering.
   */
  public <E extends T> E min(E a, E b, E c, E... rest) {
    E minSoFar = min(min(a, b), c);
    
    for (E r : rest) {
      minSoFar = min(minSoFar, r);
    }
    
    return minSoFar;
  }

  /**
   * Returns the smaller of the two values according to this ordering. If the
   * values compare as 0, the first is returned.
   *
   * @param a value to compare, returned if less than or equal to b.
   * @param b value to compare.
   * @throws ClassCastException if the parameters are not <i>mutually
   *     comparable</i> under this ordering.
   */
  public <E extends T> E min(E a, E b) {
    return compare(a, b) <= 0 ? a : b;
  }  
  
  /**
   * Returns an ordering that treats {@code null} as less than all other values
   * and uses this ordering to compare non-null values.
   */
  public Ordering<T> nullsFirst() {
    // TODO: Rename Comparators.nullLeastOrder to nullsFirst.
    return Comparators.nullLeastOrder(this);
  }
  
  /**
   * Returns an ordering that treats {@code null} as greater than all other
   * values and uses this ordering to compare non-null values.
   */
  public Ordering<T> nullsLast() {
    // TODO: Rename Comparators.nullGreatestOrder to nullsLast.
    return Comparators.nullGreatestOrder(this);
  }
}
