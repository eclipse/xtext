/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
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

	public void unloadRoot(EObject root) {
		if (root instanceof Grammar)
			caseGrammar((Grammar) root);
		else if (root instanceof AbstractRule)
			caseAbstractRule((AbstractRule) root);
	}
	
	public void caseAbstractRule(AbstractRule object) {
		unload(object);
	}
	
	public void caseGrammar(Grammar object) {
		for(AbstractRule rule: object.getRules())
			unload(rule);
		unload(object);
	}

	protected void unload(EObject object) {
		InternalEObject internalEObject = (InternalEObject) object;
		Resource resource = object.eResource();
		internalEObject.eSetProxyURI(resource.getURI().appendFragment(resource.getURIFragment(internalEObject)));
	}

}
