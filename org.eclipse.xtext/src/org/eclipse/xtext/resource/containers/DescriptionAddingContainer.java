/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractContainer;

import com.google.common.collect.Iterables;

/**
 * A container implementation that ensures that a given resource description
 * is part of the container. Delegates any other requests to another container.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DescriptionAddingContainer extends AbstractContainer {

	private final IResourceDescription description;
	private final IContainer delegate;

	/**
	 * @param addMe the description to be merged into this container. May not be contained in the given delegate.
	 * @param delegate the backing container.
	 */
	public DescriptionAddingContainer(IResourceDescription addMe, IContainer delegate) {
		this.description = addMe;
		this.delegate = delegate;
	}
	
	@Override
	public Iterable<IResourceDescription> getResourceDescriptions() {
		return Iterables.concat(Collections.singleton(description), delegate.getResourceDescriptions());
	}
	
	@Override
	public int getResourceDescriptionCount() {
		return delegate.getResourceDescriptionCount() + 1;
	}
	
	@Override
	public boolean hasResourceDescription(URI uri) {
		if (uri.equals(description.getURI()))
			return true;
		return delegate.hasResourceDescription(uri);
	}
	
	@Override
	public boolean isEmpty() {
		return false;
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName qualifiedName, boolean ignoreCase) {
		Iterable<IEObjectDescription> added = description.getExportedObjects(type, qualifiedName, ignoreCase);
		Iterable<IEObjectDescription> delegated = delegate.getExportedObjects(type, qualifiedName, ignoreCase);
		return Iterables.concat(added, delegated);
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		Iterable<IEObjectDescription> added = description.getExportedObjectsByType(type);
		Iterable<IEObjectDescription> delegated = delegate.getExportedObjectsByType(type);
		return Iterables.concat(added, delegated);
	}

	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		if (description.getURI().equals(uri))
			return description;
		return delegate.getResourceDescription(uri);
	}

}
