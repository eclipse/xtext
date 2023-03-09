/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import static java.util.Collections.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainer;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * A specialized container which is based on some long living lightweight state.
 * A {@link IContainerState container state} is used to decide about the actually
 * contained resource descriptions.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StateBasedContainer extends ResourceDescriptionsBasedContainer {

	private final IContainerState state;

	public StateBasedContainer(IResourceDescriptions descriptions, IContainerState state) {
		super(descriptions);
		this.state = state;
	}

	/**
	 * @since 2.20
	 */
	protected final IContainerState getState() {
		return state;
	}
	
	@Override
	protected Iterable<IEObjectDescription> filterByURI(Iterable<IEObjectDescription> unfiltered) {
		return Iterables.filter(unfiltered, new Predicate<IEObjectDescription>() {
			private Collection<URI> contents = null;

			@Override
			public boolean apply(IEObjectDescription input) {
				if(contents == null) {
					contents = getState().getContents();
				}
				URI resourceURI = input.getEObjectURI().trimFragment();
				final boolean contains = contents.contains(resourceURI);
				return contains;
			}
		});
	}

	@Override
	public boolean hasResourceDescription(URI uri) {
		return getState().contains(uri);
	}
	
	@Override
	public int getResourceDescriptionCount() {
		return getState().getContents().size();
	}

	@Override
	public boolean isEmpty() {
		return getState().isEmpty();
	}
	
	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		if (getState().contains(uri))
			return getDescriptions().getResourceDescription(uri);
		return null;
	}

	@Override
	public Iterable<IResourceDescription> getResourceDescriptions() {
		if (isEmpty())
			return Collections.emptyList();
		return getUriToDescription().values();
	}

	@Override
	protected Map<URI, IResourceDescription> doGetUriToDescription() {
		Map<URI, IResourceDescription> result = Maps.newLinkedHashMap();
		for(URI uri: getState().getContents()) {
			IResourceDescription description = getDescriptions().getResourceDescription(uri);
			if (description != null)
				result.put(uri, description);
		}
		return result;
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		if (isEmpty())
			return emptyList();
		return super.getExportedObjects();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		if (isEmpty())
			return emptyList();
		return super.getExportedObjectsByType(type);
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		if (isEmpty())
			return emptyList();
		return super.getExportedObjectsByObject(object);
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName qualifiedName, boolean ignoreCase) {
		if (isEmpty())
			return emptyList();
		return super.getExportedObjects(type, qualifiedName, ignoreCase);
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public String toString() {
		return "["+getClass().getSimpleName()+"] "+ state;
	}

}
