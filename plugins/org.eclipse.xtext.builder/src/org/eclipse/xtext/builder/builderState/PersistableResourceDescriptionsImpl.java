/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import static org.eclipse.xtext.builder.builderState.BuilderStateUtil.*;
/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PersistableResourceDescriptionsImpl implements IResourceDescriptions {

	private Map<URI, IResourceDescription> resourceDescriptionMap = Collections.emptyMap();

	public synchronized List<IResourceDescription.Delta> update(Iterable<IResourceDescription> toBeAdded, Iterable<URI> toBeRemoved) {
		List<IResourceDescription.Delta> deltas = Lists.newArrayList();
		Map<URI, IResourceDescription> newMap = Maps.newHashMap(resourceDescriptionMap);
		if (toBeRemoved != null) {
			for (URI uri : toBeRemoved) {
				IResourceDescription desc = newMap.remove(uri);
				if (desc != null) {
					deltas.add(new DefaultResourceDescriptionDelta(desc, null));
				}
			}
		}
		if (toBeAdded != null) {
			for (IResourceDescription iResourceDescription : toBeAdded) {
				ResourceDescriptionImpl impl = create(iResourceDescription);
				IResourceDescription oldOne = newMap.put(impl.getURI(), impl);
				deltas.add(new DefaultResourceDescriptionDelta(oldOne, impl));
			}
		}
		resourceDescriptionMap = newMap;
		return deltas;
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return resourceDescriptionMap.values();
	}

	public IResourceDescription getResourceDescription(URI uri) {
		return resourceDescriptionMap.get(uri);
	}

}
