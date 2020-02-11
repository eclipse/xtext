/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BatchLinkingService {
	
	@Inject
	private IBatchScopeProvider batchScopeProvider;
	
	@Inject
	private IBatchTypeResolver batchTypeResolver;

	public boolean isBatchLinkable(EReference reference) {
		return batchScopeProvider.isBatchScopeable(reference);
	}
	
	/**
	 * @param context the current instance that owns the referenced proxy.
	 * @param reference the {@link EReference} that has the proxy value.
	 * @param uriFragment the lazy linking fragment.
	 * 
	 * @return the resolved object for the given context or <code>null</code> if it couldn't be resolved
	 */
	public EObject resolveBatched(EObject context, EReference reference, String uriFragment) {
		return resolveBatched(context, reference, uriFragment, CancelIndicator.NullImpl);
	}

	public void resolveBatched(EObject root) {
		resolveBatched(root, CancelIndicator.NullImpl);
	}
	
	/**
	 * @param context the current instance that owns the referenced proxy.
	 * @param reference the {@link EReference} that has the proxy value.
	 * @param uriFragment the lazy linking fragment.
	 * @param monitor used to cancel type resolution
	 * 
	 * @return the resolved object for the given context or <code>null</code> if it couldn't be resolved
	 * @since 2.7
	 */
	public EObject resolveBatched(EObject context, EReference reference, String uriFragment, CancelIndicator monitor) {
		if (reference.isMany())
			throw new IllegalArgumentException("Not yet implemented for #many references");
		batchTypeResolver.resolveTypes(context, monitor);
		EObject result = (EObject) context.eGet(reference, false);
		if (result.eIsProxy())
			return null;
		return result;
	}

	/**
	 * @since 2.7
	 */
	public void resolveBatched(EObject root, CancelIndicator monitor) {
		batchTypeResolver.resolveTypes(root, monitor);
	}
	
}
