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

import com.google.common.base.Objects;
import com.google.common.collect.Multiset.Entry;

/**
 * Implementation of the {@code equals}, {@code hashCode}, and {@code toString}
 * methods of {@link Entry}.
 *
 * @author Mike Bostock
 */
public abstract class AbstractMultisetEntry<E> implements Entry<E> {
  /**
   * Indicates whether an object equals this entry, following the behavior
   * specified in {@link Entry#equals}.
   */
  @Override public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Entry)) {
      return false;
    }
    Entry<?> e = (Entry<?>) o;
    return Objects.equal(e.getElement(), getElement())
        && (e.getCount() == getCount());
  }

  /**
   * Return this entry's hash code, following the behavior specified in
   * {@link Entry#hashCode}.
   */
  @Override public int hashCode() {
    E e = getElement();
    return ((e == null) ? 0 : e.hashCode()) ^ getCount();
  }

  /**
   * Returns a string representation of this multiset entry. The string
   * representation consists of the associated element if the associated count
   * is one, and otherwise the associated element followed by the characters " x
   * " (space, x and space) followed by the count. Elements and counts are
   * converted to strings as by {@code String.valueOf}.
   */
  @Override public String toString() {
    String text = String.valueOf(getElement());
    int n = getCount();
    return (n == 1) ? text : (text + " x " + n);
  }
}
