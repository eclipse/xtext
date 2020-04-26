/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.java.resource;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.inject.Inject;

public class JavaResourceDescriptionManager implements IResourceDescription.Manager {
	@Inject
	private JvmTypesResourceDescriptionStrategy descriptionStrategy;

	@Inject
	private IResourceScopeCache cache;

	@Override
	public IResourceDescription.Delta createDelta(IResourceDescription oldDescription,
			IResourceDescription newDescription) {
		return new DefaultResourceDescriptionDelta(oldDescription, newDescription);
	}

	@Override
	public IResourceDescription getResourceDescription(Resource resource) {
		if (resource instanceof JavaResource) {
			JavaResource javaResource = (JavaResource) resource;
			boolean initialized = javaResource.isInitialized() || javaResource.isInitializing();
			try {
				if (!initialized) {
					javaResource.eSetDeliver(false);
					javaResource.installStubs();
				}
				DefaultResourceDescription result = new DefaultResourceDescription(resource, descriptionStrategy,
						cache);
				if (!initialized) {
					for (IEObjectDescription d : result.getExportedObjects()) {
						d.getEObjectURI();
					}
				}
				return result;
			} finally {
				if (!initialized) {
					javaResource.discardDerivedState();
					javaResource.eSetDeliver(true);
				}
			}
		}
		throw new IllegalArgumentException("Can only handle JavaResources");
	}

	@Override
	public boolean isAffected(IResourceDescription.Delta delta, IResourceDescription candidate)
			throws IllegalArgumentException {
		throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}

	@Override
	public boolean isAffected(Collection<IResourceDescription.Delta> deltas, IResourceDescription candidate,
			IResourceDescriptions context) throws IllegalArgumentException {
		Collection<QualifiedName> importedNames = IterableExtensions.<QualifiedName>toSet(candidate.getImportedNames());
		for (IResourceDescription.Delta delta : deltas) {
			if (hasChanges(delta, candidate)) {
				if (isAffected(importedNames, delta.getNew()) || isAffected(importedNames, delta.getOld())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Whether the given delta is considered to have changed from the candidate's perspective. By default this will just
	 * call{@link Delta#haveEObjectDescriptionsChanged() Delta#haveEObjectDescriptionsChanged()}. But in some cases even
	 * "internal" changes (that are not visible in the EObjectDescriptions) could be interesting.
	 * 
	 * @since 2.7
	 */
	protected boolean hasChanges(IResourceDescription.Delta delta, IResourceDescription candidate) {
		return delta.haveEObjectDescriptionsChanged();
	}

	protected boolean isAffected(Collection<QualifiedName> importedNames, IResourceDescription description) {
		if (description != null) {
			for (IEObjectDescription desc : description.getExportedObjects()) {
				if (importedNames.contains(desc.getName().toLowerCase())) {
					return true;
				}
			}
		}
		return false;
	}
}
