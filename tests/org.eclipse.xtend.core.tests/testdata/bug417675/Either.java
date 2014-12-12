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

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;

/**
 * A class that acts as a container for a value of one of two types. An Either
 * will be either {@link Either.Left Left} or {@link Either.Right Right}.
 * <p>
 * Checking which type an Either is can be done by calling the @
 * {@link #isLeft()} and {@link #isRight()} methods.
 * <p>
 * An Either can be used to express a success or failure case. By convention,
 * Right is used to store the success value, (you can use the play on words
 * "right" == "correct" as a mnemonic) and Left is used to store failure values
 * (such as exceptions).
 * <p>
 * While this class is public and abstract it does not expose a constructor as
 * only the concrete Left and Right subclasses are meant to be used.
 * <p>
 * Either is immutable, but does not force immutability on contained objects; if
 * the contained objects are mutable then equals and hashcode methods should not
 * be relied on.
 * 
 * @since 1.0
 */
public abstract class Either<L, R> implements Serializable {
  private static final long serialVersionUID = -1L;

  //
  // factory methods
  //

  /**
   * @param <L> the LHS type
   * @param <R> the RHS type
   * @param left the value to be stored, must not be null
   * @return a Left containing the supplied value
   */
  public static <L, R> Either<L, R> left(final L left) {
    checkNotNull(left);
    return new Left<L, R>(left);
  }

  /**
   * @param <L> the LHS type
   * @param <R> the RHS type
   * @param right the value to be stored, must not be null
   * @return a Right containing the supplied value
   */
  public static <L, R> Either<L, R> right(final R right) {
    checkNotNull(right);
    return new Right<L, R>(right);
  }

  //
  // constructors
  //

  Either() {}

  //
  // methods
  //

  /**
   * Projects this either as a left.
   * 
   * @return A left projection of this either.
   */
  public final LeftProjection left() {
    return new LeftProjection();
  }

  /**
   * Projects this either as a right.
   * 
   * @return A right projection of this either.
   */
  public final RightProjection right() {
    return new RightProjection();
  }

  // right-bias

  /**
   * Map the given function across the right hand side value if it is one.
   * 
   * @param <X> the RHS type
   * @param f The function to map .
   * @return A new either value after mapping with the function applied if this
   * is a Right.
   * @since 2.2
   */
  public final <X> Either<L, X> map(final Function<? super R, X> f) {
    return right().map(f);
  }

  /**
   * Binds the given function across the right hand side value if it is one.
   * 
   * @param <X> the RHS type
   * @param f the function to bind.
   * @return A new either value after binding with the function applied if this
   * is a Right.
   * @since 2.2
   */
  public final <X> Either<L, X> flatMap(final Function<? super R, Either<L, X>> f) {
    return right().flatMap(f);
  }

  /**
   * Map the given function across the left hand side value if it is one.
   * 
   * @param <X> the LHS type
   * @param f The function to map.
   * @return A new either value after mapping with the function applied if this
   * is a Left.
   * @since 2.2
   */
  public final <X> Either<X, R> leftMap(final Function<? super L, X> f) {
    return left().map(f);
  }

  //
  // abstract stuff
  //

  /**
   * Returns <code>true</code> if this either is a left, <code>false</code>
   * otherwise.
   * 
   * @return <code>true</code> if this either is a left, <code>false</code>
   * otherwise.
   */
  public abstract boolean isLeft();

  /**
   * Returns <code>true</code> if this either is a right, <code>false</code>
   * otherwise.
   * 
   * @return <code>true</code> if this either is a right, <code>false</code>
   * otherwise.
   */
  public abstract boolean isRight();

  /**
   * If this is a left, then return the left value in right, or vice versa.
   * 
   * @return an Either that is a Left if this is a Right or a Right if this is a
   * Left. The value remains the same.
   */
  public abstract Either<R, L> swap();

  /**
   * Applies the function to the wrapped value, applying ifLeft it this is a
   * Left and ifRight if this is a Right.
   * 
   * @param <V> the destination type
   * @param ifLeft the function to apply if this is a Left
   * @param ifRight the function to apply if this is a Right
   * @return the result of the applies function
   */
  public abstract <V> V fold(Function<? super L, V> ifLeft, Function<? super R, V> ifRight);

  /**
   * Map the given functions across the appropriate side.
   * 
   * @param <LL> the LHS type
   * @param <RR> the RHS type
   * @param ifLeft The function to map if this Either is a left.
   * @param ifRight The function to map if this Either is a right.
   * @return A new either value after mapping with the appropriate function
   * applied.
   * @since 2.2
   */
  public abstract <LL, RR> Either<LL, RR> bimap(final Function<? super L, ? extends LL> ifLeft, final Function<? super R, ? extends RR> ifRight);

  //
  // internal only, should not be accessed from outside this class
  //

  // value accessor for Left
  L getLeft() {
    throw new NoSuchElementException();
  }

  // value accessor for Right
  R getRight() {
    throw new NoSuchElementException();
  }

  //
  // inner class implementations
  //

  static final class Left<L, R> extends Either<L, R> {
    private static final long serialVersionUID = -6846704510630179771L;

    private final L value;

    public Left(final L value) {
      checkNotNull(value);
      this.value = value;
    }

    @Override final L getLeft() {
      return value;
    }

    @Override public boolean isLeft() {
      return true;
    }

    @Override public boolean isRight() {
      return false;
    }

    @Override public Either<R, L> swap() {
      return right(value);
    }

    @Override public <V> V fold(final Function<? super L, V> ifLeft, final Function<? super R, V> ifRight) {
      return ifLeft.apply(value);
    }

    @Override public <LL, RR> Either<LL, RR> bimap(Function<? super L, ? extends LL> ifLeft, Function<? super R, ? extends RR> ifRight) {
      @SuppressWarnings("unchecked")
      final Either<LL, RR> map = (Either<LL, RR>) left().map(ifLeft);
      return map;
    }

    @Override public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if ((o == null) || !(o instanceof Left<?, ?>)) {
        return false;
      }
      return value.equals(((Left<?, ?>) o).value);
    }

    @Override public int hashCode() {
      return value.hashCode();
    }

    @Override public String toString() {
      return "Either.Left(" + value.toString() + ")";
    }
  }

  static final class Right<L, R> extends Either<L, R> {
    private static final long serialVersionUID = 5025077305715784930L;

    private final R value;

    public Right(final R value) {
      checkNotNull(value);
      this.value = value;
    }

    @Override final R getRight() {
      return value;
    }

    @Override public boolean isRight() {
      return true;
    }

    @Override public boolean isLeft() {
      return false;
    }

    @Override public Either<R, L> swap() {
      return left(value);
    }

    @Override public <V> V fold(final Function<? super L, V> ifLeft, final Function<? super R, V> ifRight) {
      return ifRight.apply(value);
    }

    @Override public <LL, RR> Either<LL, RR> bimap(Function<? super L, ? extends LL> ifLeft, Function<? super R, ? extends RR> ifRight) {
      @SuppressWarnings("unchecked")
      final Either<LL, RR> map = (Either<LL, RR>) right().map(ifRight);
      return map;
    }

    @Override public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if ((o == null) || !(o instanceof Right<?, ?>)) {
        return false;
      }
      return value.equals(((Right<?, ?>) o).value);
    }

    @Override public int hashCode() {
      return value.hashCode();
    }

    @Override public String toString() {
      return "Either.Right(" + value.toString() + ")";
    }
  }

  /**
   * Holds the common implementation for both projections.
   */
  abstract class AbstractProjection<A, B> implements Projection<A, B, L, R> {
    @Override
	public final Iterator<A> iterator() {
      return Collections.<A>emptyList().iterator();
    }

    @Override
	public final Either<L, R> either() {
      return Either.this;
    }

    @Override
	public final boolean isEmpty() {
      return !isDefined();
    }

    @Override
	public final Optional<A> toOption() {
      return isDefined() ? Optional.of(get()) : Optional.<A> absent();
    }

    @Override
	public final boolean exists(final Predicate<? super A> f) {
      return isDefined() && f.apply(get());
    }

    @Override
	final public A getOrNull() {
      return isDefined() ? get() : null;
    }

    @Override
	public final boolean forall(final Predicate<? super A> f) {
      return isEmpty() || f.apply(get());
    }

    @Override
	public final A getOrError(final Supplier<String> err) {
      return toOption().get();
    }

    @Override
	public <X extends Throwable> A getOrThrow(Supplier<X> ifUndefined) throws X {
      return toOption().get();
    }

    @Override
	public final A getOrElse(final Supplier<? extends A> a) {
      return isDefined() ? get() : a.get();
    }

    @Override
	public final <X extends A> A getOrElse(final X x) {
      return isDefined() ? get() : x;
    }

    @Override
	public final void foreach(final Effect<? super A> f) {
      if (isDefined()) {
        f.apply(get());
      }
    }
  }

  /**
   * A left projection of an either value.
   */
  @SuppressWarnings("unused")
  public final class LeftProjection extends AbstractProjection<L, R> implements Projection<L, R, L, R> {
    private LeftProjection() {}

    @Override
	public L get() {
      return getLeft();
    }

    @Override
	public boolean isDefined() {
      return isLeft();
    }

    @Override
	public L on(final Function<? super R, ? extends L> f) {
      return isLeft() ? get() : f.apply(right().get());
    }

    //
    // definitions that can't be shared without higher-kinded types
    //

    /**
     * Map the given function across this projection's value if it has one.
     * 
     * @param <X> the LHS type
     * @param f The function to map across this projection.
     * @return A new either value after mapping.
     */
    public <X> Either<X, R> map(final Function<? super L, X> f) {
      return isLeft() ? new Left<X, R>(f.apply(get())) : this.<X> toRight();
    }

    /**
     * Binds the given function across this projection's value if it has one.
     * 
     * @param <X> the LHS type
     * @param f The function to bind across this projection.
     * @return A new either value after binding.
     */
    public <X> Either<X, R> flatMap(final Function<? super L, Either<X, R>> f) {
      return isLeft() ? f.apply(get()) : this.<X> toRight();
    }

    <X> Right<X, R> toRight() {
      return new Right<X, R>(getRight());
    }

    /**
     * Anonymous bind through this projection.
     * 
     * @param <X> the LHS type
     * @param e The value to bind with.
     * @return An either after binding through this projection.
     */
    public <X> Either<X, R> sequence(final Either<X, R> e) {
      return flatMap(Functions.<Either<X, R>> constant(e));
    }

    /**
     * Returns <code>None</code> if this projection has no value or if the given
     * predicate <code>p</code> does not hold for the value, otherwise, returns
     * a right in <code>Some</code>.
     * 
     * @param <X> the RHS type
     * @param f The predicate function to test on this projection's value.
     * @return <code>None</code> if this projection has no value or if the given
     * predicate <code>p</code> does not hold for the value, otherwise, returns
     * a right in <code>Some</code>.
     */
    public <X> Optional<Either<L, X>> filter(final Predicate<? super L> f) {
      if (isLeft() && f.apply(get())) {
        final Either<L, X> result = new Left<L, X>(get());
        return Optional.of(result);
      }
      return Optional.absent();
    }

    /**
     * Function application on this projection's value.
     * 
     * @param <X> the LHS type
     * @param either The either of the function to apply on this projection's
     * value.
     * @return The result of function application within either.
     */
    public <X> Either<X, R> apply(final Either<Function<L, X>, R> either) {
      return either.left().flatMap(new Function<Function<L, X>, Either<X, R>>() {
        @Override
		public Either<X, R> apply(final Function<L, X> f) {
          return map(f);
        }
      });
    }

    /**
     * Coerces our right type as X. Dangerous, isLeft() must be true
     * 
     * @param <X> the type to coerce to.
     * @return an either with the coerced right type.
     */
    <X> Either<L, X> as() {
      return left(get());
    }
  }

  /**
   * A right projection of an either value.
   */
  @SuppressWarnings("unused")
  public final class RightProjection extends AbstractProjection<R, L> implements Projection<R, L, L, R> {
    private RightProjection() {}

    @Override
	public R get() {
      return getRight();
    }

    @Override
	public boolean isDefined() {
      return isRight();
    }

    @Override
	public R on(final Function<? super L, ? extends R> f) {
      return isRight() ? get() : f.apply(left().get());
    }

    //
    // definitions that can't be shared without higher-kinded types
    //

    /**
     * Map the given function across this projection's value if it has one.
     * 
     * @param <X> the RHS type
     * @param f The function to map across this projection.
     * @return A new either value after mapping.
     */
    public <X> Either<L, X> map(final Function<? super R, X> f) {
      return isRight() ? new Right<L, X>(f.apply(get())) : this.<X> toLeft();
    }

    /**
     * Binds the given function across this projection's value if it has one.
     * 
     * @param <X> the RHS type
     * @param f The function to bind across this projection.
     * @return A new either value after binding.
     */
    public <X> Either<L, X> flatMap(final Function<? super R, Either<L, X>> f) {
      return isRight() ? f.apply(get()) : this.<X> toLeft();
    }

    <X> Left<L, X> toLeft() {
      return new Left<L, X>(left().get());
    }

    /**
     * Anonymous bind through this projection.
     * 
     * @param <X> the RHS type
     * @param e The value to bind with.
     * @return An either after binding through this projection.
     */
    public <X> Either<L, X> sequence(final Either<L, X> e) {
      return flatMap(Functions.<Either<L, X>> constant(e));
    }

    /**
     * Returns <code>None</code> if this projection has no value or if the given
     * predicate <code>p</code> does not hold for the value, otherwise, returns
     * a left in <code>Some</code>.
     * 
     * @param <X> the LHS type
     * @param f The predicate function to test on this projection's value.
     * @return <code>None</code> if this projection has no value or if the given
     * predicate <code>p</code> does not hold for the value, otherwise, returns
     * a left in <code>Some</code>.
     */
    public <X> Optional<Either<X, R>> filter(final Predicate<? super R> f) {
      if (isRight() && f.apply(get())) {
        final Either<X, R> result = new Right<X, R>(get());
        return Optional.of(result);
      }
      return Optional.absent();
    }

    /**
     * Function application on this projection's value.
     * 
     * @param <X> the RHS type
     * @param either The either of the function to apply on this projection's
     * value.
     * @return The result of function application within either.
     */
    public <X> Either<L, X> apply(final Either<L, Function<R, X>> either) {
      return either.right().flatMap(new Function<Function<R, X>, Either<L, X>>() {
        @Override
		public Either<L, X> apply(final Function<R, X> f) {
          return map(f);
        }
      });
    }

    /**
     * Coerces our left type as X. Dangerous, isRight() must be true
     * 
     * @param <X> the type to coerce to.
     * @return an either with the coerced left type.
     */
    <X> Either<X, R> as() {
      return right(get());
    }
  }

  public interface Projection<A, B, L, R> extends Maybe<A> {
    /**
     * The either value underlying this projection.
     * 
     * @return The either value underlying this projection.
     */
    Either<L, R> either();

    /**
     * Returns this projection's value in <code>Some</code> if it exists,
     * otherwise <code>None</code>.
     * 
     * @return This projection's value in <code>Some</code> if it exists,
     * otherwise <code>None</code>.
     */
    Optional<? super A> toOption();

    /**
     * The value of this projection or the result of the given function on the
     * opposing projection's value.
     * 
     * @param f The function to execute if this projection has no value.
     * @return The value of this projection or the result of the given function
     * on the opposing projection's value.
     */
    A on(Function<? super B, ? extends A> f);
  }
}
