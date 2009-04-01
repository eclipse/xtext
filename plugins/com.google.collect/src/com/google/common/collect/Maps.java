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
import static com.google.common.base.Preconditions.checkNotNull;
import com.google.common.collect.MapConstraints.ConstrainedMap;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Static utility methods pertaining to {@link Map} instances. Also see this
 * class's counterparts {@link Lists} and {@link Sets}.
 *
 * @author Kevin Bourrillion
 * @author Mike Bostock
 */
public final class Maps {
  private Maps() {}

  /**
   * Creates a {@code HashMap} instance.
   *
   * <p><b>Note:</b> if {@code K} is an {@code enum} type, use {@link
   * #newEnumMap} instead.
   *
   * <p><b>Note:</b> if you don't actually need the resulting map to be mutable,
   * use {@link Collections#emptyMap} instead.
   *
   * @return a newly-created, initially-empty {@code HashMap}
   */
  public static <K, V> HashMap<K, V> newHashMap() {
    return new HashMap<K, V>();
  }

  /**
   * Creates a {@code HashMap} instance with enough capacity to hold the
   * specified number of elements without rehashing.
   * 
   * @param expectedSize the expected size
   * @return a newly-created {@code HashMap}, initially empty, with enough
   *     capacity to hold {@code expectedSize} elements without rehashing
   * @throws IllegalArgumentException if {@code expectedSize} is negative
   */
  public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(
      int expectedSize) {
    /* 
     * The HashMap is constructed with an initialCapacity that's greater than
     * expectedSize. The larger value is necessary because HashMap resizes
     * its internal array if the map size exceeds loadFactor * initialCapacity.
     */
    return new HashMap<K, V>(capacity(expectedSize));
  }

  /**
   * Returns an appropriate value for the "capacity" (in reality, "minimum
   * table size") parameter of a {@link HashMap} constructor, such that the
   * resulting table will be between 25% and 50% full when it contains
   * {@code expectedSize} entries.
   *
   * @throws IllegalArgumentException if {@code expectedSize} is negative
   */
  static int capacity(int expectedSize) {
    checkArgument(expectedSize >= 0);
    return Math.max(expectedSize * 2, 16);
  }

  /**
   * Creates a {@code HashMap} instance with the same mappings as the specified
   * map.
   *
   * <p><b>Note:</b> if {@code K} is an {@link Enum} type, use {@link
   * #newEnumMap} instead.
   *
   * @param map the mappings to be placed in the new map
   * @return a newly-created {@code HashMap} initialized with the mappings from
   *     {@code map}
   */
  public static <K, V> HashMap<K, V> newHashMap(
      Map<? extends K, ? extends V> map) {
    return new HashMap<K, V>(map);
  }

  /**
   * Creates an insertion-ordered {@code LinkedHashMap} instance.
   *
   * @return a newly-created, initially-empty {@code LinkedHashMap}
   */
  public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
    return new LinkedHashMap<K, V>();
  }

  /**
   * Creates an insertion-ordered {@code LinkedHashMap} instance with the same
   * mappings as the specified map.
   *
   * @param map the mappings to be placed in the new map
   * @return a newly-created, {@code LinkedHashMap} initialized with the
   *     mappings from {@code map}
   */
  public static <K, V> LinkedHashMap<K, V> 
      newLinkedHashMap(Map<? extends K, ? extends V> map) {
    return new LinkedHashMap<K, V>(map);
  }

  /**
   * Creates a {@code ConcurrentHashMap} instance.
   *
   * @return a newly-created, initially-empty {@code ConcurrentHashMap}
   */
  public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap() {
    return new ConcurrentHashMap<K, V>();
  }

  /**
   * Creates a {@code TreeMap} instance using the natural ordering of its
   * elements.
   *
   * @return a newly-created, initially-empty {@code TreeMap}
   */
  @SuppressWarnings("unchecked")  // allow ungenerified Comparable types
  public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
    return new TreeMap<K, V>();
  }

  /**
   * Creates a {@code TreeMap} instance using the given comparator.
   *
   * @param comparator the comparator to sort the keys with
   * @return a newly-created, initially-empty {@code TreeMap}
   */
  public static <C, K extends C, V> TreeMap<K, V> newTreeMap(
      @Nullable Comparator<C> comparator) {
    // Ideally, the extra type parameter "C" shouldn't be necessary. It is a
    // work-around of a compiler type inference quirk that prevents the
    // following code from being compiled:
    // Comparator<Class<?>> comparator = null;
    // Map<Class<? extends Throwable>, String> map = newTreeMap(comparator);
    return new TreeMap<K, V>(comparator);
  }

  /**
   * Creates an {@code EnumMap} instance.
   *
   * @param type the key type for this map
   * @return a newly-created, initially-empty {@code EnumMap}
   */
  public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> type) {
    return new EnumMap<K, V>(type);
  }

  /**
   * Creates an {@code IdentityHashMap} instance.
   *
   * @return a newly-created, initially-empty {@code IdentityHashMap}
   */
  public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
    return new IdentityHashMap<K, V>();
  }

  /**
   * Returns {@code true} if {@code map} contains an entry mapping {@code key}
   * to {@code value}. If you are not concerned with null-safety you can simply
   * use {@code map.get(key).equals(value)}.
   */
  public static boolean containsEntry(
      Map<?, ?> map, @Nullable Object key, @Nullable Object value) {
    Object valueForKey = map.get(key);
    return (valueForKey == null)
        ? value == null && map.containsKey(key)
        : valueForKey.equals(value);
  }

  /**
   * Returns a synchronized (thread-safe) bimap backed by the specified bimap.
   * In order to guarantee serial access, it is critical that <b>all</b> access
   * to the backing bimap is accomplished through the returned bimap.
   *
   * <p>It is imperative that the user manually synchronize on the returned map
   * when accessing any of its collection views:
   *
   * <pre>  Bimap&lt;K,V> m = Maps.synchronizedBiMap(
   *      new HashBiMap&lt;K,V>());
   *   ...
   *  Set&lt;K> s = m.keySet();  // Needn't be in synchronized block
   *   ...
   *  synchronized (m) {  // Synchronizing on m, not s!
   *    Iterator&lt;K> i = s.iterator(); // Must be in synchronized block
   *    while (i.hasNext()) {
   *      foo(i.next());
   *    }
   *  }</pre>
   *
   * Failure to follow this advice may result in non-deterministic behavior.
   *
   * @param bimap the bimap to be wrapped in a synchronized view
   * @return a sychronized view of the specified bimap
   */
  public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> bimap) {
    return Synchronized.biMap(bimap, null);
  }

  /**
   * Returns an immutable map for which the {@link Map#values} are the given
   * elements in the given order, and each key is the product of invoking a
   * supplied function on its corresponding value.
   *
   * @param values the values to use when constructing the {@code Map}
   * @param keyFunction the function used to produce the key for each value
   * @return a map mapping the result of evaluating the function {@code
   *     keyFunction} on each value in the input collection to that value
   * @throws IllegalArgumentException if {@code keyFunction} produces the same
   *     key for more than one value in the input collection
   * @throws NullPointerException if any elements of {@code values} is null, or
   *     if {@code keyFunction} produces {@code null} for any value
   */
  // TODO: consider returning a bimap, whose inverse view does lookups by
  // invoking the function.
  public static <K, V> ImmutableMap<K, V> uniqueIndex(
      Iterable<V> values, Function<? super V, K> keyFunction) {
    checkNotNull(keyFunction);
    ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
    for (V value : values) {
      builder.put(keyFunction.apply(value), value);
    }
    return builder.build();
  }

  /**
   * Creates a {@code Map<String, String>} from a {@code Properties} instance.
   * Properties normally derive from {@code Map<Object, Object>}, but they
   * typically contain strings, which is awkward. This method lets you get a
   * plain-old-{@code Map} out of a {@code Properties}. The returned map won't
   * include any null keys or values. The returned map is modifiable and
   * serializable.
   *
   * @param properties a {@code Properties} object to be converted
   * @return a map containing all the entries in {@code properties}
   */
  public static Map<String, String> fromProperties(Properties properties) {
    Map<String, String> ret = newHashMapWithExpectedSize(properties.size());
    for (Enumeration<?> e = properties.propertyNames(); e.hasMoreElements();) {
      Object k = e.nextElement();
      /*
       * It is unlikely that a 'null' could be inserted into a Properties, but
       * possible in a derived class.
       */
      String key = (k != null) ? k.toString() : null;
      ret.put(key, properties.getProperty(key));
    }
    return ret;
  }

  /**
   * Returns an immutable map entry with the specified key and value. The {@link
   * Entry#setValue} operation throws an {@link UnsupportedOperationException}.
   *
   * <p>The returned entry is serializable.
   *
   * @param key the key to be associated with the returned entry
   * @param value the value to be associated with the returned entry
   */
  public static <K, V> Entry<K, V> immutableEntry(
      @Nullable final K key, @Nullable final V value) {
    return new ImmutableEntry<K, V>(key, value);
  }

  /** @see Maps#immutableEntry(Object,Object) */
  private static class ImmutableEntry<K, V> extends AbstractMapEntry<K, V>
      implements Serializable {
    final K key;
    final V value;

    ImmutableEntry(K key, V value) {
      this.key = key;
      this.value = value;
    }
    @Override public K getKey() {
      return key;
    }
    @Override public V getValue() {
      return value;
    }
    private static final long serialVersionUID = 0;
  }

  /**
   * Returns an unmodifiable view of the specified set of entries. The {@link
   * Entry#setValue} operation throws an {@link UnsupportedOperationException},
   * as do any operations that would modify the returned set.
   *
   * @param entrySet the entries for which to return an unmodifiable view
   * @return an unmodifiable view of the entries
   */
  static <K, V> Set<Entry<K, V>> unmodifiableEntrySet(
      final Set<Entry<K, V>> entrySet) {
    return new UnmodifiableEntrySet<K, V>(Collections.unmodifiableSet(
        entrySet));
  }

  /**
   * Returns an unmodifiable view of the specified map entry. The {@link
   * Entry#setValue} operation throws an {@link UnsupportedOperationException}.
   * This also has the side-effect of redefining {@code equals} to comply with
   * the Entry contract, to avoid a possible nefarious implementation of
   * equals.
   *
   * @param entry the entry for which to return an unmodifiable view
   * @return an unmodifiable view of the entry
   */
  private static <K, V> Entry<K, V> unmodifiableEntry(final Entry<K, V> entry) {
    checkNotNull(entry);
    return new AbstractMapEntry<K, V>() {
      @Override public K getKey() {
        return entry.getKey();
      }
      @Override public V getValue() {
        return entry.getValue();
      }
    };
  }

  /** @see Multimaps#unmodifiableEntries */
  static class UnmodifiableEntries<K, V>
      extends ForwardingCollection<Entry<K, V>> {
    private final Collection<Entry<K, V>> entries;
    
    UnmodifiableEntries(Collection<Entry<K, V>> entries) {
      this.entries = entries;
    }

    @Override protected Collection<Entry<K, V>> delegate() {
      return entries;
    }
    
   @Override public Iterator<Entry<K, V>> iterator() {
      final Iterator<Entry<K, V>> delegate = super.iterator();
      return new ForwardingIterator<Entry<K, V>>() {
        @Override public Entry<K, V> next() {
          return unmodifiableEntry(super.next());
        }
        @Override protected Iterator<Entry<K, V>> delegate() {
          return delegate;
        }
      };
    }

    // See java.util.Collections.UnmodifiableEntrySet for details on attacks.

    @Override public Object[] toArray() {
      return ObjectArrays.toArrayImpl(this);
    }

    @Override public <T> T[] toArray(T[] array) {
      return ObjectArrays.toArrayImpl(this, array);
    }

    @Override public boolean contains(Object o) {
      return containsEntryImpl(delegate(), o);
    }

    @Override public boolean containsAll(Collection<?> c) {
      return Collections2.containsAll(this, c);
    }
  }

  /** @see Maps#unmodifiableEntrySet(Set) */
  static class UnmodifiableEntrySet<K, V>
      extends UnmodifiableEntries<K, V>
      implements Set<Entry<K, V>> {
    UnmodifiableEntrySet(Set<Entry<K, V>> entries) {
      super(entries);
    }

    // See java.util.Collections.UnmodifiableEntrySet for details on attacks.

    @Override public boolean equals(Object o) {
      return Sets.equalsImpl(this, o);
    }
    
    @Override public int hashCode() {
      return Sets.hashCodeImpl(this);
    }
  }

  /**
   * Returns a new empty {@code HashBiMap} with the default initial capacity
   * (16).
   */
  public static <K, V> HashBiMap<K, V> newHashBiMap() {
    return new HashBiMap<K, V>();
  }

  /**
   * Returns a new empty {@code EnumHashBiMap} using the specified key type.
   *
   * @param keyType the key type
   */
  public static <K extends Enum<K>, V> EnumHashBiMap<K, V> newEnumHashBiMap(
      Class<K> keyType) {
    return new EnumHashBiMap<K, V>(keyType);
  }

  /**
   * Returns a new empty {@code EnumBiMap} using the specified key and value
   * types.
   *
   * @param keyType the key type
   * @param valueType the value type
   */
  public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V>
      newEnumBiMap(Class<K> keyType, Class<V> valueType) {
    return new EnumBiMap<K, V>(keyType, valueType);
  }

  /**
   * Returns an unmodifiable view of the specified bimap. This method allows
   * modules to provide users with "read-only" access to internal bimaps. Query
   * operations on the returned bimap "read through" to the specified bimap, and
   * attemps to modify the returned map, whether direct or via its collection
   * views, result in an {@code UnsupportedOperationException}.
   *
   * <p>The returned bimap will be serializable if the specified bimap is
   * serializable.
   *
   * @param bimap the bimap for which an unmodifiable view is to be returned
   * @return an unmodifiable view of the specified bimap
   */
  public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<K, V> bimap) {
    return new UnmodifiableBiMap<K, V>(bimap, null);
  }

  /** @see Maps#unmodifiableBiMap(BiMap) */
  private static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V>
      implements BiMap<K, V>, Serializable {
    final Map<K, V> unmodifiableMap; 
    final BiMap<K, V> delegate;
    transient BiMap<V, K> inverse;
    transient Set<V> values;
    
    UnmodifiableBiMap(BiMap<K, V> delegate, BiMap<V, K> inverse) {
      unmodifiableMap = Collections.unmodifiableMap(delegate);      
      this.delegate = delegate;
      this.inverse = inverse;
    }
    @Override protected Map<K, V> delegate() {
      return unmodifiableMap;
    }
    public V forcePut(K key, V value) {
      throw new UnsupportedOperationException();
    }
    public BiMap<V, K> inverse() {
      BiMap<V, K> result = inverse;
      return (result == null)
          ? inverse = new UnmodifiableBiMap<V, K>(delegate.inverse(), this)
          : result;
    }
    @Override public Set<V> values() {
      Set<V> result = values;
      return (result == null)
          ? values = Collections.unmodifiableSet(delegate.values())
          : result;
    }
    private static final long serialVersionUID = 0;
  }

  /**
   * Returns a new {@code ClassToInstanceMap} instance backed by a {@link
   * HashMap} using the default initial capacity and load factor.
   */
  public static <B> ClassToInstanceMap<B> newClassToInstanceMap() {
    return newClassToInstanceMap(new HashMap<Class<? extends B>, B>());
  }

  /**
   * Returns a new {@code ClassToInstanceMap} instance backed by a given empty
   * {@code backingMap}. The caller surrenders control of the backing map, and
   * thus should not allow any direct references to it to remain accessible.
   */
  public static <B> ClassToInstanceMap<B> newClassToInstanceMap(
      Map<Class<? extends B>, B> backingMap) {
    return new SimpleClassToInstanceMap<B>(backingMap);
  }

  private static final MapConstraint<Class<?>, Object> VALUE_CAN_BE_CAST_TO_KEY
      = new MapConstraint<Class<?>, Object>() {
    public void checkKeyValue(Class<?> key, Object value) {
      wrap(key).cast(value);
    }
  };

  private static class SimpleClassToInstanceMap<B> extends
      ConstrainedMap<Class<? extends B>, B> implements ClassToInstanceMap<B> {
    SimpleClassToInstanceMap(Map<Class<? extends B>, B> delegate) {
      super(delegate, VALUE_CAN_BE_CAST_TO_KEY);
    }
    public <T extends B> T putInstance(Class<T> type, T value) {
      B oldValue = put(type, value);
      return wrap(type).cast(oldValue);
    }
    public <T extends B> T getInstance(Class<T> type) {
      B value = get(type);
      return wrap(type).cast(value);
    }
    private static final long serialVersionUID = 0;
  }

  @SuppressWarnings("unchecked")
  private static <T> Class<T> wrap(Class<T> c) {
    return c.isPrimitive() ? (Class<T>) PRIMITIVES_TO_WRAPPERS.get(c) : c;
  }

  private static final Map<Class<?>, Class<?>> PRIMITIVES_TO_WRAPPERS
      = new ImmutableMap.Builder<Class<?>, Class<?>>()
          .put(boolean.class, Boolean.class)
          .put(byte.class, Byte.class)
          .put(char.class, Character.class)
          .put(double.class, Double.class)
          .put(float.class, Float.class)
          .put(int.class, Integer.class)
          .put(long.class, Long.class)
          .put(short.class, Short.class)
          .put(void.class, Void.class)
          .build();

  /**
   * Implements {@code Collection.contains} safely for forwarding collections of
   * map entries. If {@code o} is an instance of {@code Map.Entry}, it is
   * wrapped using {@link #unmodifiableEntry} to protect against a possible
   * nefarious equals method.
   *
   * <p>Note that {@code c} is the backing (delegate) collection, rather than
   * the forwarding collection.
   *
   * @param c the delegate (unwrapped) collection of map entries
   * @param o the object that might be contained in {@code c}
   * @return {@code true} if {@code c} contains {@code o}
   */
  static <K, V> boolean containsEntryImpl(Collection<Entry<K, V>> c, Object o) {
    if (!(o instanceof Entry)) {
      return false;
    }
    return c.contains(unmodifiableEntry((Entry<?, ?>) o));
  }

  /**
   * Implements {@code Collection.remove} safely for forwarding collections of
   * map entries. If {@code o} is an instance of {@code Map.Entry}, it is
   * wrapped using {@link #unmodifiableEntry} to protect against a possible
   * nefarious equals method.
   *
   * <p>Note that {@code c} is backing (delegate) collection, rather than the
   * forwarding collection.
   *
   * @param c the delegate (unwrapped) collection of map entries
   * @param o the object to remove from {@code c}
   * @return {@code true} if {@code c} was changed
   */
  static <K, V> boolean removeEntryImpl(Collection<Entry<K, V>> c, Object o) {
    if (!(o instanceof Entry)) {
      return false;
    }
    return c.remove(unmodifiableEntry((Entry<?, ?>) o));
  }
}
