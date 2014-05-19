/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JAvaDoc, factory (methods?) for lightweight type references
 */
public interface ITypeReferenceOwner {
	
	CommonTypeComputationServices getServices();
	
	/**
	 * Returns the context resource set if any.
	 * May return null if there is no context information available.
	 */
	ResourceSet getContextResourceSet();

	/*
	 * TODO move the following methods to a more suitable location if possible
	 */
	void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument);
	
	List<LightweightBoundTypeArgument> getAllHints(Object handle);

	boolean isResolved(Object handle);

	List<JvmTypeParameter> getDeclaredTypeParameters();
	
}
