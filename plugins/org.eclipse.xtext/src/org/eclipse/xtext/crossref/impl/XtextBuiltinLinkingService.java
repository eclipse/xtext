/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.crossref.ILinkingScopeService;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.util.Pair;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class XtextBuiltinLinkingService implements ILinkingService {

	@Inject
	private ILinkingScopeService linkingScopeService;
	
	private static final Logger logger = Logger.getLogger(XtextBuiltinLinkingService.class);

	private List<EObject> getObjectsInScope(EObject context) {
		if(linkingScopeService==null)
			throw new IllegalStateException("LinkingScopeService must not be null.");
		return linkingScopeService.getObjectsInScope(context);
	}

	public List<URI> getLinkedObjects(EObject context, CrossReference ref, LeafNode text) {
		List<URI> result = new ArrayList<URI>();

		for (EObject o : getObjectsInScope(context))
			if (EcoreUtil2.getURIFragment(o).equals(text.getText()))
				result.add(EcoreUtil2.getURI(o));

		return result;
	}

	public String getLinkAsText(EObject context, URI referencedObject) {
		// the same object can be referenced by different URIs. It is not
		// sufficient to extract the fragment of the passed URI
		ResourceSet resourceSet = context.eResource().getResourceSet();
		EObject eObject = resourceSet.getEObject(referencedObject, true);
		if (eObject == null)
			return null;

		return EcoreUtil2.getURIFragment(eObject);
	}

	private boolean isCandiateCompatibleFor(EObject candidate, EObject context, CrossReference ref) {

		if (ref != null && ref.eContainer() instanceof Assignment) {
			Assignment assignment = (Assignment) ref.eContainer();
			EStructuralFeature feature = context.eClass().getEStructuralFeature(assignment.getFeature());
			if (feature != null && feature.getEType() instanceof EClass) {
				EClass neededType = (EClass) feature.getEType();
				return EcoreUtil2.isAssignableFrom(neededType, candidate);
			}
		}

		return true;
	}

	public List<Pair<String, URI>> getLinkCandidates(EObject context, CrossReference ref, String partialLinkText) {
		List<Pair<String, URI>> result = new ArrayList<Pair<String, URI>>();

		for (EObject o : getObjectsInScope(context)) {
			if (isCandiateCompatibleFor(o, context, ref)) {
				URI uri = EcoreUtil2.getURI(o);
				String linktext = getLinkAsText(context, uri);

				if (isPartialLinkTextMatching(partialLinkText, linktext))
					result.add(new Pair<String, URI>(linktext, uri));
			}
		}

		logger.debug("result.size: " + result.size());

		return result;
	}

	private boolean isPartialLinkTextMatching(String partialLinkText, String linktext) {
		// TODO this might be unnecessary due to filtering on the UI side
		return linktext.toUpperCase().startsWith(partialLinkText.trim().toUpperCase());
	}

}
