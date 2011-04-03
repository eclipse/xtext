/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

import org.eclipse.xtext.xbase.lib.Functions;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class ClosureClient {

	public <T> T invoke0(Functions.Function0<T> fun) {
		return fun.apply();
	}
	
	public void infiniteApply(Functions.Function0<Object> fun) {
		while(true) {
			fun.apply();
		}
	}
	
	public <P,T> T invoke1(Functions.Function1<P, T> fun, P p1) {
		return fun.apply(p1);
	}
	
	public <P1,P2,T> T invoke2(Functions.Function2<P1, P2, T> fun, P1 p1, P2 p2) {
		return fun.apply(p1, p2);
	}
	
	public <T> T useProvider(Provider<T> provider) {
		return provider.get();
	}
	
	public <T> T useSupplier(Supplier<T> supplier) {
		return supplier.get();
	}
	
	public <In,Out> Out useGoogleCollectFunction(Function<In, Out> fun, In param) {
		return fun.apply(param);
	}
	
	public <In,Out> Out useGoogleCollectFunction2(Function<? super In, Out> fun, In param) {
		return fun.apply(param);
	}
	
	public <In> boolean useGoogleCollectPredicate(Predicate<In> predicate, In value) {
		return predicate.apply(value);
	}
	
	public <In> boolean useGoogleCollectPredicate2(Predicate<? super In> predicate, In value) {
		return predicate.apply(value);
	}
	
	public <Obj> Functions.Function1<Obj, Obj> getIdentityFunction() {
		return new Functions.Function1<Obj, Obj>() {
			public Obj apply(Obj p) {
				return p;
			}
			
		};
	}
	
}
