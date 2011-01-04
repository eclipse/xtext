/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.impl.CaseInsensitivityHelper;

import com.google.inject.ImplementedBy;

/**
 * Clients who want to use ignore case cross references should implement
 * this service if the case sensitivity depends on an {@link EReference} or
 * bind the constant {@link IgnoreCaseLinking} to <code>true</code>.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(CaseInsensitivityHelper.class)
public interface ICaseInsensitivityHelper {

	/**
	 * @param reference the current reference. May not be <code>null</code>.
	 * @return <code>true</code> if the scope for the given reference should be case insensitive.
	 */
	boolean isIgnoreCase(EReference reference);
	
}
