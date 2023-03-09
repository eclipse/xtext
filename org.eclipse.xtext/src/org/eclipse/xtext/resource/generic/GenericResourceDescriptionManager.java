/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.generic;

import static java.util.Collections.*;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.DescriptionUtils;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * An {@link org.eclipse.xtext.resource.IResourceDescription.Manager} for non-Xtext resources. 
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class GenericResourceDescriptionManager implements IResourceDescription.Manager {

	@Inject
	private IDefaultResourceDescriptionStrategy resourceDescriptionStrategy;

	@Inject
	private DescriptionUtils descriptionUtils;

	@Inject
	private IResourceScopeCache cache = new IResourceScopeCache.NullImpl();

	@Override
	public IResourceDescription getResourceDescription(Resource resource) {
		return new DefaultResourceDescription(resource, resourceDescriptionStrategy, cache);
	}

	@Override
	public Delta createDelta(IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new DefaultResourceDescriptionDelta(oldDescription, newDescription);
	}

	@Override
	public boolean isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
		return isAffected(singleton(delta), candidate, null);
	}

	@Override
	public boolean isAffected(Collection<Delta> deltas, IResourceDescription candidate, IResourceDescriptions context)
			throws IllegalArgumentException {
		Set<URI> outgoingReferences = descriptionUtils.collectOutgoingReferences(candidate);
		if (!outgoingReferences.isEmpty()) {
			for (IResourceDescription.Delta delta : deltas)
				if (delta.haveEObjectDescriptionsChanged() && outgoingReferences.contains(delta.getUri()))
					return true;
		}
		return false;
	}

}
