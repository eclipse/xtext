/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.LookaheadTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.PartialParserTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class PartialParserTest extends AbstractPartialParserTest {

	public void testExpression() throws Exception {
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
		String model = "(a+b+c)*(c/d)";
		parseAndCompareAllSubstrings(model);
	}

	public void testLookahead() throws Exception {
		with(LookaheadTestLanguageStandaloneSetup.class);
		String model = "bar a foo bar c b d foo bar b c";
		parseAndCompareAllSubstrings(model);
	}

	private void parseAndCompareAllSubstrings(String model) throws Exception {
		CompositeNode rootNode = getRootNode(model);
		for (int i = 0; i < model.length() - 1; ++i) {
			for (int j = 1; j + i < model.length(); ++j) {
				partiallyParseAndCompare(rootNode, i, j);
			}
		}
	}

	public void testErrorMarkers() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		String model = "spielplatz 1 {kind (k 1}"; // model contains an error
		// due to missing ) at idx
		// 23
		XtextResource resource = getResourceFromStringAndExpect(model, 1);
		assertEquals(1, resource.getErrors().size());
		assertEquals(1, resource.getParseResult().getParseErrors().size());
		CompositeNode rootNode = resource.getParseResult().getRootNode();
		AbstractNode leaf = NodeUtil.findLeafNodeAtOffset(rootNode, 24);
		assertTrue(leaf.getSyntaxError() != null);
		// resource.update(23, 0, ")");
		// assertTrue(resource.getParseResult().getParseErrors().isEmpty());
		IParseResult reparse = partialParser.reparse(getAntlrParser(), rootNode, 23, 0, ")");
		rootNode = reparse.getRootNode();
		String expectedFixedModel = "spielplatz 1 {kind (k 1)}";
		String fixedModel = rootNode.serialize();
		assertEquals("serialized model as expected", expectedFixedModel, fixedModel);
		resource = getResourceFromString(fixedModel);
		assertEquals("full reparse is fine", 0, resource.getErrors().size());
		assertTrue("partial reparse is fine", reparse.getParseErrors() == null || reparse.getParseErrors().isEmpty());
	}

	public void testGrammarElementAssigned() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		String model = "spielplatz 1 {kind (k 1)\n}";
		XtextResource resource = getResourceFromString(model);
		CompositeNode rootNode = resource.getParseResult().getRootNode();
		checkGrammarAssigned(rootNode);
		IParseResult reparse = partialParser.reparse(getAntlrParser(), rootNode, model.length() - 2, 0, "\n");
		rootNode = reparse.getRootNode();
		checkGrammarAssigned(rootNode);
	}

	public void testParseIsPartial() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		String model = "spielplatz 1 {kind (k 1)\n}";
		XtextResource resource = getResourceFromString(model);
		CompositeNode rootNode = resource.getParseResult().getRootNode();
		resource.update(model.indexOf("k 1"), 3, "l 2");
		assertSame(rootNode, resource.getParseResult().getRootNode());
	}

	public void testParseIsPartialTwice() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		String model = "spielplatz 1 {kind (k 1)\n}";
		XtextResource resource = getResourceFromString(model);
		CompositeNode rootNode = resource.getParseResult().getRootNode();
		resource.update(model.indexOf("k 1"), 3, "l 2");
		resource.update(model.indexOf("k 1"), 3, "m 3");
		assertSame(rootNode, resource.getParseResult().getRootNode());
	}

	private AbstractNode findLeafNodeByText(CompositeNode root, String model, String text) {
		return NodeUtil.findLeafNodeAtOffset(root, model.indexOf(text) + 1);
	}

	public void testPartialParseConcreteRuleInnermostToken() throws Exception {
		with(PartialParserTestLanguageStandaloneSetup.class);
		String model = "container c1 {\n" +
				"  children {\n" +
				"    -> C ( ch1 )\n" +
				"  }" +
				"}";
		XtextResource resource = getResourceFromString(model);
		assertTrue(resource.getErrors().isEmpty());
		CompositeNode root = resource.getParseResult().getRootNode();
		AbstractNode children = findLeafNodeByText(root, model, "children");
		resource.update(model.indexOf("ch1") + 1, 1, "h");
		resource.update(model.indexOf("ch1") + 1, 1, "h");
		assertSame(root, resource.getParseResult().getRootNode());
		assertNotSame(children, findLeafNodeByText(root, model, "children"));
	}

	public void testPartialParseConcreteRuleInnerToken() throws Exception {
		with(PartialParserTestLanguageStandaloneSetup.class);
		String model = "container c1 {\n" +
				"  children {\n" +
				"    -> C ( ch1 )\n" +
				"  }" +
				"}";
		XtextResource resource = getResourceFromString(model);
		assertTrue(resource.getErrors().isEmpty());
		CompositeNode root = resource.getParseResult().getRootNode();
		AbstractNode children = findLeafNodeByText(root, model, "children");
		resource.update(model.indexOf("C"), 1, "C");
		resource.update(model.indexOf("C"), 1, "C");
		assertSame(root, resource.getParseResult().getRootNode());
		assertNotSame(children, findLeafNodeByText(root, model, "children"));
	}

	public void testPartialParseConcreteRuleFirstInnerToken() throws Exception {
		with(PartialParserTestLanguageStandaloneSetup.class);
		String model = "container c1 {\n" +
				"  children {\n" +
				"    -> C ( ch1 )\n" +
				"  }" +
				"}";
		XtextResource resource = getResourceFromString(model);
		assertTrue(resource.getErrors().isEmpty());
		CompositeNode root = resource.getParseResult().getRootNode();
		AbstractNode children = findLeafNodeByText(root, model, "children");
		resource.update(model.indexOf("->"), 2, "->");
		resource.update(model.indexOf("->"), 2, "->");
		assertSame(root, resource.getParseResult().getRootNode());
		assertNotSame(children, findLeafNodeByText(root, model, "children"));
	}

	public void testPartialParseConcreteRuleFirstToken() throws Exception {
		with(PartialParserTestLanguageStandaloneSetup.class);
		String model = "container c1 {\n" +
				"  children {\n" +
				"    -> C ( ch1 )\n" +
				"  }" +
				"}";
		XtextResource resource = getResourceFromString(model);
		assertTrue(resource.getErrors().isEmpty());
		CompositeNode root = resource.getParseResult().getRootNode();
		AbstractNode children = findLeafNodeByText(root, model, "children");
		resource.update(model.indexOf("n {") + 2, 1, "{");
		resource.update(model.indexOf("n {") + 2, 1, "{");
		assertSame(root, resource.getParseResult().getRootNode());
		assertNotSame(children, findLeafNodeByText(root, model, "children"));
	}

	@SuppressWarnings("serial")
	private void checkGrammarAssigned(CompositeNode rootNode) {
		TreeIterator<AbstractNode> iter = new AbstractTreeIterator<AbstractNode>(rootNode) {
			@Override
			protected Iterator<? extends AbstractNode> getChildren(Object object) {
				if (object instanceof CompositeNode)
					return ((CompositeNode) object).getChildren().iterator();
				return Collections.<AbstractNode> emptyList().iterator();
			}
		};
		while (iter.hasNext()) {
			AbstractNode node = iter.next();
			assertNotNull(node.getGrammarElement());
			EObject grammarElement = node.getGrammarElement();
			assertEquals(node.getParent() == null, grammarElement instanceof ParserRule);
		}
	}

	@SuppressWarnings("unchecked")
	public void testNodeState() throws Exception {
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
		String model = "(a\r\n+(b\r\n*c\r\n)+d\r\n)";
		CompositeNode rootNode = getRootNode(model);
		Iterator iter = rootNode.getLeafNodes().iterator();
		boolean found = false;
		while (iter.hasNext()) {
			LeafNode leaf = (LeafNode) iter.next();
			if (leaf.getText().equals("c")) {
				assertEquals("before", 3, leaf.getTotalLine());
				assertEquals("before", 10, leaf.getTotalOffset());
				found = true;
			}
		}
		assertTrue("node c found", found);
		IParseResult reparse = partialParser.reparse(getAntlrParser(), rootNode, model.indexOf('c'), 1, "xy");
		assertTrue(reparse.getParseErrors() == null || reparse.getParseErrors().isEmpty());
		iter = rootNode.getLeafNodes().iterator();
		found = false;
		while (iter.hasNext()) {
			LeafNode leaf = (LeafNode) iter.next();
			if (leaf.getText().equals("xy")) {
				assertEquals("after", 3, leaf.getTotalLine());
				assertEquals("after", 10, leaf.getTotalOffset());
				found = true;
			}
		}
		assertTrue("node xy found", found);
	}

	private void partiallyParseAndCompare(CompositeNode rootNode, int offset, int length) throws Exception {
		PartialParsingPointers parsingPointers = partialParser.calculatePartialParsingPointers(rootNode, offset,
				length);
		String entryRuleName = parsingPointers.findEntryRuleName();
		IParseResult parseResult = getAntlrParser().parse(entryRuleName, new StringInputStream(
				parsingPointers.findReparseRegion()));
		comparator.assertSameStructure(parsingPointers.getDefaultReplaceRootNode(), parseResult.getRootNode());
		comparator.assertSameStructure(parsingPointers.findASTReplaceElement(), parseResult.getRootASTElement());
		assertEquals(parsingPointers.getDefaultReplaceRootNode().serialize(), parseResult.getRootNode().serialize());
	}
	
	/**
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=273209
	 */
	public void testBug273209_01() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = "grammar org.eclipse.Bug273209_01 with org.eclipse.xtext.common.Terminals \n" +
				"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/partialParsing/Bug273209/1'\n" +
				"Model : \n" +
				"        'model' ':' name=ID ';'*;";
		XtextResource resource = getResourceFromString(model);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		model = resource.getParseResult().getRootNode().serialize();
		resource.update(model.indexOf("*;") + 1, 1, "");
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		model = resource.getParseResult().getRootNode().serialize();
		resource.update(model.indexOf("*") + 1, 0, " ");
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		model = resource.getParseResult().getRootNode().serialize();
		resource.update(model.indexOf("* ") + 2, 0, ";");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	/**
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=273209
	 */
	public void testBug273209_02() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = "grammar org.eclipse.Bug273209_01 with org.eclipse.xtext.common.Terminals \n" +
				"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/partialParsing/Bug273209/2'\n" +
				"importa : \n" +
				"        name=ID;\n" +
				"Model : \n" +
				"        import;";
		XtextResource resource = getResourceFromStringAndExpect(model, 1);
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		model = resource.getParseResult().getRootNode().serialize();
		resource.update(model.indexOf("import;") + "import".length(), 1, "");
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		model = resource.getParseResult().getRootNode().serialize();
		resource.update(model.indexOf(" import") + " import".length(), 0, "a");
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		model = resource.getParseResult().getRootNode().serialize();
		resource.update(model.indexOf(" importa") + " importa".length(), 0, ";");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	/**
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=273209
	 */
	public void testBug273209_03() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = "grammar org.eclipse.Bug273209_01 with org.eclipse.xtext.common.Terminals \n" +
				"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/partialParsing/Bug273209/3'\n" +
				"Model : \n" +
				"        ('model' ':' name=ID ';'*);";
		XtextResource resource = getResourceFromString(model);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		model = resource.getParseResult().getRootNode().serialize();
		resource.update(model.indexOf("*);") + 1, 2, "");
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		model = resource.getParseResult().getRootNode().serialize();
		resource.update(model.indexOf("*") + 1, 0, " ");
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		model = resource.getParseResult().getRootNode().serialize();
		resource.update(model.indexOf("* ") + 2, 0, ");");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
}
