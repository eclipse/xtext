/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

import java.util.Collection;
import java.util.List;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OverloadedMethods<V> {

	public int usedConstructor = 0; 
	
	public OverloadedMethods() {
	}
	
	public OverloadedMethods(Collection<V> collection, Iterable<? extends V> iterable) {
		usedConstructor = 1;
	}
	
	public OverloadedMethods(Iterable<? extends V> iterable, Collection<V> collection) {
		usedConstructor = 2;
	}
	
	public OverloadedMethods(List<V> list, List<V> otherList) {
		usedConstructor = 3;
	}
	
	public OverloadedMethods(Iterable<? extends V> iterable, Iterable<? extends V> otherIterable) {
		usedConstructor = 4;
	}
	
	public String overloadedInt(int i) {
		return "overloadedInt(int)";
	}
	
	public String overloadedInt(Integer i) {
		return "overloadedInt(Integer)";
	}
	
	public <T> String overloaded(Collection<T> collection, Iterable<? extends T> iterable) {
		return "overloaded(Collection,Iterable)";
	}
	
	public <T> String overloaded(Iterable<? extends T> iterable, Collection<T> collection) {
		return "overloaded(Iterable,Collection)";
	}
	
	public <T> String overloaded(List<T> list, List<T> otherList) {
		return "overloaded(List,List)";
	}
	
	public <T> String overloaded(Iterable<? extends T> iterable, Iterable<? extends T> otherIterable) {
		return "overloaded(Iterable,Iterable)";
	}
	
	public String overloaded2(Collection<V> collection, Iterable<? extends V> iterable) {
		return "overloaded2(Collection,Iterable)";
	}
	
	public String overloaded2(Iterable<? extends V> iterable, Collection<V> collection) {
		return "overloaded2(Iterable,Collection)";
	}
	
	public String overloaded2(List<V> list, List<V> otherList) {
		return "overloaded2(List,List)";
	}
	
	public String overloaded2(Iterable<? extends V> iterable, Iterable<? extends V> otherIterable) {
		return "overloaded2(Iterable,Iterable)";
	}
	
	public <T> String overloaded3(List<T> list, List<T> otherList) {
		return "overloaded(List,List)";
	}
	
}
