/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Interner;

/**
 * Follows a similar concept as the {@link Interner}. Rather than interning the object and returning the 
 * interned instance, the instance is encoded as an integer. Useful for serialization formats.
 * 
 * @since 2.35
 */
public class Tabulated<T> {

	private final Map<T, Integer> objectToId;
	private final List<T> idToObject;

	public Tabulated() {
		objectToId = new HashMap<>();
		idToObject = new ArrayList<>();
	}
	
	@SuppressWarnings("unchecked")
	public Tabulated(int size) {
		objectToId = new HashMap<>();
		idToObject = (List<T>) Arrays.asList(new Object[size]);
	}
	
	public Tabulated(ImmutableMap<T, Integer> objectToId, ImmutableList<T> idToObject) {
		this.objectToId = objectToId;
		this.idToObject = idToObject;
	}

	public int getId(T object) {
		Integer id = objectToId.get(object);
		if (id == null) {
			id = objectToId.size();
			objectToId.put(object, id);
			idToObject.add(object);
		}
		return id;
	}
	
	public int tryGetId(T object) {
		return objectToId.getOrDefault(object, -1);
	}
	
	public void set(T object, int id) {
		objectToId.put(object, id);
		idToObject.set(id, object);
	}
	
	public boolean contains(T object) {
		return objectToId.containsKey(object);
	}

	public T getObject(int id) {
		return idToObject.get(id);
	}
	
	public int size() {
		return idToObject.size();
	}
	
	public ImmutableList<T> getObjects() {
		// No-op if idToObject is already an ImmutableList
		return ImmutableList.copyOf(idToObject);
	}
	
}
