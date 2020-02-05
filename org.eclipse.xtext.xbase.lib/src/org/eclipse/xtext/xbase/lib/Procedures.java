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
 * This class serves as a container for the various procedure types that are used to implement the type of closures in
 * Xbase that do not return any results but a meant to cause side-effects.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @see ProcedureExtensions
 * @see Functions
 */
@GwtCompatible public interface Procedures {

	/**
	 * A procedure without any parameters, e.g. a {@link Runnable}.
	 */
	interface Procedure0 {

		void apply();

	}

	/**
	 * A procedure that takes one argument.
	 * 
	 * @param <Param>
	 *            the only argument that is passed to the {@link #apply(Object) closure}
	 */
	interface Procedure1<Param> {

		void apply(Param p);

	}

	/**
	 * A procedure that takes two arguments.
	 * 
	 * @param <P1>
	 *            the first argument that is passed to the {@link #apply(Object, Object) closure}
	 * @param <P2>
	 *            the second argument that is passed to the {@link #apply(Object, Object) closure}
	 */
	interface Procedure2<P1, P2> {

		void apply(P1 p1, P2 p2);

	}

	/**
	 * A procedure that takes three arguments.
	 * 
	 * @param <P1>
	 *            the first argument that is passed to the {@link #apply(Object, Object, Object) closure}
	 * @param <P2>
	 *            the second argument that is passed to the {@link #apply(Object, Object, Object) closure}
	 * @param <P3>
	 *            the third argument that is passed to the {@link #apply(Object, Object, Object) closure}
	 */
	interface Procedure3<P1, P2, P3> {

		void apply(P1 p1, P2 p2, P3 p3);

	}

	/**
	 * A procedure that takes four arguments.
	 * 
	 * @param <P1>
	 *            the first argument that is passed to the {@link #apply(Object, Object, Object, Object) closure}
	 * @param <P2>
	 *            the second argument that is passed to the {@link #apply(Object, Object, Object, Object) closure}
	 * @param <P3>
	 *            the third argument that is passed to the {@link #apply(Object, Object, Object, Object) closure}
	 * @param <P4>
	 *            the fourth argument that is passed to the {@link #apply(Object, Object, Object, Object) closure}
	 */
	interface Procedure4<P1, P2, P3, P4> {

		void apply(P1 p1, P2 p2, P3 p3, P4 p4);

	}

	/**
	 * A procedure that takes five arguments.
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
	 */
	interface Procedure5<P1, P2, P3, P4, P5> {

		void apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);

	}

	/**
	 * A procedure that takes six arguments.
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
	 */
	interface Procedure6<P1, P2, P3, P4, P5, P6> {

		void apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6);

	}

}
