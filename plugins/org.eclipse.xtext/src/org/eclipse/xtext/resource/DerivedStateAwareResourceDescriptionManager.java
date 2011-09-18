/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import static com.google.common.collect.Lists.*;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;

/**
 * 
 * Installs the derived state in non-linking mode and discards it right after {@link EObjectDescription} creation.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class DerivedStateAwareResourceDescriptionManager extends DefaultResourceDescriptionManager {

	@Override
	protected IResourceDescription internalGetResourceDescription(final Resource resource,
			IDefaultResourceDescriptionStrategy strategy) {
		DerivedStateAwareResource res = (DerivedStateAwareResource) resource;
		boolean isInitialized = res.fullyInitialized || res.isInitializing;
		try {
			if (!isInitialized) {
				res.eSetDeliver(false);
				res.installDerivedState(true);
			}
			IResourceDescription description = super.internalGetResourceDescription(resource, strategy);
			if (!isInitialized) {
				// make sure the eobject descriptions are being built.
				newArrayList(description.getExportedObjects());
			}
			return description;
		} finally {
			if (!isInitialized) {
				res.discardDerivedState();
				res.eSetDeliver(true);
			}
		}
	}
}
