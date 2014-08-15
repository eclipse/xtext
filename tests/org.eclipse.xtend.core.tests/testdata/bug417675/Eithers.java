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

import static com.google.common.base.Suppliers.compose;
import static com.google.common.base.Suppliers.ofInstance;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * Utility functions for Eithers.
 * 
 * @since 1.2
 */
public class Eithers {

  // /CLOVER:OFF

  private Eithers() {}

  // /CLOVER:ON

  /**
   * Extracts an object from an Either, regardless of the side in which it is
   * stored, provided both sides contain the same type. This method will never
   * return null.
   * 
   * @param <T> the type for both the LHS and the RHS
   * @param either use whichever side holds the value to return
   * @return the value from whichever side holds it
   */
  public static <T> T merge(final Either<T, T> either) {
    if (either.isLeft()) {
      return either.left().get();
    }
    return either.right().get();
  }

  /**
   * Creates an Either based on a boolean expression. If predicate is true, a
   * Right will be returned containing the supplied right value; if it is false,
   * a Left will be returned containing the supplied left value.
   * 
   * @param <L> the LHS type
   * @param <R> the RHS type
   * @param predicate if predicate is true, a Right will be returned if it is false,
   * a Left will be returned containing the supplied left value.
   * @param left the LHS value
   * @param right the RHS value
   * @return an either with the appropriately selected value
   */
  public static <L, R> Either<L, R> cond(final boolean predicate, final L left, final R right) {
    return predicate ? Either.<L, R> right(right) : Either.<L, R> left(left);
  }

  /**
   * Simplifies extracting a value or throwing a checked exception from an
   * Either.
   * 
   * @param <X> the exception type
   * @param <A> the value type
   * @param either to extract from
   * @return the value from the RHS
   * @throws X the exception on the LHS
   */
  public static <X extends Exception, A> A getOrThrow(final Either<X, A> either) throws X {
    if (either.isLeft()) {
      throw either.left().get();
    }
    return either.right().get();
  }

  /**
   * Collect the right values if there are only rights, otherwise return the
   * first left encountered.
   * 
   * @param <L> the LHS type
   * @param <R> the RHS type
   * @param eithers an Iterable of either values
   * @return either the iterable of right values, or the first left encountered.
   */
  public static <L, R> Either<L, Iterable<R>> sequenceRight(final Iterable<Either<L, R>> eithers) {
    ImmutableList.Builder<R> it = ImmutableList.builder();
    for (final Either<L, R> e : eithers) {
      if (e.isLeft()) {
        return e.left().<Iterable<R>> as();
      }
      it.add(e.right().get());
    }
    return Either.right((Iterable<R>) it.build());
  }

  /**
   * Collect the left values if there are only lefts, otherwise return the
   * first right encountered.
   * 
   * @param <L> the LHS type
   * @param <R> the RHS type
   * @param eithers an Iterable of either values
   * @return either the iterable of left values, or the first right encountered.
   */
  public static <L, R> Either<Iterable<L>, R> sequenceLeft(final Iterable<Either<L, R>> eithers) {
    Iterable<L> it = ImmutableList.of();
    for (final Either<L, R> e : eithers) {
      if (e.isRight()) {
        return e.right().<Iterable<L>> as();
      }
      it = com.google.common.collect.Iterables.concat(it, e.left());
    }
    return Either.left(it);
  }

  /**
   * A predicate that tests if the supplied either is a left.
   * 
   * @param <L> the LHS type
   * @param <R> the RHS type
   * @return the predicate testing left-hand-sidedness
   */
  public static <L, R> Predicate<Either<L, R>> isLeft() {
    return new Predicate<Either<L, R>>() {
      public boolean apply(Either<L, R> e) {
        return e.isLeft();
      }
    };
  }

  /**
   * A predicate that tests if the supplied either is a right.
   * 
   * @param <L> the LHS type
   * @param <R> the RHS type
   * @return the predicate testing right-hand-sidedness
   */
  public static <L, R> Predicate<Either<L, R>> isRight() {
    return new Predicate<Either<L, R>>() {
      public boolean apply(Either<L, R> e) {
        return e.isRight();
      }
    };
  }

  /**
   * A function that maps an either to an option of its left type. The Function
   * will return a defined {@link Optional} containing the either's left value if
   * {Either#isLeft()} is true, an undefined {@link Optional} otherwise.
   * 
   * @param <L> the LHS type
   * @param <R> the RHS type
   * @return the function returning a defined option for left-hand-sided eithers
   */
  public static <L, R> Function<Either<L, R>, Optional<L>> leftMapper() {
    return new Function<Either<L, R>, Optional<L>>() {
      public Optional<L> apply(Either<L, R> either) {
        return either.left().toOption();
      }
    };
  }

  /**
   * A function that maps an either to an option of its right type. The Function
   * will return a defined {@link Optional} containing the either's right value if
   * {Either#isRight()} is true, an undefined {@link Optional} otherwise.
   * 
   * @param <L> the LHS type
   * @param <R> the RHS type
   * @return the function returning a defined option for right-hand-sided eithers
   */
  public static <L, R> Function<Either<L, R>, Optional<R>> rightMapper() {
    return new Function<Either<L, R>, Optional<R>>() {
      public Optional<R> apply(Either<L, R> either) {
        return either.right().toOption();
      }
    };
  }

  /**
   * Takes an {@link Iterable} of {@link Either eithers}, and collects the left
   * values of every either which has a left value
   * 
   * @param <L> the LHS type
   * @param <R> the RHS type
   * @param it iterable of eithers to filter and transform from
   * @return the left values contained in the contents of it
   */
  public static <L, R> Iterable<L> filterLeft(Iterable<Either<L, R>> it) {
    return Optional.presentInstances(Iterables.transform(it, Eithers.<L, R> leftMapper()));
  }

  /**
   * Takes an {@link Iterable} of {@link Either eithers}, and collects the right
   * values of every either which has a left value
   * 
   * @param <L> the LHS type
   * @param <R> the RHS type
   * @param it iterable of eithers to filter and transform from
   * @return the right values contained in the contents of it
   */
  public static <L, R> Iterable<R> filterRight(Iterable<Either<L, R>> it) {
    return Optional.presentInstances(Iterables.transform(it, Eithers.<L, R> rightMapper()));
  }

  public static <L, R> Function<L, Either<L, R>> toLeft() {
    return new Function<L, Either<L, R>>() {
      public Either<L, R> apply(final L from) {
        return Either.left(from);
      }
    };
  }

  // allows static import
  public static <L, R> Function<L, Either<L, R>> toLeft(final Class<L> leftType, final Class<R> rightType) {
    return Eithers.toLeft();
  }

  public static <L, R> Supplier<Either<L, R>> toLeft(final L l) {
    return compose(Eithers.<L, R> toLeft(), ofInstance(l));
  }

  // allows static import
  public static <L, R> Supplier<Either<L, R>> toLeft(final L l, final Class<R> rightType) {
    return Eithers.toLeft(l);
  }

  public static <L, R> Function<R, Either<L, R>> toRight() {
    return new Function<R, Either<L, R>>() {
      public Either<L, R> apply(final R from) {
        return Either.right(from);
      }
    };
  }

  // allows static import
  public static <L, R> Function<R, Either<L, R>> toRight(final Class<L> leftType, final Class<R> rightType) {
    return Eithers.toRight();
  }

  public static <L, R> Supplier<Either<L, R>> toRight(final R r) {
    return compose(Eithers.<L, R> toRight(), ofInstance(r));
  }

  // allows static import
  public static <L, R> Supplier<Either<L, R>> toRight(final Class<L> leftType, final R r) {
    return Eithers.toRight(r);
  }

  /**
   * Upcasts an {@link Either either} of left type L to an either of left type
   * LL, which is a super type of L, keeping the right type unchanged.
   * 
   * @param e the source either
   * @param <LL> the super type of the contained left type
   * @param <L> the contained left type
   * @param <R> the contained right type
   * @return an either of left type LL and right type R
   * @since 2.0
   */
  public static <LL, L extends LL, R> Either<LL, R> upcastLeft(Either<L, R> e) {
    return e.left().map(Functions.<LL> identity());
  }

  /**
   * Upcasts an {@link Either either} of right type R to an either of right type
   * RR, which is a super type of R, keeping the left type unchanged.
   * 
   * @param e the source either
   * @param <L> the contained left type
   * @param <RR> the super type of the contained right type
   * @param <R> the contained right type
   * @return an either of left type L and right type RR
   * @since 2.0
   */
  public static <L, RR, R extends RR> Either<L, RR> upcastRight(Either<L, R> e) {
    return e.right().map(Functions.<RR> identity());
  }
}
