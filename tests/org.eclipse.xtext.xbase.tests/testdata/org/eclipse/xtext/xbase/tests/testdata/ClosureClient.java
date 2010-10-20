/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.testdata;

import java.util.List;

import org.eclipse.xtext.xbase.lib.Functions;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClosureClient<T> {

	public T invoke0(Functions.Function0<T> fun) {
		return fun.apply();
	}
	
	public T invoke1(Functions.Function1<T, T> fun, T p1) {
		return fun.apply(p1);
	}
	
	public T invoke2(Functions.Function2<T, T, T> fun, T p1, T p2) {
		return fun.apply(p1, p2);
	}
	
	public T invoke3(Functions.Function3<T, T, T, T> fun, T p1, T p2, T p3) {
		return fun.apply(p1, p2, p3);
	}
	
	public T invoke4(Functions.Function4<T, T, T, T, T> fun, T p1, T p2, T p3, T p4) {
		return fun.apply(p1, p2, p3, p4);
	}
	
	public T invoke5(Functions.Function5<T, T, T, T, T, T> fun, T p1, T p2, T p3, T p4, T p5) {
		return fun.apply(p1, p2, p3, p4, p5);
	}
	
	public T invoke6(Functions.Function6<T, T, T, T, T, T, T> fun, T p1, T p2, T p3, T p4, T p5, T p6) {
		return fun.apply(p1, p2, p3, p4, p5, p6);
	}
	
	public T invokeX(Functions.FunctionX<T> fun, List<T> t) {
		return fun.apply(t.toArray(new Object[t.size()]));
	}
	
	public T useProvider(Provider<T> provider) {
		return provider.get();
	}
	
	public T useSupplier(Supplier<T> supplier) {
		return supplier.get();
	}
	
	public T useGoogleCollectFunction(Function<T, T> fun, T param) {
		return fun.apply(param);
	}
	
	public boolean useGoogleCollectPredicate(Predicate<T> predicate, T value) {
		return predicate.apply(value);
	}
	
	public Functions.Function1<T, T> getIdentityFunction() {
		return new Functions.Function1<T, T>() {
			public T apply(T p) {
				return p;
			}
			
		};
	}
	
}
