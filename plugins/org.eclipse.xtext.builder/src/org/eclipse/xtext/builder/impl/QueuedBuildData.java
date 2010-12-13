/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class QueuedBuildData {
	
	private Collection<IResourceDescription.Delta> deltas;
	private Collection<URI> uris;
	private Multimap<String, URI> projectNameToChangedResource;
	
	public QueuedBuildData() {
		deltas = Lists.newArrayList();
		uris = Lists.newArrayList();
		projectNameToChangedResource = HashMultimap.create();
	}

	public synchronized void queueChanges(Collection<IResourceDescription.Delta> deltas) {
		if (deltas != null && !deltas.isEmpty()) {
			this.deltas.addAll(deltas);
		}
	}
	
	public synchronized void queueURIs(Collection<URI> uris) {
		if (uris != null && !uris.isEmpty()) {
			for(URI uri: uris) {
				if (uri.isPlatformResource()) {
					String projectName = uri.segment(1);
					projectNameToChangedResource.put(projectName, uri);
				} else {
					this.uris.add(uri);
				}
			}
		}
	}
	
}
