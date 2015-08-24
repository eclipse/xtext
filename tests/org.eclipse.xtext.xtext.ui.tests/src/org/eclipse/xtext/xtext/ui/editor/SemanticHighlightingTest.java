/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor;

import java.util.Set;

import org.eclipse.jface.text.TypedRegion;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xtext.ui.Activator;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingConfiguration;
import org.eclipse.xtext.xtext.ui.internal.XtextUIModuleInternal;
import org.junit.Test;

import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SemanticHighlightingTest extends AbstractXtextTests implements IHighlightedPositionAcceptor {
	
	private Set<TypedRegion> expectedRegions;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new XtextRuntimeModule(),new XtextUIModuleInternal(Activator.getDefault()), new SharedStateModule()));
			}
		});
		expectedRegions = Sets.newLinkedHashSet();
	}

	@Test public void testNullPointerOnInvalidReturnKeyword() throws Exception {
		XtextResource resource = getResourceFromStringAndExpect(
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore'\n" +
				"terminal fragment FOO returns EString: 'a';", 1);
		ISemanticHighlightingCalculator calculator = get(ISemanticHighlightingCalculator.class);
		calculator.provideHighlightingFor(resource, new IHighlightedPositionAcceptor() {
			@Override
			public void addPosition(int offset, int length, String... id) {
				// ignore
			}
		}, CancelIndicator.NullImpl);
	}
	
	@Test public void testHighlightGrammar() {
		String testGrammar = "grammar org.xtext.example.mydsl1.MyDsl with org.eclipse.xtext.common.Terminals\n" + 
			"\n" + 
			"generate myDsl \"http://www.xtext.org/example/mydsl1/MyDsl\"\n" + 
			"\n" + 
			"Model returns Zonk:\n" + 
			"	greetings+=Greeting*;\n" + 
			"	\n" + 
			"Greeting:\n" + 
			"	'Hello' name=Identifier STRING '!';\n" + 
			"	\n" + 
			"Unused: name=Identifier;\n" + 
			"\n" + 
			"Identifier: ID;";
		
		expect(testGrammar.indexOf("STRING"), "STRING".length(), SemanticHighlightingConfiguration.UNUSED_VALUE_ID);
		expect(testGrammar.indexOf("Identifier:"), "Identifier".length(), SemanticHighlightingConfiguration.DATA_TYPE_RULE_ID);
		expect(testGrammar.indexOf("Unused"), "Unused".length(), SemanticHighlightingConfiguration.NEVER_CALLED_RULE_ID);
		
		expect(testGrammar.indexOf("Zonk"), "Zonk".length(), SemanticHighlightingConfiguration.TYPE_REFERENCE_ID);
		expect(testGrammar.indexOf("Model"), "Model".length(), SemanticHighlightingConfiguration.RULE_DECLARATION_ID);
		expect(testGrammar.indexOf("Greeting:"), "Greeting".length(), SemanticHighlightingConfiguration.RULE_DECLARATION_ID);
		expect(testGrammar.indexOf("name"), "name".length(), SemanticHighlightingConfiguration.SPECIAL_ATTRIBUTE_ID);
		expect(testGrammar.lastIndexOf("name"), "name".length(), SemanticHighlightingConfiguration.SPECIAL_ATTRIBUTE_ID);
		expect(testGrammar.indexOf("Identifier:"), "Identifier".length(), SemanticHighlightingConfiguration.RULE_DECLARATION_ID);
		expect(testGrammar.indexOf("Unused:"), "Unused".length(), SemanticHighlightingConfiguration.RULE_DECLARATION_ID);
		highlight(testGrammar);
	}
	
	protected void highlight(String grammar) {
		try {
			XtextResource resource = getResourceFromString(grammar);
			ISemanticHighlightingCalculator calculator = get(ISemanticHighlightingCalculator.class);
			calculator.provideHighlightingFor(resource, this, CancelIndicator.NullImpl);
			assertTrue(expectedRegions.toString(), expectedRegions.isEmpty());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void expect(int offset, int length, String type) {
		expectedRegions.add(new TypedRegion(offset, length, type));
	}

	@Override
	public void addPosition(int offset, int length, String... id) {
		assertEquals(1, id.length);
		TypedRegion region = new TypedRegion(offset, length, id[0]);
		assertFalse(region.toString(), expectedRegions.isEmpty());
		assertTrue("expected: " + expectedRegions.toString() + " but was: " + region, expectedRegions.remove(region));
	}

}
