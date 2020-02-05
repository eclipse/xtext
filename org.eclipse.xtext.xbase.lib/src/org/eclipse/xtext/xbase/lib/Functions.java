/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import com.google.common.annotations.GwtCompatible;

/**
 * This class serves as a container for the various function types that are used to implement the type of closures in
 * Xbase.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @see FunctionExtensions
 * @see Procedures
 */
@GwtCompatible public interface Functions {

	/**
	 * A function without any parameters.
	 * 
	 * @param <Result>
	 *            the result of the single closure {@link #apply() method}.
	 */
	interface Function0<Result> {

		Result apply();

	}

	/**
	 * A function that takes one argument.
	 * 
	 * @param <Param>
	 *            the only argument that is passed to the {@link #apply(Object) closure}
	 * @param <Result>
	 *            the result of the single closure {@link #apply(Object) method}.
	 */
	interface Function1<Param, Result> {

		Result apply(Param p);

	}

	/**
	 * A function that takes two arguments.
	 * 
	 * @param <P1>
	 *            the first argument that is passed to the {@link #apply(Object, Object) closure}
	 * @param <P2>
	 *            the second argument that is passed to the {@link #apply(Object, Object) closure}
	 * @param <Result>
	 *            the result of the single closure {@link #apply(Object, Object) method}.
	 */
	interface Function2<P1, P2, Result> {

		Result apply(P1 p1, P2 p2);

	}

	/**
	 * A function that takes three arguments.
	 * 
	 * @param <P1>
	 *            the first argument that is passed to the {@link #apply(Object, Object, Object) closure}
	 * @param <P2>
	 *            the second argument that is passed to the {@link #apply(Object, Object, Object) closure}
	 * @param <P3>
	 *            the third argument that is passed to the {@link #apply(Object, Object, Object) closure}
	 * @param <Result>
	 *            the result of the single closure {@link #apply(Object, Object, Object) method}.
	 */
	interface Function3<P1, P2, P3, Result> {

		Result apply(P1 p1, P2 p2, P3 p3);

	}

	/**
	 * A function that takes four arguments.
	 * 
	 * @param <P1>
	 *            the first argument that is passed to the {@link #apply(Object, Object, Object, Object) closure}
	 * @param <P2>
	 *            the second argument that is passed to the {@link #apply(Object, Object, Object, Object) closure}
	 * @param <P3>
	 *            the third argument that is passed to the {@link #apply(Object, Object, Object, Object) closure}
	 * @param <P4>
	 *            the fourth argument that is passed to the {@link #apply(Object, Object, Object, Object) closure}
	 * @param <Result>
	 *            the result of the single closure {@link #apply(Object, Object, Object, Object) method}.
	 */
	interface Function4<P1, P2, P3, P4, Result> {

		Result apply(P1 p1, P2 p2, P3 p3, P4 p4);

	}

	/**
	 * A function that takes five arguments.
	 * 
	 * @param <P1>
	 *            the first argument that is passed to the {@link #apply(Object, Object, Object, Object, Object)
	 *            closure}
	 * @param <P2>
	 *            the second argument that is passed to the {@link #apply(Object, Object, Object, Object, Object)
	 *            closure}
	 * @param <P3>
	 *            the third argument that is passed to the {@link #apply(Object, Object, Object, Object, Object)
	 *            closure}
	 * @param <P4>
	 *            the fourth argument that is passed to the {@link #apply(Object, Object, Object, Object, Object)
	 *            closure}
	 * @param <P5>
	 *            the fifth argument that is passed to the {@link #apply(Object, Object, Object, Object, Object)
	 *            closure}
	 * @param <Result>
	 *            the result of the single closure {@link #apply(Object, Object, Object, Object, Object) method}.
	 */
	interface Function5<P1, P2, P3, P4, P5, Result> {

		Result apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);

	}

	/**
	 * A function that takes six arguments.
	 * 
	 * @param <P1>
	 *            the first argument that is passed to the
	 *            {@link #apply(Object, Object, Object, Object, Object, Object) closure}
	 * @param <P2>
	 *            the second argument that is passed to the
	 *            {@link #apply(Object, Object, Object, Object, Object, Object) closure}
	 * @param <P3>
	 *            the third argument that is passed to the
	 *            {@link #apply(Object, Object, Object, Object, Object, Object) closure}
	 * @param <P4>
	 *            the fourth argument that is passed to the
	 *            {@link #apply(Object, Object, Object, Object, Object, Object) closure}
	 * @param <P5>
	 *            the fifth argument that is passed to the
	 *            {@link #apply(Object, Object, Object, Object, Object, Object) closure}
	 * @param <P6>
	 *            the sixth argument that is passed to the
	 *            {@link #apply(Object, Object, Object, Object, Object, Object) closure}
	 * @param <Result>
	 *            the result of the single closure {@link #apply(Object, Object, Object, Object, Object, Object) method}
	 *            .
	 */
	interface Function6<P1, P2, P3, P4, P5, P6, Result> {

		Result apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6);

	}

}
