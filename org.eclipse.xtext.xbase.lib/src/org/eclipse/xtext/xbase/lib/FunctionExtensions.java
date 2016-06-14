/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Functions.Function3;
import org.eclipse.xtext.xbase.lib.Functions.Function4;
import org.eclipse.xtext.xbase.lib.Functions.Function5;
import org.eclipse.xtext.xbase.lib.Functions.Function6;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.annotations.GwtCompatible;

/**
 * This is an extension library for {@link Functions functions}, e.g. closures.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @see Functions
 */
@GwtCompatible public class FunctionExtensions {

	/**
	 * Curries a function that takes one argument.
	 * 
	 * @param function
	 *            the original function. May not be <code>null</code>.
	 * @param argument
	 *            the fixed argument.
	 * @return a function that takes no arguments. Never <code>null</code>.
	 */
	@Pure
	public static <P1, RESULT> Function0<RESULT> curry(final Function1<? super P1, ? extends RESULT> function, final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function0<RESULT>() {
			@Override
			public RESULT apply() {
				return function.apply(argument);
			}
		};
	}

	/**
	 * Curries a function that takes two arguments.
	 * 
	 * @param function
	 *            the original function. May not be <code>null</code>.
	 * @param argument
	 *            the fixed first argument of {@code function}.
	 * @return a function that takes one argument. Never <code>null</code>.
	 */
	@Pure
	public static <P1, P2, RESULT> Function1<P2, RESULT> curry(final Function2<? super P1, ? super P2, ? extends RESULT> function,
			final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function1<P2, RESULT>() {
			@Override
			public RESULT apply(P2 p) {
				return function.apply(argument, p);
			}
		};
	}

	/**
	 * Curries a function that takes three arguments.
	 * 
	 * @param function
	 *            the original function. May not be <code>null</code>.
	 * @param argument
	 *            the fixed first argument of {@code function}.
	 * @return a function that takes two arguments. Never <code>null</code>.
	 */
	@Pure
	public static <P1, P2, P3, RESULT> Function2<P2, P3, RESULT> curry(final Function3<? super P1, ? super P2, ? super P3, ? extends RESULT> function,
			final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function2<P2, P3, RESULT>() {
			@Override
			public RESULT apply(P2 p2, P3 p3) {
				return function.apply(argument, p2, p3);
			}
		};
	}

	/**
	 * Curries a function that takes four arguments.
	 * 
	 * @param function
	 *            the original function. May not be <code>null</code>.
	 * @param argument
	 *            the fixed first argument of {@code function}.
	 * @return a function that takes three arguments. Never <code>null</code>.
	 */
	@Pure
	public static <P1, P2, P3, P4, RESULT> Function3<P2, P3, P4, RESULT> curry(
			final Function4<? super P1, ? super P2, ? super P3, ? super P4, ? extends RESULT> function, final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function3<P2, P3, P4, RESULT>() {
			@Override
			public RESULT apply(P2 p2, P3 p3, P4 p4) {
				return function.apply(argument, p2, p3, p4);
			}
		};
	}

	/**
	 * Curries a function that takes five arguments.
	 * 
	 * @param function
	 *            the original function. May not be <code>null</code>.
	 * @param argument
	 *            the fixed first argument of {@code function}.
	 * @return a function that takes four arguments. Never <code>null</code>.
	 */
	@Pure
	public static <P1, P2, P3, P4, P5, RESULT> Function4<P2, P3, P4, P5, RESULT> curry(
			final Function5<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends RESULT> function, final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function4<P2, P3, P4, P5, RESULT>() {
			@Override
			public RESULT apply(P2 p2, P3 p3, P4 p4, P5 p5) {
				return function.apply(argument, p2, p3, p4, p5);
			}
		};
	}

	/**
	 * Curries a function that takes six arguments.
	 * 
	 * @param function
	 *            the original function. May not be <code>null</code>.
	 * @param argument
	 *            the fixed first argument of {@code function}.
	 * @return a function that takes five arguments. Never <code>null</code>.
	 */
	@Pure
	public static <P1, P2, P3, P4, P5, P6, RESULT> Function5<P2, P3, P4, P5, P6, RESULT> curry(
			final Function6<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends RESULT> function, final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function5<P2, P3, P4, P5, P6, RESULT>() {
			@Override
			public RESULT apply(P2 p2, P3 p3, P4 p4, P5 p5, P6 p6) {
				return function.apply(argument, p2, p3, p4, p5, p6);
			}
		};
	}
	
	
	/**
	 * Returns a composed function that first applies the {@code before}
	 * function to its input, and then applies the {@code after} function to the result.
	 * If evaluation of either function throws an exception, it is relayed to
	 * the caller of the composed function.
	 *
	 * @param <V> the type of input to the {@code before} function, and to the
	 *        composed function
	 * @param <T> the type of output of the {@code before} function, and input to the
	 *        {@code after} function
	 * @param <R> the type of output to the {@code after} function, and to the
	 *        composed function
	 * @param after the function to apply after the before function is applied
	 * @param before the function to apply before the after function is applied
	 * @return a composed function that first applies the {@code before}
	 * function and then applies the {@code after} function
	 * @throws NullPointerException if {@code before} or {@code after} is <code>null</code>
	 *
	 * @see #andThen(Function1, Function1)
	 * @since 2.9
	 */
	public static <V,T,R> Function1<V, R> compose(final Function1<? super T, ? extends R> after, final Function1<? super V, ? extends T> before) {
		if (after == null)
			throw new NullPointerException("after");
		if (before == null)
			throw new NullPointerException("before");
		return new Function1<V,R>() {
			@Override
			public R apply(V v) {
				return after.apply(before.apply(v));
			}
		};
	}
	
	/**
	 * Returns a composed function that first applies the {@code before}
	 * function to its input, and then applies the {@code after} function to the result.
	 * If evaluation of either function throws an exception, it is relayed to
	 * the caller of the composed function.
	 *
	 * @param <V> the type of input to the {@code before} function, and to the composed function
	 * @param <T> the type of output of the {@code before} function, and input to the {@code after} function
	 * @param <R> the type of output to the {@code after} function, and to the composed function
	 * @param before the function to apply before the after function is applied
	 * @param after the function to apply after the before function is applied
	 * @return a composed function that first applies the {@code before}
	 * function and then applies the {@code after} function
	 * @throws NullPointerException if {@code before} or {@code after} is <code>null</code>
	 *
	 * @see #compose(Function1, Function1)
	 * @since 2.9
	 */
	public static <V,T,R> Function1<V, R> andThen(final Function1<? super V, ? extends T> before, final Function1<? super T, ? extends R> after) {
		return compose(after, before);
	}
	
	/**
	 * Returns a composed function that first applies the {@code before}
	 * function to its input, and then applies the {@code after} function to the result.
	 * If evaluation of either function throws an exception, it is relayed to
	 * the caller of the composed function.
	 *
	 * @param <V1> the type of the first parameter to the {@code before} function, and to the composed function
	 * @param <V2> the type of the second parameter to the {@code before} function, and to the composed function
	 * @param <T> the type of output of the {@code before} function, and input to the {@code after} function
	 * @param <R> the type of output to the {@code after} function, and to the composed function
	 * @param before the function to apply before the {@code after} function is applied
	 * @param after the function to apply after the {@code before} function is applied
	 * @return a composed function that first applies the {@code before}
	 * function and then applies the {@code after} function
	 * @throws NullPointerException if {@code before} or {@code after} is null
	 *
	 * @see #compose(Function1, Function1)
	 * @since 2.9
	 */
	public static <V1,V2,T,R> Function2<V1, V2, R> andThen(final Function2<? super V1,? super V2, ? extends T> before, final Function1<? super T, ? extends R> after) {
		if (after == null)
			throw new NullPointerException("after");
		if (before == null)
			throw new NullPointerException("before");
		return new Function2<V1, V2, R>() {
			@Override
			public R apply(V1 v1, V2 v2) {
				return after.apply(before.apply(v1, v2));
			}
		};
	}
	
	
	/**
	 * Returns a composed {@code Procedure1} that performs, in sequence, the {@code before}
	 * operation followed by the {@code after} operation. If performing either
	 * operation throws an exception, it is relayed to the caller of the
	 * composed operation. If performing the {@code before} operation throws an exception,
	 * the {@code after} operation will not be performed.
	 *
	 * @param <T> the type of input for the {@code before} operation
	 * @param before the operation to perform first
	 * @param after the operation to perform afterwards
	 * @return a composed {@code Procedure1} that performs in sequence the {@code before}
	 * operation followed by the {@code after} operation
	 * @throws NullPointerException if {@code before} or {@code after} is null
	 * @since 2.9
	 */
	public static <T> Procedure1<T> andThen(final Procedure1<? super T> before, final Procedure1<? super T> after) {
		if (after == null)
			throw new NullPointerException("after");
		if (before == null)
			throw new NullPointerException("before");
		return new Procedures.Procedure1<T>() {
			@Override
			public void apply(T p) {
				before.apply(p);
				after.apply(p);
			}
		};
	}
	
	/**
	 * Returns a composed {@code Procedure1} that performs, in sequence, the {@code before}
	 * operation followed by the {@code after} operation. If performing either
	 * operation throws an exception, it is relayed to the caller of the
	 * composed operation. If performing the {@code before} operation throws an exception,
	 * the {@code after} operation will not be performed.
	 *
	 * @param before the operation to perform first
	 * @param after the operation to perform afterwards
	 * @return a composed {@code Procedure1} that performs in sequence the {@code before}
	 * operation followed by the {@code after} operation
	 * @throws NullPointerException if {@code before} or {@code after} is null
	 * @since 2.9
	 */
	public static Procedure0 andThen(final Procedure0 before, final Procedure0 after) {
		if (after == null)
			throw new NullPointerException("after");
		if (before == null)
			throw new NullPointerException("before");
		return new Procedures.Procedure0() {
			@Override
			public void apply() {
				before.apply();
				after.apply();
			}
		};
	}
	
}
