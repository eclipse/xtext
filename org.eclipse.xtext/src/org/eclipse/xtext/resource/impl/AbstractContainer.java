/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Abstract container implementation. Minimal clients have to implement
 * {@link #getResourceDescriptions()}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContainer extends AbstractCompoundSelectable implements IContainer {
	
	@Override
	protected Iterable<IResourceDescription> getSelectables() {
		return getResourceDescriptions();
	}
	
	@Override
	public int getResourceDescriptionCount() {
		return Iterables.size(getResourceDescriptions());
	}
	
	@Override
	public boolean hasResourceDescription(URI uri) {
		return getResourceDescription(uri) != null;
	}
	
	@Override
	public IResourceDescription getResourceDescription(final URI uri) {
		return Iterables.find(getResourceDescriptions(), new Predicate<IResourceDescription>() {
			@Override
			public boolean apply(IResourceDescription input) {
				return uri.equals(input.getURI());
			}
		}, null);
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
		URI resourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(object).trimFragment();
		IResourceDescription description = getResourceDescription(resourceURI);
		if (description == null)
			return Collections.emptyList();
		return description.getExportedObjectsByObject(object);
	}
	
}
