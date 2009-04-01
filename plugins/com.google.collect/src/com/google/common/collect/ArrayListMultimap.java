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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Implementation of {@code Multimap} that uses an {@code ArrayList} to store
 * the values for a given key. A {@link HashMap} associates each key with an
 * {@link ArrayList} of values.
 *
 * <p>When iterating through the collections supplied by this class, the
 * ordering of values for a given key agrees with the order in which the values
 * were added.
 *
 * <p>This multimap allows duplicate key-value pairs. After adding a new
 * key-value pair equal to an existing key-value pair, the {@code
 * ArrayListMultimap} will contain entries for both the new value and the old
 * value.
 *
 * <p>Keys and values may be null. All optional multimap methods are supported,
 * and all returned views are modifiable.
 *
 * <p>This class is not threadsafe when any concurrent operations update the
 * multimap. Concurrent read operations will work correctly. To allow concurrent
 * update operations, wrap your multimap with a call to {@link
 * Multimaps#synchronizedListMultimap}.
 *
 * @author Jared Levy
 */
public final class ArrayListMultimap<K, V> extends StandardListMultimap<K, V> {
  // Default from ArrayList
  /*@VisibleForTesting*/ static final int DEFAULT_CAPACITY = 10;   
  
  /*@VisibleForTesting*/ transient int initialListCapacity;

  /** Constructs an empty {@code ArrayListMultimap}. */
  public ArrayListMultimap() {
    super(new HashMap<K, Collection<V>>());
    initialListCapacity = DEFAULT_CAPACITY;
  }

  /**
   * Constructs an empty {@code ArrayListMultimap} with the expected number of
   * distinct keys and the expected number of values per distinct key.
   *
   * @param distinctKeys the expected number of distinct keys
   * @param valuesPerKey the expected number of values per distinct key
   * @throws IllegalArgumentException if either argument is negative
   */
  public ArrayListMultimap(int distinctKeys, int valuesPerKey) {
    super(new HashMap<K, Collection<V>>(Maps.capacity(distinctKeys)));
    checkArgument(valuesPerKey >= 0);
    initialListCapacity = valuesPerKey;
  }

  /**
   * Constructs an {@code ArrayListMultimap} with the same mappings as the
   * specified {@code Multimap}.
   */
  public ArrayListMultimap(Multimap<? extends K, ? extends V> multimap) {
    this(multimap.keySet().size(),
        (multimap instanceof ArrayListMultimap) ?
            ((ArrayListMultimap<?, ?>) multimap).initialListCapacity :
            DEFAULT_CAPACITY);
    putAll(multimap);
  }

  /**
   * Creates a new empty {@code ArrayList} to hold the collection of values for
   * an arbitrary key.
   */
  @Override List<V> createCollection() {
    return new ArrayList<V>(initialListCapacity);
  }

  /**
   * Reduces the memory used by this {@code ArrayListMultimap}, if feasible.
   */
  public void trimToSize() {
    for (Collection<V> collection : backingMap().values()) {
      ArrayList<V> arrayList = (ArrayList<V>) collection;
      arrayList.trimToSize();
    }
  }
  
  /**
   * @serialData initial list capacity, number of distinct keys, and then for
   *     each distinct key: the key, number of values for that key, and the
   *     key's values
   */
  private void writeObject(ObjectOutputStream stream) throws IOException {
    stream.defaultWriteObject();
    stream.writeInt(initialListCapacity);
    Serialization.writeMultimap(this, stream);
  }
  
  private void readObject(ObjectInputStream stream)
      throws IOException, ClassNotFoundException {
    stream.defaultReadObject();
    setMap(new HashMap<K, Collection<V>>());
    initialListCapacity = stream.readInt();
    Serialization.populateMultimap(this, stream);
  }
  
  private static final long serialVersionUID = 0;  
}
