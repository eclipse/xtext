/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Queue;

/**
 * {@link Queue} with unique valuess
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @author Christian Dietrich - Initial contribution and API
 */
public class LinkedHashSetQueue<T> extends AbstractQueue<T> {
	private final LinkedHashSet<T> data;

	public LinkedHashSetQueue(LinkedHashSetQueue<T> base) {
		this.data = new LinkedHashSet<>(base.data);
	}

	public LinkedHashSetQueue() {
		this.data = new LinkedHashSet<>();
	}

	@Override
	public boolean offer(T e) {
		data.add(e);
		return true;
	}

	@Override
	public T poll() {
		Iterator<T> iterator = data.iterator();
		if (iterator.hasNext()) {
			T next = iterator.next();
			iterator.remove();
			return next;
		}
		return null;
	}

	@Override
	public T peek() {
		Iterator<T> iterator = data.iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		}
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return data.iterator();
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public void clear() {
		data.clear();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return data.addAll(c);
	}
	
	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	@Override
	public boolean contains(Object o) {
		return data.contains(o);
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		return data.containsAll(c);
	}

}