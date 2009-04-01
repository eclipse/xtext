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

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * {@code AbstractMap} extension whose views have {@code removeAll} and
 * {@code retainAll} methods that always throw an exception when given a null
 * collection. It provides a workaround for <a
 * href="http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4802647">Sun bug
 * 4802647</a>.
 * 
 * @author Jared Levy
 */
abstract class NpeThrowingAbstractMap<K, V> extends AbstractMap<K, V> {
  
  /**
   * Supplies an entry set, a wrapped version of which is returned by
   * {@code entrySet()}. That way, {@link #entrySet} retrieves an entry set
   * whose {@link Set#retainAll} method always throws an exception.
   * 
   * <p>This method is invoked at most once on a given map, at the time when
   * {@code entrySet()} is first called.
   */
  protected abstract Set<Map.Entry<K, V>> createEntrySet();
  
  private transient Set<Map.Entry<K, V>> entrySet;
  
  @Override public synchronized Set<Map.Entry<K, V>> entrySet() {
    if (entrySet == null) {
      final Set<Map.Entry<K, V>> delegate = createEntrySet();
      entrySet = new ForwardingSet<Map.Entry<K, V>>() {
        @Override protected Set<Map.Entry<K, V>> delegate() {
          return delegate;
        }
      };
    }
    return entrySet;
  }
  
  private transient Set<K> keySet;
  
  @Override public synchronized Set<K> keySet() {
    if (keySet == null) {
      final Set<K> delegate = super.keySet();
      keySet = new ForwardingSet<K>() {
        @Override protected Set<K> delegate() {
          return delegate;
        }
      };
    }
    return keySet;
  }

  private transient Collection<V> values;

  @Override public synchronized Collection<V> values() {
    if (values == null) {
      final Collection<V> delegate = super.values();
      values = new ForwardingCollection<V>() {
        @Override protected Collection<V> delegate() {
          return delegate;
        }        
      };
    }
    return values;
  }
}
