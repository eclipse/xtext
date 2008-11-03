/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.util.Pair;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public interface ILinkingService extends ILanguageService {

	/**
	 * Returns the URIs of all EObjects referenced by the given link text in the
	 * given context.
	 */
	List<URI> getLinkedObjects(EObject context, CrossReference ref, LeafNode text);

	/**
	 * Returns a link text of a referenced object. If more than one textual
	 * representation is possible (e.g. relative vs. absolute), try to provide
	 * the unambiguous one (here: absolute)
	 */
	String getLinkAsText(EObject context, URI referencedObject);

	/**
	 * Returns all possible link matches of a partially provided link text. This
	 * could be the starting of a link text or in case of nested namespaces the
	 * fragment.
	 */
	List<Pair<String, URI>> getLinkCandidates(EObject context, CrossReference ref, String textFragment);
}
