/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
	 */
	public EObject resolveBatched(EObject context, EReference reference, String uriFragment) {
		if (reference.isMany())
			throw new IllegalArgumentException("Not yet implemented for #many references");
		batchTypeResolver.resolveTypes(context);
		return (EObject) context.eGet(reference, false);
	}

	public void resolveBatched(EObject root) {
		batchTypeResolver.resolveTypes(root);
	}
	
}
