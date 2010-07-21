/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractContainer;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DescriptionAddingContainer extends AbstractContainer {

	private final IResourceDescription description;
	private final IContainer delegate;

	public DescriptionAddingContainer(IResourceDescription addMe, IContainer delegate) {
		this.description = addMe;
		this.delegate = delegate;
	}
	
	public Iterable<IResourceDescription> getResourceDescriptions() {
		return Iterables.concat(Collections.singleton(description), delegate.getResourceDescriptions());
	}

	public IResourceDescription getResourceDescription(URI uri) {
		if (description.getURI().equals(uri))
			return description;
		return delegate.getResourceDescription(uri);
	}

}
