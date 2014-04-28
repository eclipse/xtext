/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EObject;

/**
 * No feature scope tracking at all if this implementation is bound.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NullFeatureScopeTrackerProvider implements IFeatureScopeTracker.Provider {

	/**
	 * Always returns a null implementation of the {@link IFeatureScopeTracker}.
	 * Effectively disables the tracking of scopes.
	 * 
	 * @param root to-be-ignored by the null implementation
	 */
	public IFeatureScopeTracker track(EObject root) {
		return IFeatureScopeTracker.NULL;
	}

}