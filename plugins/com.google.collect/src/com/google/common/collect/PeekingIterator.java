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

import java.util.Iterator;

/**
 * An iterator that supports a one-element lookahead while iterating.
 *
 * @author Mick Killianey
 */
public interface PeekingIterator<E> extends Iterator<E> {

  /**
   * Returns the next element in the iteration without advancing the iteration.
   *
   * <p>If possible, calls to {@code peek()} should not affect the iteration.
   * As is the case with most Iterators, modifications to the underlying
   * iteration may have unanticipated results.
   *
   * <p>If there are no remaining elements in the iteration, {@code peek()}
   * will throw a {@code NoSuchElementException}.  (A {@code null} return value
   * does <em>not</em> indicate that this iterator has reached the end of its
   * iteration.)
   *
   * <p><b>Usage note</b>:  Implementations may, but are not required to,
   * support {@code remove()} following a call to {@code peek()}.
   *
   * @throws java.util.NoSuchElementException if the iteration has
   *     no more elements.
   */
  E peek();
}
