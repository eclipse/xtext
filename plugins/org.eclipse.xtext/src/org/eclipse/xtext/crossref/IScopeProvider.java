/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.service.ILanguageService;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sven Efftinge
 */
public interface IScopeProvider extends ILanguageService {
	
	/**
	 * Returns a scope for the given context.
	 *
	 * @param context - the element from which an element shall be referenced 
	 * @param reference - the reference to be filled.  
	 * @return {@link IScope} representing the inner most {@link IScope} for the passed context and reference
	 */
	public IScope getScope(EObject context, EReference reference);
}
