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

import com.google.common.base.FinalizableSoftReference;
import com.google.common.base.FinalizableWeakReference;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import com.google.common.base.ReferenceType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * A {@code ConcurrentMap} implementation that internally utilizes your choice
 * of strong, soft or weak references for its keys and for its values. As soon
 * as any key or value is reclaimed by the garbage collector, the corresponding
 * entry automatically disappears from the map.
 *
 * <p>All nine possible combinations of reference types are supported, although
 * using strong keys with strong values provides no benefit over using a {@code
 * Map} or {@code ConcurrentMap} directly. This implementation does not permit
 * null keys or values.
 *
 * <p><b>Note:</b> because garbage collection happens concurrently to your
 * program, it follows that this map is always subject to concurrent
 * modifications, whether or not the caller exposes it to multiple application
 * threads. The usual caveats about the reliability of methods such as {@link
 * #size} and {@link Map#equals} apply; for example, {@link #size} may be
 * observed to remain unchanged for a short time after an entry was reclaimed.
 *
 * <p>To determine equality to a key, this implementation uses
 * {@link Object#equals} for strong references, and identity-based equality for
 * soft and weak references. In other words, for a map with weak or soft key
 * references, {@link #get} returns {@code null} when passed an object that
 * equals a map key, but isn't the same instance. This behavior is similar to
 * the way {@link IdentityHashMap} handles key lookups. However, to determine
 * value equality, as occurs when {@link #containsValue} is called, the
 * {@code ReferenceMap} always uses {@code equals}, regardless of the value
 * reference type.
 *
 * <p><b>Note:</b> {@code new ReferenceMap(WEAK, STRONG)} is very nearly a
 * drop-in replacement for {@link WeakHashMap}, but improves upon this by using
 * only identity-based equality for keys. When possible, {@code ReferenceMap}
 * should be preferred over the JDK collection, for its concurrency and greater
 * flexibility.
 *
 * <p>Though this class implements {@link Serializable}, serializing reference
 * maps with weak or soft references leads to unpredictable results.
 *
 * @author Bob Lee
 * @author Kevin Bourrillion
 */
public final class ReferenceMap<K, V> extends AbstractMap<K, V>
    implements ConcurrentMap<K, V>, Serializable {
  private final ReferenceStrategy keyStrategy;
  private final ReferenceStrategy valueStrategy;

  /*
   * The keys in this map are either of type K, SoftReference<K>, or
   * WeakReference<K>, depending on the chosen keyReferenceType; and likewise
   * for the values.
   */
  private transient ConcurrentMap<Object, Object> delegate;

  /**
   * Constructs an empty instance, using the given reference types for keys and
   * values.
   */
  public ReferenceMap(
      ReferenceType keyReferenceType, ReferenceType valueReferenceType) {
    this(keyReferenceType, valueReferenceType,
        new ConcurrentHashMap<Object, Object>());
  }

  /**
   * Constructs an empty instance, using the given backing map and the given
   * reference types for keys and values.
   */
  public ReferenceMap(ReferenceType keyReferenceType, ReferenceType
      valueReferenceType, ConcurrentMap<Object, Object> backingMap) {
    checkArgument(keyReferenceType != ReferenceType.PHANTOM,
        "Phantom references are not supported.");
    checkArgument(valueReferenceType != ReferenceType.PHANTOM,
        "Phantom references are not supported.");
    checkArgument(backingMap.isEmpty(), "The backing map must be empty.");
    
    keyStrategy = ReferenceStrategy.forType(keyReferenceType);
    valueStrategy = ReferenceStrategy.forType(valueReferenceType);
    delegate = backingMap;
  }
 
  /*
   * Specifying Javadoc for many classes so the AbstractMap Javadoc, which
   * includes incorrect implementation details, is not displayed.
   */

  // Query Operations

  /**
   * Returns the number of key-value mappings in this map.
   */
  @Override public int size() {
    return delegate.size();
  }

  /**
   * Returns {@code true} if this map contains no key-value mappings.
   */
  @Override public boolean isEmpty() {
    return delegate.isEmpty();
  }

  /**
   * Returns {@code true} if this map contains a mapping for the specified key.
   */
  @Override public boolean containsKey(Object key) {
    Object keyDummy = keyStrategy.getDummyFor(key);
    return delegate.containsKey(keyDummy);
  }

  /**
   * Returns {@code true} if this map maps one or more keys to the specified
   * value. 
   */
  @Override public boolean containsValue(Object value) {
    checkNotNull(value);
    for (Object valueReference : delegate.values()) {
      if (value.equals(dereferenceValue(valueReference))) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the value to which the specified key is mapped, or {@code null} if
   * this map contains no mapping for the key.
   */
  @Override public V get(Object key) {
    Object keyDummy = keyStrategy.getDummyFor(key);
    Object valueReference = delegate.get(keyDummy);
    return dereferenceValue(valueReference);
  }

  // Modification Operations

  /**
   * Associates the specified value with the specified key in this map.
   */
  @Override public V put(K key, V value) {
    Object keyReference = referenceKey(key);
    Object valueReference = referenceValue(keyReference, value);
    return dereferenceValue(delegate.put(keyReference, valueReference));
  }

  public V putIfAbsent(K key, V value) {
    Object keyReference = referenceKey(key);
    Object valueReference = referenceValue(keyReference, value);

    Object existingValueReference;
    V existingValue;
    do {
      existingValueReference
          = delegate.putIfAbsent(keyReference, valueReference);
      existingValue = dereferenceValue(existingValueReference);
    } while (isPartiallyReclaimed(existingValueReference, existingValue));

    return existingValue;
  }

  public V replace(K key, V value) {
    Object keyReference = referenceKey(key);
    Object valueReference = referenceValue(keyReference, value);

    // Ensure that the existing value is not collected.
    do {
      Object existingValueReference;
      V existingValue;
      do {
        existingValueReference = delegate.get(keyReference);

        /*
         * This method as a side-effect will proactively call
         * finalizeReference() as necessary, which prevents this loop from
         * spinning for a long time.
         */
        existingValue = dereferenceValue(existingValueReference);
      } while (isPartiallyReclaimed(existingValueReference, existingValue));

      if (existingValueReference == null) {
        return null; // nothing to replace
      }

      if (delegate.replace(
          keyReference, existingValueReference, valueReference)) {
        // existingValue didn't expire since we still have a reference to it
        return existingValue;
      }
    } while (true);
  }

  public boolean replace(K key, V oldValue, V newValue) {
    /*
     * It's surprising how much simpler this, the "more-discriminating" form of
     * replace(), is to implement than the other, "less-discriminating" form.
     * The difference is that, because we have a strong reference to
     * 'oldValue', we know that it can't have been garbage collected and so we
     * can skip all the logic that handles that case.
     */
    Object keyReference = referenceKey(key);
    Object oldValueDummy = valueStrategy.getDummyFor(oldValue);
    Object newValueReference = referenceValue(keyReference, newValue);
    return delegate.replace(keyReference, oldValueDummy, newValueReference);
  }

  /**
   * Returns {@code true} if the specified value reference has been garbage
   * collected. The value behind the reference is also passed in, rather than
   * queried inside this method, to ensure that the return statement of this
   * method will still hold true after it has returned (that is, a value
   * reference exists outside of this method which will prevent that value from
   * being garbage collected). A {@code false} result may indicate either that
   * the value has been fully reclaimed, or that it has not been reclaimed at
   * all.
   *
   * @param valueReference the value reference to be tested
   * @param value the object referenced by {@code valueReference}
   * @return {@code true} if {@code valueReference} is non-null and {@code
   *     value} is null
   */
  private static boolean isPartiallyReclaimed(
      Object valueReference, Object value) {
    return (valueReference != null) && (value == null);
  }

  /**
   * Removes the mapping for a key from this map if it is present.
   */
  @Override public V remove(Object key) {
    Object keyDummy = keyStrategy.getDummyFor(key);
    Object valueReference = delegate.remove(keyDummy);
    return dereferenceValue(valueReference);
  }

  public boolean remove(Object key, Object value) {
    Object keyDummy = keyStrategy.getDummyFor(key);
    Object valueDummy = valueStrategy.getDummyFor(value);
    return delegate.remove(keyDummy, valueDummy);
  }

  // Bulk Operations

  // Inherit putAll() from AbstractMap

  /**
   * Removes all of the mappings from this map.
   */
  @Override public void clear() {
    delegate.clear();
  }

  // Views

  // Inherit keySet() and values() from AbstractMap

  private transient EntrySet entrySet;

  /**
   * {@inheritDoc}
   *
   * <p><b>Note:</b> Regardless of the choice of key and value reference types,
   * an entry in the entry set always has strong references to both key and
   * value. You should avoid any lingering strong references to {@code Entry}
   * objects.
   */
  @Override public Set<Map.Entry<K, V>> entrySet() {
    EntrySet es = entrySet;
    return (es == null) ? (entrySet = new EntrySet()) : es;
  }

  private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
    @Override public int size() {
      return ReferenceMap.this.size();
    }

    @Override public boolean isEmpty() {
      return ReferenceMap.this.isEmpty();
    }

    @Override public boolean contains(Object object) {
      checkNotNull(object);
      if (!(object instanceof Map.Entry<?, ?>)) {
        return false;
      }
      Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
      Object key = entry.getKey();
      Object value = entry.getValue();
      return key != null && value != null && value.equals(get(key));
    }

    @Override public Iterator<Map.Entry<K, V>> iterator() {
      return new EntryIterator();
    }

    /*
     * Note: the superclass toArray() methods assume that size() gives a correct
     * answer, which ours does not.
     */

    @Override public Object[] toArray() {
      return snapshot().toArray();
    }

    @Override public <T> T[] toArray(T[] array) {
      checkNotNull(array);
      return snapshot().toArray(array);
    }

    /*
     * We'd love to use 'new ArrayList(this)' or 'list.addAll(this)', but either
     * of these would recurse back to us again!
     */
    private List<Map.Entry<K, V>> snapshot() {
      List<Map.Entry<K, V>> list = Lists.newArrayListWithExpectedSize(size());
      for (Map.Entry<K, V> entry : this) {
        list.add(entry);
      }
      return list;
    }

    @Override public boolean remove(Object object) {
      checkNotNull(object);
      if (object instanceof Map.Entry<?, ?>) {
        Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
        return ReferenceMap.this.remove(entry.getKey(), entry.getValue());
      }
      return false;
    }

    @Override public void clear() {
      ReferenceMap.this.clear();
    }
  }

  private class EntryIterator extends AbstractRemovableIterator<Map.Entry<K, V>>
  {
    Iterator<Map.Entry<Object, Object>> delegateEntries
        = delegate.entrySet().iterator();

    @Override protected Map.Entry<K, V> computeNext() {
      while (delegateEntries.hasNext()) {
        Map.Entry<Object, Object> entry = delegateEntries.next();
        Object reference = entry.getKey();

        @SuppressWarnings("unchecked")
        final K key = (K) keyStrategy.dereferenceKey(reference);

        if (key != null) {
          final V value = dereferenceValue(entry.getValue());
          if (value != null) {
            return new AbstractMapEntry<K, V>() {
              V currentValue = value;
              @Override public K getKey() {
                return key;
              }
              @Override public V getValue() {
                return currentValue;
              }
              @Override public V setValue(V newValue) {
                put(key, newValue);
                try {
                  return currentValue;
                } finally {
                  currentValue = newValue;
                }
              }
            };
          }
        }
        // Otherwise, skip over this partially-GC'ed entry.
      }
      return endOfData();
    }

    /*
     * On a typical Map this would produce a ConcurrentModificationException,
     * but we're using a ConcurrentMap, which of course has no problem.
     */
    @Override public void remove(Map.Entry<K, V> entry) {
      ReferenceMap.this.remove(entry.getKey(), entry.getValue());
    }
  }

  // Serialization

  /*
   * "Override" default serialization so that we serialize the wrapped values
   * themselves (of type K and V), since serializing References would be absurd.
   */

  private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject(); // referenceType fields
    out.writeInt(size());
    for (Map.Entry<K, V> entry : entrySet()) {
      out.writeObject(entry.getKey());
      out.writeObject(entry.getValue());
    }
    out.writeObject(null);
  }

  private void readObject(ObjectInputStream in)
      throws IOException, ClassNotFoundException {
    in.defaultReadObject(); // sets the referenceType fields
    int approximateSize = in.readInt();
    delegate = new ConcurrentHashMap<Object, Object>(
        Maps.capacity(approximateSize));
    while (true) {
      @SuppressWarnings("unchecked") // see writeObject()
      K key = (K) in.readObject();
      if (key == null) {
        break;
      }
      @SuppressWarnings("unchecked") // see writeObject()
      V value = (V) in.readObject();
      put(key, value);
    }
  }

  // The rest of the file is all private machinery

  private enum ReferenceStrategy {
    DIRECT {
      @Override Object referenceKey(ReferenceMap<?, ?> map, Object key) {
        return key;
      }
      @Override Object referenceValue(
          ReferenceMap<?, ?> map, Object keyReference, Object value) {
        return value;
      }
      @Override Object dereferenceKey(Object reference) {
        return reference;
      }
      @Override Object dereferenceValue(Object object) {
        return object;
      }
      @Override Object getDummyFor(Object object) {
        return checkNotNull(object);
      }
    },

    WRAP_IN_SOFT {
      @Override Object referenceKey(ReferenceMap<?, ?> map, Object key) {
        return map.new SoftKeyReference(key);
      }
      @Override Object referenceValue(
          ReferenceMap<?, ?> map, Object keyReference, Object value) {
        return map.new SoftValueReference(keyReference, value);
      }
    },

    WRAP_IN_WEAK {
      @Override Object referenceKey(ReferenceMap<?, ?> map, Object key) {
        return map.new WeakKeyReference(key);
      }
      @Override Object referenceValue(
          ReferenceMap<?, ?> map, Object keyReference, Object value) {
        return map.new WeakValueReference(keyReference, value);
      }
    };

    abstract Object referenceKey(ReferenceMap<?, ?> map, Object key);

    abstract Object referenceValue(
        ReferenceMap<?, ?> map, Object keyReference, Object value);

    Object dereferenceKey(Object reference) {
      return ((Reference<?>) reference).get();
    }

    Object dereferenceValue(Object object) {
      InternalReference reference = (InternalReference) object;
      Object value = reference.get();

      /*
       * It's important that we proactively try to finalize the referent, rather
       * rather than waiting on the queue, in particular because of the
       * do/while loop in replace().
       */
      if (value == null) {
        reference.finalizeReferent(); // The old value was garbage collected.
      }
      return value;
    }

    Object getDummyFor(Object object) {
      return new DummyReference(checkNotNull(object));
    }

    static ReferenceStrategy forType(ReferenceType type) {
      switch (checkNotNull(type)) {
        case STRONG:
          return ReferenceStrategy.DIRECT;
        case SOFT:
          return ReferenceStrategy.WRAP_IN_SOFT;
        case WEAK:
          return ReferenceStrategy.WRAP_IN_WEAK;
        default:
          throw new AssertionError();
      }
    }
  }

  /*
   * Marker interface to differentiate external and internal references. Also
   * duplicates finalizeReferent() and Reference.get() for internal use.
   */
  private interface InternalReference {
    void finalizeReferent();
    Object get();
  }

  private class SoftKeyReference extends FinalizableSoftReference<Object>
      implements InternalReference {
    final int hashCode;

    SoftKeyReference(Object key) {
      super(key);
      hashCode = System.identityHashCode(key);
    }
    public void finalizeReferent() {
      delegate.remove(this);
    }
    @Override public int hashCode() {
      return hashCode;
    }
    @Override public boolean equals(Object object) {
      return referenceEquals(this, object);
    }
  }

  private class SoftValueReference extends FinalizableSoftReference<Object>
      implements InternalReference {
    final Object keyReference;

    SoftValueReference(Object keyReference, Object value) {
      super(value);
      this.keyReference = keyReference;
    }
    public void finalizeReferent() {
      delegate.remove(keyReference, this);
    }
    @Override public int hashCode() {
      // It's hard to define a useful hash code, so we're careful not to use it.
      throw new AssertionError("don't hash me");
    }
    @Override public boolean equals(Object obj) {
      return referenceEquals(this, obj);
    }
  }

  /*
   * WeakKeyReference/WeakValueReference are absolutely identical to
   * SoftKeyReference/SoftValueReference except for which classes they extend.
   */

  private class WeakKeyReference extends FinalizableWeakReference<Object>
      implements InternalReference {
    final int hashCode;

    WeakKeyReference(Object key) {
      super(key);
      hashCode = System.identityHashCode(key);
    }
    public void finalizeReferent() {
      delegate.remove(this);
    }
    @Override public int hashCode() {
      return hashCode;
    }
    @Override public boolean equals(Object object) {
      return referenceEquals(this, object);
    }
  }

  private class WeakValueReference extends FinalizableWeakReference<Object>
      implements InternalReference {
    final Object keyReference;

    WeakValueReference(Object keyReference, Object value) {
      super(value);
      this.keyReference = keyReference;
    }
    public void finalizeReferent() {
      delegate.remove(keyReference, this);
    }
    @Override public int hashCode() {
      // It's hard to define a useful hash code, so we're careful not to use it.
      throw new AssertionError("don't hash me");
    }
    @Override public boolean equals(Object obj) {
      return referenceEquals(this, obj);
    }
  }

  /*
   * A short-lived object that is contrived for the purpose of passing to
   * methods of the backing map such as get(), remove(), containsKey(), and
   * replace() (all parameters but the last). That is, it's an object suitable
   * only for use with the backing map, and only for _comparison_ purposes. This
   * is a hack that lets us compare keys and values to referenced keys and
   * values without creating more references.
   */
  private static class DummyReference {
    final Object wrapped;
    DummyReference(Object wrapped) {
      this.wrapped = wrapped;
    }
    Object unwrap() {
      return wrapped;
    }
    @Override public int hashCode() {
      return System.identityHashCode(wrapped);
    }
    @Override public boolean equals(Object object) {
      return object.equals(this); // Defer to the reference's equals() logic.
    }
  }

  /*
   * Tests weak and soft references for identity equality. Compares references
   * to other references and wrappers. If o is a reference, this returns true if
   * r == o or if r and o reference the same non-null object. If o is a wrapper,
   * this returns true if r's referent is identical to the wrapped object.
   */
  private static boolean referenceEquals(Reference<?> reference, Object object)
  {
    // Are they the same reference? Used in cleanup.
    if (object == reference) {
      return true;
    }
    if (object instanceof InternalReference) {
      /*
       * Do they reference identical values? Used in conditional puts. We can
       * assume it's of type InternalReference now, as no one outside
       * ReferenceMap can be invoking equals().
       */
      Object referent = ((InternalReference) object).get();
      return referent != null && referent == reference.get();
    }

    // Is the wrapped object identical to the referent? Used in lookups.
    return ((DummyReference) object).unwrap() == reference.get();
  }

  private Object referenceKey(K key) {
    return keyStrategy.referenceKey(this, checkNotNull(key));
  }

  private Object referenceValue(Object keyReference, V value) {
    return valueStrategy.referenceValue(
        this, keyReference, checkNotNull(value));
  }

  /*
   * Converts a reference to a value. Do not call this method without being
   * certain that the object is a reference to a value type (V).
   */
  @SuppressWarnings("unchecked")
  private V dereferenceValue(Object object) {
    if (object == null) {
      return null;
    }
    return (V) valueStrategy.dereferenceValue(object);
  }

  private static final long serialVersionUID = 0L;
}
