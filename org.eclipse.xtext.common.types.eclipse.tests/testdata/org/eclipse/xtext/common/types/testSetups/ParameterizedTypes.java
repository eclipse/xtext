/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class ParameterizedTypes<
		S, 
		T extends S, 
		U extends List<S>, 
		V extends List<List<? extends V>>, 
		W extends Comparable<S> & Serializable
	> extends TestScenario {

	public abstract class Inner<X extends W, Y extends List<X>, Z extends List<W>> {
		
		abstract S methodS();
		
		abstract X methodX();
		
		abstract List<T> methodT();
		
		abstract List<? extends V>[] methodVArray_01();
		
		abstract List<? extends V[]> methodVArray_02();
		
		abstract List<Z[][]> methodZArray_01();
		
		abstract List<Z[]>[] methodZArray_02();
		
	}
	
	abstract List<? extends S> methodS(S s);
	
	abstract List<? super T> methodT(T t);
	
	abstract <Y extends T> void methodY(Y y);
	
	abstract <Z> List<? super Z> methodZ(List<? extends Z> list);
	
	abstract <Z> Z methodMap(Map<? super Z, ? extends S> map);
	
	abstract Inner<W, List<W>, List<W>> plainInner(Inner<W, List<W>, List<W>> p);
	
	abstract ParameterizedTypes<String, String, List<String>, V, String>.Inner<String, List<String>, List<String>> concreteInner();
	
}
