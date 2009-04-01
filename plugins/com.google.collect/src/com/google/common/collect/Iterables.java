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

import com.google.common.base.Function;
import com.google.common.base.Nullable;
import com.google.common.base.Objects;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkContentsNotNull;
import static com.google.common.base.Preconditions.checkNotNull;
import com.google.common.base.Predicate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;

/**
 * This class contains static utility methods that operate on or return objects
 * of type {@code Iterable}. Also see the parallel implementations in {@link
 * Iterators}.
 *
 * @author Kevin Bourrillion
 * @author Scott Bonneau
 */
public final class Iterables {
  private Iterables() {}

  private static final Iterable<Object> EMPTY_ITERABLE = new Iterable<Object>()
  {
    public Iterator<Object> iterator() {
      return Iterators.EMPTY_ITERATOR;
    }
    @Override public String toString() {
      return "[]";
    }
  };

  /** Returns the empty {@code Iterable}. */
  // Casting to any type is safe since there are no actual elements.
  @SuppressWarnings("unchecked")
  public static <T> Iterable<T> emptyIterable() {
    return (Iterable<T>) EMPTY_ITERABLE;
  }

  /** Returns an unmodifiable view of {@code iterable}. */
  public static <T> Iterable<T> unmodifiableIterable(final Iterable<T> iterable)
  {
    checkNotNull(iterable);
    return new Iterable<T>() {
      public Iterator<T> iterator() {
        return Iterators.unmodifiableIterator(iterable.iterator());
      }
      @Override public String toString() {
        return iterable.toString();
      }
      // no equals and hashCode; it would break the contract!
    };
  }

  /**
   * Returns the number of elements in {@code iterable}.
   */
  public static int size(Iterable<?> iterable) {
    return (iterable instanceof Collection)
        ? ((Collection<?>) iterable).size()
        : Iterators.size(iterable.iterator());
  }

  /**
   * Returns {@code true} if {@code iterable} contains {@code element}; that is,
   * any object for while {@code equals(element)} is true.
   */
  public static boolean contains(Iterable<?> iterable, @Nullable Object element)
  {
    if (element == null) {
      return containsNull(iterable);
    }
    if (iterable instanceof Collection) {
      Collection<?> collection = (Collection<?>) iterable;
      try {
        return collection.contains(element);
      } catch (ClassCastException e) {
        return false;
      }
    }
    return Iterators.contains(iterable.iterator(), element);
  }

  /**
   * Returns {@code true} if {@code iterable} contains at least one null
   * element.
   */
  public static boolean containsNull(Iterable<?> iterable) {
    if (iterable instanceof Collection) {
      Collection<?> collection = (Collection<?>) iterable;
      try {
        return collection.contains(null);
      } catch (NullPointerException e) {
        return false;
      }
    }
    return Iterators.containsNull(iterable.iterator());
  }

  /**
   * Removes, from an iterable, every element that belongs to the provided
   * collection.
   * 
   * <p>This method calls {@link Collection#removeAll} if {@code iterable} is a
   * collection, and {@link Iterators#removeAll} otherwise.
   * 
   * @param iterable the iterable to (potentially) remove elements from
   * @param c the elements to remove
   * @return {@code true} if any elements are removed from {@code iterable}
   */
  public static boolean removeAll(Iterable<?> iterable, Collection<?> c) {
    return (iterable instanceof Collection)
        ? ((Collection<?>) iterable).removeAll(checkNotNull(c))
        : Iterators.removeAll(iterable.iterator(), c);
  }
  
  /**
   * Removes, from an iterable, every element that does not belong to the
   * provided collection.
   * 
   * <p>This method calls {@link Collection#retainAll} if {@code iterable} is a
   * collection, and {@link Iterators#retainAll} otherwise.
   *
   * @param iterable the iterable to (potentially) remove elements from
   * @param c the elements to retain
   * @return {@code true} if any elements are removed from {@code iterable}
   */
  public static boolean retainAll(Iterable<?> iterable, Collection<?> c) {
    return (iterable instanceof Collection)
        ? ((Collection<?>) iterable).retainAll(checkNotNull(c))
        : Iterators.retainAll(iterable.iterator(), c);
  }
  
  /**
   * Determines whether two iterables contain equal elements in the same order.
   * More specifically, this method returns {@code true} if {@code iterable1}
   * and {@code iterable2} contain the same number of elements and every element
   * of {@code iterable1} is equal to the corresponding element of
   * {@code iterable2}.
   */
  public static boolean elementsEqual(
      Iterable<?> iterable1, Iterable<?> iterable2) {
    return Iterators.elementsEqual(iterable1.iterator(), iterable2.iterator());
  }

  /**
   * Returns a string representation of {@code iterable}, with the format
   * {@code [e1, e2, ..., en]}.
   */
  public static String toString(Iterable<?> iterable) {
    return Iterators.toString(iterable.iterator());
  }

  /**
   * Returns the single element contained in {@code iterable}.
   *
   * @throws NoSuchElementException if the iterable is empty
   * @throws IllegalArgumentException if the iterable contains multiple
   *     elements
   */
  public static <T> T getOnlyElement(Iterable<T> iterable) {
    return Iterators.getOnlyElement(iterable.iterator());
  }

  /**
   * Returns the single element contained in {@code iterable}, or {@code
   * defaultValue} if the iterable is empty.
   *
   * @throws IllegalArgumentException if the iterator contains multiple
   *     elements
   */
  public static <T> T getOnlyElement(
      Iterable<T> iterable, @Nullable T defaultValue) {
    return Iterators.getOnlyElement(iterable.iterator(), defaultValue);
  }

  /**
   * Copies an iterable's elements into an array.
   *
   * @param iterable the iterable to copy
   * @param type the type of the elements
   * @return a newly-allocated array into which all the elements of the iterable
   *     have been copied
   */
  public static <T> T[] newArray(Iterable<T> iterable, Class<T> type) {
    Collection<T> collection = (iterable instanceof Collection)
        ? (Collection<T>) iterable
        : Lists.newArrayList(iterable);
    T[] array = ObjectArrays.newArray(type, collection.size());
    return collection.toArray(array);
  }

  /**
   * Adds all elements in {@code iterable} to {@code collection}.
   *
   * @return {@code true} if {@code collection} was modified as a result of this
   *     operation.
   */
  public static <T> boolean addAll(
      Collection<T> collection, Iterable<? extends T> iterable) {
    if (iterable instanceof Collection) {
      @SuppressWarnings("unchecked")
      Collection<? extends T> c = (Collection<? extends T>) iterable;
      return collection.addAll(c);
    }
    return Iterators.addAll(collection, iterable.iterator());
  }

  /**
   * Returns the number of elements in the specified iterable that equal the
   * specified object.
   * 
   * @see Collections#frequency
   */
  public static int frequency(Iterable<?> iterable, @Nullable Object element) {
    if ((iterable instanceof Multiset)) {
      return ((Multiset<?>) iterable).count(element);
    }
    if ((iterable instanceof Set)) {
      return ((Set<?>) iterable).contains(element) ? 1 : 0;
    }
    return Iterators.frequency(iterable.iterator(), element);
  }

  /**
   * Returns an iterable whose iterator cycles indefinitely over the elements of
   * {@code iterable}.
   * 
   * <p>That iterator supports {@code remove()} if {@code iterable.iterator()}
   * does. After {@code remove()} is called, subsequent cycles omit the removed
   * element, which is no longer in {@code iterable}. The iterator's
   * {@code hasNext()} method returns {@code true} until {@code iterable} is
   * empty.
   *   
   * <p><b>Warning:</b> Typical uses of the resulting iterator may produce an
   * infinite loop. You should use an explicit {@code break} or be certain that
   * you will eventually remove all the elements.
   * 
   * <p>To cycle over the iterable {@code n} times, use the following:
   * {@code Iterables.concat(Collections.nCopies(n, iterable))}
   */
  public static <T> Iterable<T> cycle(final Iterable<T> iterable) {
    checkNotNull(iterable);
    return new Iterable<T>() {
      public Iterator<T> iterator() {
        return Iterators.cycle(iterable);
      }
      @Override public String toString() {
        return iterable.toString() + " (cycled)";
      }
    };
  }

  /**
   * Returns an iterable whose iterator cycles indefinitely over the provided
   * elements.
   * 
   * <p>That iterator supports {@code remove()} if {@code iterable.iterator()}
   * does. After {@code remove()} is called, subsequent cycles omit the removed
   * element, but {@code elements} does not change. The iterator's
   * {@code hasNext()} method returns {@code true} until all of the original
   * elements have been removed.
   *   
   * <p><b>Warning:</b> Typical uses of the resulting iterator may produce an
   * infinite loop. You should use an explicit {@code break} or be certain that
   * you will eventually remove all the elements.
   * 
   * <p>To cycle over the elements {@code n} times, use the following:
   * {@code Iterables.concat(Collections.nCopies(n, Arrays.asList(elements)))}
   */
  public static <T> Iterable<T> cycle(T... elements) {
    return cycle(Lists.newArrayList(elements));
  }

  /**
   * Combines two iterables into a single iterable. The returned iterable has an
   * iterator that traverses the elements in {@code a}, followed by the elements
   * in {@code b}. The source iterators are not polled until necessary.
   * 
   * <p>The returned iterable's iterator supports {@code remove()} when the
   * corresponding input iterator supports it.
   */
  @SuppressWarnings("unchecked")
  public static <T> Iterable<T> concat(
      Iterable<? extends T> a, Iterable<? extends T> b) {
    checkNotNull(a);
    checkNotNull(b);
    return concat(Arrays.asList(a, b));
  }

  /**
   * Combines multiple iterables into a single iterable. The returned iterable
   * has an iterator that traverses the elements of each iterable in
   * {@code inputs}. The input iterators are not polled until necessary.
   *
   * <p>The returned iterable's iterator supports {@code remove()} when the
   * corresponding input iterator supports it.
   * 
   * @throws NullPointerException if any of the provided iterables is null
   */
  public static <T> Iterable<T> concat(Iterable<? extends T>... inputs) {
    return concat(checkContentsNotNull(Arrays.asList(inputs)));
  }

  /**
   * Combines multiple iterables into a single iterable. The returned iterable
   * has an iterator that traverses the elements of each iterable in
   * {@code inputs}. The input iterators are not polled until necessary.
   *
   * <p>The returned iterable's iterator supports {@code remove()} when the
   * corresponding input iterator supports it. The methods of the returned
   * iterable may throw {@code NullPointerException} if any of the input
   * iterators are null.
   */
  public static <T> Iterable<T> concat(
      Iterable<? extends Iterable<? extends T>> inputs) {
    /*
     * Hint: if you let A represent Iterable<? extends T> and B represent
     * Iterator<? extends T>, then this Function would look simply like:
     *
     *   Function<A, B> function = new Function<A, B> {
     *     public B apply(A from) {
     *       return from.iterator();
     *     }
     *   }
     *
     * TODO: there may be a better way to do this.
     */

    Function<Iterable<? extends T>, Iterator<? extends T>> function
        = new Function<Iterable<? extends T>, Iterator<? extends T>>() {
      public Iterator<? extends T> apply(Iterable<? extends T> from) {
        return from.iterator();
      }
    };
    final Iterable<Iterator<? extends T>> iterators
        = transform(inputs, function);
    return new AbstractIterable<T>() {
      public Iterator<T> iterator() {
        return Iterators.concat(iterators.iterator());
      }
    };
  }

  /**
   * Partition an iterable into sub-iterables of the given size. For example, 
   * <code>{A, B, C, D, E, F}</code> with partition size 3 yields
   * <code>{A, B, C}</code> and <code>{D, E, F}</code>. The returned iterables
   * have iterators that do not support {@code remove()}.
   *
   * <p>After {@code next()} is called on the returned iterable's iterator, the
   * iterables from prior {@code next()} calls become invalid. 
   *
   * @param iterable the iterable to partition
   * @param partitionSize the size of each partition
   * @param padToSize whether to pad the last partition to the partition size
   *     with {@code null}.
   * @return an iterable across partitioned iterables
   */
  public static <T> Iterable<Iterable<T>> partition(
      final Iterable<? extends T> iterable, final int partitionSize,
      final boolean padToSize) {
    checkNotNull(iterable);
    return new AbstractIterable<Iterable<T>>() {
      public Iterator<Iterable<T>> iterator() {
        final Iterator<Iterator<T>> iterator = Iterators.partition(
            iterable.iterator(), partitionSize, padToSize);
        return new AbstractIterator<Iterable<T>>() {
          int howFarIn;

          @Override protected Iterable<T> computeNext() {
            howFarIn++;
            if (!iterator.hasNext()) {
              return endOfData();
            }
            return new AbstractIterable<T>() {
              Iterator<T> innerIter = iterator.next();
              boolean firstIteratorRequest = true;

              public Iterator<T> iterator() {
                if (firstIteratorRequest) {
                  firstIteratorRequest = false;
                  return innerIter;
                } else {
                  Iterator<Iterator<T>> partitionIter = Iterators.partition(
                      iterable.iterator(), partitionSize, padToSize);
                  for (int i = 0; i < howFarIn; i++) {
                    innerIter = partitionIter.next();
                  }
                  return innerIter;
                }
              }
            };
          }
        };
      }
    };
  }

  /**
   * Returns the elements of {@code unfiltered} that satisfy a predicate. The
   * resulting iterable's iterator does not support {@code remove()}.
   */
  public static <T> Iterable<T> filter(
      final Iterable<T> unfiltered, final Predicate<? super T> predicate) {
    checkNotNull(unfiltered);
    checkNotNull(predicate);
    return new AbstractIterable<T>() {
      public Iterator<T> iterator() {
        return Iterators.filter(unfiltered.iterator(), predicate);
      }
    };
  }

  /**
   * Returns all instances of class {@code type} in {@code unfiltered}. The
   * returned iterable has elements whose class is {@code type} or a subclass of
   * {@code type}. The returned iterable's iterator does not support
   * {@code remove()}.
   *
   * @param unfiltered an iterable containing objects of any type
   * @param type the type of elements desired
   * @return an unmodifiable iterable containing all elements of the original
   *     iterable that were of the requested type
   */
  public static <T> Iterable<T> filter(
      final Iterable<?> unfiltered, final Class<T> type) {
    checkNotNull(unfiltered);
    checkNotNull(type);
    return new AbstractIterable<T>() {
      public Iterator<T> iterator() {
        return Iterators.filter(unfiltered.iterator(), type);
      }
    };
  }

  /**
   * Returns {@code true} if one or more elements in {@code iterable} satisfy
   * the predicate.
   */
  public static <T> boolean any(
      Iterable<T> iterable, Predicate<? super T> predicate) {
    return Iterators.any(iterable.iterator(), predicate);
  }

  /**
   * Returns {@code true} if every element in {@code iterable} satisfies the
   * predicate. If {@code iterable} is empty, {@code true} is returned.
   */
  public static <T> boolean all(
      Iterable<T> iterable, Predicate<? super T> predicate) {
    return Iterators.all(iterable.iterator(), predicate);
  }

  /**
   * Returns the first element in {@code iterable} that satisfies the given
   * predicate.
   *
   * @throws NoSuchElementException if no element in {@code iterable} matches
   *     the given predicate
   */
  public static <E> E find(Iterable<E> iterable,
      Predicate<? super E> predicate) {
    return Iterators.find(iterable.iterator(), predicate);
  }

  /**
   * Returns an iterable that applies {@code function} to each element of {@code
   * fromIterable}.
   * 
   * <p>The returned iterable's iterator supports {@code remove()} if the
   * provided iterator does. After a successful {@code remove()} call,
   * {@code fromIterable} no longer contains the corresponding element.
   */
  public static <F, T> Iterable<T> transform(final Iterable<F> fromIterable,
      final Function<? super F, ? extends T> function) {
    checkNotNull(fromIterable);
    checkNotNull(function);
    return new AbstractIterable<T>() {
      public Iterator<T> iterator() {
        return Iterators.transform(fromIterable.iterator(), function);
      }
    };
  }

  /**
   * Returns the element at the specified position in an iterable.
   * 
   * @param position position of the element to return
   * @return the element at the specified position in {@code iterable}
   * @throws IndexOutOfBoundsException if {@code position} is negative or
   *     greater than or equal to the size of {@code iterable}
   */
  public static <T> T get(Iterable<T> iterable, int position) {
    checkNotNull(iterable);
    if (position < 0) {
      throw new IndexOutOfBoundsException(
          "position cannot be negative: " + position);
    }

    if (iterable instanceof Collection) {
      Collection<T> collection = (Collection<T>) iterable;
      int size = collection.size();
      if (position >= size) {
        throw new IndexOutOfBoundsException(String.format(
            "position %d must be less than the iterable size %d", 
            position, size));
      }

      if (iterable instanceof List) {
        List<T> list = (List<T>) iterable;
        return list.get(position);
      }
    }

    return Iterators.get(iterable.iterator(), position);
  }

  /**
   * Returns the last element of {@code iterable}.
   * 
   * @return the last element of {@code iterable}
   * @throws NoSuchElementException if the iterable has no elements
   */
  public static <T> T getLast(Iterable<T> iterable) {
    if (iterable instanceof List) {
      List<T> list = (List<T>) iterable;
      // TODO: Support a concurrent list whose size changes while this method
      // is running.
      if (list.isEmpty()) {
        throw new NoSuchElementException();
      }
      return list.get(list.size() - 1);
    }
    
    if (iterable instanceof SortedSet) {
      SortedSet<T> sortedSet = (SortedSet<T>) iterable;
      return sortedSet.last();
    }
    
    return Iterators.getLast(iterable.iterator());    
  }
  
  /**
   * Returns a view of {@code iterable} that skips its first
   * {@code numberToSkip} elements. If {@code iterable} contains fewer than
   * {@code numberToSkip} elements, the returned iterable skips all of its
   * elements.
   * 
   * <p>Modifications to the underlying {@link Iterable} before a call to
   * {@code iterator()} are reflected in the returned iterator. That is, the
   * iterator skips the first {@code numberToSkip} elements that exist when the
   * {@code Iterator} is created, not when {@code skip()} is called.
   * 
   * <p>The returned iterable's iterator supports {@code remove()} if the
   * iterator of the underlying iterable supports it. Note that it is
   * <i>not</i> possible to delete the last skipped element by immediately
   * calling {@code remove()} on that iterator, as the {@code Iterator}
   * contract states that a call to {@code remove()} before a call to
   * {@code next()} will throw an {@link IllegalStateException}.
   */
  public static <T> Iterable<T> skip(final Iterable<T> iterable,
      final int numberToSkip) {
    checkNotNull(iterable);
    checkArgument(numberToSkip >= 0, "number to skip cannot be negative");

    if (iterable instanceof List) {
      final List<T> list = (List<T>) iterable;      
      return new AbstractIterable<T>() {
        public Iterator<T> iterator() {           
          // TODO: Support a concurrent list whose size changes while this
          // method is running.
          return (numberToSkip >= list.size())
              ? Iterators.<T>emptyIterator() 
              : list.subList(numberToSkip, list.size()).iterator();
        }        
      };
    }
    
    return new AbstractIterable<T>() {
      public Iterator<T> iterator() {
        final Iterator<T> iterator = iterable.iterator();

        Iterators.skip(iterator, numberToSkip);

        /*
         * We can't just return the iterator because an immediate call to its
         * remove() method would remove one of the skipped elements instead of
         * throwing an IllegalStateException.
         */
        return new Iterator<T>() {
          boolean atStart = true;

          public boolean hasNext() {
            return iterator.hasNext();
          }

          public T next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }

            try {
              return iterator.next();
            } finally {
              atStart = false;
            }
          }

          public void remove() {
            if (atStart) {
              throw new IllegalStateException();
            }
            iterator.remove();
          }
        };
      }
    };
  }

  /**
   * Creates an iterable with the first {@code limitSize} elements of the given
   * iterable. If the original iterable does not contain that many elements, the
   * returned iterator will have the same behavior as the original iterable. The
   * returned iterable's iterator supports {@code remove()} if the original
   * iterator does.
   * 
   * @param iterable the iterable to limit
   * @param limitSize the maximum number of elements in the returned iterator
   * @throws IllegalArgumentException if {@code limitSize} is negative
   */
  public static <T> Iterable<T> limit(
      final Iterable<T> iterable, final int limitSize) {
    checkNotNull(iterable);
    checkArgument(limitSize >= 0, "limit is negative");
    return new AbstractIterable<T>() {
      public Iterator<T> iterator() {
        return Iterators.limit(iterable.iterator(), limitSize);
      }
    };
  }

  // Methods only in Iterables, not in Iterators

  /**
   * Adapts a list to an iterable with reversed iteration order. It is
   * especially useful in foreach-style loops:
   * <pre>
   * List<String> mylist = ...
   * for (String str : Iterables.reverse(mylist)) {
   *   ...
   * } </pre>
   *
   * @return an iterable with the same elements as the list, in reverse.
   */
  public static <T> Iterable<T> reverse(final List<T> list) {
    checkNotNull(list);
    return new AbstractIterable<T>() {
      public Iterator<T> iterator() {
        final ListIterator<T> listIter = list.listIterator(list.size());
        return new Iterator<T>() {
          public boolean hasNext() {
            return listIter.hasPrevious();
          }
          public T next() {
            return listIter.previous();
          }
          public void remove() {
            listIter.remove();
          }
        };
      }
    };
  }

  /**
   * Provides a rotated view of a list. Differs from {@link Collections#rotate}
   * in that it leaves the underlying list unchanged. Note that this is a
   * "live" view of the list that will change as the list changes. However, the
   * behavior of an {@link Iterator} retrieved from a rotated view of the list
   * is undefined if the list is structurally changed after the iterator is
   * retrieved.
   *
   * @param list the list to return a rotated view of
   * @param distance the distance to rotate the list. There are no constraints
   *     on this value; it may be zero, negative, or greater than {@code
   *     list.size()}.
   * @return a rotated view of the given list
   */
  public static <T> Iterable<T> rotate(final List<T> list, final int distance) {
    checkNotNull(list);

    
    // If no rotation is requested, just return the original list
    if (distance == 0) {
      return list;
    }

    return new AbstractIterable<T>() {
      /**
       * Determines the actual distance we need to rotate (distance provided
       * might be larger than the size of the list or negative).
       */
      int calcActualDistance(int size) {
        // we already know distance and size are non-zero
        int actualDistance = distance % size;
        if (actualDistance < 0) {
          // distance must have been negative
          actualDistance += size;
        }
        return actualDistance;
      }

      public Iterator<T> iterator() {
        int size = list.size();
        if (size <= 1) {
          return list.iterator();
        }
        
        int actualDistance = calcActualDistance(size);
        // lists of a size that go into the distance evenly don't need rotation
        if (actualDistance == 0) {
          return list.iterator();
        }

        @SuppressWarnings("unchecked")
        Iterable<T> rotated = concat(list.subList(actualDistance, size),
            list.subList(0, actualDistance));
        return rotated.iterator();
      }
    };
  }

  /**
   * Returns whether the given iterable contains no elements.
   *
   * @return {@code true} if the iterable has no elements, {@code false} if the
   *     iterable has one or more elements
   */
  public static <T> boolean isEmpty(Iterable<T> iterable) {
    return !iterable.iterator().hasNext();
  }

  /**
   * Removes the specified element from the specified iterable.
   *
   * <p>This method iterates over the iterable, checking each element returned
   * by the iterator in turn to see if it equals the object {@code o}. If they
   * are equal, it is removed from the iterable with the iterator's
   * {@code remove} method. At most one element is removed, even if the iterable
   * contains multiple members that equal {@code o}.
   *
   * <p><b>Warning</b>: Do not use this method for a collection, such as a
   * {@link HashSet}, that has a fast {@code remove} method.
   * 
   * @param iterable the iterable from which to remove
   * @param o an element to remove from the collection
   * @return {@code true} if the iterable changed as a result
   * @throws UnsupportedOperationException if the iterator does not support the
   *     {@code remove} method and the iterable contains the object
   */
  static boolean remove(Iterable<?> iterable, @Nullable Object o) {
    Iterator<?> i = iterable.iterator();
    while (i.hasNext()) {
      if (Objects.equal(i.next(), o)) {
        i.remove();
        return true;
      }
    }
    return false;
  }  
}
