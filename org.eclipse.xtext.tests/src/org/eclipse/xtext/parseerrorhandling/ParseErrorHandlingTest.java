/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parseerrorhandling;

import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.XtextGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.TreeTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.treeTestLanguage.Model;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xtextTest.AbstractRule;
import org.eclipse.xtext.xtextTest.Assignment;
import org.eclipse.xtext.xtextTest.Grammar;
import org.eclipse.xtext.xtextTest.Keyword;
import org.eclipse.xtext.xtextTest.RuleCall;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

public class ParseErrorHandlingTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextGrammarTestLanguageStandaloneSetup.class);
	}

	@Test public void testLexerError_01() throws Exception {
		String model = "grammar a import 'holla' % as foo";
		EObject root = getModelAndExpect(model, 2);
		Iterable<INode> errors = ((XtextResource) root.eResource()).getParseResult().getSyntaxErrors();
		assertEquals(1, Iterables.size(errors));
		assertEquals("%", errors.iterator().next().getText());
		assertEquals(1, errors.iterator().next().getTotalStartLine());
		assertEquals(model.indexOf('%'), errors.iterator().next().getTotalOffset());
		assertEquals(1, errors.iterator().next().getTotalLength());
	}

	@Test public void testParseError1() throws Exception {
		String model = "grammar a import 'holla' foo returns x::y::Z : name=ID;";
		EObject root = getModelAndExpect(model, 5);
		Iterable<INode> errors = ((XtextResource) root.eResource()).getParseResult().getSyntaxErrors();
		assertEquals("::",  errors.iterator().next().getText());
		assertEquals(1, errors.iterator().next().getTotalStartLine());
		assertEquals(model.indexOf("::Z"), errors.iterator().next().getTotalOffset());
		assertEquals(2, errors.iterator().next().getTotalLength());
		assertEquals(1, Iterables.size(errors));
	}

	@Test public void testParseError2() throws Exception {
		Grammar grammar = (Grammar) getModelAndExpect("grammar a import 'holla' foo returns y::Z : name=foo #;", 4);
		AbstractRule rule = grammar.getRules().get(0);
		Assignment assignment = (Assignment) rule.getAlternatives();
		RuleCall call = (RuleCall) assignment.getTerminal();
		assertSame(rule, call.getRule());
//		assertWithXtend("'foo'", "rules.first().eAllContents().typeSelect(RuleCall).first().rule.name", grammar);
	}

	@Test public void testParseError3() throws Exception {
		Grammar grammar = (Grammar) getModelAndExpect("grammar a import 'holla' foo returns y::Z : name=foo #############", 4);
		AbstractRule rule = grammar.getRules().get(0);
		Assignment assignment = (Assignment) rule.getAlternatives();
		RuleCall call = (RuleCall) assignment.getTerminal();
		assertSame(rule, call.getRule());
//		assertWithXtend("'foo'", "rules.first().eAllContents().typeSelect(RuleCall).first().rule.name", grammar);
	}

	@Test public void testParseError4() throws Exception {
		Grammar grammar = (Grammar) getModelAndExpect("grammar a import 'holla' foo returns y::Z : name=foo # 'foo'; bar : 'stuff'", 5);
		AbstractRule rule = grammar.getRules().get(0);
		Assignment assignment = (Assignment) rule.getAlternatives();
		RuleCall call = (RuleCall) assignment.getTerminal();
		assertSame(rule, call.getRule());
//		assertWithXtend("'foo'", "rules.first().eAllContents().typeSelect(RuleCall).first().rule.name", grammar);
		
		AbstractRule secondRule = grammar.getRules().get(1);
		Keyword stuff = (Keyword) secondRule.getAlternatives();
		assertEquals("stuff", stuff.getValue());
//		assertWithXtend("'stuff'", "rules.get(1).eAllContents().typeSelect(Keyword).first().value", grammar);
	}
	
	@Test public void testExpectNoSuchMethodException() throws Exception {
		IParser parser = get(IParser.class);
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("ruleDoesNotExist");
		try {
			parser.parse(parserRule, new StringReader("empty"));
			fail("Expected WrappedException");
		} catch(ParseException e) {
			assertTrue(e.getCause() instanceof WrappedException);
			WrappedException cause = (WrappedException) e.getCause();
			assertTrue(cause.getCause() instanceof NoSuchMethodException);
		}
	}


	@Test public void testName() throws Exception {
		String model = "grammar a import 'holla' foo returns y::Z : name=ID # 'foo'; bar : 'stuff'";
		for (int i=model.length();0<i;i--) {
			getModelAndExpect(model.substring(0, i), EXPECT_ERRORS);
		}
	}

	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=236425
	 * @throws Exception
	 */
	@Test public void testBug236425() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		String model = "spielplatz 100 }";
		EObject object = getModelAndExpect(model, 1);
		ICompositeNode node = NodeModelUtils.getNode(object).getRootNode();
		assertEquals(1, Iterables.size(allSyntaxErrors(node)));
	}
	
	protected Iterable<INode> allSyntaxErrors(final ICompositeNode node) {
		return new Iterable<INode>() {
			@Override
			public Iterator<INode> iterator() {
				return Iterators.filter(node.getAsTreeIterable().iterator(), new Predicate<INode>() {
					@Override
					public boolean apply(INode input) {
						return input.getSyntaxErrorMessage() != null;
					}
				});
			}
		};
	}

	@Test public void testLexerError_02() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		String model = "spielplatz 100 '}";
		EObject object = getModelAndExpect(model, 1);
		ICompositeNode node = NodeModelUtils.getNode(object).getRootNode();
		assertEquals(1, Iterables.size(allSyntaxErrors(node)));
	}

	@Test public void testTrailingRecoverableError() throws Exception {
		with(TreeTestLanguageStandaloneSetup.class);
		String model = "parent ('Teststring') { \n" +
			"	child ('Teststring'){};\n" +
			"	child ('Teststring'){};\n" +
			"};\n" +
			"};\n" +
			"\n";
		Resource res = getResourceFromStringAndExpect(model, 1);
		assertEquals(res.getErrors().size(), 1, res.getErrors().size());
		Diagnostic diag = res.getErrors().get(0);
		assertNotNull(diag);
		assertEquals(5, diag.getLine());
		Model parsedModel = (Model) res.getContents().get(0);
		assertNotNull(parsedModel);
		ICompositeNode composite = NodeModelUtils.getNode(parsedModel);
		assertNotNull(composite);
		List<ILeafNode> leafs = Lists.newArrayList(composite.getLeafNodes());
		ILeafNode lastWs = leafs.get(leafs.size() - 1);
		assertTrue(lastWs.isHidden());
		assertNull(lastWs.getSyntaxErrorMessage());
		ILeafNode lastNode = leafs.get(leafs.size() - 2);
		assertFalse(lastNode.isHidden());
		assertNotNull(lastNode);
		assertEquals("};", lastNode.getText());
		assertNotNull(lastNode.getSyntaxErrorMessage());
	}

}
