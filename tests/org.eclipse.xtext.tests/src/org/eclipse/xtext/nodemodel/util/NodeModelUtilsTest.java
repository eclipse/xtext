/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.SyntheticCompositeNode;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class NodeModelUtilsTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
	}
	
	@Test public void testFindNodesForFeature() throws Exception {
		Grammar grammar = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model : name=ID;");
		List<INode> nodes = NodeModelUtils.findNodesForFeature(grammar, XtextPackage.eINSTANCE.getGrammar_Name());
		assertEquals(1, nodes.size());
		assertEquals("foo.Bar", nodes.get(0).getText().trim());
		
		nodes = NodeModelUtils.findNodesForFeature(grammar, XtextPackage.eINSTANCE.getGrammar_Rules());
		assertEquals(1, nodes.size());
		assertEquals("Model : name=ID;", nodes.get(0).getText().trim());
		
		AbstractMetamodelDeclaration declaration = grammar.getMetamodelDeclarations().get(0);
		nodes = NodeModelUtils.findNodesForFeature(declaration, XtextPackage.eINSTANCE.getGeneratedMetamodel_Name());
		assertEquals(1, nodes.size());
		assertEquals("foo", nodes.get(0).getText().trim());
	}
	
	@Test public void testFindNodesForFeature_MultipleFeature() throws Exception {
		Grammar grammar = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model : foo=Foo; Foo : name=ID; ");
		List<INode> nodes = NodeModelUtils.findNodesForFeature(grammar, XtextPackage.eINSTANCE.getGrammar_Rules());
		assertEquals(2, nodes.size());
		assertEquals("Model : foo=Foo;", nodes.get(0).getText().trim());
		assertEquals("Foo : name=ID;", nodes.get(1).getText().trim());
	}
	
	@Test public void testFindNodesForFeature_CallToConcreteRule() throws Exception {
		Grammar grammar = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model returns X: name='foo';");
		AbstractRule rule = grammar.getRules().get(0);
		List<INode> nodes = NodeModelUtils.findNodesForFeature(rule, XtextPackage.eINSTANCE.getAbstractRule_Type());
		assertEquals(1, nodes.size());
		assertEquals("X", nodes.get(0).getText().trim());
	}
	
	@Test public void testFindNodesForFeature_Cardinality_0() throws Exception {
		Grammar grammar = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model: name+='foo'*;");
		Assignment assignment = (Assignment) grammar.getRules().get(0).getAlternatives();
		List<INode> nodes = NodeModelUtils.findNodesForFeature(assignment, XtextPackage.eINSTANCE.getAbstractElement_Cardinality());
		assertEquals(1, nodes.size());
		assertEquals("*", nodes.get(0).getText().trim());
	}
	
	@Test public void testFindNodesForFeature_Cardinality_1() throws Exception {
		Grammar grammar = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model: name+='foo'* name+='bar'*;");
		Group group = (Group) grammar.getRules().get(0).getAlternatives();
		List<INode> nodes = NodeModelUtils.findNodesForFeature(group, XtextPackage.eINSTANCE.getAbstractElement_Cardinality());
		assertEquals(0, nodes.size());
	}
	
	@Test public void testFindNodesForFeature_Cardinality_2() throws Exception {
		Grammar grammar = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model: (name+='foo'*)?;");
		Assignment assignment = (Assignment) grammar.getRules().get(0).getAlternatives();
		List<INode> nodes = NodeModelUtils.findNodesForFeature(assignment, XtextPackage.eINSTANCE.getAbstractElement_Cardinality());
		assertEquals(2, nodes.size());
		assertEquals("*", nodes.get(0).getText());
		assertEquals("?", nodes.get(1).getText());
	}
	
	@Test public void testFindNodesForFeature_Elements() throws Exception {
		Grammar grammar = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model:name='foo'|name='bar';");
		Alternatives body = (Alternatives) grammar.getRules().get(0).getAlternatives();
		List<INode> nodes = NodeModelUtils.findNodesForFeature(body, XtextPackage.eINSTANCE.getCompoundElement_Elements());
		assertEquals(2, nodes.size());
		assertEquals("name='foo'", nodes.get(0).getText());
		assertEquals("name='bar'", nodes.get(1).getText());
	}
	
	@Test public void testFindActualSemanticObjectFor_01() throws Exception {
		String grammarString = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model:((name=ID));";
		Grammar grammar = (Grammar) getModel(grammarString);
		ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(NodeModelUtils.getNode(grammar), grammarString.indexOf('('));
		EObject object = NodeModelUtils.findActualSemanticObjectFor(leafNode);
		assertTrue(object instanceof Assignment);
	}
	
	@Test public void testFindActualSemanticObjectFor_02() throws Exception {
		String grammarString = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model:((name=ID)*)?;";
		Grammar grammar = (Grammar) getModel(grammarString);
		ILeafNode star = NodeModelUtils.findLeafNodeAtOffset(NodeModelUtils.getNode(grammar), grammarString.indexOf('*'));
		EObject object = NodeModelUtils.findActualSemanticObjectFor(star);
		assertTrue(object instanceof Assignment);
		ILeafNode questionMark = NodeModelUtils.findLeafNodeAtOffset(NodeModelUtils.getNode(grammar), grammarString.indexOf('?'));
		object = NodeModelUtils.findActualSemanticObjectFor(questionMark);
		assertTrue(object instanceof Assignment);
	}
	
	@Test public void testFindActualSemanticObjectFor_03() throws Exception {
		String grammarString = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model:name=ID;";
		Grammar grammar = (Grammar) getModel(grammarString);
		ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(NodeModelUtils.getNode(grammar), grammarString.indexOf('='));
		EObject object = NodeModelUtils.findActualSemanticObjectFor(leafNode);
		assertTrue(object instanceof Assignment);
	}
	
	@Test public void testFindActualSemanticObjectFor_04() throws Exception {
		String grammarString = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model:name=ID;";
		Grammar grammar = (Grammar) getModel(grammarString);
		ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(NodeModelUtils.getNode(grammar), grammarString.indexOf("name"));
		EObject object = NodeModelUtils.findActualSemanticObjectFor(leafNode);
		assertTrue(object instanceof Assignment);
	}
	
	@Test public void testFindActualSemanticObjectFor_05() throws Exception {
		String grammarString = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model:name=ID;";
		Grammar grammar = (Grammar) getModel(grammarString);
		ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(NodeModelUtils.getNode(grammar), grammarString.indexOf("ID"));
		EObject object = NodeModelUtils.findActualSemanticObjectFor(leafNode);
		assertTrue(object instanceof RuleCall);
	}
	
	@Test public void testFindActualSemanticObjectFor_06() throws Exception {
		String grammarString = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model: name=ID;";
		Grammar grammar = (Grammar) getModel(grammarString);
		ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(NodeModelUtils.getNode(grammar), grammarString.lastIndexOf(" "));
		EObject object = NodeModelUtils.findActualSemanticObjectFor(leafNode);
		assertTrue(object instanceof Assignment);
	}
	
	@Test public void testFindActualSemanticObjectFor_07() throws Exception {
		String grammarString = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model:(name=ID|name=STRING?)*;";
		Grammar grammar = (Grammar) getModel(grammarString);
		ILeafNode star = NodeModelUtils.findLeafNodeAtOffset(NodeModelUtils.getNode(grammar), grammarString.indexOf('*'));
		EObject object = NodeModelUtils.findActualSemanticObjectFor(star);
		assertTrue(object instanceof Alternatives);
		ILeafNode questionMark = NodeModelUtils.findLeafNodeAtOffset(NodeModelUtils.getNode(grammar), grammarString.indexOf('?'));
		object = NodeModelUtils.findActualSemanticObjectFor(questionMark);
		assertTrue(object instanceof Assignment);
	}
	
	@Test public void testFindActualSemanticObjectFor_08() throws Exception {
		String grammarString = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model:/**/name=ID;";
		Grammar grammar = (Grammar) getModel(grammarString);
		ILeafNode leadingComment = NodeModelUtils.findLeafNodeAtOffset(NodeModelUtils.getNode(grammar), grammarString.indexOf('*'));
		EObject object = NodeModelUtils.findActualSemanticObjectFor(leadingComment);
		assertTrue(object instanceof Assignment);
	}
	
	@Test public void testFindActualSemanticObjectFor_09() throws Exception {
		String grammarString = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model:name=ID/**/;";
		Grammar grammar = (Grammar) getModel(grammarString);
		ILeafNode trailingComment = NodeModelUtils.findLeafNodeAtOffset(NodeModelUtils.getNode(grammar), grammarString.indexOf('*'));
		EObject object = NodeModelUtils.findActualSemanticObjectFor(trailingComment);
		assertTrue(object instanceof ParserRule);
	}
	
	@Test public void testCompactDump_1() throws Exception {
		String grammarString = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model:name=ID;";
		Grammar grammar = (Grammar) getModel(grammarString);
		String actual = NodeModelUtils.compactDump(NodeModelUtils.getNode(grammar.getMetamodelDeclarations().get(0)), true);
		String expected = 
				"GeneratedMetamodel {\n" + 
				"  hidden WS returns EString: => ' '\n" + 
				"  'generate' => 'generate'\n" + 
				"  name=ValidID {\n" + 
				"    hidden WS returns EString: => ' '\n" + 
				"    ID => 'foo'\n" + 
				"  }\n" + 
				"  hidden WS returns EString: => ' '\n" + 
				"  ePackage=[EPackage] => ''bar''\n" + 
				"}";
		assertEquals(expected.toString(), actual);
	}
	
	@Test public void testCompactDump_2() throws Exception {
		String grammarString = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo x 'bar' Model:name=ID;";
		Grammar grammar = (Grammar) getModelAndExpect(getAsStream(grammarString), 1);
		String actual = NodeModelUtils.compactDump(NodeModelUtils.getNode(grammar.getMetamodelDeclarations().get(0)), true);
		String expected = 
				"GeneratedMetamodel {\n" + 
				"  hidden WS returns EString: => ' '\n" + 
				"  'generate' => 'generate'\n" + 
				"  name=ValidID {\n" + 
				"    hidden WS returns EString: => ' '\n" + 
				"    ID => 'foo'\n" + 
				"  }\n" + 
				"  hidden WS returns EString: => ' '\n" + 
				"  ID returns EString: => 'x' SyntaxError: [org.eclipse.xtext.diagnostics.Diagnostic.Syntax] extraneous input 'x' expecting RULE_STRING\n" + 
				"  hidden WS returns EString: => ' '\n" + 
				"  ePackage=[EPackage] => ''bar''\n" + 
				"}";
		assertEquals(expected, actual);
	}
	
	@Test public void testCompactDump_3() throws Exception {
		String grammarString = "grammar 1 2";
		Grammar grammar = (Grammar) getModelAndExpect(getAsStream(grammarString), UNKNOWN_EXPECTATION);
		String actual = NodeModelUtils.compactDump(NodeModelUtils.getNode(grammar), true);
		String expected = 
				"Grammar: {\n" + 
				"  'grammar' => 'grammar'\n" + 
				"  name=GrammarID {\n" + 
				"    ValidID {\n" + 
				"      hidden WS returns EString: => ' '\n" + 
				"      INT returns EInt: => '1' SyntaxError: [org.eclipse.xtext.diagnostics.Diagnostic.Syntax] no viable alternative at input '1'\n" + 
				"      hidden WS returns EString: => ' '\n" + 
				"      INT returns EInt: => '2' SyntaxError: [org.eclipse.xtext.diagnostics.Diagnostic.Syntax] required (...)+ loop did not match anything at input '<EOF>'\n" + 
				"    }\n" + 
				"  }\n" + 
				"}";
		assertEquals(expected, actual);
	}

	@Test public void testFindLeafNodeAtOffset_1() throws Exception {
		String grammarText = "grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model : (name=ID value=ID);";
		Grammar grammar = (Grammar) getModel(grammarText);
		int equalsSign = grammarText.indexOf('=');
		ICompositeNode grammarNode = NodeModelUtils.getNode(grammar);
		ILeafNode leafNodeAtOffset = NodeModelUtils.findLeafNodeAtOffset(grammarNode, equalsSign);
		assertEquals("=", leafNodeAtOffset.getText());
		boolean syntheticNodeSeen = false;
		INode parent = leafNodeAtOffset.getParent();
		while(parent != null) {
			// walk up the tree to make sure we call #findLeafNodeAtOffset with synthetic nodes, too
			ILeafNode otherLeafNode = NodeModelUtils.findLeafNodeAtOffset(parent, equalsSign);
			assertSame(leafNodeAtOffset, otherLeafNode);
			if (parent instanceof SyntheticCompositeNode)
				syntheticNodeSeen = true;
			parent = parent.getParent();
		}
		assertTrue(syntheticNodeSeen);
	}
}
