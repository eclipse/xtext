/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parseerrorhandling;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.XtextGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.TreeTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.treeTestLanguage.Model;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class ParseErrorHandlingTest extends AbstractGeneratorTest {

	private static final Logger logger = Logger.getLogger(ParseErrorHandlingTest.class);

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextGrammarTestLanguageStandaloneSetup.class);
	}

	public void testLexerError_01() throws Exception {
		String model = "grammar a import 'holla' % as foo";
		EObject root = getModelAndExpect(model, 2);
		EList<SyntaxError> errors = NodeUtil.getRootNode(root).allSyntaxErrors();
		assertEquals(1,errors.size());
		assertEquals("%", ((LeafNode)errors.get(0).getNode()).getText());
		assertEquals(1, errors.get(0).getNode().getTotalLine());
		assertEquals(model.indexOf('%'), errors.get(0).getNode().getTotalOffset());
		assertEquals(1, errors.get(0).getNode().getTotalLength());
		assertEquals(1, errors.size());
	}

	public void testParseError1() throws Exception {
		String model = "grammar a import 'holla' foo returns x::y::Z : name=ID;";
		EObject root = getModelAndExpect(model, 5);
		EList<SyntaxError> errors = NodeUtil.getRootNode(root).allSyntaxErrors();
		assertEquals("::",  ((LeafNode)errors.get(0).getNode()).getText());
		assertEquals(1, errors.get(0).getNode().getTotalLine());
		assertEquals(model.indexOf("::Z"), errors.get(0).getNode().getTotalOffset());
		assertEquals(2, errors.get(0).getNode().getTotalLength());
		assertEquals(1, errors.size());
	}

	public void testParseError2() throws Exception {
		Object object = getModelAndExpect("grammar a import 'holla' foo returns y::Z : name=foo #;", 4);
		assertWithXtend("'foo'", "rules.first().eAllContents.typeSelect(xtextTest::RuleCall).first().rule.name", object);
	}

	public void testParseError3() throws Exception {
		Object object = getModelAndExpect("grammar a import 'holla' foo returns y::Z : name=foo #############", 4);
		assertWithXtend("'foo'", "rules.first().eAllContents.typeSelect(xtextTest::RuleCall).first().rule.name", object);
	}

	public void testParseError4() throws Exception {
		Object object = getModelAndExpect("grammar a import 'holla' foo returns y::Z : name=foo # 'foo'; bar : 'stuff'", 5);
		//logger.debug(errors);
		assertWithXtend("'foo'", "rules.first().eAllContents.typeSelect(xtextTest::RuleCall).first().rule.name", object);
		assertWithXtend("null", "rules.first().eAllContents.typeSelect(xtextTest::Keyword).first().name", object);
		assertWithXtend("'stuff'", "rules.get(1).eAllContents.typeSelect(xtextTest::Keyword).first().value", object);
	}


	public void testName() throws Exception {
		String model = "grammar a import 'holla' foo returns y::Z : name=ID # 'foo'; bar : 'stuff'";
		for (int i=model.length();0<i;i--) {
			getModelAndExpect(model.substring(0, i), EXPECT_ERRORS);
		}
	}

	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=236425
	 * @throws Exception
	 */
	public void testBug236425() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		String model = "spielplatz 100 }";
		EObject object = getModelAndExpect(model, 1);
		CompositeNode node = NodeUtil.getRootNode(object);
		assertEquals(1,node.allSyntaxErrors().size());
	}

	public void testLexerError_02() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		String model = "spielplatz 100 '}";
		EObject object = getModelAndExpect(model, 1);
		CompositeNode node = NodeUtil.getRootNode(object);
		assertEquals(1,node.allSyntaxErrors().size());
		logger.debug(node.allSyntaxErrors().get(0).getMessage());
	}

	public void testTrailingRecoverableError() throws Exception {
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
		assertEquals(1, diag.getColumn());
		Model parsedModel = (Model) res.getContents().get(0);
		assertNotNull(parsedModel);
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(parsedModel);
		assertNotNull(nodeAdapter);
		List<LeafNode> leafs = nodeAdapter.getParserNode().getLeafNodes();
		LeafNode lastWs = leafs.get(leafs.size() - 1);
		assertTrue(lastWs.isHidden());
		assertNull(lastWs.getSyntaxError());
		LeafNode lastNode = leafs.get(leafs.size() - 2);
		assertFalse(lastNode.isHidden());
		assertNotNull(lastNode);
		assertEquals("};", lastNode.getText());
		assertNotNull(lastNode.getSyntaxError());
	}

}
