/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.service.ILanguageService;

/**
 * Used to compute fragments (i.e. resource local IDs) for EObjects. Typically
 * used within a Resource
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public interface IFragmentProvider extends ILanguageService {
	/**
	 * @param obj
	 *            The EObject to compute the fragment for
	 * @return the fragment, which can be an arbitrary string but must be unique
	 *         within a resource. Return null to use default implementation
	 */
	String getFragment(EObject obj);
}
