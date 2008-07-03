/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class MultiMap<K,V> extends HashMap<K, List<V>>{

	private static final long serialVersionUID = 28768781263L;

	public void put(K key, V value) {
		List<V> list = super.get(key);
		if(list == null) {
			list=new ArrayList<V>();
			put(key, list);
		}
		list.add(value);
	}
	
	public boolean remove(K key, V value) {
		List<V> list = super.get(key);
		if(list == null) return false;
		boolean result = list.remove(value);
		if(list.isEmpty()) {
			remove(key);
		}
		return result;
	}
	
	public List<V> get(K key) {
		List<V> list = super.get(key);
		return (list == null) ? Collections.<V>emptyList() : list;
	}
}
