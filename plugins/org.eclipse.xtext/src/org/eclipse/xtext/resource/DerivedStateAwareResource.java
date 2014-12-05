/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.OnChangeEvictingCache;

import com.google.inject.Inject;

/**
 * Adds a hook for late initialization to be used to create derived state.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class DerivedStateAwareResource extends StorageAwareResource {

	@Inject(optional=true)
	private IDerivedStateComputer derivedStateComputer;
	
	public void setDerivedStateComputer(IDerivedStateComputer lateInitialization) {
		this.derivedStateComputer = lateInitialization;
	}
	
	protected volatile boolean fullyInitialized = false;
	protected volatile boolean isInitializing = false;

	/**
	 * @since 2.7
	 */
	public boolean isFullyInitialized() {
		return fullyInitialized;
	}

	/**
	 * @since 2.7
	 */
	public boolean isInitializing() {
		return isInitializing;
	}
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * As soon as an external client tries to access the content of the resource,
	 * the {@link IDerivedStateComputer derived state} will be added to the content of this resource.
	 */
	@Override
	public synchronized EList<EObject> getContents() {
		if (isLoaded && !isLoading && !isInitializing && !isUpdating && !fullyInitialized && !isLoadedFromStorage) {
			try {
				eSetDeliver(false);
				installDerivedState(false);
			} finally {
				eSetDeliver(true);
			}
		}
		return doGetContents();
	}

	/**
	 * @return the contents without the side effect of installing the derived the state.
	 * @since 2.4
	 */
	protected EList<EObject> doGetContents() {
		return super.getContents();
	}
	
	/**
	 * @since 2.8
	 */
	@Override
	protected List<EObject> getUnloadingContents() {
		return new BasicEList.FastCompare<EObject>(doGetContents());
	}
	
	/**
	 * Copied from {@link ResourceImpl#doUnload()} but doesn't call {@link #getContents()} to avoid derived state
	 * computation.
	 * 
	 * @since 2.8
	 */
	@Override
	protected void doUnload() {
		Iterator<EObject> allContents = getAllProperContents(unloadingContents);
		// This guard is needed to ensure that clear doesn't make the resource become loaded.
		//
		if (!doGetContents().isEmpty()) {
			doGetContents().clear();
		}
		getErrors().clear();
		getWarnings().clear();
		while (allContents.hasNext()) {
			unloaded((InternalEObject) allContents.next());
		}
		setParseResult(null);
		setIsLoadedFromStorage(false);
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	protected void clearInternalState() {
		if (fullyInitialized) {
			discardDerivedState();
		}
		super.clearInternalState();
	}
	
	@Override
	protected void updateInternalState(IParseResult oldParseResult, IParseResult newParseResult) {
		if (fullyInitialized) {
			discardDerivedState();
		}
		super.updateInternalState(oldParseResult, newParseResult);
	}
	
	/**
	 * Overridden to make sure that the cache is initialized during {@link #isLoading() loading}.
	 */
	@Override
	protected void updateInternalState(IParseResult newParseResult) {
		super.updateInternalState(newParseResult);
		// make sure that the cache adapter is installed on this resource
		IResourceScopeCache cache = getCache();
		if (cache instanceof OnChangeEvictingCache) {
			((OnChangeEvictingCache) cache).getOrCreate(this);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * Overridden to make sure that we do not initialize a resource
	 * just to compute the root URI fragment for the parse result.
	 */
	@Override
	protected String getURIFragmentRootSegment(EObject eObject) {
		if (unloadingContents == null) {
			IParseResult parseResult = getParseResult();
			if (parseResult != null && eObject == parseResult.getRootASTElement()) {
				return "0"; 
			}
		}
		return super.getURIFragmentRootSegment(eObject);
	}
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * <em>Not</em> specialized because we want to obtain a fully working root instance
	 * when the resource is queried with the root fragment.
	 */
	@Override
	protected EObject getEObjectForURIFragmentRootSegment(String uriFragmentRootSegment) {
		return super.getEObjectForURIFragmentRootSegment(uriFragmentRootSegment);
	}
	

	public void discardDerivedState() {
		if (isLoaded && fullyInitialized && !isInitializing) {
			try {
				isInitializing = true;
				if (derivedStateComputer != null)
					derivedStateComputer.discardDerivedState(this);
				fullyInitialized = false;
			} finally {
				isInitializing = false;
				getCache().clear(this);
			}
		}
	}

	public void installDerivedState(boolean preIndexingPhase) {
		if (!isLoaded)
			throw new IllegalStateException("The resource must be loaded, before installDerivedState can be called.");
		if (!fullyInitialized && !isInitializing && !isLoadedFromStorage) {
			try {
				isInitializing = true;
				if (derivedStateComputer != null)
					derivedStateComputer.installDerivedState(this, preIndexingPhase);
				fullyInitialized = true;
			} finally {
				isInitializing = false;
				getCache().clear(this);
			}
		}
	}
	
}
