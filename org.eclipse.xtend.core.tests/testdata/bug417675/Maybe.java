/*
   Copyright 2011 Atlassian

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package bug417675;

import java.util.Iterator;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;

/**
 * Implemented by things that may or may not contain a value.
 * <p>
 * Note there are some methods suggested by this interface that cannot be
 * expressed here as the return type cannot be expressed in Java's type system
 * (due to the lack of higher-kinded types). These are for instance (where M is
 * the implementing Maybe sub-type):
 * <ul>
 * <li>&lt;B&gt; M&lt;B&gt; map(Function&lt;? super A, B&gt;)
 * <li>&lt;B&gt; M&lt;B&gt; flatMap(Function&lt;? super A, M&ltB&gt&gt;)
 * <li>M&lt;A&gt; filter(final Predicate&lt;? super A&gt; p);
 * </ul>
 * 
 * @param <A> the contained type
 * 
 * @since 1.0
 */
public interface Maybe<A> extends Iterable<A>, Effect.Applicant<A> {
  /**
   * Get the value if defined. Throw an exception otherwise.
   * 
   * @return the wrapped value
   * @throws NoSuchElementException if this is a none
   */
  A get();

  /**
   * Get the value if defined, otherwise returns {@code other}.
   * 
   * @param <B> the destination type
   * @param other value to return if this {@link #isEmpty() is empty}
   * @return wrapped value if this {@link #isDefined() is defined}, otherwise
   * returns {@code other}
   */
  <B extends A> A getOrElse(final B other);

  /**
   * Get the value {@link #isDefined() if defined} or call the supplier and
   * return its value if not.
   * 
   * @param supplier called if this {@link #isEmpty() is empty}
   * @return the wrapped value or the value from the {@code Supplier}
   */
  A getOrElse(final Supplier<? extends A> supplier);

  /**
   * Get the value if defined or null if not.
   * <p>
   * Although the use of null is discouraged, code written to use these must
   * often interface with code that expects and returns nulls.
   * 
   * @return the value or null if not defined
   */
  A getOrNull();

  /**
   * Get the value or throws an error with the supplied message if not defined.
   * <p>
   * Used when absolutely sure this {@link #isDefined() is defined}.
   * 
   * @param msg the message for the error.
   * @return the contained value.
   */
  A getOrError(Supplier<String> msg);

  /**
   * Get the value or throws the supplied throwable if not defined.
   * <p>
   * Used when absolutely sure this {@link #isDefined() is defined}.
   * 
   * @param <X> the type of the {@link Throwable} that could be thrown.
   * @param ifUndefined the supplier of the throwable.
   * @throws X the throwable the supplier creates if there is no value.
   * @return the contained value.
   * @since 2.0
   */
  <X extends Throwable> A getOrThrow(Supplier<X> ifUndefined) throws X;

  /**
   * @return {@code true} if this holds a value, {@code false} otherwise.
   */
  boolean isDefined();

  /**
   * @return {@code true} if this does not hold a value, {@code false}
   * otherwise.
   */
  boolean isEmpty();

  /**
   * Whether this is {@link #isDefined() is defined} <strong>and</strong>
   * applying the predicate to the contained value returns true.
   * 
   * @param p the predicate to test
   * @return {@code true} if defined and the predicate returns true for the
   * contained value, {@code false} otherwise.
   */
  boolean exists(final Predicate<? super A> p);

  @Override
/**
   * @return an iterator over the contained value {@link #isDefined() if
   * defined}, or an empty one otherwise.
   */
  Iterator<A> iterator();

  /**
   * Returns <code>true</code> {@link #isEmpty() if empty} or the result of the
   * application of the given function to the value.
   * 
   * @param p The predicate function to test on the contained value.
   * @return <code>true</code> if no value or returns the result of the
   * application of the given function to the value.
   */
  boolean forall(final Predicate<? super A> p);
}