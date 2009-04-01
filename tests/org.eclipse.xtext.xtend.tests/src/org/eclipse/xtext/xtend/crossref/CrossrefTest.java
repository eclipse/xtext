/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.crossref;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class CrossrefTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
	}
	public void testCrossRef() throws Exception {
		EObject spielplatz = getModel("spielplatz 1 \"SpielplatzBeschreibung\" { kind(k1 0) kind(k2 0) erwachsener(v1 1) erwachsener(m1 1) }");
		EObject familie = getASTFactory().create(spielplatz.eClass().getEPackage().getEClassifier("Familie"));
		getASTFactory().add(spielplatz, "familie", familie, null, null);

		assertInScope(familie, familie.eClass().getEStructuralFeature("kinder"), "k1", "k2");
		assertInScope(familie, familie.eClass().getEStructuralFeature("vater"), "v1", "m1");
		assertInScope(familie, familie.eClass().getEStructuralFeature("mutter"), "v1", "m1");
	}

	public void testUnsupportedOperationException() {
		try {
			getScopeProvider().getScope(null, (EReference) null);
			fail("Expected: UnsupportedOperationException");
		} catch(UnsupportedOperationException e) {
			// expected
		}
	}
	private void assertInScope(EObject familie, EStructuralFeature eReference, String... names) {
		IScopeProvider scopeProvider = getScopeProvider();
		assertTrue(scopeProvider instanceof AbstractXtendScopeProvider);
		IScope scope = scopeProvider.getScope(familie, (EReference) eReference);
		List<String> namesInScope = Lists.newArrayList(Iterables.transform(scope.getContents(), new Function<IScopedElement, String>() {
			public String apply(IScopedElement param) {
				return param.name();
			}
		}));
		assertTrue(namesInScope.size() == 2);
		for(String name : names){
			assertTrue(namesInScope.contains(name));
		}
	}
}
