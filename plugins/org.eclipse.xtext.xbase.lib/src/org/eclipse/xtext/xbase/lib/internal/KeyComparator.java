/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib.internal;

import static com.google.common.base.Preconditions.*;

import java.util.Comparator;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import com.google.common.annotations.GwtCompatible;

/**
 * A comparator that compares objects by calling the supplied key function on them and then comparing the resulting
 * keys. It is null-safe if the key's compareTo method is null-safe.
 * 
 * @param <T>
 *            the type to compare
 * @param <C>
 *            the type of the comparable key
 */
@GwtCompatible
public final class KeyComparator<T, C extends Comparable<? super C>> implements Comparator<T> {
	private final Function1<? super T, C> keyFunction;

	/**
	 * @param keyFunction
	 *            the key function to use for comparing objects. May not be <code>null</code>
	 */
	public KeyComparator(Function1<? super T, C> keyFunction) {
		this.keyFunction = checkNotNull(keyFunction, "keyFunction");
	}

	@Override
	public int compare(T a, T b) {
		C c1 = keyFunction.apply(a);
		C c2 = keyFunction.apply(b);
		if (c1 == c2) {
			return 0;
		} else if (c1 != null) {
			return c1.compareTo(c2);
		} else {
			return -c2.compareTo(c1);
		}
	}
}