/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.crossref.ILinkingScopeService;
import org.eclipse.xtext.testlanguages.ReferenceGrammarStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextBuiltinLinkingScopeServiceTest extends AbstractGeneratorTest {

	private EObject model;
	private ILinkingScopeService scopeService;

	protected void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarStandaloneSetup.class);
		String modelAsString = "spielplatz 1 {" +
				"kind (Bob 1)" +
				"kind (Joe 2)" +
				"erwachsener (Biff 3)" +
				"erwachsener (Bommel 4)";
		model = getModel(modelAsString);
		scopeService = new XtextBuiltinLinkingScopeService();
	}
	
	public void testGetObjectsInScope() {
		Iterable<EObject> scope = scopeService.getObjectsInScope(model, null); // reference is ignored by default implementation
		assertEquals(5, size(scope)); // default implementation returns every navigateable EObject in the resource 
	}

	private int size(Iterable<EObject> scope) {
		int i = 0;
		Iterator<EObject> iterator = scope.iterator();
		while (iterator.hasNext()) {
			iterator.next();
			i++;
		}
		return i;
	}
}
