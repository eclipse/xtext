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

import com.google.common.base.Nullable;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkContentsNotNull;
import static com.google.common.base.Preconditions.checkNotNull;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.ReferenceType;
import com.google.common.collect.Collections2.FilteredCollection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Static utility methods pertaining to {@link Set} instances. Also see this
 * class's counterparts {@link Lists} and {@link Maps}.
 *
 * @author Kevin Bourrillion
 * @author Jared Levy
 */
public final class Sets {
  private Sets() {}

  /**
   * Returns an immutable set instance containing the given enum elements.
   * Internally, the returned set will be backed by an {@link EnumSet}. See
   * {@link ImmutableSet} for a description of immutability. The set is
   * serializable.
   *
   * @param anElement one of the elements the set should contain
   * @param otherElements the rest of the elements the set should contain
   * @return an immutable {@code Set} instance containing those elements, minus
   *     duplicates
   */
  public static <E extends Enum<E>> Set<E> immutableEnumSet(
      E anElement, E... otherElements) {
    return Collections.unmodifiableSet(EnumSet.of(anElement, otherElements));
  }

  /**
   * Returns a new {@code EnumSet} instance containing the given elements.
   * Unlike {@link EnumSet#copyOf(Collection)}, this method does not produce an
   * exception on an empty collection, and it may be called on any iterable, not
   * just a {@code Collection}.
   */
  public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> iterable,
      Class<E> elementType) {
    /*
     * TODO: noneOf() and addAll() will both throw NullPointerExceptions when
     * appropriate. However, NullPointerTester will fail on this method because
     * it passes in Class.class instead of an enum type. This means that, when
     * iterable is null but elementType is not, noneOf() will throw a
     * ClassCastException before addAll() has a chance to throw a
     * NullPointerException. NullPointerTester considers this a failure.
     * Ideally the test would be fixed, but it would require a special case for
     * Class<E> where E extends Enum. Until that happens (if ever), leave
     * checkNotNull() here. For now, contemplate the irony that checking
     * elementType, the problem argument, is harmful, while checking iterable,
     * the innocent bystander, is effective.
     */
    checkNotNull(iterable);
    EnumSet<E> set = EnumSet.noneOf(elementType);
    Iterables.addAll(set, iterable);
    return set;
  }

  // HashSet

  /**
   * Creates an empty {@code HashSet} instance.
   *
   * <p><b>Note:</b> if {@code E} is an {@link Enum} type, use {@link
   * EnumSet#noneOf} instead.
   *
   * <p><b>Note:</b> if you need an <i>immutable</i> empty Set, use {@link
   * Collections#emptySet} instead.
   *
   * @return a newly created, empty {@code HashSet}
   */
  public static <E> HashSet<E> newHashSet() {
    return new HashSet<E>();
  }

  /**
   * Creates a {@code HashSet} instance containing the given elements.
   *
   * <p><b>Note:</b> if {@code E} is an {@link Enum} type, use {@link
   * EnumSet#of(Enum, Enum...)} instead.
   *
   * <p><b>Note:</b> if you need an immutable set without nulls, you should use
   * {@link ImmutableSet#of(Object...)}.
   *
   * <p><b>Note:</b> due to a bug in javac 1.5.0_06, we cannot support the
   * following:
   *
   * <p>{@code Set<Base> set = Sets.newHashSet(sub1, sub2);}
   *
   * <p>where {@code sub1} and {@code sub2} are references to subtypes of {@code
   * Base}, not of {@code Base} itself. To get around this, you must use:
   *
   * <p>{@code Set<Base> set = Sets.<Base>newHashSet(sub1, sub2);}
   *
   * @param elements the elements that the set should contain
   * @return a newly created {@code HashSet} containing those elements (minus
   *     duplicates)
   */
  public static <E> HashSet<E> newHashSet(E... elements) {
    int capacity = Maps.capacity(elements.length);
    HashSet<E> set = new HashSet<E>(capacity);
    Collections.addAll(set, elements);
    return set;
  }

  /**
   * Creates an empty {@code HashSet} instance with enough capacity to hold the
   * specified number of elements without rehashing.
   *
   * @param expectedSize the expected size
   * @return a newly created {@code HashSet}, empty, with enough capacity to
   *     hold {@code expectedSize} elements without rehashing.
   * @throws IllegalArgumentException if {@code expectedSize} is negative
   */
  public static <E> HashSet<E> newHashSetWithExpectedSize(int expectedSize) {
    return new HashSet<E>(Maps.capacity(expectedSize));
  }

  /**
   * Creates a {@code HashSet} instance containing the given elements.
   *
   * <p><b>Note:</b> if {@code E} is an {@link Enum} type, use
   * {@link #newEnumSet(Iterable, Class)} instead.
   *
   * <p><b>Note:</b> if you need an immutable set without nulls, you should use
   * {@link ImmutableSet#copyOf(Iterable)}.
   *
   * @param elements the elements that the set should contain
   * @return a newly created {@code HashSet} containing those elements (minus
   *     duplicates)
   */
  public static <E> HashSet<E> newHashSet(Iterable<? extends E> elements) {
    if (elements instanceof Collection) {
      @SuppressWarnings("unchecked")
      Collection<? extends E> collection = (Collection<? extends E>) elements;
      return new HashSet<E>(collection);
    } else {
      return newHashSet(elements.iterator());
    }
  }

  /**
   * Creates a {@code HashSet} instance containing the given elements.
   *
   * <p><b>Note:</b> if {@code E} is an {@link Enum} type, you should create an
   * {@link EnumSet} instead.
   *
   * <p><b>Note:</b> if you need an immutable set without nulls, you should use
   * {@link ImmutableSet}.
   *
   * @param elements the elements that the set should contain
   * @return a newly created {@code HashSet} containing those elements (minus
   *     duplicates)
   */
  public static <E> HashSet<E> newHashSet(Iterator<? extends E> elements) {
    HashSet<E> set = newHashSet();
    while (elements.hasNext()) {
      set.add(elements.next());
    }
    return set;
  }

  // ConcurrentHashSet

  private static <E> Set<E> fixedRemoveAllAndRetainAll(final Set<E> original) {
    return new ForwardingSet<E>() {
      @Override protected Set<E> delegate() {
        return original;
      }
      @Override public boolean removeAll(Collection<?> c) {
        return Iterators.removeAll(iterator(), c);
      }
      @Override public boolean retainAll(Collection<?> c) {
        return Iterators.retainAll(iterator(), c);
      }
    };
  }

  /**
   * ConcurrentHashMap wrapper whose views have {@code removeAll(null)} and
   * {@code retainAll(null)} throw a {@link NullPointerException}.
   */
  private static class ForwardingConcurrentMap<K, V>
      extends ForwardingMap<K, V> implements Serializable {
    final Map<K, V> delegate;
    
    ForwardingConcurrentMap() {
      delegate = new ConcurrentHashMap<K, V>();
    }

    ForwardingConcurrentMap(int capacity) {
      delegate = new ConcurrentHashMap<K, V>(capacity);
    }
    
    @Override protected Map<K, V> delegate() {
      return delegate;
    }
    
    transient Set<K> keySet;
    
    @Override public Set<K> keySet() {
      Set<K> result = keySet;
      return (result == null) 
          ? keySet = fixedRemoveAllAndRetainAll(delegate().keySet()) : result;
    }
    
    static final long serialVersionUID = 0;    
  }
  
  /**
   * Creates a thread-safe set backed by a hash map. The set is backed by a
   * {@link ConcurrentHashMap} instance, and thus carries the same concurrency
   * guarantees.
   *
   * <p>Unlike {@code HashSet}, this class does NOT allow {@code null} to be
   * used as an element. The set is serializable.
   *
   * @return a newly created, empty thread-safe {@code Set}
   */
  public static <E> Set<E> newConcurrentHashSet() {
    Map<E, Boolean> delegate = new ForwardingConcurrentMap<E, Boolean>();
    return newSetFromMap(delegate);
  }

  /**
   * Creates a thread-safe set backed by a hash map and containing the given
   * elements. The set is backed by a {@link ConcurrentHashMap} instance, and
   * thus carries the same concurrency guarantees.
   *
   * <p>Unlike {@code HashSet}, this class does NOT allow {@code null} to be
   * used as an element. The set is serializable.
   *
   * <p>Please see the notice in {@link #newHashSet(Object...)} about a relevant
   * javac bug.
   *
   * @param elements the elements that the set should contain
   * @return a newly created thread-safe {@code Set} containing those elements
   *     (minus duplicates)
   * @throws NullPointerException if any of the elements is null
   */
  public static <E> Set<E> newConcurrentHashSet(E... elements) {
    int capacity = Maps.capacity(elements.length);
    Map<E, Boolean> delegate
        = new ForwardingConcurrentMap<E, Boolean>(capacity);
    Set<E> set = newSetFromMap(delegate);
    Collections.addAll(set, elements);
    return set;
  }

  /**
   * Creates a thread-safe set backed by a hash map and containing the given
   * elements. The set is backed by a {@link ConcurrentHashMap} instance, and
   * thus carries the same concurrency guarantees.
   *
   * <p>Unlike {@code HashSet}, this class does NOT allow {@code null} to be
   * used as an element. The set is serializable.
   *
   * @param elements the elements that the set should contain
   * @return a newly created thread-safe {@code Set} containing those elements
   *     (minus duplicates)
   * @throws NullPointerException if {@code elements} or any of its contents is
   *      null
   */
  public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> elements)
  {
    return newConcurrentHashSet(elements.iterator());
  }

  /**
   * Creates a thread-safe set backed by a hash map and containing the given
   * elements. The set is backed by a {@link ConcurrentHashMap} instance, and
   * thus carries the same concurrency guarantees.
   *
   * <p>Unlike {@code HashSet}, this class does NOT allow {@code null} to be
   * used as an element. The set is serializable.
   *
   * @param elements the elements that the set should contain
   * @return a newly created thread-safe {@code Set} containing those elements
   *     (minus duplicates)
   * @throws NullPointerException if {@code elements} or any of its contents is
   *     null
   */
  public static <E> Set<E> newConcurrentHashSet(Iterator<? extends E> elements)
  {
    Set<E> set = newConcurrentHashSet();
    while (elements.hasNext()) {
      set.add(elements.next());
    }
    return set;
  }

  // LinkedHashSet

  /**
   * Creates an empty {@code LinkedHashSet} instance.
   *
   * @return a newly created, empty {@code LinkedHashSet}
   */
  public static <E> LinkedHashSet<E> newLinkedHashSet() {
    return new LinkedHashSet<E>();
  }

  /**
   * Creates a {@code LinkedHashSet} instance containing the given elements.
   *
   * <p><b>Note:</b> if you need an immutable set without nulls, you should use
   * {@link ImmutableSet#copyOf(Iterable)}.
   *
   * @param elements the elements that the set should contain, in order
   * @return a newly created {@code LinkedHashSet} containing those elements
   *     (minus duplicates)
   */
  public static <E> LinkedHashSet<E> newLinkedHashSet(
      Iterable<? extends E> elements) {
    LinkedHashSet<E> set = newLinkedHashSet();
    Iterables.addAll(set, elements);
    return set;
  }

  // TreeSet, without Comparator

  /**
   * Creates an empty {@code TreeSet} instance sorted by the natural sort
   * ordering of its elements.
   *
   * @return a newly created, empty {@code TreeSet}
   */
  @SuppressWarnings("unchecked")  // allow ungenerified Comparable types
  public static <E extends Comparable> TreeSet<E> newTreeSet() {
    return new TreeSet<E>();
  }

  /**
   * Creates a {@code TreeSet} instance containing the given elements sorted by
   * their natural ordering.
   *
   * <p><b>Note:</b> if you need an immutable sorted set without nulls, you
   * should use {@link ImmutableSortedSet#of(Comparable...)}.
   * 
   * <p>Please see the notice in {@link #newHashSet(Object...)} about a relevant
   * javac bug.
   *
   * @param elements the elements that the set should contain
   * @return a newly created {@code TreeSet} containing those elements (minus
   *     duplicates)
   */
  @SuppressWarnings("unchecked")  // allow ungenerified Comparable types
  public static <E extends Comparable> TreeSet<E> newTreeSet(E... elements) {
    TreeSet<E> set = newTreeSet();
    Collections.addAll(set, elements);
    return set;
  }

  /**
   * Creates a {@code TreeSet} instance containing the given elements sorted by
   * their natural ordering.
   *
   * <p><b>Note:</b> If {@code elements} is a {@code SortedSet} with an explicit
   * comparator, this method has different behavior than
   * {@link TreeSet#TreeSet(SortedSet)}, which returns a {@code TreeSet} with
   * that comparator.  
   *
   * <p><b>Note:</b> if you need an immutable sorted set without nulls, you
   * should use {@link ImmutableSortedSet#copyOf(Iterable)}.
   * 
   * @param elements the elements that the set should contain
   * @return a newly created {@code TreeSet} containing those elements (minus
   *     duplicates)
   */
  @SuppressWarnings("unchecked")  // allow ungenerified Comparable types
  public static <E extends Comparable> TreeSet<E> newTreeSet(
      Iterable<? extends E> elements) {
    return newTreeSet(elements.iterator());
  }

  /**
   * Creates a {@code TreeSet} instance containing the given elements sorted by
   * their natural ordering.
   *
   * @param elements the elements that the set should contain
   * @return a newly created {@code TreeSet} containing those elements (minus
   *     duplicates)
   */
  @SuppressWarnings("unchecked")  // allow ungenerified Comparable types
  public static <E extends Comparable> TreeSet<E> newTreeSet(
      Iterator<? extends E> elements) {
    TreeSet<E> set = newTreeSet();
    while (elements.hasNext()) {
      set.add(elements.next());
    }
    return set;
  }

  // TreeSet, with Comparator

  /**
   * Creates an empty {@code TreeSet} instance with the given comparator.
   *
   * @param comparator the comparator to use to sort the set
   * @return a newly created, empty {@code TreeSet}
   * @throws NullPointerException if {@code comparator} is null
   */
  public static <E> TreeSet<E> newTreeSet(Comparator<? super E> comparator) {
    return new TreeSet<E>(checkNotNull(comparator));
  }

  /**
   * Creates a {@code TreeSet} instance containing the given elements sorted by
   * the given comparator.
   *
   * <p><b>Note:</b> if you need an immutable sorted set without nulls, you
   * should use {@code ImmutableSortedSet.orderedBy(comparator).of(elements)}.
   * 
   * <p>Please see the notice in {@link #newHashSet(Object...)} about a relevant
   * javac bug.
   *
   * @param comparator the comparator to use to sort the set
   * @param elements the elements that the set should contain
   * @return a newly created {@code TreeSet} containing those elements (minus
   *     duplicates)
   * @throws NullPointerException if {@code comparator} is null
   */
  public static <E> TreeSet<E> newTreeSet(
      Comparator<? super E> comparator, E... elements) {
    TreeSet<E> set = newTreeSet(comparator);
    Collections.addAll(set, elements);
    return set;
  }

  /**
   * Creates a {@code TreeSet} instance containing the given elements sorted by
   * the given comparator.
   *
   * <p><b>Note:</b> if you need an immutable sorted set without nulls, you
   * should use {@code ImmutableSortedSet.orderedBy(comparator).of(elements)}
   * instead.
   * 
   * @param comparator the comparator to use to sort the set
   * @param elements the elements that the set should contain
   * @return a newly created {@code TreeSet} containing those elements (minus
   *     duplicates)
   * @throws NullPointerException if {@code comparator} or {@code elements} is
   *     null
   */
  public static <E> TreeSet<E> newTreeSet(
      Comparator<? super E> comparator, Iterable<? extends E> elements) {
    return newTreeSet(comparator, elements.iterator());
  }

  /**
   * Creates a {@code TreeSet} instance containing the given elements sorted by
   * the given comparator.
   *
   * @param comparator the comparator to use to sort the set
   * @param elements the elements that the set should contain
   * @return a newly created {@code TreeSet} containing those elements (minus
   *     duplicates)
   * @throws NullPointerException if {@code comparator} or {@code elements} is
   *     null
   */
  public static <E> TreeSet<E> newTreeSet(
      Comparator<? super E> comparator, Iterator<? extends E> elements) {
    TreeSet<E> set = newTreeSet(comparator);
    while (elements.hasNext()) {
      set.add(elements.next());
    }
    return set;
  }

  /**
   * Creates an empty {@code Set} that uses identity to determine equality. It
   * compares object references, instead of calling {@code equals}, to
   * determine whether a provided object matches an element in the set. For
   * example, {@code contains} returns {@code false} when passed an object that
   * equals a set member, but isn't the same instance. This behavior is similar
   * to the way {@link IdentityHashMap} handles key lookups.
   * 
   * <p>The {@code referenceType} parameter specifies the kind of reference that
   * the returned set uses: {@link ReferenceType#STRONG},
   * {@link ReferenceType#WEAK}, or {@link ReferenceType#SOFT}. The returned set
   * is thread-safe when the reference type is {@link ReferenceType#WEAK} or
   * {@link ReferenceType#SOFT}, but not when the reference type is
   * {@link ReferenceType#STRONG}. 
   * 
   * @throws IllegalArgumentException if {@code referenceType} is
   *     {@link ReferenceType#PHANTOM}
   */
  public static <E> Set<E> newIdentityHashSet(ReferenceType referenceType) {
    Map<E, Boolean> map;
    if (referenceType == ReferenceType.STRONG) {
      map = new IdentityHashMap<E, Boolean>();
    } else {
      map = new ReferenceMap<E, Boolean>(referenceType, ReferenceType.STRONG);
    }
    return newSetFromMap(map);
  }  

  /**
   * Creates an {@code EnumSet} consisting of all enum values that are not in
   * the specified collection. If the collection is an {@link EnumSet}, this
   * method has the same behavior as {@link EnumSet#complementOf}. Otherwise,
   * the specified collection must contain at least one element, in order to
   * determine the element type. If the collection could be empty, use
   * {@link #complementOf(Collection,Class)} instead of this method.
   * 
   * @param collection the collection whose complement should be stored in the
   *     enum set
   * @return a new, modifiable {@code EnumSet} containing all values of the enum
   *     that aren't present in the given collection
   * @throws IllegalArgumentException if {@code collection} is not an
   *     {@code EnumSet} instance and contains no elements
   */
  public static <E extends Enum<E>> EnumSet<E> complementOf(
      Collection<E> collection) {
    if (collection instanceof EnumSet) {
      return EnumSet.complementOf((EnumSet<E>) collection);
    }
    checkArgument(!collection.isEmpty(),
        "collection is empty; use the other version of this method");
    Class<E> type = collection.iterator().next().getDeclaringClass();
    return makeComplementByHand(collection, type);
  }

  /**
   * Creates an {@code EnumSet} consisting of all enum values that are not in
   * the specified collection. This is equivalent to
   * {@link EnumSet#complementOf}, but can act on any input collection, as long
   * as the elements are of enum type.
   * 
   * @param collection the collection whose complement should be stored in the
   *     {@code EnumSet} 
   * @param type the type of the elements in the set 
   * @return a new, modifiable {@code EnumSet} initially containing all the
   *     values of the enum not present in the given collection
   */
  public static <E extends Enum<E>> EnumSet<E> complementOf(
      Collection<E> collection, Class<E> type) {
    checkNotNull(collection);
    return (collection instanceof EnumSet)
        ? EnumSet.complementOf((EnumSet<E>) collection)
        : makeComplementByHand(collection, type);
  }

  private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(
      Collection<E> collection, Class<E> type) {
    EnumSet<E> result = EnumSet.allOf(type);
    result.removeAll(collection);
    return result;
  }

  /*
   * Regarding newSetForMap() and SetFromMap: 
   * 
   * Written by Doug Lea with assistance from members of JCP JSR-166
   * Expert Group and released to the public domain, as explained at
   * http://creativecommons.org/licenses/publicdomain
   */

  /**
   * Returns a set backed by the specified map. The resulting set displays
   * the same ordering, concurrency, and performance characteristics as the
   * backing map. In essence, this factory method provides a {@link Set}
   * implementation corresponding to any {@link Map} implementation. There is no
   * need to use this method on a {@link Map} implementation that already has a
   * corresponding {@link Set} implementation (such as {@link HashMap} or
   * {@link TreeMap}).
   *
   * <p>Each method invocation on the set returned by this method results in
   * exactly one method invocation on the backing map or its <tt>keySet</tt>
   * view, with one exception. The <tt>addAll</tt> method is implemented as a
   * sequence of <tt>put</tt> invocations on the backing map.
   *
   * <p>The specified map must be empty at the time this method is invoked,
   * and should not be accessed directly after this method returns. These
   * conditions are ensured if the map is created empty, passed directly
   * to this method, and no reference to the map is retained, as illustrated
   * in the following code fragment:
   * <pre>
   *    Set&lt;Object&gt; identityHashSet = Sets.newSetFromMap(
   *        new IdentityHashMap&lt;Object, Boolean&gt;()); </pre>
   *
   * This method has the same behavior as the JDK 6 method
   * {@code Collections.newSetFromMap()}. The returned set is serializable if
   * the backing map is.
   * 
   * @param map the backing map
   * @return the set backed by the map
   * @throws IllegalArgumentException if <tt>map</tt> is not empty
   */
  public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
    return new SetFromMap<E>(map);
  }

  private static class SetFromMap<E> extends AbstractSet<E>
      implements Set<E>, Serializable {
    private final Map<E, Boolean> m; // The backing map
    private transient Set<E> s; // Its keySet

    SetFromMap(Map<E, Boolean> map) {
      checkArgument(map.isEmpty(), "Map is non-empty");
      m = map;
      s = map.keySet();
    }

    @Override public void clear() {
      m.clear();
    }
    @Override public int size() {
      return m.size();
    }
    @Override public boolean isEmpty() {
      return m.isEmpty();
    }
    @Override public boolean contains(Object o) {
      return m.containsKey(o);
    }
    @Override public boolean remove(Object o) {
      return m.remove(o) != null;
    }
    @Override public boolean add(E e) {
      return m.put(e, Boolean.TRUE) == null;
    }
    @Override public Iterator<E> iterator() {
      return s.iterator();
    }
    @Override public Object[] toArray() {
      return s.toArray();
    }
    @Override public <T> T[] toArray(T[] a) {
      return s.toArray(a);
    }
    @Override public String toString() {
      return s.toString();
    }
    @Override public int hashCode() {
      return s.hashCode();
    }
    @Override public boolean equals(Object o) {
      return (o == this) || s.equals(o);
    }
    @Override public boolean containsAll(Collection<?> c) {
      return s.containsAll(c);
    }
    @Override public boolean removeAll(Collection<?> c) {
      return s.removeAll(c);
    }
    @Override public boolean retainAll(Collection<?> c) {
      return s.retainAll(c);
    }

    // addAll is the only inherited implementation

    static final long serialVersionUID = 0;

    private void readObject(ObjectInputStream stream)
        throws IOException, ClassNotFoundException {
      stream.defaultReadObject();
      s = m.keySet();
    }
  }

  /**
   * An unmodifiable view of a set which may be backed by other sets; this view
   * will change as the backing sets do. Contains methods to copy the data into
   * a new set which will then remain stable.
   */
  public static abstract class SetView<E> extends AbstractSet<E> {
    /**
     * Returns an immutable copy of the current contents of this set view.
     * Does not support null elements.
     */
    public ImmutableSet<E> immutableCopy() {
      return ImmutableSet.copyOf(this);
    }

    /**
     * Copies the current contents of this set view into an existing set. This
     * method has equivalent behavior to {@code set.addAll(this)}, assuming that
     * all the sets involved are based on the same notion of equivalence.
     */
    // TODO: add wildcard when we get a fixed javac (e.g. openjdk7)
    public <S extends Set</*? super */E>> S copyInto(S set) {
      set.addAll(this);
      return set;
    }
  }

  /**
   * Returns an unmodifiable <b>view</b> of the union of two sets. The returned
   * set contains all elements that are contained in either backing set.
   * Iterating over the returned set iterates first over all the elements of
   * {@code set1}, then over each element of {@code set2}, in order, that is not
   * contained in {@code set1}.
   *
   * <p>Results are undefined if {@code set1} and {@code set2} are sets based on
   * different equivalence relations (as {@link HashSet}, {@link TreeSet}, and
   * the {@link Map#keySet} of an {@link java.util.IdentityHashMap} all are).
   */
  public static <E> SetView<E> union(
      final Set<? extends E> set1, final Set<? extends E> set2) {
    // TODO: check if sorted sets with same comparator?
    final Set<? extends E> set2minus1 = difference(set2, set1);
    final Iterable<E> iterable = Iterables.concat(set1, set2minus1);

    return new SetView<E>() {
      @Override public int size() {
        return set1.size() + set2minus1.size();
      }
      @Override public boolean isEmpty() {
        return set1.isEmpty() && set2.isEmpty();
      }
      @Override public Iterator<E> iterator() {
        return Iterators.unmodifiableIterator(iterable.iterator());
      }
      @Override public boolean contains(Object object) {
        return set1.contains(object) || set2.contains(object);
      }
      @Override public <S extends Set<E>> S copyInto(S set) {
        set.addAll(set1);
        set.addAll(set2);
        return set;
      }
    };
  }

  /**
   * Returns an unmodifiable <b>view</b> of the intersection of two sets. The
   * returned set contains all elements that are contained by both backing sets.
   * The iteration order of the returned set matches that of {@code set1}.
   *
   * <p>Results are undefined if {@code set1} and {@code set2} are sets based
   * on different equivalence relations (as {@code HashSet}, {@code TreeSet},
   * and the keySet of an {@code IdentityHashMap} all are).
   */
  public static <E> SetView<E> intersection(
      final Set<E> set1, final Set<?> set2) {
    // TODO: check if sorted sets with same comparator?
    checkNotNull(set1);
    final Predicate<Object> inSet2 = Predicates.in(set2);
    return new SetView<E>() {
      @Override public Iterator<E> iterator() {
        return Iterators.filter(set1.iterator(), inSet2);
      }
      @Override public int size() {
        return Iterators.size(iterator());
      }
      @Override public boolean isEmpty() {
        return Collections.disjoint(set1, set2);
      }
      @Override public boolean contains(Object object) {
        return set1.contains(object) && set2.contains(object);
      }
      @Override public boolean containsAll(Collection<?> collection) {
        return set1.containsAll(collection)
            && set2.containsAll(collection);
      }
    };
  }

  /**
   * Returns an unmodifiable <b>view</b> of the difference of two sets. The
   * returned set contains all elements that are contained by {@code set1} and
   * not contained by {@code set2}. {@code set2} may also contain elements not
   * present in {@code set1}; these are simply ignored. The iteration order of
   * the returned set matches that of {@code set1}.
   *
   * <p>Results are undefined if {@code set1} and {@code set2} are sets based
   * on different equivalence relations (as {@code HashSet}, {@code TreeSet},
   * and the keySet of an {@code IdentityHashMap} all are).
   */
  public static <E> SetView<E> difference(
      final Set<E> set1, final Set<?> set2) {
    // TODO: check if sorted sets with same comparator?
    checkNotNull(set1);
    final Predicate<Object> notInSet2 = Predicates.not(Predicates.in(set2));
    return new SetView<E>() {
      @Override public Iterator<E> iterator() {
        return Iterators.filter(set1.iterator(), notInSet2);
      }
      @Override public int size() {
        return Iterators.size(iterator());
      }
      @Override public boolean isEmpty() {
        return set2.containsAll(set1);
      }
      @Override public boolean contains(Object element) {
        return set1.contains(element) && !set2.contains(element);
      }
      @Override public boolean containsAll(Collection<?> collection) {
        return set1.containsAll(collection)
            && Collections.disjoint(set2, collection);
      }
    };
  }

  /**
   * Returns the elements of {@code unfiltered} that satisfy a predicate. The
   * returned set is a live view of {@code unfiltered}; changes to one affect
   * the other.
   * 
   * <p>The resulting set's iterator does not support {@code remove()}, but all
   * other set methods are supported. The set's {@code add()} and
   * {@code addAll()} methods throw an {@link IllegalArgumentException} if an
   * element that doesn't satisfy the predicate is provided. When methods such
   * as {@code removeAll()} and {@code clear()} are called on the filtered set,
   * only elements that satisfy the filter will be removed from the underlying
   * collection.
   * 
   * <p>The returned set isn't threadsafe or serializable, even if
   * {@code unfiltered} is.
   * 
   * <p>Many of the filtered set's methods, such as {@code size()}, iterate
   * across every element in the underlying set and determine which elements
   * satisfy the filter. When a live view is <i>not</i> needed, it may be faster
   * to copy the filtered set and use the copy.
   * 
   * <p>The {@code clear()}, {@code removeAll()}, and {@code retainAll()} 
   * methods all call {@link Iterator#remove()} on the underlying collection's
   * iterator. Consequently, methods like the following throw an
   * {@link UnsupportedOperationException}. 
   * <pre>  Sets.filter(Sets.filter(set, predicate1),
   *     predicate2)).clear();</pre> 
   * Instead, call
   * {@link com.google.common.base.Predicates#and(Predicate, Predicate)} to
   * combine the predicates and pass the combined predicate to this method.
   * 
   */
  public static <T> Set<T> filter(
      Set<T> unfiltered, Predicate<? super T> predicate) {
    return new FilteredSet<T>(unfiltered, predicate);
  }
  
  private static class FilteredSet<E> extends FilteredCollection<E>
      implements Set<E> {
    FilteredSet(Set<E> unfiltered, Predicate<? super E> predicate) {
      super(unfiltered, predicate);
    }
    
    @Override public boolean equals(Object obj) {
      return equalsImpl(this, obj);
    }
    
    @Override public int hashCode() {
      return hashCodeImpl(this);
    }
  }
  
  /*
   * Standard implementations from AbstractSet. 
   */  
  
  /**
   * Compares the specified object with the specified set for equality. Returns
   * true if the specified object is also set, the two sets have the same size,
   * and every member of the set {@code o} is contained in the set {@code s}.
   *
   * <p>This method first checks if the object {@code o} is the set {@code s};
   * if so it returns true. Then, it checks if {@code o} is a set whose size is
   * identical to the size of {@code s}; if not, it returns false. If so, it
   * returns {@code s.containsAll((Collection) o)}.
   *
   * @param s the set to be compared for equality with the specified object
   * @param o the object to be compared for equality with the specified set
   * @return true if the object {@code o} is equal to the set {@code s}
   * @see java.util.AbstractSet#equals(Object)
   */
  static boolean equalsImpl(Set<?> s, Object o) {
    if (o == s) {
      return true;
    }
    if (!(o instanceof Set)) {
      return false;
    }
    Set<?> os = (Set<?>) o;
    if (os.size() != s.size()) {
      return false;
    }
    return s.containsAll(os);
  }

  /**
   * Calculates and returns the hash code of {@code s}.
   */
  static int hashCodeImpl(Set<?> s) {
    int hashCode = 0;
    for (Object o : s) {
      hashCode += o != null ? o.hashCode() : 0;
    }
    return hashCode;
  }
}
