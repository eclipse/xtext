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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.OnChangeEvictingCache;

import com.google.common.base.Throwables;
import com.google.inject.Inject;

/**
 * Adds a hook for late initialization to be used to create derived state.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class DerivedStateAwareResource extends StorageAwareResource {
	
	private final static Logger LOG = Logger.getLogger(DerivedStateAwareResource.class);

	@Inject(optional=true)
	private IDerivedStateComputer derivedStateComputer;
	
	public void setDerivedStateComputer(IDerivedStateComputer lateInitialization) {
		this.derivedStateComputer = lateInitialization;
	}

	@Inject(optional=true)
	private DeliverNotificationAdapter.Provider notificationAdapterProvider;
	
	/**
	 * If <code>true</code>, the contents list of the resource is complete.
	 * Does not necessarily apply to the contents of the elements itself.
	 */
	protected volatile boolean fullyInitialized = false;
	/**
	 * <code>true</code> if this resource is currently running its {@link #derivedStateComputer}
	 * to {@link IDerivedStateComputer#installDerivedState(DerivedStateAwareResource, boolean) install}
	 * new elements.
	 */
	protected volatile boolean isInitializing = false;

	/**
	 * If <code>true</code>, the contents list of the resource is complete.
	 * Does not necessarily apply to the contents of the elements itself.
	 * 
	 * @since 2.7
	 */
	public boolean isFullyInitialized() {
		return fullyInitialized;
	}
	
	/**
	 * External means to mark a resource as fully initialized, e.g. if it was created programmatically.
	 * @since 2.8
	 */
	public void setFullyInitialized(boolean fullyInitialized) {
		this.fullyInitialized = fullyInitialized;
	}

	/**
	 * <code>true</code> if this resource is currently running its {@link #derivedStateComputer}
	 * to {@link IDerivedStateComputer#installDerivedState(DerivedStateAwareResource, boolean) install}
	 * new elements.
	 * 
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
		if (isLoaded && !isLoading && !isInitializing && !isUpdating && !fullyInitialized && !isLoadedFromStorage()) {
			try {
				if (notificationAdapterProvider!=null) {
					notificationAdapterProvider.get(this).setDeliver(this); // is null in Unit Test
				} else {
					eSetDeliver(false);
				}
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
	/*@Override only for emf 2.11. We build with 2.10.2 add Override for 2.9*/
	@SuppressWarnings("all")
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
	
	/*
	 * Overridden to avoid unnecessary derived state computation internal to the call graphs of
	 * {@link #updateInternalState(IParseResult)}. 
	 */
	@Override
	boolean containsRootElement(EObject newRootASTElement) {
		return doGetContents().contains(newRootASTElement);
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
				doDiscardDerivedState();
				fullyInitialized = false;
			} finally {
				// fullyInitialized should remain true, so we don't try initializing again on error.
				isInitializing = false;
				getCache().clear(this);
			}
		}
	}

	public void installDerivedState(boolean preIndexingPhase) {
		if (!isLoaded)
			throw new IllegalStateException("The resource must be loaded, before installDerivedState can be called.");
		if (!fullyInitialized && !isInitializing && !isLoadedFromStorage()) {
			//set fully initialized to true, so we don't try initializing again on error. 
			boolean newFullyInitialized = true;
			try {
				isInitializing = true;
				if (derivedStateComputer != null) {
					EList<EObject> roots = doGetContents();
					if (roots.size() > 1) {
						throw new IllegalStateException("The resource should have no more than one root element, but: " + roots);
					}
					try {
						derivedStateComputer.installDerivedState(this, preIndexingPhase);
					} catch (Throwable e) {
						if (operationCanceledManager.isOperationCanceledException(e)) {
							doDiscardDerivedState();
							// on cancellation we should try to initialize again next time   
							newFullyInitialized = false;
							operationCanceledManager.propagateAsErrorIfCancelException(e);
						}
						throw Throwables.propagate(e);
					}
				}
			} catch (RuntimeException e) {
				getErrors().add(new ExceptionDiagnostic(e));
				throw e;
			} finally {
				fullyInitialized = newFullyInitialized;
				isInitializing = false;
				try {
					getCache().clear(this);
				} catch (RuntimeException e) {
					// don't rethrow as there might have been an exception in the try block.
					LOG.error(e.getMessage(), e);
				}
			}
		}
	}
	
	/**
	 * @since 2.9
	 */
	protected void doDiscardDerivedState() {
		if (derivedStateComputer == null)
			return;
		try {
			derivedStateComputer.discardDerivedState(this);
		} catch (Throwable e) {
			if (operationCanceledManager.isOperationCanceledException(e)) {
				throw new IllegalStateException("IDerivedStateComputer#discardDerivedState should not check whether the current operation is canceled.", e);
			}
			throw Throwables.propagate(e);
		}
	}
	
}
