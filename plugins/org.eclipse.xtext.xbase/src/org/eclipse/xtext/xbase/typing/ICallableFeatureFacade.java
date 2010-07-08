/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(CallableFeatureFacadeImpl.class)
public interface ICallableFeatureFacade {
	
	/**
	 * returns whether the given EObject is a callable feature
	 */
	public boolean isCallableFeature(EObject eobject);

	/**
	 * returns the simple name of the callable feature or null if the passed {@link EObject} is not a callable feature
	 * (see {@link #isCallableFeature(EObject)})
	 */
	public String getFeatureName(EObject eobject);

	/**
	 * @return the type of callable feature or null if the passed {@link EObject} is not a callable feature
	 * (see {@link #isCallableFeature(EObject)})
	 */
	public JvmTypeReference getReturnType(EObject eobject);
}
