/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

/**
 * An Xtext-specific facade over an EMF ResourceSet.
 * 
 * This class provides a nicer API for Xtext-specific configuration of a ResourceSet.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public class ResourceSetContext {

	public static ResourceSetContext get(Notifier context) {
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(context);
		return new ResourceSetContext(resourceSet);
	}

	private final ResourceSet resourceSet;

	public ResourceSetContext(ResourceSet ressourceSet) {
		super();
		this.resourceSet = ressourceSet;
	}

	public ResourceSet getRessourceSet() {
		return resourceSet;
	}

	public boolean isBuilder() {
		return resourceSet.getLoadOptions().containsKey(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE);
	}

	public boolean isEditor() {
		return !isBuilder() && !resourceSet.getLoadOptions().containsKey(ResourceDescriptionsProvider.LIVE_SCOPE);
	}

}
