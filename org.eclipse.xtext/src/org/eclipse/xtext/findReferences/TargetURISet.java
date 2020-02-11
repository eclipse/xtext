/*******************************************************************************
 * Copyright (c) 2014 NumberFour AG (http://www.numberfour.eu).
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.findReferences;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * Default implementation for {@link TargetURIs}.
 * 
 * We extend {@link AbstractSet} on purpose to allow this instance to be funneled through
 * the old APIs.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TargetURISet extends AbstractSet<URI> implements TargetURIs {

	private final Set<URI> uris;
	private final Multimap<URI, URI> index;
	private Map<Key<? extends Object>, Object> userData;
	
	protected TargetURISet() {
		uris = Sets.newLinkedHashSet();
		index = HashMultimap.create(4, 4);
	}
	
	@Override
	public Iterator<URI> iterator() {
		return Iterators.unmodifiableIterator(uris.iterator());
	}

	@Override
	public <T> T getUserData(Key<T> key) {
		if (userData == null) {
			return null;
		}
		Object result = userData.get(key);
		if (result == null) {
			return null;
		}
		Class<T> type = key.getType();
		return type.cast(result);
	}

	@Override
	public <T> void putUserData(Key<T> key, T data) {
		if (userData == null) {
			userData = Maps.newHashMap();
		}
		userData.put(key, data);
	}
	
	@Override
	public void addURI(URI uri) {
		if (uris.add(uri)) {
			index.put(uri.trimFragment(), uri);
		}
	}
	
	@Override
	public void addAllURIs(Iterable<URI> uris) {
		for(URI uri: uris) {
			addURI(uri);
		}
	}
	
	@Override
	public Collection<URI> getTargetResourceURIs() {
		return Collections.unmodifiableCollection(index.keySet());
	}
	
	@Override
	public Collection<URI> getEObjectURIs(URI resourceURI) {
		return Collections.unmodifiableCollection(index.get(resourceURI));
	}

	@Override
	public boolean apply(URI uri) {
		return contains(uri);
	}

	@Override
	public boolean contains(URI uri) {
		return uris.contains(uri);
	}

	@Override
	public boolean containsResource(URI resourceURI) {
		return index.containsKey(resourceURI);
	}

	@Override
	public boolean isEmpty() {
		return uris.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return uris.contains(o);
	}

	@Override
	public Object[] toArray() {
		return uris.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return uris.toArray(a);
	}

	@Override
	public boolean add(URI e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return uris.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends URI> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean equals(Object o) {
		return uris.equals(o);
	}

	@Override
	public int hashCode() {
		return uris.hashCode();
	}

	@Override
	public int size() {
		return uris.size();
	}
	
	@Override
	public Set<URI> asSet() {
		return this;
	}
}