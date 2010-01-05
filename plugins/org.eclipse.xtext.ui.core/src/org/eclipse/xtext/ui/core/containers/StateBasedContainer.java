/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.containers;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainer;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StateBasedContainer extends ResourceDescriptionsBasedContainer {

	private final IContainerState state;

	public StateBasedContainer(IResourceDescriptions descriptions, IContainerState state) {
		super(descriptions);
		this.state = state;
	}

	@Override
	protected boolean contains(IResourceDescription input) {
		return state.contains(input.getURI());
	}

	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		if (state.contains(uri))
			return getDescriptions().getResourceDescription(uri);
		return null;
	}

	@Override
	public Iterable<IResourceDescription> getResourceDescriptions() {
		if (state.getContents().isEmpty())
			return Iterables.emptyIterable();
		return getUriToDescription().values();
	}

	@Override
	protected Map<URI, IResourceDescription> doGetUriToDescription() {
		Map<URI, IResourceDescription> result = Maps.newLinkedHashMap();
		for(URI uri: state.getContents()) {
			IResourceDescription description = getDescriptions().getResourceDescription(uri);
			if (description != null)
				result.put(uri, description);
		}
		return result;
	}
	
	@Override
	public Iterable<IEObjectDescription> findAllEObjects(EClass type) {
		if (state.getContents().isEmpty())
			return Iterables.emptyIterable();
		return super.findAllEObjects(type);
	}
	
	@Override
	public Iterable<IEObjectDescription> findAllEObjects(EClass type, String name) {
		if (state.getContents().isEmpty())
			return Iterables.emptyIterable();
		return super.findAllEObjects(type, name);
	}

}
