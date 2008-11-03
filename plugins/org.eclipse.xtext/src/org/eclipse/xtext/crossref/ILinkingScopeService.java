/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.service.ILanguageService;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public interface ILinkingScopeService extends ILanguageService {
	
	/**
	 * Provides all EObjects that can be accessed from a given context.
	 * @param context meta model element that defines the scope 
	 * @return List of EObjects in the given scope
	 */
	public List<EObject> getObjectsInScope(EObject context);
}
