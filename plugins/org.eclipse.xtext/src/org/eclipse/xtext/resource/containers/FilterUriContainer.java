/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractContainer;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class FilterUriContainer extends AbstractContainer {
	private final URI filterMe;
	private final IContainer delegate;

	public FilterUriContainer(URI filterMe, IContainer delegate) {
		this.filterMe = filterMe;
		this.delegate = delegate;
	}
	
	public Iterable<IResourceDescription> getResourceDescriptions() {
		return Iterables.filter(delegate.getResourceDescriptions(), new Predicate<IResourceDescription>() {
			public boolean apply(IResourceDescription input) {
				return !input.getURI().equals(filterMe);
			}
		});
	}

	public IResourceDescription getResourceDescription(URI uri) {
		if (uri.equals(filterMe))
			return null;
		return delegate.getResourceDescription(uri);
	}
}
