/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextValidationTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	public void testMarkerForCrossReferences() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: name=ID ref=[Model|(ID|STRING)];");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Grammar grammar = (Grammar) resource.getContents().get(0);
		ParserRule modelRule = (ParserRule) grammar.getRules().get(0);
		Assignment assignment = (Assignment) ((Group) modelRule.getAlternatives()).getTokens().get(1);
		CrossReference reference = (CrossReference) assignment.getTerminal();

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isWarning", diag.getSeverity(), Diagnostic.WARNING);
		assertEquals(diag.getData().toString(), grammar, diag.getData().get(0));
		assertEquals(diag.getData().toString(), 1, diag.getData().size());

		Diagnostic child = diag.getChildren().get(0);
		assertNotNull("child", child);
		assertEquals("child.isWarning", child.getSeverity(), Diagnostic.WARNING);
		assertNotNull("child.children", child.getChildren());
		assertTrue("child.children.isEmpty", child.getChildren().isEmpty());
		assertEquals("child.data[0]", reference, child.getData().get(0));
		assertEquals("child.data[1]", XtextPackage.CROSS_REFERENCE__TERMINAL, child.getData().get(1));
		assertEquals(child.getData().toString(), 2, child.getData().size());
	}

	public void testRulenamesAreNotEqualIgnoreCase() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: name=ID ref=[Model|(ID)];\n" +
				"moDel: name=ID ref='foo';");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 2, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	public void testDuplicateEnumLiterals() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
				"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/validation/literal/1'\n" +
				"Model: enumValue=ExistingEnum;\n" +
				"enum ExistingEnum: SameName | DifferentName='SameName';");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 2, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	public void testDefinedLiteralTwice() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/validation/literal/2'\n" +
				"Model: enumValue=GeneratedEnum;\n" +
				"enum GeneratedEnum: SameName ='value' | SameName='otherValue';");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isWarning", diag.getSeverity(), Diagnostic.WARNING);
	}
	
	public void testEnumWithEmptyLiteralGenerated() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/validation/literal/2'\n" +
				"Model: enumValue=GeneratedEnum;\n" +
				"enum GeneratedEnum: NoLiteral | ValidLiteral='literal' | EmptyLiteral='';");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}

	public void testEnumWithEmptyLiteralImported() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
				"enum ExistingEnum: SameName | DifferentName='Diff' | OverriddenLiteral='';");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	public void testBug_280413_01() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.Xtext\n" +
				"import 'classpath:/org/eclipse/xtext/Xtext.ecore' as xtext\n" +
				"ParserRule returns xtext::ParserRule: name = ID;");
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
		ReferencedMetamodel metamodel = (ReferencedMetamodel) diag.getChildren().get(0).getData().get(0);
		assertNotNull(metamodel);
	}
	
	public void testBug_280413_02() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.Xtext\n" +
				"import 'http://www.eclipse.org/2008/Xtext' as xtext\n" +
				"ParserRule returns xtext::ParserRule: name = ID;");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getSeverity(), Diagnostic.OK);
		assertTrue(diag.getChildren().toString(), diag.getChildren().isEmpty());
	}
	
	public void testBug_280413_03() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/Xtext.ecore' as xtext\n" +
				"ParserRule returns xtext::ParserRule: name = ID;");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getSeverity(), Diagnostic.OK);
		assertTrue(diag.getChildren().toString(), diag.getChildren().isEmpty());
	}
	
	public void testBug_281660() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : foo += [RuleB] ('->' foo+=RuleB)*;\n" +
				"RuleB : 'holla' name=ID;");
		assertTrue(resource.getErrors().toString(), resource.getErrors().size()==1);
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getSeverity(), Diagnostic.OK);
		assertTrue(diag.getChildren().toString(), diag.getChildren().isEmpty());
	}
}
