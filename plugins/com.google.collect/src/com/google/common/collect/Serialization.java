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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * Provides static method for serializing collection classes. 
 *
 * @author Jared Levy
 */
public final class Serialization {
  private Serialization() {}  
  
  /**
   * Stores the contents of a map in an output stream, as part of serialization.
   * It does not support concurrent maps whose content may change while the
   * method is running.
   * 
   * <p>The serialized output consists of the number of entries, first key,
   * first value, second key, second value, and so on.
   */
  public static <K, V> void writeMap(Map<K, V> map, ObjectOutputStream stream)
      throws IOException {
    stream.writeInt(map.size());
    for (Map.Entry<K, V> entry : map.entrySet()) {
      stream.writeObject(entry.getKey());
      stream.writeObject(entry.getValue());
    }
  }
  
  /**
   * Populates a map by reading an input stream, as part of deserialization.
   * See {@link #writeMap} for the data format.
   */
  public static <K, V> void populateMap(Map<K, V> map, ObjectInputStream stream)
      throws IOException, ClassNotFoundException {
    int size = stream.readInt();
    for (int i = 0; i < size; i++) {
      @SuppressWarnings("unchecked") // reading data stored by writeMap
      K key = (K) stream.readObject();
      @SuppressWarnings("unchecked") // reading data stored by writeMap
      V value = (V) stream.readObject();
      map.put(key, value);
    }
  }
  /**
   * Stores the contents of a multiset in an output stream, as part of
   * serialization. It does not support concurrent multisets whose content may
   * change while the method is running. 
   * 
   * <p>The serialized output consists of the number of distinct elements, the
   * first element, its count, the second element, its count, and so on.
   */
  public static <E> void writeMultiset(
      Multiset<E> multiset, ObjectOutputStream stream) throws IOException {
    int entryCount = multiset.entrySet().size();
    stream.writeInt(entryCount);
    for (Multiset.Entry<E> entry : multiset.entrySet()) {
      stream.writeObject(entry.getElement());
      stream.writeInt(entry.getCount());
    }
  }  
  
  /**
   * Populates a multiset by reading an input stream, as part of
   * deserialization. See {@link #writeMultiset} for the data format.
   */
  public static <E> void populateMultiset(
      Multiset<E> multiset, ObjectInputStream stream)
      throws IOException, ClassNotFoundException {
    int entryCount = stream.readInt();
    for (int i = 0; i < entryCount; i++) {
      @SuppressWarnings("unchecked") // reading data stored by writeMultiset
      E element = (E) stream.readObject();
      int count = stream.readInt();
      multiset.add(element, count);
    }
  }
  
  /**
   * Stores the contents of a multimap in an output stream, as part of
   * serialization. It does not support concurrent multimaps whose content may
   * change while the method is running. The {@link Multimap#asMap} view
   * determines the ordering in which data is written to the stream.
   * 
   * <p>The serialized output consists of the number of distinct keys, and then
   * for each distinct key: the key, the number of values for that key, and the
   * key's values.  
   */
  public static <K, V> void writeMultimap(
      Multimap<K, V> multimap, ObjectOutputStream stream) throws IOException {
    stream.writeInt(multimap.asMap().size());
    for (Map.Entry<K, Collection<V>> entry : multimap.asMap().entrySet()) {
      stream.writeObject(entry.getKey());
      stream.writeInt(entry.getValue().size());
      for (V value : entry.getValue()) {
        stream.writeObject(value);
      }
    }
  }
  
  /**
   * Populates a multimap by reading an input stream, as part of
   * deserialization. See {@link #writeMultimap} for the data format.
   */
  public static <K, V> void populateMultimap(
      Multimap<K, V> multimap, ObjectInputStream stream)
      throws IOException, ClassNotFoundException {
    int keyCount = stream.readInt();
    for (int i = 0; i < keyCount; i++) {
      @SuppressWarnings("unchecked") // reading data stored by writeMultimap
      K key = (K) stream.readObject();
      Collection<V> values = multimap.get(key);
      int valueCount = stream.readInt();
      for (int j = 0; j < valueCount; j++) {
        @SuppressWarnings("unchecked") // reading data stored by writeMultimap
        V value = (V) stream.readObject();
        values.add(value);
      }
    }
  }

  /**
   * Updates the value of a final field, to support field initialization during
   * deserialization.
   * 
   * @param clazz the class in which the field is declared
   * @param instance the instance containing the field to be updated
   * @param fieldName the name of the field to update
   * @param value the value to store in the field
   * @throws NoSuchFieldException if no field has the specified name
   * @throws SecurityException if a security manager denies the request
   * @throws IllegalArgumentException if the value cannot be converted to the
   *     type of the field
   */
  public static <T> void setFinalField(
      Class<T> clazz, T instance, String fieldName, Object value)
      throws SecurityException, NoSuchFieldException {
    Field field = clazz.getDeclaredField(fieldName);
    field.setAccessible(true);
    try {
      field.set(instance, value);
    } catch (IllegalAccessException e) {
      throw new AssertionError(
          "Field should be accessible after setAccessible(true) call: "
              + e.getMessage());
    }
  }
}
