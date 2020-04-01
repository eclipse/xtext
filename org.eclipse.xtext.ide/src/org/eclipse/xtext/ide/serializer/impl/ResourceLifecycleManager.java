/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceSnapshot;
import org.eclipse.xtext.ide.serializer.impl.RelatedResourcesProvider.RelatedResource;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class ResourceLifecycleManager {

	public Resource openAndApplyReferences(ResourceSet resourceSet, RelatedResource toLoad) {
		Resource resource = resourceSet.getResource(toLoad.getUri(), true);
		for (IReferenceSnapshot desc : toLoad.outgoingReferences) {
			EObject source = resource.getEObject(desc.getSourceEObjectUri().fragment());
			EObject target = desc.getTarget().getObject();
			EReference reference = desc.getEReference();
			if (reference.isMany()) {
				@SuppressWarnings("unchecked")
				List<Object> list = (EList<Object>) source.eGet(reference, false);
				list.set(desc.getIndexInList(), target);
			} else {
				source.eSet(reference, target);
			}
		}
		return resource;
	}

	public void close(Resource resource) {

	}

}
