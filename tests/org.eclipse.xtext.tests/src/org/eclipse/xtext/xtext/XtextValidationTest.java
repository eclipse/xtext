/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import static com.google.common.collect.Maps.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator.State;
import org.eclipse.xtext.validation.AbstractValidationMessageAcceptingTestCase;
import org.eclipse.xtext.validation.AbstractValidationMessageAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Michael Clay
 */
public class XtextValidationTest extends AbstractValidationMessageAcceptingTestCase {

	private String lastMessage;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		EValidator.Registry.INSTANCE.put(EcorePackage.eINSTANCE, EcoreValidator.INSTANCE);
	}
	
	private void configureValidator(XtextValidator validator, ValidationMessageAcceptor messageAcceptor, EObject currentObject) {
		State state = validator.setMessageAcceptor(messageAcceptor).getState();
		state.currentObject = currentObject;
		state.context = newHashMap();
	}
	
	@Test public void testMissingArgument() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar com.acme.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: rule=Rule<First=true, Second=false>;\n" + 
				"Rule<First, Missing, Second>: name=ID;");

		IResourceValidator validator = get(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.FAST_ONLY, CancelIndicator.NullImpl);
		assertEquals(issues.toString(), 1, issues.size());
		assertEquals("Missing argument for parameter Missing", issues.get(0).getMessage());
	}
	
	@Test public void testMissingArgument2() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar com.acme.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: rule=Rule<First=true>;\n" + 
				"Rule<First, Missing, AlsoMissing>: name=ID;");

		IResourceValidator validator = get(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.FAST_ONLY, CancelIndicator.NullImpl);
		assertEquals(issues.toString(), 1, issues.size());
		assertEquals("2 missing arguments for the following parameters: Missing, AlsoMissing", issues.get(0).getMessage());
	}
	
	@Test public void testMissingArgument3() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar com.acme.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: rule=Rule<true>;\n" + 
				"Rule<First, Missing, AlsoMissing>: name=ID;");

		IResourceValidator validator = get(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.FAST_ONLY, CancelIndicator.NullImpl);
		assertEquals(issues.toString(), 1, issues.size());
		assertEquals("Expected 3 arguments but got 1", issues.get(0).getMessage());
	}

	@Test public void testOutOfSequenceArgument_01() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar com.acme.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: rule=Rule<true, C=false, B=true>;\n" + 
				"Rule<A, B, C>: name=ID;");

		IResourceValidator validator = get(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.FAST_ONLY, CancelIndicator.NullImpl);
		assertEquals(issues.toString(), 2, issues.size());
		assertEquals("Out of sequence named argument. Expected value for B", issues.get(0).getMessage());
		assertEquals("Out of sequence named argument. Expected value for C", issues.get(1).getMessage());
	}
	
	@Test public void testOutOfSequenceArgument_02() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar com.acme.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: rule=Rule<true, B=false, C=true>;\n" + 
				"Rule<A, B, C>: name=ID;");

		IResourceValidator validator = get(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.FAST_ONLY, CancelIndicator.NullImpl);
		assertEquals(issues.toString(), 0, issues.size());
	}

	@Test public void testOutOfSequenceArgument_03() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar com.acme.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: rule=Rule<A=true, C=false, B=true>;\n" + 
				"Rule<A, B, C>: name=ID;");

		IResourceValidator validator = get(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.FAST_ONLY, CancelIndicator.NullImpl);
		assertEquals(issues.toString(), 0, issues.size());
	}
	
	@Test public void testDuplicateArgument() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar com.acme.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: rule=Rule<Single=true, Single=false>;\n" + 
				"Rule<Single>: name=ID;");

		IResourceValidator validator = get(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.FAST_ONLY, CancelIndicator.NullImpl);
		assertEquals(issues.toString(), 1, issues.size());
		assertEquals("Duplicate value for parameter Single", issues.get(0).getMessage());
	}
	
	@Test public void testInvalidOverride() throws Exception {
		XtextResource resource = getResourceFromStringAndExpect(
				"grammar org.foo.Bar with org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage\n" +
				"import 'http://www.eclipse.org/xtext/test/simpleExpressions' as mm\n" +
				"Atom<Whoot> returns mm::Atom: name = ID;", 1);
		String message = resource.getErrors().get(0).getMessage();
		assertEquals("Overridden rule Atom does not declare any parameters", message);
	}
	
	@Test public void testParameterNotAvailable() throws Exception {
		XtextResource resource = getResourceFromStringAndExpect(
				"grammar Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: rule=Rule<Arg>;\n" + 
				"Rule<Arg>: name=ID;", 1);

		String message = resource.getErrors().get(0).getMessage();
		assertEquals("Couldn't resolve reference to Parameter 'Arg'.", message);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=287082
	 */
	@Test public void testOverriddenCardinality() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: ((name+=ID+)+)?;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertEquals(2, resource.getWarnings().size());

		String message = resource.getWarnings().get(0).getMessage();
		assertEquals("More than one cardinality was set. Merging '+' with previously assigned cardinality to '+'.", message);
		message = resource.getWarnings().get(1).getMessage();
		assertEquals("More than one cardinality was set. Merging '?' with previously assigned cardinality to '*'.", message);
	}
	
	@Test public void testSupressedWarning_01() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.acme.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				 
				"Model: child=Child;\n" + 
				"/* SuppressWarnings[noInstantiation] */\n" +
				"Child: name=ID?;");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		IResourceValidator validator = get(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.FAST_ONLY, CancelIndicator.NullImpl);
		assertTrue(issues.toString(), issues.isEmpty());
	}
	
	@Test public void testSupressedWarning_02() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.acme.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
						
				"/* SuppressWarnings[potentialOverride] */\n" + 
				"Parens: \n" + 
				"  ('(' Parens ')'|name=ID) em='!'?;");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());
		
		IResourceValidator validator = get(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.FAST_ONLY, CancelIndicator.NullImpl);
		assertTrue(issues.toString(), issues.isEmpty());
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=348052
	 */
	@Test public void testGrammarHasNoNamespace() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: name=ID;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}

	@Test public void testRulenamesAreNotEqualIgnoreCase() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: name=ID ref=[Model|ID];\n" +
				"moDel: name=ID ref='foo';");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 4, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test
	public void testBug322875_01() throws Exception {
		String testGrammar = "grammar foo.Bar with org.eclipse.xtext.common.Terminals\n " +
				" import 'classpath:/org/eclipse/xtext/xtext/XtextValidationTest.ecore'  " +
				" import 'http://www.eclipse.org/2008/Xtext' as xtext\n" +
				"Bug322875 returns Bug322875: referencesETypeFromClasspathPackage=[xtext::Grammar];";
		XtextResource resource = getResourceFromStringAndExpect(testGrammar,1);
		assertFalse(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertBug322875(resource);
	}

	protected void assertBug322875(XtextResource resource) {
		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.toString(), 0, diag.getChildren().size());
		assertEquals("diag.isOk", Diagnostic.OK, diag.getSeverity());
		int xtextPackageCounter = 0;
		int validationTestCounter = 0;
		for(Resource packResource: resource.getResourceSet().getResources()) {
			EObject object = packResource.getContents().get(0);
			if (object instanceof EPackage) {
				String nsURI = ((EPackage) object).getNsURI();
				if (nsURI.equals("http://www.eclipse.org/2008/Xtext"))
					xtextPackageCounter++;
				if (nsURI.equals("http://XtextValidationBugs")) {
					validationTestCounter++;
				}
			}
		}
		assertEquals(1, xtextPackageCounter);
		assertEquals(1, validationTestCounter);
	}
	
	@Test
	public void testBug322875_01_b() throws Exception {
		String testGrammar = "grammar foo.Bar with org.eclipse.xtext.common.Terminals\n " +
				" import 'http://www.eclipse.org/2008/Xtext' as xtext\n" +
				" import 'classpath:/org/eclipse/xtext/xtext/XtextValidationTest.ecore'  " +
				"Bug322875 returns Bug322875: referencesETypeFromClasspathPackage=[xtext::Grammar];";
		XtextResource resource = getResourceFromStringAndExpect(testGrammar,1);
		assertFalse(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertBug322875(resource);
	}
	
	@Test
	public void testBug322875_02() throws Exception {
		String testGrammar = "grammar foo.Bar with org.eclipse.xtext.common.Terminals\n " +
				" import 'platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore'  " +
				"Model returns EClass: name=ID;";
		XtextResource resource = getResourceFromString(testGrammar);
		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.toString(), 0, diag.getChildren().size());
		assertEquals("diag.isOk", Diagnostic.OK, diag.getSeverity());
	}
	
	@Test public void testBug322875_03() throws Exception {
		String testGrammar = "grammar foo.Bar with org.eclipse.xtext.common.Terminals\n " +
				" import 'http://www.eclipse.org/emf/2002/Ecore'  " +
				"Model returns EClass: name=ID;";
		XtextResource resource = getResourceFromString(testGrammar);
		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.toString(), 0, diag.getChildren().size());
	}
	
	@Test
	public void testBug322875_04() throws Exception {
		String testGrammarNsURI = "grammar foo.Bar with org.eclipse.xtext.common.Terminals\n " +
				" import 'http://www.eclipse.org/emf/2002/Ecore'  " +
				"Model returns EClass: name=ID;";
		String testGrammarPlatformPlugin = "grammar foo.Bar with org.eclipse.xtext.common.Terminals\n " +
				" import 'platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore'  " +
				"Model returns EClass: name=ID;";
		XtextResource resourceOk = getResourceFromString(testGrammarNsURI);
		XtextResource resourceOk2 = (XtextResource) resourceOk.getResourceSet().createResource(URI.createURI("unused.xtext"));
		resourceOk2.load(new StringInputStream(testGrammarPlatformPlugin), null);
		Diagnostic diagOK = Diagnostician.INSTANCE.validate(resourceOk.getContents().get(0));
		assertNotNull("diag", diagOK);
		assertEquals(diagOK.toString(), 0, diagOK.getChildren().size());
		diagOK = Diagnostician.INSTANCE.validate(resourceOk2.getContents().get(0));
		assertNotNull("diag", diagOK);
		assertEquals(diagOK.toString(), 0, diagOK.getChildren().size());
	}
	
	@Test public void testBug_282852_01() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: name=ID ref='bar';\n" +
				"Model: name=ID ref='foo';");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 2, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testBug_282852_02() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: name=ID ref='bar';\n" +
				"terminal Id: 'a'..'z'+;");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 2, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}

	@Test public void testBug_282852_03() throws Exception {
		Grammar base = XtextFactory.eINSTANCE.createGrammar();
		Grammar child = XtextFactory.eINSTANCE.createGrammar();
		child.getUsedGrammars().add(base);
		AbstractRule ruleFoo = XtextFactory.eINSTANCE.createParserRule();
		ruleFoo.setName("Foo");
		base.getRules().add(ruleFoo);
		AbstractRule subRuleFoo = XtextFactory.eINSTANCE.createParserRule();
		subRuleFoo.setName("Foo");
		child.getRules().add(subRuleFoo);

		XtextValidator validator = get(XtextValidator.class);
		validator.setMessageAcceptor(this);
		validator.checkRuleName(subRuleFoo);
		assertNull(lastMessage);
	}
	
	@Test public void testBug_282852_04() throws Exception {
		Grammar base = XtextFactory.eINSTANCE.createGrammar();
		Grammar child = XtextFactory.eINSTANCE.createGrammar();
		child.getUsedGrammars().add(base);
		AbstractRule ruleFoo = XtextFactory.eINSTANCE.createParserRule();
		ruleFoo.setName("Foo");
		base.getRules().add(ruleFoo);
		AbstractRule subRuleFoo = XtextFactory.eINSTANCE.createParserRule();
		subRuleFoo.setName("foo");
		child.getRules().add(subRuleFoo);

		XtextValidator validator = get(XtextValidator.class);
		configureValidator(validator, this, subRuleFoo);
		validator.checkRuleName(subRuleFoo);
		assertEquals("A rule's name has to be unique even case insensitive. A used grammar contains another rule 'Foo'.", lastMessage);
	}
	
	@Test public void testBug_282852_05() throws Exception {
		Grammar base = XtextFactory.eINSTANCE.createGrammar();
		AbstractRule ruleFoo = XtextFactory.eINSTANCE.createParserRule();
		ruleFoo.setName("Foo");
		base.getRules().add(ruleFoo);
		AbstractRule subRuleFoo = XtextFactory.eINSTANCE.createParserRule();
		subRuleFoo.setName("foo");
		base.getRules().add(subRuleFoo);

		XtextValidator validator = get(XtextValidator.class);
		configureValidator(validator, this, subRuleFoo);
		validator.checkRuleName(subRuleFoo);
		assertEquals("A rule's name has to be unique even case insensitive. This grammar contains another rule 'Foo'.", lastMessage);
	}
	
	@Test public void testBug_282852_06() throws Exception {
		Grammar base = XtextFactory.eINSTANCE.createGrammar();
		AbstractRule ruleFoo = XtextFactory.eINSTANCE.createParserRule();
		ruleFoo.setName("Foo");
		base.getRules().add(ruleFoo);
		AbstractRule subRuleFoo = XtextFactory.eINSTANCE.createParserRule();
		subRuleFoo.setName("Foo");
		base.getRules().add(subRuleFoo);

		XtextValidator validator = get(XtextValidator.class);
		configureValidator(validator, this, subRuleFoo);
		validator.checkRuleName(subRuleFoo);
		assertEquals("A rule's name has to be unique.", lastMessage);
	}
	
	@Test public void testBug_282852_07() throws Exception {
		Grammar base = XtextFactory.eINSTANCE.createGrammar();
		AbstractRule ruleFoo = XtextFactory.eINSTANCE.createParserRule();
		ruleFoo.setName("Foo");
		base.getRules().add(ruleFoo);
		AbstractRule subRuleFoo = XtextFactory.eINSTANCE.createParserRule();
		subRuleFoo.setName("foo");
		AbstractRule subRuleFoo2 = XtextFactory.eINSTANCE.createParserRule();
		subRuleFoo2.setName("Foo");
		AbstractRule subRuleFoo3 = XtextFactory.eINSTANCE.createParserRule();
		subRuleFoo3.setName("FOO");
		base.getRules().add(subRuleFoo);
		base.getRules().add(subRuleFoo2);
		base.getRules().add(subRuleFoo3);

		XtextValidator validator = get(XtextValidator.class);
		configureValidator(validator, this, subRuleFoo);
		validator.checkRuleName(subRuleFoo);
		assertEquals("A rule's name has to be unique even case insensitive. The conflicting rules are 'FOO' and 'Foo'.", lastMessage);
	}
	
	@Test public void testBug_282852_08() throws Exception {
		Grammar base = XtextFactory.eINSTANCE.createGrammar();
		AbstractRule ruleFoo = XtextFactory.eINSTANCE.createParserRule();
		ruleFoo.setName("Foo");
		base.getRules().add(ruleFoo);
		AbstractRule subRuleFoo = XtextFactory.eINSTANCE.createParserRule();
		subRuleFoo.setName("foo");
		AbstractRule subRuleFoo2 = XtextFactory.eINSTANCE.createParserRule();
		subRuleFoo2.setName("fOO");
		AbstractRule subRuleFoo3 = XtextFactory.eINSTANCE.createParserRule();
		subRuleFoo3.setName("FOO");
		base.getRules().add(subRuleFoo);
		base.getRules().add(subRuleFoo2);
		base.getRules().add(subRuleFoo3);

		XtextValidator validator = get(XtextValidator.class);
		configureValidator(validator, this, subRuleFoo);
		validator.checkRuleName(subRuleFoo);
		assertEquals("A rule's name has to be unique even case insensitive. The conflicting rules are 'FOO', 'Foo' and 'fOO'.", lastMessage);
	}
	
	@Test public void testBug_283534_01() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: name=ID;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 0, diag.getChildren().size());
		assertEquals("diag.isOk", diag.getSeverity(), Diagnostic.OK);
	}

	@Test public void testBug_283534_02() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"enum EnumRule: Zonk;\n"+
				"Model: name=STRING;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testBug_283534_03() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"terminal TERMINAL: ID;\n" +
				"Model: name=STRING;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testBug_283534_04() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: ID;\n" +
				"SecondModel: name=STRING;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testBug_283534_05() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"enum EnumRule: Zonk;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 0, diag.getChildren().size());
		assertEquals("diag.isOk", diag.getSeverity(), Diagnostic.OK);
	}
	
	@Test public void testBug_283534_06() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"terminal TERMINAL: ID;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 0, diag.getChildren().size());
		assertEquals("diag.isOk", diag.getSeverity(), Diagnostic.OK);
	}
	
	@Test public void testBug_283534_07() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"Model: ID;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 0, diag.getChildren().size());
		assertEquals("diag.isOk", diag.getSeverity(), Diagnostic.OK);
	}
	
	@Test public void testDuplicateEnumLiterals() throws Exception {
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
	
	@Test public void testDefinedLiteralTwice() throws Exception {
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
	
	@Test public void testEnumWithEmptyLiteralGenerated() throws Exception {
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

	@Test public void testEnumWithEmptyLiteralImported() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
				"generate test 'http://foo'\n" +
				"Model: name=ID;\n" +
				"enum ExistingEnum: SameName | DifferentName='Diff' | OverriddenLiteral='';");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testEnumRuleReturnsEClass() throws Exception {
		XtextResource resource = getResourceFromStringAndExpect(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate testLanguage 'http://www.eclipse.org/2011/xtext/bug348749'\n" +
				"Model: element=Enum;\n" +
				"enum Enum returns Model: A | B;", 1);
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 0, diag.getChildren().size());
		assertEquals("diag.isOk", diag.getSeverity(), Diagnostic.OK);
	}
	
	@Test public void testBug_280413_01() throws Exception {
		XtextResource resource = getResourceFromStringAndExpect(
				"grammar org.foo.Bar with org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage\n" +
				"import 'classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.ecore' as mm\n" +
				"Atom returns mm::Atom: name = ID;", 1);
//		System.out.println(resource.getErrors());
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
		ReferencedMetamodel metamodel = (ReferencedMetamodel) diag.getChildren().get(0).getData().get(0);
		assertNotNull(metamodel);
	}
	
	@Test public void testBug_280413_02() throws Exception {
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
	
	@Test
	@Ignore("TODO this one should yield a warning, because two different instances of a package (ecore itself) might be referenced.")
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
	
	@Test public void testBug_281660() throws Exception {
		XtextResource resource = getResourceFromStringAndExpect(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : foo += [RuleB] ('->' foo+=RuleB)*;\n" +
				"RuleB : 'holla' name=ID;", 1);
		assertTrue(resource.getErrors().toString(), resource.getErrors().size()==1);
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getSeverity(), Diagnostic.OK);
		assertTrue(diag.getChildren().toString(), diag.getChildren().isEmpty());
	}
	
	@Test public void testLeftRecursion_Bug_285605_01() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleA=RuleA;");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 2, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_02() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleA=RuleA;");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 3, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_03() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleC=RuleC;\n" +
				"Unused : something=Unused;\n" +
				"RuleC : ruleA=RuleA;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 3, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_04() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : RuleA|RuleB;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 6, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_05() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : ruleA=RuleA ruleB=RuleB;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 4, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_06() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : (ruleA=RuleA)? ruleB=RuleB;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 6, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_07() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : (ruleA+=RuleA | '_')* name=ID;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 4, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_08() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : '_' (ruleA+=RuleA)* name=ID;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getSeverity(), Diagnostic.OK);
		assertTrue(diag.getChildren().toString(), diag.getChildren().isEmpty());
	}
	
	@Test public void testLeftRecursion_Bug_285605_09() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : '_'?  ( ( '__' | ruleA+=RuleA )* '___')? name=ID;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 4, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_10() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"Y: x+=X? x+=X;\n" +
				"X: name=ID;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getSeverity(), Diagnostic.OK);
		assertTrue(diag.getChildren().toString(), diag.getChildren().isEmpty());
	}
	
	@Test public void testLeftRecursion_Bug_285605_11() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : ruleA=RuleA & ruleB=RuleB;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 6, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_12() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : '_'?  ( ( '__' & ruleA+=RuleA )* '___')? name=ID;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 4, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_13() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : (ruleA+=RuleA & '_')* name=ID;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 4, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_14() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : (name=ID? & value=STRING?) ruleA=RuleA;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 4, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_15() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : (name=ID & value=STRING)? ruleA=RuleA;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 4, diag.getChildren().size());
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test public void testLeftRecursion_Bug_285605_16() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : (name=ID & value=STRING) ruleA=RuleA;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getSeverity(), Diagnostic.OK);
		assertTrue(diag.getChildren().toString(), diag.getChildren().isEmpty());
	}

	@Test public void testLeftRecursion_Bug_285605_17() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : (name=ID? & value=STRING) ruleA=RuleA;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.toString(), diag.getSeverity(), Diagnostic.OK);
		assertTrue(diag.getChildren().toString(), diag.getChildren().isEmpty());
	}
	
	@Test public void testLeftRecursion_Bug_285605_18() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://foo/bar'\n" +
				"RuleA : ruleB=RuleB;\n" +
				"RuleB : ruleC=RuleC;\n" +
				"RuleC : (name=ID & value=STRING?) ruleA=RuleA;\n");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.toString(), diag.getSeverity(), Diagnostic.OK);
		assertTrue(diag.getChildren().toString(), diag.getChildren().isEmpty());
	}
	
	@Test public void testBug_286683() throws Exception {
		XtextResource resource = getResourceFromString("grammar org.xtext.example.MyDsl with org.xtext.example.MyDsl\n"+
				"generate myDsl 'http://www.xtext.org/example/MyDsl'\n"+
				"Model : {Model} 'name';");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getSeverity(), Diagnostic.ERROR);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
	}
	
	@Test public void testBug_293110() throws Exception {
		XtextResource resource = doGetResource(new org.eclipse.xtext.util.StringInputStream("A: value=B; B: name=ID;"),URI.createURI("testBug_293110"));
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		Collection<Diagnostic> runtimeExceptions = Collections2.filter(diagnostic.getChildren(), new Predicate<Diagnostic>(){
			@Override
			public boolean apply(Diagnostic input) {
				return input.getException() instanceof RuntimeException;
			}});
		assertTrue(runtimeExceptions.isEmpty());
	}
	
	@Test public void testCheckCrossReferenceTerminal_01() throws Exception {
		XtextValidator validator = get(XtextValidator.class);
		CrossReference reference = XtextFactory.eINSTANCE.createCrossReference();
		RuleCall call = XtextFactory.eINSTANCE.createRuleCall();
		reference.setTerminal(call);
		ParserRule rule = XtextFactory.eINSTANCE.createParserRule();
		call.setRule(rule);
		TypeRef typeRef = XtextFactory.eINSTANCE.createTypeRef();
		rule.setType(typeRef);
		typeRef.setClassifier(EcorePackage.Literals.ESTRING);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkCrossReferenceTerminal(reference);
		messageAcceptor.validate();
	}
	
	@Test public void testCheckCrossReferenceTerminal_02() throws Exception {
		XtextValidator validator = get(XtextValidator.class);
		CrossReference reference = XtextFactory.eINSTANCE.createCrossReference();
		RuleCall call = XtextFactory.eINSTANCE.createRuleCall();
		reference.setTerminal(call);
		ParserRule rule = XtextFactory.eINSTANCE.createParserRule();
		call.setRule(rule);
		TypeRef typeRef = XtextFactory.eINSTANCE.createTypeRef();
		rule.setType(typeRef);
		typeRef.setClassifier(EcorePackage.Literals.EINT);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(call, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkCrossReferenceTerminal(reference);
		messageAcceptor.validate();
	}
	
	@Test public void testCheckCrossReferenceTerminal_05() throws Exception {
		XtextValidator validator = get(XtextValidator.class);
		CrossReference reference = XtextFactory.eINSTANCE.createCrossReference();
		Keyword keyword = XtextFactory.eINSTANCE.createKeyword();
		reference.setTerminal(keyword);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkCrossReferenceTerminal(reference);
		messageAcceptor.validate();
	}
	
	@Test public void testCheckActionInUnorderedGroup_01() throws Exception {
		XtextValidator validator = get(XtextValidator.class);
		UnorderedGroup unorderedGroup = XtextFactory.eINSTANCE.createUnorderedGroup();
		Action action = XtextFactory.eINSTANCE.createAction();
		unorderedGroup.getElements().add(action);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(action, true, false);
		configureValidator(validator, messageAcceptor, action);
		validator.checkActionInUnorderedGroup(action);
		messageAcceptor.validate();
	}
	
	@Test public void testCheckRuleCallInUnorderedGroup_01() throws Exception {
		XtextValidator validator = get(XtextValidator.class);
		UnorderedGroup unorderedGroup = XtextFactory.eINSTANCE.createUnorderedGroup();
		RuleCall ruleCall = XtextFactory.eINSTANCE.createRuleCall();
		TypeRef typeRef = XtextFactory.eINSTANCE.createTypeRef();
		typeRef.setClassifier(EcorePackage.Literals.EOBJECT);
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setType(typeRef);
		ruleCall.setRule(parserRule);
		unorderedGroup.getElements().add(ruleCall);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(ruleCall, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkRuleCallInUnorderedGroup(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testCheckRuleCallInUnorderedGroup_02() throws Exception {
		XtextValidator validator = get(XtextValidator.class);
		UnorderedGroup unorderedGroup = XtextFactory.eINSTANCE.createUnorderedGroup();
		RuleCall ruleCall = XtextFactory.eINSTANCE.createRuleCall();
		TypeRef typeRef = XtextFactory.eINSTANCE.createTypeRef();
		typeRef.setClassifier(EcorePackage.Literals.EBIG_DECIMAL);
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setType(typeRef);
		ruleCall.setRule(parserRule);
		unorderedGroup.getElements().add(ruleCall);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkRuleCallInUnorderedGroup(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testCheckRuleCallInUnorderedGroup_03() throws Exception {
		XtextValidator validator = get(XtextValidator.class);
		UnorderedGroup unorderedGroup = XtextFactory.eINSTANCE.createUnorderedGroup();
		RuleCall ruleCall = XtextFactory.eINSTANCE.createRuleCall();
		EnumRule enumRule = XtextFactory.eINSTANCE.createEnumRule();
		ruleCall.setRule(enumRule);
		unorderedGroup.getElements().add(ruleCall);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkRuleCallInUnorderedGroup(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testCheckRuleCallInUnorderedGroup_04() throws Exception {
		XtextValidator validator = get(XtextValidator.class);
		UnorderedGroup unorderedGroup = XtextFactory.eINSTANCE.createUnorderedGroup();
		RuleCall ruleCall = XtextFactory.eINSTANCE.createRuleCall();
		TerminalRule terminalRule = XtextFactory.eINSTANCE.createTerminalRule();
		ruleCall.setRule(terminalRule);
		unorderedGroup.getElements().add(ruleCall);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkRuleCallInUnorderedGroup(ruleCall);
		messageAcceptor.validate();
	}

	@Test public void testCheckRuleCallInUnorderedGroup_05() throws Exception {
		XtextValidator validator = get(XtextValidator.class);
		UnorderedGroup unorderedGroup = XtextFactory.eINSTANCE.createUnorderedGroup();
		RuleCall ruleCall = XtextFactory.eINSTANCE.createRuleCall();
		TypeRef typeRef = XtextFactory.eINSTANCE.createTypeRef();
		typeRef.setClassifier(EcorePackage.Literals.EOBJECT);
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setType(typeRef);
		ruleCall.setRule(parserRule);
		Assignment assignment = XtextFactory.eINSTANCE.createAssignment();
		assignment.setTerminal(ruleCall);
		unorderedGroup.getElements().add(assignment);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkRuleCallInUnorderedGroup(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testBug318424_01() throws Exception {
		XtextValidator validator = get(XtextValidator.class);
		CrossReference reference = XtextFactory.eINSTANCE.createCrossReference();
		TypeRef typeRef = XtextFactory.eINSTANCE.createTypeRef();
		reference.setType(typeRef);
		typeRef.setClassifier(EcorePackage.Literals.EBOOLEAN);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(typeRef, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkCrossReferenceType(reference);
		messageAcceptor.validate();
	}
	
	@Test public void testBug318424_02() throws Exception {
		XtextValidator validator = get(XtextValidator.class);
		Action action = XtextFactory.eINSTANCE.createAction();
		TypeRef typeRef = XtextFactory.eINSTANCE.createTypeRef();
		action.setType(typeRef);
		typeRef.setClassifier(EcorePackage.Literals.EBOOLEAN);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(typeRef, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkInstantiatedType(action);
		messageAcceptor.validate();
	}
	
	@Test public void testCycleInTypeHierarchy() throws Exception {
		String grammarAsText = "grammar test with org.eclipse.xtext.common.Terminals" +
				" generate test 'http://test'";
		grammarAsText += " RuleA: RuleB;";
		grammarAsText += " RuleB: RuleC;";
		grammarAsText += " RuleC: RuleA;";
		grammarAsText += " RuleD: RuleA;";

		Grammar grammar = (Grammar) getModel(grammarAsText);
		AbstractMetamodelDeclaration metamodelDeclaration = grammar.getMetamodelDeclarations().get(0);
		
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(grammar.getRules().get(0).getType(), true, false);
		messageAcceptor.expectedContext(
				grammar.getRules().get(1).getType(),
				grammar.getRules().get(2).getType()
		);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkGeneratedPackage((GeneratedMetamodel) metamodelDeclaration, Diagnostician.INSTANCE, Collections.EMPTY_MAP);
		messageAcceptor.validate();
	}
	
	@Test public void testDuplicateFeatures_01() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Model: Parent1 | Parent2 | NoParent;\n" + 
				"NoParent: foo=ID;" +
				"Parent1: Sub1 | Sub2;\n" + 
				"Parent2: Sub2 | Sub3;\n" + 
				"Sub1: x=ID;\n" + 
				"Sub2: x=ID;\n" + 
				"Sub3: x=ID;\n";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		AbstractMetamodelDeclaration metamodelDeclaration = grammar.getMetamodelDeclarations().get(0);
		
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, true, false);
		messageAcceptor.expectedContext(
				grammar.getRules().get(2).getType(),
				grammar.getRules().get(3).getType(),
				grammar.getRules().get(5).getType(),
				grammar.getRules().get(4).getAlternatives(),
				grammar.getRules().get(5).getAlternatives(),
				grammar.getRules().get(6).getAlternatives()
		);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkGeneratedPackage((GeneratedMetamodel) metamodelDeclaration, Diagnostician.INSTANCE, Collections.EMPTY_MAP);
		messageAcceptor.validate();
	}

	@Test public void testDuplicateFeatures_02() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"A : (b+=B)*;\n" + 
				"B : C | D;\n" +
				"C : 'c' name=ID ('e' e+=E)+;\n" + 
				"E : name=ID;\n" + 
				"F : C | E;\n" + 
				"D : 'd' name=ID 'ref' ref=[F];";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		AbstractMetamodelDeclaration metamodelDeclaration = grammar.getMetamodelDeclarations().get(0);
		
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, true, false);
		messageAcceptor.expectedContext(
				grammar.getRules().get(1).getType(),
				grammar.getRules().get(2).getType(),
				grammar.getRules().get(4).getType(),
				((CompoundElement) grammar.getRules().get(2).getAlternatives()).getElements().get(1),
				grammar.getRules().get(3).getAlternatives(),
				((CompoundElement) grammar.getRules().get(5).getAlternatives()).getElements().get(1)
		);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkGeneratedPackage((GeneratedMetamodel) metamodelDeclaration, Diagnostician.INSTANCE, Collections.EMPTY_MAP);
		messageAcceptor.validate();
	}
	
	@Test public void testNameClash_01() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"PRINTF: vars=PRINTF_Vars;\n" +
				"PRINTF_Vars: arg1=ID;";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		AbstractMetamodelDeclaration metamodelDeclaration = grammar.getMetamodelDeclarations().get(0);
		
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, true, false);
		messageAcceptor.expectedContext(
				grammar.getRules().get(0).getAlternatives(),
				grammar.getRules().get(1).getType()
		);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkGeneratedPackageForNameClashes((GeneratedMetamodel) metamodelDeclaration);
		messageAcceptor.validate();
	}
	
	@Test public void testNameClash_02() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Class returns Class: {Class_} name=ID;\n";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		AbstractMetamodelDeclaration metamodelDeclaration = grammar.getMetamodelDeclarations().get(0);
		
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, true, false);
		CompoundElement element = (CompoundElement) grammar.getRules().get(0).getAlternatives();
		messageAcceptor.expectedContext(
				grammar.getRules().get(0).getType(),
				((Action) element.getElements().get(0)).getType()
		);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkGeneratedPackage((GeneratedMetamodel) metamodelDeclaration, Diagnostician.INSTANCE, Collections.EMPTY_MAP);
		messageAcceptor.validate();
	}
	
	@Test public void testNameClash_03() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Foo: myVars=ID my_vars=ID;\n";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		AbstractMetamodelDeclaration metamodelDeclaration = grammar.getMetamodelDeclarations().get(0);
		
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, true, false);
		CompoundElement element = (CompoundElement) grammar.getRules().get(0).getAlternatives();
		messageAcceptor.expectedContext(
				grammar.getRules().get(0).getType(),
				element.getElements().get(0),
				element.getElements().get(1)
		);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkGeneratedPackage((GeneratedMetamodel) metamodelDeclaration, Diagnostician.INSTANCE, Collections.EMPTY_MAP);
		messageAcceptor.validate();
	}
	
	@Test public void testGeneratedPackageNotEmpty() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Foo: 'a';\n";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		AbstractMetamodelDeclaration metamodelDeclaration = grammar.getMetamodelDeclarations().get(0);
		
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(metamodelDeclaration, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkGeneratedPackageNotEmpty((GeneratedMetamodel) metamodelDeclaration);
		messageAcceptor.validate();
	}
	
	@Test public void testHiddenTokenIsATerminal_01() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals hidden(Model)\n" +
			"generate test 'http://test'\n" +
			"Model: name=ID;\n";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(grammar, true, false);
		configureValidator(validator, messageAcceptor, grammar);
		validator.checkHiddenTokenIsNotAFragment(grammar);
		messageAcceptor.validate();
	}
	
	@Test public void testHiddenTokenIsATerminal_02() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model hidden(Foo): name=ID;\n"+
			"enum Foo: A | B;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ParserRule rule = (ParserRule) grammar.getRules().get(0);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(rule, true, false);
		configureValidator(validator, messageAcceptor, rule);
		validator.checkHiddenTokenIsNotAFragment(rule);
		messageAcceptor.validate();
	}
	
	@Test public void testHiddenTokenIsATerminal_03() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals hidden(Fragment)\n" +
			"generate test 'http://test'\n" +
			"Model: name=ID;\n" +
			"terminal fragment Fragment: 'a'..'z'+;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(grammar, true, false);
		configureValidator(validator, messageAcceptor, grammar);
		validator.checkHiddenTokenIsNotAFragment(grammar);
		messageAcceptor.validate();
	}
	
	@Test public void testHiddenTokenIsATerminal_04() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model hidden(Fragment): name=ID;\n" +
			"terminal fragment Fragment: 'a'..'z'+;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ParserRule rule = (ParserRule) grammar.getRules().get(0);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(rule, true, false);
		configureValidator(validator, messageAcceptor, rule);
		validator.checkHiddenTokenIsNotAFragment(rule);
		messageAcceptor.validate();
	}
	
	@Test public void testHiddenTokenIsATerminal_05() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals hidden(WS)\n" +
			"generate test 'http://test'\n" +
			"Model: name=ID;\n";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkHiddenTokenIsNotAFragment(grammar);
		messageAcceptor.validate();
	}
	
	@Test public void testHiddenTokenIsATerminal_06() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model hidden(WS): name=ID;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ParserRule rule = (ParserRule) grammar.getRules().get(0);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkHiddenTokenIsNotAFragment(rule);
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_01() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: name=ID;\n"+
			"terminal MyTerminal: Fragment;\n"+
			"terminal fragment Fragment: 'a'..'z'+;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		TerminalRule rule = (TerminalRule) grammar.getRules().get(1);
		RuleCall ruleCall = (RuleCall) rule.getAlternatives();
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnassignedRuleCallAllowed(ruleCall);
		validator.checkTerminalFragmentCalledFromTerminalRule(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_02() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: name=ID;\n"+
			"terminal fragment FirstFragment: SecondFragment;\n"+
			"terminal fragment SecondFragment: 'a'..'z'+;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		TerminalRule rule = (TerminalRule) grammar.getRules().get(1);
		RuleCall ruleCall = (RuleCall) rule.getAlternatives();
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnassignedRuleCallAllowed(ruleCall);
		validator.checkTerminalFragmentCalledFromTerminalRule(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_03() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: name=ID;\n"+
			"terminal fragment Fragment: Terminal;\n"+
			"terminal Terminal: 'a'..'z'+;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		TerminalRule rule = (TerminalRule) grammar.getRules().get(1);
		RuleCall ruleCall = (RuleCall) rule.getAlternatives();
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnassignedRuleCallAllowed(ruleCall);
		validator.checkTerminalFragmentCalledFromTerminalRule(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_04() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: name=Terminal;\n"+
			"terminal Terminal: 'a'..'z'+;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ParserRule rule = (ParserRule) grammar.getRules().get(0);
		RuleCall ruleCall = (RuleCall) ((Assignment) rule.getAlternatives()).getTerminal();
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnassignedRuleCallAllowed(ruleCall);
		validator.checkTerminalFragmentCalledFromTerminalRule(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_05() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: name=Fragment;\n"+
			"terminal fragment Fragment: 'a'..'z'+;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ParserRule rule = (ParserRule) grammar.getRules().get(0);
		RuleCall ruleCall = (RuleCall) ((Assignment) rule.getAlternatives()).getTerminal();
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(ruleCall, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnassignedRuleCallAllowed(ruleCall);
		validator.checkTerminalFragmentCalledFromTerminalRule(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_06() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: name=Terminal;\n"+
			"terminal Terminal: Enum;\n" +
			"enum Enum: A | B;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		TerminalRule rule = (TerminalRule) grammar.getRules().get(1);
		RuleCall ruleCall = (RuleCall) rule.getAlternatives();
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(ruleCall, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnassignedRuleCallAllowed(ruleCall);
		validator.checkTerminalFragmentCalledFromTerminalRule(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_07() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: name=ID;\n"+
			"terminal Terminal: Model;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		TerminalRule rule = (TerminalRule) grammar.getRules().get(1);
		RuleCall ruleCall = (RuleCall) rule.getAlternatives();
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(ruleCall, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnassignedRuleCallAllowed(ruleCall);
		validator.checkTerminalFragmentCalledFromTerminalRule(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_08_335692() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model : value=ID FRAGMENT;\n"+
			"SubModel : FRAGMENT;\n"+
			"terminal fragment FRAGMENT: ';';";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ParserRule datatypeRule = (ParserRule) grammar.getRules().get(1);
		RuleCall ruleCall = (RuleCall) datatypeRule.getAlternatives();
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(ruleCall, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnassignedRuleCallAllowed(ruleCall);
		validator.checkTerminalFragmentCalledFromTerminalRule(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_09_335692() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model : value=ID FRAGMENT;\n"+
			"SubModel : FRAGMENT;\n"+
			"terminal fragment FRAGMENT: ';';";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ParserRule rule = (ParserRule) grammar.getRules().get(0);
		RuleCall ruleCall = (RuleCall) ((Group) rule.getAlternatives()).getElements().get(1);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(ruleCall, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnassignedRuleCallAllowed(ruleCall);
		validator.checkTerminalFragmentCalledFromTerminalRule(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_10() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: name=ID Fragment;\n"+
			"fragment Fragment: value=STRING;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ParserRule rule = (ParserRule) grammar.getRules().get(0);
		RuleCall ruleCall = (RuleCall) ((Group) rule.getAlternatives()).getElements().get(1);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnassignedRuleCallAllowed(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_11() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: name=ID Fragment;\n" +
			"fragment Fragment: Other;\n" +
			"Other: name=ID;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ParserRule rule = (ParserRule) grammar.getRules().get(1);
		RuleCall ruleCall = (RuleCall) rule.getAlternatives();
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(ruleCall, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		try {
			validator.checkUnassignedRuleCallAllowed(ruleCall);
			fail();
		} catch(RuntimeException e) {
			assertEquals("org.eclipse.xtext.validation.GuardException", e.getClass().getName());
		}
		messageAcceptor.validate();
	}
	
	@Test public void testRuleCallAllowed_12() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: name=ID Fragment;\n" +
			"fragment Fragment: Other;\n" +
			"fragment Other: name=ID;";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ParserRule rule = (ParserRule) grammar.getRules().get(1);
		RuleCall ruleCall = (RuleCall) rule.getAlternatives();
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, false, false);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnassignedRuleCallAllowed(ruleCall);
		messageAcceptor.validate();
	}
	
	@Test public void testActionAllowed_01() throws Exception {
		String grammarAsText =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: name=ID Fragment;\n" +
			"fragment Fragment: {Model};\n";
	
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ParserRule rule = (ParserRule) grammar.getRules().get(1);
		Action action = (Action) rule.getAlternatives();
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(action, true, false);
		validator.setMessageAcceptor(messageAcceptor);
		try {
			validator.checkUnassignedActionAfterAssignment(action);
			fail();
		} catch(RuntimeException e) {
			assertEquals("org.eclipse.xtext.validation.GuardException", e.getClass().getName());
		}
		messageAcceptor.validate();
	}
	
	@Test public void testPredicatedUnorderedGroup_01() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Model: =>(name=ID & value=STRING);\n";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, true, false);
		messageAcceptor.expectedContext(
				grammar.getRules().get(0).getAlternatives(),
				((CompoundElement) grammar.getRules().get(0).getAlternatives()).getElements().get(0)
		);
		PredicateUsesUnorderedGroupInspector inspector = new PredicateUsesUnorderedGroupInspector(messageAcceptor);
		inspector.inspect(grammar);
		messageAcceptor.validate();
	}
	
	@Test public void testPredicatedUnorderedGroup_02() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"A: =>C;\n" +
				"B: =>C;\n" +
				"C: name=ID & value=STRING;";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, true, false);
		messageAcceptor.expectedContext(
				grammar.getRules().get(0).getAlternatives(),
				grammar.getRules().get(1).getAlternatives(),
				grammar.getRules().get(2).getAlternatives()
		);
		PredicateUsesUnorderedGroupInspector inspector = new PredicateUsesUnorderedGroupInspector(messageAcceptor);
		inspector.inspect(grammar);
		messageAcceptor.validate();
	}
	
	@Test public void testTerminalRuleNamingConventions() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"A : someFeature=New_Line;\n" +
				"terminal New_Line : '\n';";
		Grammar grammar = (Grammar) getModel(grammarAsText);
		TerminalRule rule = (TerminalRule) grammar.getRules().get(1);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(rule, false, true);
		configureValidator(validator, messageAcceptor, rule);
		validator.checkTerminalRuleNamingConventions(rule);
		messageAcceptor.validate();
	}

	@Test public void testPredicatedUnorderedGroup_03() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"A: =>B;\n" +
				"B: =>C;\n" +
				"C: name=ID & value=STRING;";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, true, false);
		messageAcceptor.expectedContext(
				grammar.getRules().get(0).getAlternatives(),
				grammar.getRules().get(1).getAlternatives(),
				grammar.getRules().get(2).getAlternatives()
		);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnorderedGroupIsNotPredicated(grammar);
		messageAcceptor.validate();
	}
	
	@Test public void testPredicatedUnorderedGroup_04() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"A: =>(name=ID value=B);\n" +
				"B: name=ID & value=STRING;";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, true, false);
		Group predicatedGroup = (Group) grammar.getRules().get(0).getAlternatives();
		Group groupContent = (Group) predicatedGroup.getElements().get(0);
		Assignment valueAssignment = (Assignment) groupContent.getElements().get(1);
		messageAcceptor.expectedContext(
				grammar.getRules().get(0).getAlternatives(),
				valueAssignment.getTerminal(),
				grammar.getRules().get(1).getAlternatives()
		);
		validator.setMessageAcceptor(messageAcceptor);
		validator.checkUnorderedGroupIsNotPredicated(grammar);
		messageAcceptor.validate();
	}
	
	@Test public void testEmptyKeyword() throws Exception {
		String grammarAsText =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"A: foo='';";
		
		Grammar grammar = (Grammar) getModel(grammarAsText);
		XtextValidator validator = get(XtextValidator.class);
		ValidatingMessageAcceptor messageAcceptor = new ValidatingMessageAcceptor(null, true, false);
		Assignment valueAssignment = (Assignment) grammar.getRules().get(0).getAlternatives();
		messageAcceptor.expectedContext(
				valueAssignment.getTerminal()
		);
		configureValidator(validator, messageAcceptor, valueAssignment);
		validator.checkKeywordNotEmpty((Keyword) valueAssignment.getTerminal());
		messageAcceptor.validate();
	}
	
	public class ValidatingMessageAcceptor extends AbstractValidationMessageAcceptor {

		private final Set<EObject> contexts;
		private boolean error;
		private boolean warning;
		private boolean info;

		public ValidatingMessageAcceptor(EObject context, boolean error, boolean warning) {
			this.contexts = Sets.newHashSet();
			if (context != null)
				contexts.add(context);
			this.error = error;
			this.warning = warning;
		}
		
		public void expectedContext(EObject... contexts) {
			this.contexts.addAll(Arrays.asList(contexts));
		}
		
		public void validate() {
			assertTrue(contexts.toString(), contexts.isEmpty());
			assertFalse(info);
			assertFalse(warning);
			assertFalse(error);
		}

		@Override
		public void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
			assertTrue(error);
			assertTrue(String.valueOf(object) + " but expected: " + contexts.toString(), contexts.remove(object));
			error = contexts.size() > 0;
		}

		@Override
		public void acceptWarning(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
			assertTrue(warning);
			assertTrue(object.toString(), contexts.remove(object));
			warning = contexts.size() > 0;
		}
		
		@Override
		public void acceptInfo(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
			assertTrue(warning);
			assertTrue(object.toString(), contexts.remove(object));
			info = contexts.size() > 0;
		}
		
	}
	
	@Override
	public void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		assertNull(lastMessage);
		lastMessage = message;
	}

}
