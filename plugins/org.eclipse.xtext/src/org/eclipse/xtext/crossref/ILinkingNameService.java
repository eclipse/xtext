/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.service.ILanguageService;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ILinkingNameService extends ILanguageService {

	/**
	 * Returns the text representation of a given object as it would be serialized in the given reference.
	 * 
	 * @param object
	 * @param reference
	 * @return the text representation.
	 */
	String getText(EObject object, CrossReference reference);

	Iterator<EObject> getMatches(Collection<EObject> candidates, CrossReference reference, String text,
			boolean exactMatch);

}
