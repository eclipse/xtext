/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.util.Iterator;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ParameterizedTypeModule extends AbstractGenericModule {
	public final X BIND_X = new X();
	public final X PROVIDE_X = new X();

	static class X implements Comparable<X>, Iterator<X>, Iterable<X> {
		@Override
		public int compareTo(X o) {
			return 0;
		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public X next() {
			return null;
		}

		@Override
		public void remove() {
		}

		@Override
		public Iterator<X> iterator() {
			return null;
		}
	}
	
	public Class<? extends Comparable<X>> bindParameterizedType() {
		return X.class;
	}
	
	public Iterator<X> bindParameterizedType2() {
		return BIND_X;
	}
	
	public Provider<Iterable<X>> provideParameterizedType2() {
		return new Provider<Iterable<X>>(){
			@Override
			public Iterable<X> get() {
				return PROVIDE_X;
			}
		};
	}
}
