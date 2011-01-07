/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface Functions {

	interface Function0<Result> {

		Result apply();

	}
	
	interface Function1<Param, Result> extends Function<Param, Result>{

		Result apply(Param p);

	}

	interface Function2<P1, P2, Result> {

		Result apply(P1 p1, P2 p2);

	}

	interface Function3<P1, P2, P3, Result> {

		Result apply(P1 p1, P2 p2, P3 p3);

	}

	interface Function4<P1, P2, P3, P4, Result> {

		Result apply(P1 p1, P2 p2, P3 p3, P4 p4);

	}

	interface Function5<P1, P2, P3, P4, P5, Result> {

		Result apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);

	}

	interface Function6<P1, P2, P3, P4, P5, P6, Result> {

		Result apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6);

	}

	interface FunctionX<Result> {

		Result apply(Object... arguments);

	}

}
