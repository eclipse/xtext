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
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.service.ILanguageService;

/**
 * @todo Change type of reference from CrossReference to EReference
 * @todo Find a proper way to test these Services in the life cycle (reference parameter is not tested, currently) 
 * @author Heiko Behrens - Initial contribution and API
 */
public interface ILinkingScopeService extends ILanguageService {
	
	/**
	 * Provides all EObjects that can be accessed from a given context.
	 * <p>
	 * LinkingScope should not filter the visible EObjects with
	 * respect to their type. The passed cross reference is only used
	 * to influence the scope. Type filtering is done by the linker.
	 *  
	 * @param context meta model element that defines the scope 
	 * @param reference cross reference to have fine grained access for visibility  
	 * @return List of EObjects in the given scope
	 */
	public List<EObject> getObjectsInScope(EObject context, CrossReference reference);
}
