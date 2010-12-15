/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class QueuedBuildData {
	
	private Collection<IResourceDescription.Delta> deltas;
	private LinkedList<URI> uris;
	private Map<String, LinkedList<URI>> projectNameToChangedResource;
	
	public QueuedBuildData() {
		deltas = Lists.newArrayList();
		uris = Lists.newLinkedList();
		projectNameToChangedResource = Maps.newHashMap();
	}

	public synchronized void queueChanges(Collection<IResourceDescription.Delta> deltas) {
		if (deltas != null && !deltas.isEmpty()) {
			this.deltas.addAll(deltas);
		}
	}
	
	public synchronized void queueURIs(Collection<URI> uris) {
		if (uris != null && !uris.isEmpty()) {
			for(URI uri: uris) {
				queueURI(uri);
			}
		}
	}
	
	void queueURI(URI uri) {
		if (uri.isPlatformResource()) {
			String projectName = uri.segment(1);
			LinkedList<URI> list = projectNameToChangedResource.get(projectName);
			if (list == null) {
				list = Lists.newLinkedList();
				projectNameToChangedResource.put(projectName, list);
			}
			list.add(uri);
		} else {
			this.uris.add(uri);
		}
	}

	public Collection<IResourceDescription.Delta> getAndRemovePendingDeltas() {
		Collection<IResourceDescription.Delta> result = deltas;
		deltas = Lists.newArrayList();
		return result;
	}
	
	public boolean isEmpty(String projectName) {
		return deltas.isEmpty() && getQueue(projectName).isEmpty();
	}

	public Queue<URI> getQueue(String projectName) {
		final LinkedList<URI> list = projectNameToChangedResource.get(projectName);
		if (list == null)
			return uris;
		return new AbstractQueue<URI>() {

			public boolean offer(URI o) {
				return list.offer(o);
			}

			public URI poll() {
				if (uris.isEmpty())
					return list.poll();
				return uris.poll();
			}

			public URI peek() {
				if (uris.isEmpty())
					return list.peek();
				return uris.peek();
			}

			@Override
			public Iterator<URI> iterator() {
				return Iterators.concat(uris.iterator(), list.iterator());
			}

			@Override
			public int size() {
				return uris.size() + list.size();
			}
		};
	}

	public Iterable<URI> getAllRemainingURIs() {
		return Iterables.concat(uris, Iterables.concat(projectNameToChangedResource.values()));
	}

}
