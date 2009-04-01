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

import static com.google.common.base.Preconditions.checkContentsNotNull;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.Nullable;
import com.google.common.base.Objects;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Standard comparators and utilities for creating and working with comparators.
 *
 * <p>Some of these methods return an {@link Ordering}, a serializable class
 * that implements {@link Comparator} and includes many additional methods.
 * 
 * <p>Several method signatures include {@code <C extends Comparable>} with a
 * raw {@link Comparable}, instead of
 * {@code <C extends Comparable<? super C>}. That's necessary to support classes
 * defined without generics.
 *
 * @author Jared Levy
 * @author Kevin Bourrillion
 * @author Mike Bostock
 */
public final class Comparators {
  private Comparators() {}

  /**
   * Returns a comparator that uses the natural ordering of the values. The
   * comparator throws a {@link NullPointerException} when passed a null
   * parameter.
   */
  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  public static <T extends Comparable> Ordering<T> naturalOrder() {
    return (Ordering<T>) NATURAL_ORDER;
  }

  /** @see #naturalOrder */
  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  private static final Ordering<Comparable> NATURAL_ORDER
      = new NaturalOrdering();

  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  private static class NaturalOrdering extends Ordering<Comparable> {
    public int compare(Comparable left, Comparable right) {
      checkNotNull(right);    // later code throws NPE when only left is null
      if (left == right) {
        return 0;
      }

      /*
       * compareTo() may throw a ClassCastException if the elements are not
       * mutually comparable.
       */
      int result = left.compareTo(right);
      return result;
    }

    // preserve singleton-ness, so equals() and hashCode() work correctly
    private Object readResolve() {
      return NATURAL_ORDER;
    }
    
    @Override public String toString() {
      return "naturalOrder()";
    }
    
    private static final long serialVersionUID = 0;
  }

  /**
   * Returns a comparator that treats {@code null} as less than all other
   * values and uses {@code comparator} to compare non-null values.
   */
  public static <T> Ordering<T> nullLeastOrder(Comparator<T> comparator) {
    checkNotNull(comparator);
    return new NullLeastOrdering<T>(comparator);
  }
  
  private static class NullLeastOrdering<T> extends NullHandlingOrdering<T> {
    NullLeastOrdering(Comparator<T> comparator) {
      super(comparator);
    }
    
    @Override int compareNullAndNonNull() {
      return -1;
    }
    
    @Override public String toString() {
      return "nullLeastOrder(" + comparator + ")";
    }
    
    private static final long serialVersionUID = 0;
  }
  
  /**
   * Returns a comparator that uses the natural ordering of the values, but also
   * handles null values, treating them as less than all other values.
   */
  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  public static <T extends Comparable> Ordering<T> nullLeastOrder() {
    return (Ordering<T>) NULL_LEAST_ORDER;
  }

  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  private static final Ordering<Comparable> NULL_LEAST_ORDER
      = new NaturalNullLeastOrder();

  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  private static class NaturalNullLeastOrder
      extends NullLeastOrdering<Comparable> {
    private NaturalNullLeastOrder() {
      super(NATURAL_ORDER);
    }
    
    // preserve singleton-ness
    private Object readResolve() {
      return NULL_LEAST_ORDER;
    }
    
    @Override public String toString() {
      return "nullLeastOrder()";
    }
    
    private static final long serialVersionUID = 0;    
  }
  
  /**
   * Returns a comparator that treats {@code null} as greater than all other
   * values and uses the given comparator to compare non-null values.
   */
  public static <T> Ordering<T> nullGreatestOrder(Comparator<T> comparator) {
    checkNotNull(comparator);
    return new NullGreatestOrdering<T>(comparator);
  }

  private static class NullGreatestOrdering<T> extends NullHandlingOrdering<T> {
    NullGreatestOrdering(Comparator<T> comparator) {
      super(comparator);
    }
    
    @Override int compareNullAndNonNull() {
      return 1;
    }
    
    @Override public String toString() {
      return "nullGreatestOrder(" + comparator + ")";
    }
    
    private static final long serialVersionUID = 0;
  }
  
  /**
   * Returns a comparator that uses the natural ordering of the values, but also
   * handles null values, treating them as greater than all other values.
   */
  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  public static <T extends Comparable> Ordering<T> nullGreatestOrder() {
    return (Ordering<T>) NULL_GREATEST_ORDER;
  }

  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  private static final Ordering<Comparable> NULL_GREATEST_ORDER
      = new NaturalNullGreatestOrder();

  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  private static class NaturalNullGreatestOrder
      extends NullGreatestOrdering<Comparable> {
    private NaturalNullGreatestOrder() {
      super(NATURAL_ORDER);
    }
    
    // preserve singleton-ness
    private Object readResolve() {
      return NULL_GREATEST_ORDER;
    }
    
    @Override public String toString() {
      return "nullGreatestOrder()";
    }
    
    private static final long serialVersionUID = 0;    
  }

  private static abstract class NullHandlingOrdering<T> extends Ordering<T> {
    final Comparator<T> comparator;

    public NullHandlingOrdering(Comparator<T> comparator) {
      this.comparator = comparator;
    }

    public int compare(T left, T right) {
      if (left == right) {
        return 0;
      }
      if (left == null) {
        return compareNullAndNonNull();
      }
      if (right == null) {
        return -compareNullAndNonNull();
      }
      return comparator.compare(left, right);
    }

    /**
     * Returns the value this comparator should produce when comparing {@code
     * null} to any non-null value (in that order).
     */
    abstract int compareNullAndNonNull();

    @Override public boolean equals(Object object) {
      if (object == null) {
        return false;
      }
      if (object instanceof NullHandlingOrdering) {
        NullHandlingOrdering<?> that = (NullHandlingOrdering<?>) object;
        return (this.compareNullAndNonNull() == that.compareNullAndNonNull())
            && this.comparator.equals(that.comparator);
      }
      return false;
    }

    @Override public int hashCode() {
      return comparator.hashCode();
    }
  }
  
  /**
   * Returns a comparator which tries two comparators in order until a non-zero
   * result is found, returning that result, and returning zero only if both
   * comparators return zero.
   * 
   * @param first the first comparator to invoke
   * @param second the second comparator to invoke
   * @see #compound(Iterable)
   */
  @SuppressWarnings("unchecked")
  public static <T> Ordering<T> compound(Comparator<? super T> first,
      Comparator<? super T> second) {
    Comparator<T> firstT = (Comparator<T>) first;
    Comparator<T> secondT = (Comparator<T>) second;
    return compound(Arrays.asList(firstT, secondT));
  }
  
  /**
   * Returns a comparator which tries three comparators in order until a
   * non-zero result is found, returning that result, and returning zero only if
   * all comparators return zero.
   * 
   * @param first the first comparator to invoke
   * @param second the second comparator to invoke
   * @param third the third comparator to invoke
   * @see #compound(Iterable)
   */
  @SuppressWarnings("unchecked")
  public static <T> Ordering<T> compound(Comparator<? super T> first,
      Comparator<? super T> second, Comparator<? super T> third) {
    Comparator<T> firstT = (Comparator<T>) first;
    Comparator<T> secondT = (Comparator<T>) second;
    Comparator<T> thirdT = (Comparator<T>) third;
    return compound(Arrays.asList(firstT, secondT, thirdT));
  }
  
  /**
   * Returns a comparator which tries four comparators in order until a non-zero
   * result is found, returning that result, and returning zero only if all
   * comparators return zero.
   * 
   * @param first the first comparator to invoke
   * @param second the second comparator to invoke
   * @param third the third comparator to invoke
   * @param forth the fourth comparator to invoke
   * @see #compound(Iterable)
   */
  @SuppressWarnings("unchecked")
  public static <T> Ordering<T> compound(Comparator<? super T> first,
      Comparator<? super T> second, Comparator<? super T> third,
      Comparator<? super T> forth) {
    Comparator<T> firstT = (Comparator<T>) first;
    Comparator<T> secondT = (Comparator<T>) second;
    Comparator<T> thirdT = (Comparator<T>) third;
    Comparator<T> forthT = (Comparator<T>) forth;
    return compound(Arrays.asList(firstT, secondT, thirdT, forthT));
  }
  
  /**
   * Returns a comparator which tries each given comparator in order until a
   * non-zero result is found, returning that result, and returning zero only if
   * all comparators return zero.
   *
   * <p>Subsequent changes to the {@code rest} array do not affect the behavior
   * of the returned comparator.
   * 
   * @param first the first comparator to invoke
   * @param second the second comparator to invoke
   * @param third the third comparator to invoke
   * @param forth the fourth comparator to invoke
   * @param rest additional comparators to invoke as necessary
   * @see #compound(Iterable)
   */
  @SuppressWarnings("unchecked") // TODO: check that this is right
  public static <T> Ordering<T> compound(Comparator<? super T> first,
      Comparator<? super T> second, Comparator<? super T> third,
      Comparator<? super T> forth, Comparator<? super T>... rest) {
    // TODO: is this really the best way?  if so, explain why.
    Comparator<T> firstT = (Comparator<T>) first;
    Comparator<T> secondT = (Comparator<T>) second;
    Comparator<T> thirdT = (Comparator<T>) third;
    Comparator<T> forthT = (Comparator<T>) forth;
    List<Comparator<T>> list = Lists.newArrayList(
        firstT, secondT, thirdT, forthT);
    list.addAll(Arrays.asList((Comparator<T>[]) rest));
    return compound(list);
  }

  /**
   * Returns a comparator which tries each given comparator in order until a
   * non-zero result is found, returning that result, and returning zero only if
   * all comparators return zero.
   *
   * <p>The returned comparator is a "view" of the specified {@code Iterable}
   * instance; changes to the iterable will be reflected in the behavior of the
   * returned comparator.
   *
   * <p><b>Warning:</b> Supplying an argument with undefined iteration order,
   * such as a {@link java.util.HashSet}, will produce non-deterministic
   * results.
   *
   * @param comparators the comparators to try in order
   */
  public static <T> Ordering<T> compound(
      Iterable<? extends Comparator<? super T>> comparators) {
    return new CompoundOrder<T>(comparators);
  }

  /** @see Comparators#compound(Iterable) */
  static class CompoundOrder<T> extends Ordering<T> {
    private final Iterable<? extends Comparator<? super T>> comparators;

    CompoundOrder(Iterable<? extends Comparator<? super T>> comparators) {
      this.comparators = checkContentsNotNull(comparators);
    }

    public int compare(T left, T right) {
      if (left == right) {
        return 0;
      }
      for (Comparator<? super T> comparator : comparators) {
        int result = comparator.compare(left, right);
        if (result != 0) {
          return result;
        }
      }
      return 0;
    }

    @Override public boolean equals(Object object) {
      if (object instanceof CompoundOrder) {
        CompoundOrder<?> that = (CompoundOrder<?>) object;
        return (this.comparators).equals(that.comparators);
      }
      return false;
    }

    @Override public int hashCode() {
      return comparators.hashCode();
    }
    
    @Override public String toString() {
      return "compound(" + comparators + ")";
    }

    private static final long serialVersionUID = 0;
  }

  /**
   * Creates a comparator that compares any two items by applying a function to
   * each of them and using the natural ordering of the results.
   * 
   * @param function the function returning the value to compare. The function
   *     should never return {@code null}.
   * @return the generated comparator
   */
  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  public static <F, T extends Comparable> Ordering<F>
      fromFunction(Function<F, T> function) {
    return new TransformingNaturalOrder<F, T>(function);
  }

  /** @see Comparators#fromFunction(Function) */
  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  private static class TransformingNaturalOrder<F, T extends Comparable>
      extends Ordering<F> {
    private final Function<F, T> function;

    TransformingNaturalOrder(Function<F, T> function) {
      this.function = checkNotNull(function);
    }

    public int compare(F left, F right) {
      T leftTransformed = function.apply(left);
      T rightTransformed = function.apply(right);

      /*
       * Let this throw a ClassCastException if T is a bizarre Comparable that
       * can't be compared to itself.
       */
      return leftTransformed.compareTo(rightTransformed);
    }

    @Override public boolean equals(Object object) {
      if (object instanceof TransformingNaturalOrder) {
        TransformingNaturalOrder<?, ?> that
            = (TransformingNaturalOrder<?, ?>) object;
        return (this.function).equals(that.function);
      }
      return false;
    }

    @Override public int hashCode() {
      return function.hashCode();
    }

    @Override public String toString() {
      return "fromFunction(" + function + ")";
    }
    
    private static final long serialVersionUID = 0;
  }

  /**
   * Creates a comparator that compares any two items by applying a function to
   * each of them and using the supplied comparator to compare the results.
   *
   * @param function the function returning the value to compare
   * @param comparator the comparator that receives the function output
   * @return the generated comparator
   */
  public static <F, T> Ordering<F> fromFunction(
      Function<F, T> function, Comparator<? super T> comparator) {
    return new TransformingOrder<F, T>(function, comparator);
  }

  /** @see Comparators#fromFunction(Function,Comparator) */
  private static class TransformingOrder<F, T> extends Ordering<F> {
    private final Function<F, T> function;
    private final Comparator<? super T> comparator;

    TransformingOrder(
        Function<F, T> function, Comparator<? super T> comparator) {
      this.function = checkNotNull(function);
      this.comparator = checkNotNull(comparator);
    }

    public int compare(F left, F right) {
      return comparator.compare(function.apply(left), function.apply(right));
    }

    @Override public boolean equals(Object object) {
      if (object instanceof TransformingOrder) {
        TransformingOrder<?, ?> that = (TransformingOrder<?, ?>) object;
        return (this.function).equals(that.function)
            && (this.comparator).equals(that.comparator);
      }
      return false;
    }

    @Override public int hashCode() {
      return Objects.hashCode(function, comparator);
    }

    @Override public String toString() {
      return "fromFunction(" + function + ", " + comparator + ")";
    }
    
    private static final long serialVersionUID = 0;
  }

  /**
   * A comparator that compares objects by the natural ordering of their string
   * representations as returned by {@code toString()}. It does not support null
   * values.
   * 
   * <p>TODO: Deprecate this in favor of {@link #toStringOrder}.
   */
  public static final Ordering<Object> STRING_FORM_ORDER = new ToStringOrder();
  
  private static class ToStringOrder extends Ordering<Object> {
    public int compare(Object o1, Object o2) {
      return o1.toString().compareTo(o2.toString());
    }
    
    // preserve singleton-ness, so equals() and hashCode() work correctly
    private Object readResolve() {
      return STRING_FORM_ORDER;
    }
    
    @Override public String toString() {
      return "toStringOrder()";
    }
    
    private static final long serialVersionUID = 0;
  }
  
  /**
   * Returns a comparator that compares objects by the natural ordering of their
   * string representations as returned by {@code toString()}. It does not
   * support null values.
   */
  @SuppressWarnings("unchecked")  // casting STRING_FORM_ORDER
  public static final <T> Ordering<T> toStringOrder() {
    return (Ordering<T>) STRING_FORM_ORDER;
  }
  
  /**
   * Returns the smaller of the two values, according to their natural ordering.
   * If the values are equal, the first is returned.
   * 
   * <p>To handle more than two values, call
   * {@link Ordering#min(Object, Object, Object, Object...)} or
   * {@link Ordering#min(Iterable)} on the {@link Ordering} returned by
   * {@link Ordering#natural()}. 
   * 
   * @param a non-null value to compare, returned if less than or equal to b.
   * @param b non-null value to compare.
   * @throws ClassCastException if the parameters are not mutually comparable
   *         (for example, a string and an integer).
   */
  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  public static <T extends Comparable> T min(T a, T b) {
    /*
     * Let this throw a ClassCastException if T is a bizarre Comparable that
     * can't be compared to itself, as documented.
     */
    int result = a.compareTo(b);
    return result <= 0 ? a : b;
  }

  /**
   * Returns the larger of the two values, according to their natural ordering.
   * If the values are equal, the first is returned.
   * 
   * <p>To handle more than two values, call
   * {@link Ordering#max(Object, Object, Object, Object...)} or
   * {@link Ordering#max(Iterable)} on the {@link Ordering} returned by
   * {@link Ordering#natural()}.
   *  
   * @param a non-null value to compare, returned if greater than or equal to b.
   * @param b non-null value to compare.
   * @throws ClassCastException if the parameters are not mutually comparable
   *         (for example, a string and an integer).
   */
  @SuppressWarnings("unchecked")   // see explanation in class Javadoc
  public static <T extends Comparable> T max(T a, T b) {
    /*
     * Let this throw a ClassCastException if T is a bizarre Comparable that
     * can't be compared to itself, as documented.
     */
    int result = a.compareTo(b);
    return result >= 0 ? a : b;
  }

  /**
   * Returns the smaller of the two values according to the specified
   * comparator. If the values are equal, the first is returned. Null values
   * are allowed if the comparator supports them.
   *
   * <p>To handle more than two values, call
   * {@link Ordering#min(Object, Object, Object, Object...)} or
   * {@link Ordering#min(Iterable)} on the {@link Ordering} returned by
   * {@link Ordering#forComparator(Comparator)}. 
   * 
   * @param comparator comparator that compares the two values
   * @param a value to compare, returned if less than or equal to b
   * @param b value to compare
   */
  public static <T> T min(Comparator<? super T> comparator, @Nullable T a,
      @Nullable T b) {
    return comparator.compare(a, b) <= 0 ? a : b;
  }

  /**
   * Returns the larger of the two values according to the specified comparator.
   * If the values are equal, the first is returned. Null values are allowed if
   * the comparator supports them.
   *
   * <p>To handle more than two values, call
   * {@link Ordering#max(Object, Object, Object, Object...)} or
   * {@link Ordering#max(Iterable)} on the {@link Ordering} returned by
   * {@link Ordering#forComparator(Comparator)}. 
   * 
   * @param comparator comparator that compares the two values
   * @param a value to compare, returned if greater than or equal to b
   * @param b value to compare
   */
  public static <T> T max(Comparator<? super T> comparator, @Nullable T a,
      @Nullable T b) {
    return comparator.compare(a, b) >= 0 ? a : b;
  }

  /**
   * Returns a comparator that compares objects according to the order in
   * which they appear in the given list. Only objects present in the list
   * (according to {@link Object#equals}) may be compared. This comparator
   * imposes a "partial ordering" over the type {@code T}. Subsequent changes
   * to the {@code valuesInOrder} list will have no effect on the returned
   * comparator. Null values in the list are supported.
   * 
   * <p>The returned comparator throws an {@link ClassCastException} when it
   * receives an input parameter that isn't in {@code valuesInOrder}.
   * 
   * @param valuesInOrder the values that the returned comparator will be able
   *     to compare, in the order the comparator should follow
   * @return the comparator described above
   * @throws IllegalArgumentException if {@code valuesInOrder} contains any
   *     non-consecutive duplicate values (according to {@link Object#equals})
   */
  public static <T> Ordering<T> givenOrder(List<? extends T> valuesInOrder) {
    return new GivenOrder<T>(valuesInOrder);
  }

  /**
   * Returns the comparator that compares objects according to the order in
   * which they are given to this method. Only objects present in the argument
   * list (according to {@link Object#equals}) may be compared. This comparator
   * imposes a "partial ordering" over the type {@code T}. Null values in the
   * argument list are supported.
   * 
   * <p>The returned comparator throws a {@link ClassCastException} when it
   * receives an input parameter that isn't equal to {@code leastValue}
   * or in {@code remainingValuesInOrder}.
   * 
   * @param leastValue the value which the returned comparator should consider
   *     the "least" of all values
   * @param remainingValuesInOrder the rest of the values that the returned
   *     comparator will be able to compare, in the order the comparator should
   *     follow
   * @return the comparator described above
   * @throws IllegalArgumentException if any non-consecutive duplicate values
   *     (according to {@link Object#equals}) are present among the method
   *     arguments         
   */
  public static <T> Ordering<T> givenOrder(
      @Nullable T leastValue, T... remainingValuesInOrder) {
    return givenOrder(Lists.asList(leastValue, remainingValuesInOrder));
  }

  /** @see Comparators#givenOrder(List) */
  private static class GivenOrder<T> extends Ordering<T> {
    final Map<T, Integer> rankMap;

    GivenOrder(List<? extends T> valuesInOrder) {
      rankMap = buildRankMap(valuesInOrder);
    }

    public int compare(T left, T right) {
      return rank(left) - rank(right);   // safe because both are nonnegative
    }

    int rank(T value) {
      Integer rank = rankMap.get(value);
      if (rank == null) {
        throw new IncomparableValueException(value);
      }
      return rank;
    }

    static <T> Map<T, Integer> buildRankMap(
        Collection<? extends T> valuesInOrder) {
      Map<T, Integer> ranks
          = Maps.newHashMapWithExpectedSize(valuesInOrder.size());
      T previousValue = null;
      int rank = 0;
      for (T value : valuesInOrder) {
        if ((rank == 0) || !Objects.equal(value, previousValue)) {
          Integer priorRank = ranks.put(value, rank);
          if (priorRank != null) {
            throw new DuplicateValueException(value, priorRank, rank);
          }
        }
        rank++;
        previousValue = value;
      }
      return ranks;
    }

    @Override public boolean equals(Object object) {
      if (object instanceof GivenOrder) {
        GivenOrder<?> that = (GivenOrder<?>) object;
        return (this.rankMap).equals(that.rankMap);
      }
      return false;
    }

    @Override public int hashCode() {
      return rankMap.hashCode();
    }

    @Override public String toString() {
      return "givenOrder(" + rankMap + ")";
    }
    
    private static final long serialVersionUID = 0;
  }

  /**
   * Exception thrown by a {@link #givenOrder(List)} or
   * {@link #givenOrder(Object, Object...)} comparator when comparing a value
   * outside the set of values it can compare. Extending
   * {@link ClassCastException} may seem odd, but it fits the spirit of the
   * {@link Comparator#compare} specification, if you consider that we are
   * handling what is conceptually a "subtype" of {@code T}.
   */
  static class IncomparableValueException extends ClassCastException {
    final Object value;

    IncomparableValueException(Object value) {
      super("Cannot compare value: " + value);
      this.value = value;
    }

    private static final long serialVersionUID = 0;
  }

  /**
   * Exception thrown when a duplicate value is found in a list or array which
   * is not expected to contain any.
   */
  static class DuplicateValueException extends IllegalArgumentException {
    private static final long serialVersionUID = 0;
    final Object value;
    final int firstIndex;
    final int secondIndex;

    DuplicateValueException(Object value, int firstIndex, int secondIndex) {
      super(String.format("Duplicate value at indices %s and %s: %s",
          firstIndex, secondIndex, value));
      this.value = value;
      this.firstIndex = firstIndex;
      this.secondIndex = secondIndex;
    }
  }

  /**
   * Compares the two specified {@code byte} values. The sign of the value
   * returned is the same as that of the value that would be returned by the
   * call:
   *
   * <pre>  Byte.valueOf(a).compareTo(Byte.valueOf(b))</pre>
   *
   * @param a the first {@code byte} to compare
   * @param b the second {@code byte} to compare
   * @return a negative value if {@code a} is less than {@code b}; a positive
   *     value if {@code a} is greater than {@code b}; otherwise zero.
   */
  public static int compare(byte a, byte b) {
    return (a < b) ? -1 : ((a > b) ? 1 : 0);
  }

  /**
   * Compares the two specified {@code char} values. The sign of the value
   * returned is the same as that of the value that would be returned by the
   * call:
   *
   * <pre>  Character.valueOf(a).compareTo(Character.valueOf(b))</pre>
   *
   * @param a the first {@code char} to compare
   * @param b the second {@code char} to compare
   * @return a negative value if {@code a} is less than {@code b}; a positive
   *     value if {@code a} is greater than {@code b}; otherwise zero.
   */
  public static int compare(char a, char b) {
    return (a < b) ? -1 : ((a > b) ? 1 : 0);
  }

  /**
   * Compares the two specified {@code short} values. The sign of the value
   * returned is the same as that of the value that would be returned by the
   * call:
   *
   * <pre>  Short.valueOf(a).compareTo(Short.valueOf(b))</pre>
   *
   * @param a the first {@code short} to compare
   * @param b the second {@code short} to compare
   * @return a negative value if {@code a} is less than {@code b}; a positive
   *     value if {@code a} is greater than {@code b}; otherwise zero.
   */
  public static int compare(short a, short b) {
    return (a < b) ? -1 : ((a > b) ? 1 : 0);
  }

  /**
   * Compares the two specified {@code int} values. The sign of the value
   * returned is the same as that of the value that would be returned by the
   * call:
   *
   * <pre>  Integer.valueOf(a).compareTo(Integer.valueOf(b))</pre>
   *
   * @param a the first {@code int} to compare
   * @param b the second {@code int} to compare
   * @return a negative value if {@code a} is less than {@code b}; a positive
   *     value if {@code a} is greater than {@code b}; otherwise zero.
   */
  public static int compare(int a, int b) {
    return (a < b) ? -1 : ((a > b) ? 1 : 0);
  }

  /**
   * Compares the two specified {@code long} values. The sign of the value
   * returned is the same as that of the value that would be returned by the
   * call:
   *
   * <pre>  Long.valueOf(a).compareTo(Long.valueOf(b))</pre>
   *
   * @param a the first {@code long} to compare
   * @param b the second {@code long} to compare
   * @return a negative value if {@code a} is less than {@code b}; a positive
   *     value if {@code a} is greater than {@code b}; otherwise zero.
   */
  public static int compare(long a, long b) {
    return (a < b) ? -1 : ((a > b) ? 1 : 0);
  }

  /**
   * Compares the two specified {@code double} values. The sign of the value
   * returned is the same as that of the value that would be returned by the
   * call:
   *
   * <pre>  Double.valueOf(a).compareTo(Double.valueOf(b))</pre>
   *
   * @param a the first {@code double} to compare
   * @param b the second {@code double} to compare
   * @return a negative value if {@code a} is less than {@code b}; a positive
   *     value if {@code a} is greater than {@code b}; otherwise zero.
   * @see Double#compare
   */
  public static int compare(double a, double b) {
    return Double.compare(a, b); // takes care of Double.NaN
  }

  /**
   * Compares the two specified {@code float} values. The sign of the value
   * returned is the same as that of the value that would be returned by the
   * call:
   *
   * <pre>  Float.valueOf(a).compareTo(Float.valueOf(b))</pre>
   *
   * @param a the first {@code float} to compare
   * @param b the second {@code float} to compare
   * @return a negative value if {@code a} is less than {@code b}; a positive
   *     value if {@code a} is greater than {@code b}; otherwise zero.
   * @see Float#compare
   */
  public static int compare(float a, float b) {
    return Float.compare(a, b); // takes care of Float.NaN
  }

  /**
   * Compares the two specified {@code boolean} values. The sign of the value
   * returned is the same as that of the value that would be returned by the
   * call:
   *
   * <pre>  Boolean.valueOf(a).compareTo(Boolean.valueOf(b))</pre>
   *
   * @param a the first {@code boolean} to compare
   * @param b the second {@code boolean} to compare
   * @return a negative value if {@code a} is false and {@code b} is true; a
   *     positive value if {@code a} is true and {@code b} is false; otherwise
   *     zero.
   */
  public static int compare(boolean a, boolean b) {
    return (a == b) ? 0 : (a ? 1 : -1);
  }
}
