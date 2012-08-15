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
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JAvaDoc, factory (methods?) for lightweight type references
 */
@NonNullByDefault
public interface ITypeReferenceOwner {
	
	CommonTypeComputationServices getServices();
	
	ResourceSet getContextResourceSet();

	// TODO move these to *somewhere* else
	void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument);
	
	// TODO move these to *somewhere* else
	List<LightweightBoundTypeArgument> getAllHints(Object handle);

	// TODO move these to *somewhere* else
	boolean isResolved(Object handle);
	
}
