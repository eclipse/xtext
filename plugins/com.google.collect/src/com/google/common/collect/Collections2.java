/*
 * Copyright (C) 2008 Google Inc.
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

import com.google.common.base.Predicate;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Provides static methods for working with {@code Collection} instances.
 * 
 * @author Chris Povirk
 * @author Mike Bostock
 * @author Jared Levy
 */
public final class Collections2 {
  private Collections2() {}

  /**
   * Returns a limited {@link Collection} view of the given {@link Iterable}, or
   * the {@code Iterable} itself if it is already a {@code Collection} (in which
   * case the rest of this documentation does not apply). The returned
   * collection is not appropriate for general use for a number of reasons.
   * Instead, it exists to provide frequently desired methods for dealing with
   * {@code Iterable} objects -- such as
   * {@link Collection#removeAll(Collection)} -- through the familiar
   * {@code Collection} interface. To treat the contents of an {@code Iterable}
   * as a full-fledged, performant {@code Collection}, it is recommended that
   * clients call a method like {@link ImmutableSet#copyOf(Iterable)} or
   * {@link Iterables#addAll(Collection, Iterable)} to dump the contents of the
   * {@code Iterable} into a standard {@code Collection}. For cases in which a
   * view of the {@code Iterable} is required, {@code forIterable()} is
   * available.
   * 
   * <p>A number of limitations result from building on the {@code Iterable}
   * interface. Notably, {@code size()}, {@code contains()}, and many other
   * methods of the returned collection are O(n). The returned collection does
   * not support the insertion of items. Removal of elements is supported if the
   * underlying {@code Iterable} supports it, and all non-mutative operations
   * are supported. Additionally, each method call on the returned collection
   * calls {@link Iterable#iterator()} on the source {@code Iterable}. Thus, if
   * you wish to call more than one method on the collection or to otherwise
   * access the contents of the {@code Iterable} after calling a method, the
   * {@code Iterable} must support the creation of multiple iterators.
   * 
   * <p>{@link #equals(Object)} and {@link #hashCode()} are inherited from
   * {@link Object}, as the returned {@code Collection} is not an implementation
   * of any additional interface, such as {@link java.util.List} or
   * {@link java.util.Set}.
   * 
   * <p>The behavior of the returned collection's iterator in the face of
   * concurrent structural modification of the returned collection or of the
   * underlying {@code Iterable} is undefined, and no guarantee is made that the
   * objects are fail-fast.
   * 
   * <p><b>Usage Example</b>
   * 
   * <pre>
   * // Remove all instances of "foo" from an Iterable:
   * Collections2.forIterable(iterable).removeAll(ImmutableSet.of("foo"));
   * </pre>
   */
  public static <T> Collection<T> forIterable(final Iterable<T> iterable) {
    checkNotNull(iterable);

    if (iterable instanceof Collection) {
      return (Collection<T>) iterable;
    }

    return new AbstractCollection<T>() {
      @Override public Iterator<T> iterator() {
        return iterable.iterator();
      }

      @Override public int size() {
        return Iterables.size(iterable);
      }

      @Override public boolean isEmpty() {
        return Iterables.isEmpty(iterable);
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
   * Returns {@code true} if the collection {@code self} contains all of the
   * elements in the collection {@code c}.
   *
   * <p>This method iterates over the specified collection {@code c}, checking
   * each element returned by the iterator in turn to see if it is contained in
   * the specified collection {@code self}. If all elements are so contained,
   * {@code true} is returned, otherwise {@code false}.
   *
   * @param self a collection which might contain all elements in {@code c}
   * @param c a collection whose elements might be contained by {@code self}
   */
  // TODO: Make public?
  static boolean containsAll(Collection<?> self, Collection<?> c) {
    checkNotNull(self);
    for (Object o : c) {
      if (!self.contains(o)) {
        return false;
      }
    }
    return true;
  }  
  
  /**
   * Converts an iterable into a collection. If the iterable is already a
   * collection, it is returned. Otherwise, an {@link java.util.ArrayList} is
   * created with the contents of the iterable in same iteration order.
   */
  static <E> Collection<E> toCollection(Iterable<E> iterable) {
    return (iterable instanceof Collection)
        ? (Collection<E>) iterable : Lists.newArrayList(iterable);
  }
  
  /**
   * Returns the elements of {@code unfiltered} that satisfy a predicate. The
   * returned collection is a live view of {@code unfiltered}; changes to one
   * affect the other.
   * 
   * <p>The resulting collection's iterator does not support {@code remove()},
   * but all other collection methods are supported. The collection's
   * {@code add()} and {@code addAll()} methods throw an
   * {@link IllegalArgumentException} if an element that doesn't satisfy the
   * predicate is provided. When methods such as {@code removeAll()} and
   * {@code clear()} are called on the filtered collection, only elements that
   * satisfy the filter will be removed from the underlying collection.
   * 
   * <p>The returned collection isn't threadsafe or serializable, even if
   * {@code unfiltered} is.
   * 
   * <p>Many of the filtered collection's methods, such as {@code size()},
   * iterate across every element in the underlying collection and determine
   * which elements satisfy the filter. When a live view is <i>not</i> needed,
   * it may be faster to copy the filtered collection and use the copy.
   * 
   * <p>The {@code clear()}, {@code removeAll()}, and {@code retainAll()} 
   * methods all call {@link Iterator#remove()} on the underlying collection's
   * iterator. Consequently, methods like the following throw an
   * {@link UnsupportedOperationException}. 
   * <pre>  Collections2.filter(Collections2.filter(collection, predicate1),
   *     predicate2)).clear();</pre> 
   * Instead, call
   * {@link com.google.common.base.Predicates#and(Predicate, Predicate)} to
   * combine the predicates and pass the combined predicate to this method.
   * 
   */
  public static <T> Collection<T> filter(
      Collection<T> unfiltered, Predicate<? super T> predicate) {
    return new FilteredCollection<T>(unfiltered, predicate);
  }
  
  static class FilteredCollection<T> implements Collection<T> {
    private final Collection<T> unfiltered;
    private final Predicate<? super T> predicate;
    
    FilteredCollection(Collection<T> unfiltered,
        Predicate<? super T> predicate) {
      this.unfiltered = checkNotNull(unfiltered);
      this.predicate = checkNotNull(predicate);
    }

    public boolean add(T element) {
      checkArgument(predicate.apply(element)); 
      return unfiltered.add(element);
    }

    public boolean addAll(Collection<? extends T> collection) {
      for (T element : collection) {
        checkArgument(predicate.apply(element)); 
      }
      return unfiltered.addAll(collection);
    }

    public void clear() {
      Iterator<T> iterator = unfiltered.iterator();
      while (iterator.hasNext()) {
        T element = iterator.next();
        if (predicate.apply(element)) {
          iterator.remove();
        }
      }
    }

    // if a ClassCastException occurs, contains() returns false
    @SuppressWarnings("unchecked") 
    public boolean contains(Object element) {
      try {
        return predicate.apply((T) element) && unfiltered.contains(element);
      } catch (NullPointerException e) {
        return false;
      } catch (ClassCastException e) {
        return false;
      }
    }

    public boolean containsAll(Collection<?> collection) {
      for (Object element : collection) {
        if (!contains(element)) {
          return false;
        }
      }
      return true;
    }

    public boolean isEmpty() {
      return !Iterators.any(unfiltered.iterator(), predicate);
    }

    public Iterator<T> iterator() {
      return Iterators.filter(unfiltered.iterator(), predicate);
    }

    // if a ClassCastException occurs, remove() returns false
    @SuppressWarnings("unchecked") 
    public boolean remove(Object element) {
      try {
        return predicate.apply((T) element) && unfiltered.remove(element);
      } catch (NullPointerException e) {
        return false;
      } catch (ClassCastException e) {
        return false;
      }
    }

    public boolean removeAll(Collection<?> collection) {
      checkNotNull(collection);
      boolean changed = false;
      Iterator<T> iterator = unfiltered.iterator();
      while (iterator.hasNext()) {
        T element = iterator.next();
        if (predicate.apply(element) && collection.contains(element)) {
          iterator.remove();
          changed = true;
        }
      }
      return changed;
    }

    public boolean retainAll(Collection<?> collection) {
      checkNotNull(collection);
      boolean changed = false;
      Iterator<T> iterator = unfiltered.iterator();
      while (iterator.hasNext()) {
        T element = iterator.next();
        if (predicate.apply(element) && !collection.contains(element)) {
          iterator.remove();
          changed = true;
        }
      }
      return changed;
    }

    public int size() {
      return Iterators.size(iterator());
    }

    public Object[] toArray() {
      // creating an ArrayList so filtering happens once      
      return Lists.newArrayList(iterator()).toArray();
    }

    @SuppressWarnings("hiding")
	public <T> T[] toArray(T[] array) {
      return Lists.newArrayList(iterator()).toArray(array);
    }
    
    @Override public String toString() {
      return Iterators.toString(iterator());
    }
  }
}
