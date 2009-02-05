/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.crossref;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar.Familie;
import org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar.ReferenceGrammarFactory;
import org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar.ReferenceGrammarPackage;
import org.eclipse.xtext.testlanguages.referenceGrammarTestLanguage.ReferenceGrammar.Spielplatz;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.CollectionUtils;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class Crossreftest extends AbstractGeneratorTest {

	public void testCrossRef() throws Exception {
		EPackage.Registry.INSTANCE.put(ReferenceGrammarPackage.eNS_URI, ReferenceGrammarPackage.eINSTANCE);
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		Spielplatz model = (Spielplatz) getModel("spielplatz 1 \"SpielplatzBeschreibung\" { kind(k1 0) kind(k2 0) erwachsener(v1 1) erwachsener(m1 1) }");
		Familie familie = ReferenceGrammarFactory.eINSTANCE.createFamilie();
		model.getFamilie().add(familie);

		IScopeProvider scopeProvider = getScopeProvider();
		IScope kinderScope = scopeProvider.getScope(familie, ReferenceGrammarPackage.Literals.FAMILIE__KINDER);
		List<IScopedElement> kinder = CollectionUtils.list(kinderScope.getContents());
		assertTrue(kinder.size() == 2);
		assertEquals("k1", kinder.get(0).name());
		assertEquals("k2", kinder.get(1).name());

		IScope vaterScope = scopeProvider.getScope(familie, ReferenceGrammarPackage.Literals.FAMILIE__VATER);
		List<IScopedElement> erwachsene = CollectionUtils.list(vaterScope.getContents());
		assertTrue(erwachsene.size() == 2);
		assertEquals("v1", erwachsene.get(0).name());
		assertEquals("m1", erwachsene.get(1).name());

	}
}
