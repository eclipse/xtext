/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

/**
 * This class serves as a container for the various function types that are used to implement the type of closures in
 * Xbase.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @see FunctionExtensions
 */
public interface Functions {

	/**
	 * A function without any parameters.
	 */
	interface Function0<Result> {

		Result apply();

	}

	/**
	 * A function that takes one argument.
	 */
	interface Function1<Param, Result> {

		Result apply(Param p);

	}

	/**
	 * A function that takes two arguments.
	 */
	interface Function2<P1, P2, Result> {

		Result apply(P1 p1, P2 p2);

	}

	/**
	 * A function that takes three arguments.
	 */
	interface Function3<P1, P2, P3, Result> {

		Result apply(P1 p1, P2 p2, P3 p3);

	}

	/**
	 * A function that takes four arguments.
	 */
	interface Function4<P1, P2, P3, P4, Result> {

		Result apply(P1 p1, P2 p2, P3 p3, P4 p4);

	}

	/**
	 * A function that takes five arguments.
	 */
	interface Function5<P1, P2, P3, P4, P5, Result> {

		Result apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);

	}

	/**
	 * A function that takes six arguments.
	 */
	interface Function6<P1, P2, P3, P4, P5, P6, Result> {

		Result apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6);

	}

}
