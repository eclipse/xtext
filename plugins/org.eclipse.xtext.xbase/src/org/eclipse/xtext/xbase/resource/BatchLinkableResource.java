/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * A specialized EMF resource that is capable of resolving proxies in batch mode.
 * That is, on {@link #getEObject(String)}, the {@link BatchLinkingService} is used
 * to resolve a chunk of proxies. 
 * 
 * @author Sebastian Zarnekow - Linking assumptions
 */
public class BatchLinkableResource extends DerivedStateAwareResource implements ISynchronizable<BatchLinkableResource> {
	
	private static final Logger log = Logger.getLogger(BatchLinkableResource.class);
	
	@Inject
	private BatchLinkingService batchLinkingService;
	
	/**
	 * Returns the lock of the owning {@link ResourceSet}, if it exposes such a lock.
	 * Otherwise this resource itself is used as the lock context.
	 */
	@NonNull
	public Object getLock() {
		ResourceSet resourceSet = getResourceSet();
		if (resourceSet instanceof ISynchronizable<?>) {
			return ((ISynchronizable<?>) resourceSet).getLock();
		}
		return this;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @since 2.4
	 */
	@Nullable
	public <Result> Result execute(@NonNull IUnitOfWork<Result, ? super BatchLinkableResource> unit) throws Exception {
		synchronized (getLock()) {
			return unit.exec(this);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Delegates to the {@link BatchLinkingService} if the requested reference is 
	 * {@link BatchLinkingService#isBatchLinkable(EReference) linkeable in batch mode}.
	 * 
	 * Implementation detail: This specialization of {@link #getEObject(String) getEObject}
	 * synchronizes on the {@link #getLock() lock} which is exposed by the synchronizable
	 * resource rather than on the resource directly. This guards against reentrant resolution
	 * from different threads that could block each other.
	 * 
	 * Usually one would want to lock only in the {@link BatchLinkingService} but we could
	 * have intermixed {@link LazyURIEncoder#isCrossLinkFragment(org.eclipse.emf.ecore.resource.Resource, String)
	 * lazy cross reference} and vanilla EMF cross references which again could lead to a
	 * dead lock.
	 */
	@SuppressWarnings("sync-override")
	@Override
	public EObject getEObject(String uriFragment) {
		synchronized (getLock()) {
			try {
				if (getEncoder().isCrossLinkFragment(this, uriFragment)) {
					Triple<EObject, EReference, INode> triple = getEncoder().decode(this, uriFragment);
					if (batchLinkingService.isBatchLinkable(triple.getSecond())) {
						return batchLinkingService.resolveBatched(triple.getFirst(), triple.getSecond(), uriFragment);
					}
					return super.getEObject(uriFragment, triple);
				}
				return basicGetEObject(uriFragment);
			} catch (RuntimeException e) {
				getErrors().add(new ExceptionDiagnostic(e));
				log.error("resolution of uriFragment '" + uriFragment + "' failed.", e);
				// wrapped because the javaDoc of this method states that WrappedExceptions are thrown
				// logged because EcoreUtil.resolve will ignore any exceptions.
				throw new WrappedException(e);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * <p>Implementation detail: Overridden to use the shared {@link #getLock() lock}.</p> 
	 */
	@SuppressWarnings("sync-override")
	@Override
	public EList<EObject> getContents() {
		synchronized (getLock()) {
			if (isLoaded && !isLoading && !isInitializing && !isUpdating && !fullyInitialized) {
				try {
					eSetDeliver(false);
					installDerivedState(false);
				} finally {
					eSetDeliver(true);
				}
			}
			return doGetContents();
		}
	}
	
	/**
	 * Delegates to the BatchLinkingService to resolve all references. The linking service
	 * is responsible to lock the resource or resource set. 
	 */
	@Override
	public void resolveLazyCrossReferences(CancelIndicator monitor) {
		IParseResult parseResult = getParseResult();
		if (parseResult != null) {
			batchLinkingService.resolveBatched(parseResult.getRootASTElement());
		}
		if (monitor == null || !monitor.isCanceled())
			super.resolveLazyCrossReferences(monitor);
	}
	
	@Override
	protected EObject handleCyclicResolution(Triple<EObject, EReference, INode> triple) throws AssertionError {
		if (!isValidationDisabled()) {
			DiagnosticMessage message = new DiagnosticMessage("Cyclic linking detected : " + getReferences(triple, resolving), Severity.ERROR, "cyclic-resolution");
			List<Diagnostic> list = getDiagnosticList(message);
			Diagnostic diagnostic = createDiagnostic(triple, message);
			if (!list.contains(diagnostic))
				list.add(diagnostic);
		}
		return null;
	}
}
