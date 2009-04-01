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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

/**
 * Provides static utility methods for creating and working with {@link
 * Multiset} instances.
 *
 * @author Kevin Bourrillion
 * @author Mike Bostock
 */
public final class Multisets {
  private Multisets() {}

  /**
   * Creates an empty {@code HashMultiset} using the default initial capacity
   * (16 distinct elements).
   */
  public static <E> HashMultiset<E> newHashMultiset() {
    return new HashMultiset<E>();
  }

  /**
   * Creates a {@code HashMultiset} containing the specified elements, using the
   * default initial capacity (16 distinct elements).
   *
   * @param elements the elements that the multiset should contain
   */
  public static <E> HashMultiset<E> newHashMultiset(E... elements) {
    HashMultiset<E> multiset = new HashMultiset<E>();
    Collections.addAll(multiset, elements);
    return multiset;
  }

  /**
   * Creates a {@code HashMultiset} containing the specified elements.
   *
   * @param elements the elements that the multiset should contain
   */
  public static <E> HashMultiset<E> newHashMultiset(
      Iterable<? extends E> elements) {
    return HashMultiset.create(elements);
  }

  /**
   * Creates an empty {@code TreeMultiset} instance.
   *
   * @return a newly-created, initially-empty TreeMultiset
   */
  @SuppressWarnings("unchecked")  // allow ungenerified Comparable types
  public static <E extends Comparable> TreeMultiset<E> newTreeMultiset() {
    return new TreeMultiset<E>();
  }

  /**
   * Creates an empty {@code TreeMultiset} instance, sorted according to the
   * specified comparator.
   *
   * @return a newly-created, initially-empty TreeMultiset
   */
  public static <E> TreeMultiset<E> newTreeMultiset(Comparator<? super E> c) {
    return new TreeMultiset<E>(c);
  }

  /** Creates an empty {@code EnumMultiset}. */
  public static <E extends Enum<E>> EnumMultiset<E> newEnumMultiset(
      Class<E> type) {
    return new EnumMultiset<E>(type);
  }

  /**
   * Creates an {@code EnumMultiset} containing the specified elements.
   *
   * @throws IllegalArgumentException if {@code elements} is empty
   */
  public static <E extends Enum<E>> EnumMultiset<E> newEnumMultiset(
      Iterable<E> elements) {
    return new EnumMultiset<E>(elements);
  }

  /**
   * Creates an {@code EnumMultiset} containing the specified elements.
   *
   * @throws IllegalArgumentException if {@code elements} is empty
   */
  public static <E extends Enum<E>> EnumMultiset<E> newEnumMultiset(
      E... elements) {
    checkArgument(elements.length > 0,
        "newEnumMultiset requires at least one element");
    EnumMultiset<E> multiset = newEnumMultiset(elements[0].getDeclaringClass());
    Collections.addAll(multiset, elements);
    return multiset;
  }

  /**
   * Returns an unmodifiable view of the specified multiset. Query operations on
   * the returned multiset "read through" to the specified multiset, and
   * attempts to modify the returned multiset result in an
   * {@link UnsupportedOperationException}.
   *
   * @param multiset the multiset for which an unmodifiable view is to be
   *     generated
   * @return an unmodifiable view of the multiset
   */
  public static <E> Multiset<E> unmodifiableMultiset(Multiset<E> multiset) {
    return new UnmodifiableMultiset<E>(multiset);
  }

  private static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> 
      implements Serializable {
    final Multiset<E> delegate;
    private UnmodifiableMultiset(Multiset<E> delegate) {
      this.delegate = delegate;
    }

    @Override protected Multiset<E> delegate() {
      return delegate;      
    }
    
    transient Set<E> elementSet;

    @Override public Set<E> elementSet() {
      Set<E> es = elementSet;
      return (es == null)
          ? elementSet = Collections.unmodifiableSet(delegate.elementSet())
          : es;
    }

    transient Set<Multiset.Entry<E>> entrySet;

    @Override public Set<Multiset.Entry<E>> entrySet() {
      Set<Multiset.Entry<E>> es = entrySet;
      return (es == null)
          ? entrySet = Collections.unmodifiableSet(delegate.entrySet())
          : es;
    }

    @Override public Iterator<E> iterator() {
      return Iterators.unmodifiableIterator(delegate.iterator());
    }

    @Override public boolean add(E element) {
      throw new UnsupportedOperationException();
    }

    @Override public boolean add(E element, int occurences) {
      throw new UnsupportedOperationException();
    }

    @Override public boolean addAll(Collection<? extends E> elementsToAdd) {
      throw new UnsupportedOperationException();
    }

    @Override public boolean remove(Object element) {
      throw new UnsupportedOperationException();
    }

    @Override public int remove(Object element, int occurrences) {
      throw new UnsupportedOperationException();
    }

    @Override public int removeAllOccurrences(Object element) {
      throw new UnsupportedOperationException();
    }

    @Override public boolean removeAll(Collection<?> elementsToRemove) {
      throw new UnsupportedOperationException();
    }

    @Override public boolean retainAll(Collection<?> elementsToRetain) {
      throw new UnsupportedOperationException();
    }

    @Override public void clear() {
      throw new UnsupportedOperationException();
    }

    private static final long serialVersionUID = 0;    
  }

  /**
   * Returns a synchronized (thread-safe) multiset backed by the specified
   * multiset. In order to guarantee serial access, <b>all</b> access to the
   * backing multiset must go through the returned multiset.
   *
   * <p>It is imperative that the user manually synchronize on the returned
   * multiset when iterating over any of its collection views:
   *
   * <pre>  Multiset&lt;E&gt; m = Multisets.synchronizedMultiset(
   *      new HashMultiset&lt;E&gt;());
   *   ...
   *  Set&lt;E&gt; s = m.elementSet(); // Needn't be in synchronized block
   *   ...
   *  synchronized (m) { // Synchronizing on m, not s!
   *    Iterator&lt;E&gt; i = s.iterator(); // Must be in synchronized block
   *    while (i.hasNext()) {
   *      foo(i.next());
   *    }
   *  }</pre>
   *
   * Failure to follow this advice may result in non-deterministic behavior.
   *
   * <p>For a greater degree of concurrency, you may use a {@link
   * ConcurrentMultiset}.
   *
   * @param multiset the multiset to be wrapped
   * @return a synchronized view of the specified multiset
   */
  public static <E> Multiset<E> synchronizedMultiset(Multiset<E> multiset) {
    return Synchronized.multiset(multiset, null);
  }

  /**
   * Returns an immutable multiset entry with the specified element and count.
   *
   * @param e the element to be associated with the returned entry
   * @param n the count to be associated with the returned entry
   * @throws IllegalArgumentException if {@code n} is negative
   */
  public static <E> Multiset.Entry<E> immutableEntry(final E e, final int n) {
    checkArgument(n >= 0);
    return new AbstractMultisetEntry<E>() {
      public E getElement() {
        return e;
      }
      public int getCount() {
        return n;
      }
    };
  }

  /**
   * Returns a multiset view of the specified set. The multiset is backed by the
   * set, so changes to the set are reflected in the multiset, and vice versa.
   * If the set is modified while an iteration over the multiset is in progress
   * (except through the iterator's own {@code remove} operation) the results of
   * the iteration are undefined.
   *
   * <p>The multiset supports element removal, which removes the corresponding
   * element from the set. It does not support the {@code add} or {@code addAll}
   * operations.
   *
   * <p>The returned multiset will be serializable if the specified set is
   * serializable. The multiset is threadsafe if the set is threadsafe.
   *
   * @param set the backing set for the returned multiset view
   */
  public static <E> Multiset<E> forSet(Set<E> set) {
    return new SetMultiset<E>(set);
  }

  /** @see Multisets#forSet */
  private static class SetMultiset<E> extends ForwardingCollection<E>
      implements Multiset<E>, Serializable {
    final Set<E> delegate;
    
    SetMultiset(Set<E> set) {
      delegate = checkNotNull(set);
    }

    @Override protected Set<E> delegate() {
      return delegate;
    }

    public int count(Object element) {
      return delegate.contains(element) ? 1 : 0;
    }

    public boolean add(E element, int occurrences) {
      throw new UnsupportedOperationException();
    }

    public int remove(Object element, int occurrences) {
      if (occurrences == 0) {
        return 0;
      }
      checkArgument(occurrences > 0);
      return removeAllOccurrences(element);
    }

    public int removeAllOccurrences(Object element) {
      return delegate.remove(element) ? 1 : 0;
    }

    transient Set<E> elementSet;
    
    public Set<E> elementSet() {
      Set<E> es = elementSet;
      return (es == null) ? elementSet = new ElementSet() : es;
    }

    transient Set<Entry<E>> entrySet;
    
    public Set<Entry<E>> entrySet() {
      Set<Entry<E>> es = entrySet;
      return (es == null) ? entrySet = new EntrySet() : es;
    }

    @Override public boolean add(E o) {
      throw new UnsupportedOperationException();
    }

    @Override public boolean addAll(Collection<? extends E> c) {
      throw new UnsupportedOperationException();
    }

    @Override public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof Multiset)) {
        return false;
      }
      Multiset<?> m = (Multiset<?>) o;
      return size() == m.size() && delegate.equals(m.elementSet());
    }

    @Override public int hashCode() {
      int sum = 0;
      for (E e : this) {
        sum += ((e == null) ? 0 : e.hashCode()) ^ 1;
      }
      return sum;
    }

    /** @see SetMultiset#elementSet */
    class ElementSet extends ForwardingSet<E> {
      @Override protected Set<E> delegate() {
        return delegate;
      }

      @Override public boolean add(E o) {
        throw new UnsupportedOperationException();
      }

      @Override public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
      }
    }

    /** @see SetMultiset#entrySet */
    class EntrySet extends AbstractSet<Entry<E>> {
      @Override public int size() {
        return delegate.size();
      }
      @Override public boolean retainAll(Collection<?> c) {
        return super.retainAll(checkNotNull(c));
      }
      @Override public Iterator<Entry<E>> iterator() {
        return new Iterator<Entry<E>>() {
          final Iterator<E> elements = delegate.iterator();

          public boolean hasNext() {
            return elements.hasNext();
          }
          public Entry<E> next() {
            return immutableEntry(elements.next(), 1);
          }
          public void remove() {
            elements.remove();
          }
        };
      }
      // TODO: faster contains, remove
    }
    
    private static final long serialVersionUID = 0;
  }

  /**
   * Returns the expected number of distinct elements given the specified
   * elements. The number of distinct elements is only computed if {@code
   * elements} is an instance of {@code Multiset}; otherwise the default value
   * of 11 is returned.
   */
  static int inferDistinctElements(Iterable<?> elements) {
    if (elements instanceof Multiset) {
      return ((Multiset<?>) elements).elementSet().size();
    }
    return 11; // initial capacity will be rounded up to 16
  }

  /**
   * Returns a comparator that orders elements according to their increasing
   * frequency in a multiset. For example, suppose {@code m} is a non-empty
   * multiset of strings. Then:
   *
   * <pre>  Collections.max(m.elementSet(), frequencyOrder(m));</pre>
   *
   * returns a string that occurs most frequently in {@code m}.
   * (Warning: in this example, {@code Collections.max} throws
   * {@code NoSuchElementException} when {@code m} is empty.)
   *
   * <p>The returned {@link Ordering} is a view into the backing multiset, so
   * the ordering's behavior will change if the backing multiset changes. This
   * can be dangerous; for example, if the ordering is used by a {@code TreeSet}
   * and the backing multiset changes, the behavior of the {@code TreeSet}
   * becomes undefined. Use a copy of the multiset to isolate against such
   * changes when necessary.
   *
   * @param multiset the multiset specifying the frequencies of the objects to
   *    compare
   */
  public static <T> Ordering<T> frequencyOrder(Multiset<?> multiset) {
    return new FrequencyOrder<T>(multiset);
  }

  /** @see Multisets#frequencyOrder(Multiset) */
  private static class FrequencyOrder<T> extends Ordering<T> {
    final Multiset<?> multiset;

    FrequencyOrder(Multiset<?> multiset) {
      this.multiset = checkNotNull(multiset);
    }

    public int compare(T left, T right) {
      int leftCount = multiset.count(left);
      int rightCount = multiset.count(right);
      return Comparators.compare(leftCount, rightCount);
    }

    @Override public boolean equals(Object object) {
      if (object instanceof FrequencyOrder) {
        FrequencyOrder<?> that = (FrequencyOrder<?>) object;
        return (this.multiset).equals(that.multiset);
      }
      return false;
    }

    @Override public int hashCode() {
      return multiset.hashCode();
    }

    @Override public String toString() {
      return "FrequencyOrder " + multiset;
    }
    
    private static final long serialVersionUID = 0;
  }
}
