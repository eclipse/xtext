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

import static com.google.common.base.Preconditions.checkState;

/**
 * A specialization of {@code AbstractIterator} for data sources which can
 * handle arbitrary removal by element, concurrently with iteration. Subclasses
 * must implement both the {@link AbstractIterator#computeNext} and {@link
 * #remove(Object)} methods.
 *
 * @author Kevin Bourrillion
 */
public abstract class AbstractRemovableIterator<T> extends AbstractIterator<T> {
  private T elementToRemove;
  private boolean canRemove;

  /** Removes {@code element} from the backing data source. */
  protected abstract void remove(T element);

  @Override public T next() {
    T element = super.next();
    canRemove = true;
    elementToRemove = element;
    return element;
  }

  /**
   * Removes from the underlying collection the last element returned by the
   * iterator.
   */
  @Override public void remove() {
    checkState(canRemove, "no calls to next() since the last call to remove()");
    try {
      remove(elementToRemove);
    } finally {
      elementToRemove = null;
      canRemove = false;
    }
  }
}
