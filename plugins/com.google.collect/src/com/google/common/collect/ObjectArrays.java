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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

/**
 * Static utility methods pertaining to object arrays.
 *
 * @author Kevin Bourrillion
 */
public final class ObjectArrays {
  private ObjectArrays() {}

  /** An empty object array. */
  public static final Object[] EMPTY_ARRAY = new Object[0];

  /**
   * Returns a new array of the given length with the specified component type.
   *
   * @param type the component type
   * @param length the length of the new array
   */
  @SuppressWarnings("unchecked")
  public static <T> T[] newArray(Class<T> type, int length) {
    return (T[]) Array.newInstance(type, length);
  }

  /**
   * Returns a new array of the given length with the same type as a reference
   * array.
   *
   * @param reference any array of the desired type
   * @param length the length of the new array
   */
  public static <T> T[] newArray(T[] reference, int length) {
    Class<?> type = reference.getClass().getComponentType();

    // the cast is safe because result.getClass() == reference.getClass()
    @SuppressWarnings("unchecked")
    T[] result = (T[]) Array.newInstance(type, length);
    return result;
  }

  /**
   * Returns an empty array with the same component type as the specified array.
   *
   * @param array the array from which to infer the component type
   */
  public static <T> T[] emptyArray(T[] array) {
    return (array.length == 0) ? array : newArray(array, 0);
  }

  /**
   * Returns a new array that contains the concatenated contents of two arrays.
   *
   * @param first the first array of elements to concatenate
   * @param second the second array of elements to concatenate
   * @param type the component type of the returned array
   */
  public static <T> T[] concat(T[] first, T[] second, Class<T> type) {
    T[] result = newArray(type, first.length + second.length);
    System.arraycopy(first, 0, result, 0, first.length);
    System.arraycopy(second, 0, result, first.length, second.length);
    return result;
  }

  /**
   * Returns an array containing all of the elements in the specified
   * collection; the runtime type of the returned array is that of the specified
   * array. If the collection fits in the specified array, it is returned
   * therein. Otherwise, a new array is allocated with the runtime type of the
   * specified array and the size of the specified collection.
   *
   * <p>If the collection fits in the specified array with room to spare (i.e.,
   * the array has more elements than the collection), the element in the array
   * immediately following the end of the collection is set to null. This is
   * useful in determining the length of the collection <i>only</i> if the
   * caller knows that the collection does not contain any null elements.
   *
   * <p>This method returns the elements in the order they are returned by the
   * collection's iterator.
   * 
   * <p>TODO: Support concurrent collections whose size can change while the
   * method is running.
   *
   * @param c the collection for which to return an array of elements
   * @param array the array in which to place the collection elements
   * @throws ArrayStoreException if the runtime type of the specified array is
   *     not a supertype of the runtime type of every element in the specified
   *     collection
   */
  static <T> T[] toArrayImpl(Collection<?> c, T[] array) {
    int size = c.size();
    if (array.length < size) {
      array = newArray(array, size);
    }
    fillArray(c, array);
    if (array.length > size) {
      array[size] = null;
    }
    return array;
  }

  /**
   * Returns an array containing all of the elements in the specified
   * collection. This method returns the elements in the order they are returned
   * by the collection's iterator. The returned array is "safe" in that no
   * references to it are maintained by the collection. The caller is thus free
   * to modify the returned array.
   * 
   * <p>This method assumes that the collection size doesn't change while the
   * method is running.
   *
   * <p>TODO: Support concurrent collections whose size can change while the
   * method is running.
   *
   * @param c the collection for which to return an array of elements
   */
  static Object[] toArrayImpl(Collection<?> c) {
    return fillArray(c, new Object[c.size()]);
  }

  private static Object[] fillArray(Iterable<?> elements, Object[] array) {
    int i = 0;
    for (Object element : elements) {
      array[i++] = element;
    }
    return array;
  }
}
