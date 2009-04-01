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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link Multimap} using hash tables.
 *
 * <p>The multimap does not store duplicate key-value pairs. Adding a new
 * key-value pair equal to an existing key-value pair has no effect.
 *
 * <p>Keys and values may be null. All optional multimap methods are supported,
 * and all returned views are modifiable.
 *
 * <p>This class is not threadsafe when any concurrent operations update the
 * multimap. Concurrent read operations will work correctly. To allow concurrent
 * update operations, wrap your multimap with a call to {@link
 * Multimaps#synchronizedSetMultimap}.
 *
 * @author Jared Levy
 */
public final class HashMultimap<K, V> extends StandardSetMultimap<K, V> {
  /** Constructs an empty {@code HashMultimap}. */
  public HashMultimap() {
    super(new HashMap<K, Collection<V>>());
  }

  /**
   * Constructs a {@code HashMultimap} with the same mappings as the specified
   * {@code Multimap}. If a key-value mapping appears multiple times in the
   * input multimap, it only appears once in the constructed multimap.
   *
   * @param multimap the multimap whose contents are copied to this multimap.
   * @see #putAll(Multimap)
   */
  public HashMultimap(Multimap<? extends K, ? extends V> multimap) {
    super(new HashMap<K, Collection<V>>(
        Maps.capacity(multimap.keySet().size())));
    putAll(multimap);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Creates an empty {@code HashSet} for a collection of values for one key.
   *
   * @return a new {@code HashSet} containing a collection of values for one key
   */
  @Override Set<V> createCollection() {
    return new HashSet<V>();
  }

  /**
   * @serialData number of distinct keys, and then for each distinct key: the
   *     key, the number of values for that key, and the key's values  
   */
  private void writeObject(ObjectOutputStream stream) throws IOException {
    stream.defaultWriteObject();
    Serialization.writeMultimap(this, stream);
  }
  
  private void readObject(ObjectInputStream stream)
      throws IOException, ClassNotFoundException {
    stream.defaultReadObject();
    setMap(new HashMap<K, Collection<V>>());
    Serialization.populateMultimap(this, stream);
  }
  
  private static final long serialVersionUID = 0;  
}
