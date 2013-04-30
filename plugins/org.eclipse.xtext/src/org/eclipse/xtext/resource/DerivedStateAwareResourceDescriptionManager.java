/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp;
import org.eclipse.xtext.util.RuntimeIOException;

import com.google.inject.Singleton;

/**
 * 
 * Installs the derived state in non-linking mode and discards it right after {@link EObjectDescription} creation.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
@Singleton
public class DerivedStateAwareResourceDescriptionManager extends DefaultResourceDescriptionManager {
	
	private final static Logger log = Logger.getLogger(DerivedStateAwareResourceDescriptionManager.class);
	
	@Override
	protected IResourceDescription internalGetResourceDescription(final Resource resource,
			IDefaultResourceDescriptionStrategy strategy) {
		DerivedStateAwareResource res = (DerivedStateAwareResource) resource;
		if (!res.isLoaded()) {
			try {
				res.load(res.getResourceSet().getLoadOptions());
			} catch (IOException e) {
				throw new RuntimeIOException(e);
			}
		}
		boolean isInitialized = res.fullyInitialized || res.isInitializing;
		try {
			if (!isInitialized) {
				res.eSetDeliver(false);
				res.installDerivedState(true);
			}
			IResourceDescription description = createResourceDescription(resource, strategy);
			if (!isInitialized) {
				// eager initialize
				for (IEObjectDescription desc : description.getExportedObjects()) {
					desc.getEObjectURI();
				}
			}
			return description;
		} finally {
			if (!isInitialized) {
				if (log.isDebugEnabled())
					log.debug("Discarding inferred state for "+resource.getURI());
				res.discardDerivedState();
				res.eSetDeliver(true);
			}
		}
	}
	
	protected IResourceDescription createResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		return new DefaultResourceDescription(resource, strategy, getCache()) {
			@Override
			protected EObjectDescriptionLookUp getLookUp() {
				if (lookup == null)
					lookup = new EObjectDescriptionLookUp(computeExportedObjects());
				return lookup;
			}
		};
	}
}
