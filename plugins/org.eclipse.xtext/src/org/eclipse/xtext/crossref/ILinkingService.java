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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.ILanguageService;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public interface ILinkingService extends ILanguageService {

	/**
	 * Returns all {@link EObject}s referenced by the given link text in the given context.
	 * But does not set the references or modifies the passed information somehow
	 */
	List<EObject> getLinkedObjects(EObject context, EReference reference, LeafNode text);

	/**
	 * Returns the textual representation of a given object as it would be serialized in the given context.
	 * 
	 * @param object
	 * @param reference
	 * @param context
	 * @return the text representation.
	 */
	String getLinkText(EObject object, EReference reference, EObject context);
}
