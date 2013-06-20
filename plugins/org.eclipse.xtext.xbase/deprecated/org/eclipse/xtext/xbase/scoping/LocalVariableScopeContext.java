/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;

/**
 * A wrapped parameter object that holds the necessary information for computing local variable scopes.
 * 
 * @see XbaseScopeProvider#createLocalVarScope(org.eclipse.xtext.scoping.IScope, LocalVariableScopeContext)
 * @see XbaseScopeProvider#createLocalVariableScopeContext(EObject, EReference, boolean, int)
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class LocalVariableScopeContext {
	private final EObject context;
	private final EReference reference;
	private final boolean includeCurrentBlock;
	private final int idx;
	private final boolean referredFromClosure;
	private final ILogicalContainerProvider expressionContext;
	
	public LocalVariableScopeContext(EObject context, EReference reference, boolean includeCurrentBlock, int idx, boolean referredFromClosure, ILogicalContainerProvider expressionContext) {
		this.context = context;
		this.reference = reference;
		this.includeCurrentBlock = includeCurrentBlock;
		this.idx = idx;
		this.referredFromClosure = referredFromClosure;
		this.expressionContext = expressionContext;
	}
	
	/**
	 * Create a copy of the context and adjust parameters, e.g. the information about the block scoping context
	 * is set to default while the flag {@link #referredFromClosure} is updated appropriately.
	 * @return the spawned context. Never <code>null</code>.
	 * @see LocalVariableScopeContext#canSpawnForContainer()
	 */
	public LocalVariableScopeContext spawnForContainer() {
		if (context instanceof XClosure) {
			return new LocalVariableScopeContext(getLogicalOrRealContainer(), reference, false, -1, true, expressionContext);
		}
		return new LocalVariableScopeContext(getLogicalOrRealContainer(), reference, false, -1, referredFromClosure, expressionContext);
	}

	public EObject getLogicalOrRealContainer() {
		JvmIdentifiableElement logicalContainer = expressionContext.getLogicalContainer(context);
		if (logicalContainer != null)
			return logicalContainer;
		return context.eContainer();
	}
	
	/**
	 * Used to decide whether the container hierarchy for the referenced {@link #context} should be walked up or not.
	 */
	public boolean canSpawnForContainer() {
		return getLogicalOrRealContainer() != null;
	}
	
	public EObject getContext() {
		return context;
	}
	
	public EReference getReference() {
		return reference;
	}
	
	/**
	 * Returns the index in the current block for the 'leaf context'.
	 * @return the index in the current block for the 'leaf context'.
	 */
	public int getIndex() {
		return idx;
	}
	
	public boolean isIncludeCurrentBlock() {
		return includeCurrentBlock;
	}
	
	public boolean isReferredFromClosure() {
		return referredFromClosure;
	}
}