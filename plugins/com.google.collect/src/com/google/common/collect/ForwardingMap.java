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

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * A map which forwards all its method calls to another map. Subclasses should
 * override one or more methods to modify the behavior of the backing map as
 * desired per the <a
 * href="http://en.wikipedia.org/wiki/Decorator_pattern">decorator pattern</a>.
 *
 * @see ForwardingObject
 * @author Kevin Bourrillion
 * @author Jared Levy
 */
public abstract class ForwardingMap<K, V> extends ForwardingObject
    implements Map<K, V> {

  @Override protected abstract Map<K, V> delegate();

  public int size() {
    return delegate().size();
  }

  public boolean isEmpty() {
    return delegate().isEmpty();
  }

  public V remove(Object object) {
    return delegate().remove(object);
  }

  public void clear() {
    delegate().clear();
  }

  public boolean containsKey(Object key) {
    return delegate().containsKey(key);
  }

  public boolean containsValue(Object value) {
    return delegate().containsValue(value);
  }

  public V get(Object key) {
    return delegate().get(key);
  }

  public V put(K key, V value) {
    return delegate().put(key, value);
  }

  public void putAll(Map<? extends K, ? extends V> map) {
    delegate().putAll(map);
  }

  private transient Set<K> keySet;
  
  /**
   * {@inheritDoc}
   * 
   * <p>The returned set's {@code removeAll} and {@code retainAll} methods
   * always throw a {@link NullPointerException} when given a null collection.  
   */
  public Set<K> keySet() {
    return (keySet == null) ? keySet = createKeySet() : keySet;
  }

  private Set<K> createKeySet() {
    final Set<K> delegate = delegate().keySet();
    return new ForwardingSet<K>() {
      @Override protected Set<K> delegate() {
        return delegate;
      }
    };
  }
  
  private transient Collection<V> values;

  /**
   * {@inheritDoc}
   * 
   * <p>The returned collection's {@code removeAll} and {@code retainAll}
   * methods always throw a {@link NullPointerException} when given a null
   * collection.  
   */
  public Collection<V> values() {
    return (values == null) ? values = createValues() : values;
  }

  private Collection<V> createValues() {
    final Collection<V> delegate = delegate().values();
    return new ForwardingCollection<V>() {
      @Override protected Collection<V> delegate() {
        return delegate;
      }      
    };
  }
  
  private transient Set<Entry<K, V>> entrySet;
  
  /**
   * {@inheritDoc}
   * 
   * <p>The returned set's {@code removeAll} and {@code retainAll} methods
   * always throw a {@link NullPointerException} when given a null collection.  
   */
  public Set<Entry<K, V>> entrySet() {
    return (entrySet == null) ? entrySet = createEntrySet() : entrySet;
  }

  private Set<Entry<K, V>> createEntrySet() {
    final Set<Entry<K, V>> delegate = delegate().entrySet();
    return new ForwardingSet<Entry<K, V>>() {
      @Override protected Set<Entry<K, V>> delegate() {
        return delegate;
      }
    };
  }
  
  @Override public boolean equals(Object obj) {
    return (this == obj) || delegate().equals(obj);
  }

  @Override public int hashCode() {
    return delegate().hashCode();
  }
}
