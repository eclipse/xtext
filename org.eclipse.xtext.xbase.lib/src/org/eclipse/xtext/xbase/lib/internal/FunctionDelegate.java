/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib.internal;

import org.eclipse.xtext.xbase.lib.Functions;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;

/**
 * Internal wrapper to look like a google.collect function
 * 
 * @param <P>
 *            the type of the arguments that can be passed to this function.
 * @param <R>
 *            the type of the result instances of this function.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@GwtCompatible public class FunctionDelegate<P, R> implements Function<P, R> {

	private final Functions.Function1<? super P, ? extends R> delegate;

	/**
	 * Creates a new {@link FunctionDelegate} that wraps the given delegate function.
	 * 
	 * @param delegate
	 *            the delegate function. May not be <code>null</code>.
	 */
	public FunctionDelegate(Functions.Function1<? super P, ? extends R> delegate) {
		if (delegate == null)
			throw new NullPointerException("delegate");
		this.delegate = delegate;
	}

	@Override
	public R apply(P input) {
		R result = delegate.apply(input);
		return result;
	}

}