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
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Multiset implementation backed by a {@link HashMap}.
 *
 * @author Kevin Bourrillion
 * @author Jared Levy
 */
public final class HashMultiset<E> extends AbstractMapBasedMultiset<E> {

  /**
   * Creates a new empty {@code HashMultiset} using the default initial
   * capacity.
   */
  public static <E> HashMultiset<E> create() {
    return new HashMultiset<E>();
  }
  
  /**
   * Creates a new empty {@code HashMultiset} with the specified expected number
   * of distinct elements.
   *
   * @param distinctElements the expected number of distinct elements
   * @throws IllegalArgumentException if {@code distinctElements} is negative
   */
  public static <E> HashMultiset<E> create(int distinctElements) {
    return new HashMultiset<E>(distinctElements);
  }
  
  /**
   * Creates a new {@code HashMultiset} containing the specified elements.
   *
   * @param elements the elements that the multiset should contain
   */
  public static <E> HashMultiset<E> create(Iterable<? extends E> elements) {
    return new HashMultiset<E>(elements);
  }
  
  /**
   * Constructs a new empty {@code HashMultiset} using the default initial
   * capacity.
   */
  public HashMultiset() {
    super(new HashMap<E, AtomicInteger>());
  }

  /**
   * Constructs a new empty {@code HashMultiset} with the specified expected
   * number of distinct elements.
   *
   * @param distinctElements the expected number of distinct elements
   * @throws IllegalArgumentException if {@code distinctElements} is negative
   */
  private HashMultiset(int distinctElements) {
    super(new HashMap<E, AtomicInteger>(Maps.capacity(distinctElements)));
  }

  /**
   * Constructs a new {@code HashMultiset} containing the specified elements.
   *
   * @param elements the elements that the multiset should contain
   */
  private HashMultiset(Iterable<? extends E> elements) {
    this(Multisets.inferDistinctElements(elements));
    Iterables.addAll(this, elements); // careful if we make this class non-final
  }

  /**
   * @serialData the number of distinct elements, the first element, its count,
   *     the second element, its count, and so on
   */
  private void writeObject(ObjectOutputStream stream) throws IOException {
    stream.defaultWriteObject();
    Serialization.writeMultiset(this, stream);
  }
  
  private void readObject(ObjectInputStream stream)
      throws IOException, ClassNotFoundException {
    stream.defaultReadObject();
    setBackingMap(new HashMap<E, AtomicInteger>());
    Serialization.populateMultiset(this, stream);
  }
  
  private static final long serialVersionUID = 0;  
}
