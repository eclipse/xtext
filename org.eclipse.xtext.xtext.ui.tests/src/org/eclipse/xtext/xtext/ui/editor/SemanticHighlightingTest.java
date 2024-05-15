/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor;

import java.util.Set;

import org.eclipse.jface.text.TypedRegion;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xtext.ui.XtextUiInjectorProvider;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextUiInjectorProvider.class)
public class SemanticHighlightingTest extends AbstractXtextTests implements IHighlightedPositionAcceptor {

	@Inject
	private ISemanticHighlightingCalculator calculator;

	private Set<TypedRegion> expectedRegions;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		expectedRegions = Sets.newLinkedHashSet();
	}

	@Test public void testNullPointerOnInvalidReturnKeyword() throws Exception {
		XtextResource resource = getResourceFromStringAndExpect(
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore'\n" +
				"terminal fragment FOO returns EString: 'a';", 1);
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
	
	@Test 
	public void testKeywordFeatureHighlighting() {
		String testGrammar = "grammar org.xtext.example.mydsl1.MyDsl with org.eclipse.xtext.common.Terminals\n" + 
				"\n" + 
				"generate myDsl \"http://www.xtext.org/example/mydsl1/MyDsl\"\n" + 
				"\n" + 
				"Model:\n" + 
				"	greetings+=Greeting*;\n" + 
				"	\n" + 
				"Greeting:\n" + 
				"	'Hello' name=ID true=\"true\" false=\"false\";";
		expect(testGrammar.indexOf("Model"), "Model".length(), SemanticHighlightingConfiguration.RULE_DECLARATION_ID);
		expect(testGrammar.indexOf("Greeting:"), "Greeting".length(), SemanticHighlightingConfiguration.RULE_DECLARATION_ID);
		expect(testGrammar.indexOf("name"), "name".length(), SemanticHighlightingConfiguration.SPECIAL_ATTRIBUTE_ID);
		
		expect(testGrammar.indexOf("true"), "true".length(), DefaultHighlightingConfiguration.DEFAULT_ID);
		expect(testGrammar.indexOf("false"), "false".length(), DefaultHighlightingConfiguration.DEFAULT_ID);
		highlight(testGrammar);
	}
	
	protected void highlight(String grammar) {
		try {
			XtextResource resource = getResourceFromString(grammar);
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
	
	@Inject
	@Override
	protected void setInjector(Injector injector) {
		super.setInjector(injector);
	}

}
