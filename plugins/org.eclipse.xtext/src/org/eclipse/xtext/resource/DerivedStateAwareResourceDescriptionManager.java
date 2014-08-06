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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.RuntimeIOException;

import com.google.inject.Inject;
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
	
	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;

	@Override
	protected IResourceDescription internalGetResourceDescription(final Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		DerivedStateAwareResource res = (DerivedStateAwareResource) resource;
		if (!res.isLoaded()) {
			try {
				res.load(res.getResourceSet().getLoadOptions());
			} catch (IOException e) {
				throw new RuntimeIOException(e);
			}
		}
		boolean isInitialized = res.indexingStateInitialized || res.isInitializing;
		boolean canReconcileState = res.canReconcileState();
		try {
			if (!isInitialized) {
				if (!canReconcileState)
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
			if (!isInitialized && !canReconcileState) {
				if (log.isDebugEnabled())
					log.debug("Discarding inferred state for "+resource.getURI());
				res.discardDerivedState();
				res.eSetDeliver(true);
			}
		}
	}
	
	protected IResourceDescription createResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		return new DefaultResourceDescription(resource, strategy, cache) {
			@Override
			protected EObjectDescriptionLookUp getLookUp() {
				if (lookup == null)
					lookup = new EObjectDescriptionLookUp(computeExportedObjects());
				return lookup;
			}
			
			@Override
			protected TreeIterator<EObject> getAllProperContents() {
				EList<EObject> contents = ((DerivedStateAwareResource)getResource()).doGetContents();
				return EcoreUtil.getAllProperContents(contents, false);
			}
		};
	}
	
	@Override
	protected IResourceDescription internalGetIndexingResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		DerivedStateAwareResource res = (DerivedStateAwareResource) resource;
		if (!res.isLoaded()) {
			try {
				res.load(res.getResourceSet().getLoadOptions());
			} catch (IOException e) {
				throw new RuntimeIOException(e);
			}
		}
		boolean isInitialized = res.indexingStateInitialized || res.isInitializing;
		boolean canReconcileState = res.canReconcileState();
		try {
			if (!isInitialized) {
				if (!canReconcileState)
					res.eSetDeliver(false);
				res.installDerivedState(true);
			}
			IResourceDescription description = createIndexingResourceDescription(resource, strategy);
			if (!isInitialized) {
				// eager initialize
				for (IEObjectDescription desc : description.getExportedObjects()) {
					desc.getEObjectURI();
				}
			}
			return description;
		} finally {
			if (!isInitialized && !canReconcileState) {
				if (log.isDebugEnabled())
					log.debug("Discarding inferred state for "+resource.getURI());
				res.discardDerivedState();
				res.eSetDeliver(true);
			}
		}
	}

	/**
	 * @since 2.7
	 */
	protected IResourceDescription createIndexingResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		return new IndexingResourceDescription(resource, strategy) {
			@Override
			protected TreeIterator<EObject> getAllProperContents() {
				EList<EObject> contents = ((DerivedStateAwareResource)getResource()).doGetContents();
				return EcoreUtil.getAllProperContents(contents, false);
			}
		};
	}
}
