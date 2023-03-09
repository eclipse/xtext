/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XtextReferableElementsUnloader implements IReferableElementsUnloader {

	@Override
	public void unloadRoot(EObject root) {
		if (root instanceof Grammar)
			caseGrammar((Grammar) root);
		else if (root instanceof AbstractRule)
			caseAbstractRule((AbstractRule) root);
		else if (root instanceof EPackage) {
			caseEPackage((EPackage) root);
		}
	}

	public void caseAbstractRule(AbstractRule object) {
		unload(object);
	}
	
	public void caseGrammar(Grammar object) {
		for(AbstractRule rule: object.getRules())
			unload(rule);
		unload(object);
	}
	
	private void caseEPackage(EPackage ePackage) {
		// guard against infinite recursion
		// EPackage.eSetProxyURI and friends tries to be smart thus
		// we have to make sure to compute all URIs before they are
		// set
		Resource resource = ePackage.eResource();
		URI resourceURI = resource.getURI();
		List<EClassifier> classifiers = ePackage.getEClassifiers();
		List<URI> uris = new ArrayList<URI>(classifiers.size());
		for(int i = 0, size = classifiers.size(); i < size; i++) {
			uris.add(resourceURI.appendFragment(resource.getURIFragment(classifiers.get(i))));
		}
		// and we have to set them in a proper order
		unload(ePackage);
		for(int i = 0, size = classifiers.size(); i < size; i++) {
			InternalEObject classifier = (InternalEObject) classifiers.get(i);
			classifier.eSetProxyURI(uris.get(i));
		}
	}
	
	protected void unload(EObject object) {
		InternalEObject internalEObject = (InternalEObject) object;
		Resource resource = object.eResource();
		internalEObject.eSetProxyURI(resource.getURI().appendFragment(resource.getURIFragment(internalEObject)));
	}

}
