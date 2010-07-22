/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Element;
import org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Model;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug317840Test extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(Bug317840TestLanguageStandaloneSetup.class);
	}
	
	public void testCanParse_01() throws Exception {
		getModel("element a");
		getModel("element a b");
		getModel("element a b c");
		getModel("element a b c d");
		getModel("element a b c d e");
		getModel("element a b c d e f");
		getModel("element a b c d e f g");
		
		getModel2("element a");
		getModel2("element a b");
		getModel2("element a b c");
		getModel2("element a b c d");
		getModel2("element a b c d e");
		getModel2("element a b c d e f");
		getModel2("element a b c d e f g");
	}
	
	public void testCanParse_02() throws Exception {
		getModel("element a.a");
		getModel("element a.a b.b");
		getModel("element a.a b.b c.c");
		getModel("element a.a b.b c.c d.d");
		getModel("element a.a b.b c.c d.d e.e");
		getModel("element a.a b.b c.c d.d e.e f.f");
		getModel("element a.a b.b c.c d.d e.e f.f g.g");
		
		getModel2("element a.a");
		getModel2("element a.a b.b");
		getModel2("element a.a b.b c.c");
		getModel2("element a.a b.b c.c d.d");
		getModel2("element a.a b.b c.c d.d e.e");
		getModel2("element a.a b.b c.c d.d e.e f.f");
		getModel2("element a.a b.b c.c d.d e.e f.f g.g");
	}
	
	public void testCanParse_03() throws Exception {
		getModel("element a.a ");
		getModel("element a.a b.b /* */");
		getModel("element a.a b.b c.c /* */ ");
		getModel("element a.a b.b c.c /* */ d.d");
		getModel("element a.a b.b c.c d.d /* */e.e");
		getModel("element a.a //\nb.b c.c d.d e.e f.f");
		getModel(" element a.a b.b c.c d.d e.e f.f g.g ");
		
		getModel2("element a.a ");
		getModel2("element a.a b.b /* */");
		getModel2("element a.a b.b c.c /* */ ");
		getModel2("element a.a b.b c.c /* */ d.d");
		getModel2("element a.a b.b c.c d.d /* */e.e");
		getModel2("element a.a //\nb.b c.c d.d e.e f.f");
		getModel2(" element a.a b.b c.c d.d e.e f.f g.g ");
	}
	
	public void testCannotParse_01() throws Exception {
		getModelAndExpect("element", 1);
		getModelAndExpect("element a .a", 1);
		getModelAndExpect("element element", 1);
		getModelAndExpect("element a.a .b", 1);
		getModelAndExpect("element a. a", 1);
		getModelAndExpect("element a /* */. ", 1);
		getModelAndExpect("element a.", 1);
		getModelAndExpect("element .a", 1);
	}
	
	public void testSemanticModel_01() throws Exception {
		Element element = getFirstElement("element a");
		assertEquals("a", element.getFirst().getName());
		assertNull(element.getSecond());
		assertTrue(element.getThird().isEmpty());
		assertTrue(element.getForth().isEmpty());
	}
	
	public void testSemanticModel_02() throws Exception {
		Element element = getFirstElement("element a b");
		assertEquals("a", element.getFirst().getName());
		assertEquals("b", element.getSecond().getName());
		assertTrue(element.getThird().isEmpty());
		assertTrue(element.getForth().isEmpty());
	}
	
	public void testSemanticModel_03() throws Exception {
		Element element = getFirstElement("element a b c");
		assertEquals("a", element.getFirst().getName());
		assertNull(element.getSecond());
		assertEquals(1, element.getThird().size());
		assertEquals("b", element.getThird().get(0).getName());
		assertEquals(1, element.getForth().size());
		assertEquals("c", element.getForth().get(0).getName());
	}
	
	public void testSemanticModel_04() throws Exception {
		Element element = getFirstElement("element a b c d");
		assertEquals("a", element.getFirst().getName());
		assertEquals("b", element.getSecond().getName());
		assertEquals(1, element.getThird().size());
		assertEquals("c", element.getThird().get(0).getName());
		assertEquals(1, element.getForth().size());
		assertEquals("d", element.getForth().get(0).getName());
	}
	
	public void testSemanticModel_05() throws Exception {
		Element element = getFirstElement("element a b c d e");
		assertEquals("a", element.getFirst().getName());
		assertNull(element.getSecond());
		assertEquals(2, element.getThird().size());
		assertEquals("b", element.getThird().get(0).getName());
		assertEquals("d", element.getThird().get(1).getName());
		assertEquals(2, element.getForth().size());
		assertEquals("c", element.getForth().get(0).getName());
		assertEquals("e", element.getForth().get(1).getName());
	}
	
	public void testSemanticModel_06() throws Exception {
		Element element = getFirstElement("element a.a");
		assertEquals("a.a", element.getFirst().getName());
		assertNull(element.getSecond());
		assertTrue(element.getThird().isEmpty());
		assertTrue(element.getForth().isEmpty());
	}
	
	public void testSemanticModel_07() throws Exception {
		Element element = getFirstElement("element a.a b.b");
		assertEquals("a.a", element.getFirst().getName());
		assertEquals("b.b", element.getSecond().getName());
		assertTrue(element.getThird().isEmpty());
		assertTrue(element.getForth().isEmpty());
	}
	
	public void testSemanticModel_08() throws Exception {
		Element element = getFirstElement("element a.a b.b c.c");
		assertEquals("a.a", element.getFirst().getName());
		assertNull(element.getSecond());
		assertEquals(1, element.getThird().size());
		assertEquals("b.b", element.getThird().get(0).getName());
		assertEquals(1, element.getForth().size());
		assertEquals("c.c", element.getForth().get(0).getName());
	}
	
	public void testSemanticModel_09() throws Exception {
		Element element = getFirstElement("element a.a b.b c.c d.d");
		assertEquals("a.a", element.getFirst().getName());
		assertEquals("b.b", element.getSecond().getName());
		assertEquals(1, element.getThird().size());
		assertEquals("c.c", element.getThird().get(0).getName());
		assertEquals(1, element.getForth().size());
		assertEquals("d.d", element.getForth().get(0).getName());
	}
	
	public void testSemanticModel_10() throws Exception {
		Element element = getFirstElement("element a.a b.b c.c d.d e.e");
		assertEquals("a.a", element.getFirst().getName());
		assertNull(element.getSecond());
		assertEquals(2, element.getThird().size());
		assertEquals("b.b", element.getThird().get(0).getName());
		assertEquals("d.d", element.getThird().get(1).getName());
		assertEquals(2, element.getForth().size());
		assertEquals("c.c", element.getForth().get(0).getName());
		assertEquals("e.e", element.getForth().get(1).getName());
	}
	
	public void testNodeModel_01() throws Exception {
		Element element = getFirstElement("element a");
		AbstractNode node = NodeUtil.getNode(element);
		assertEquals("element a", node.serialize());
		assertEquals("[(element)[[( )(a)]]]", toDebugString(node));
	}
	
	public void testNodeModel_02() throws Exception {
		Element element = getFirstElement("element a b");
		AbstractNode node = NodeUtil.getNode(element);
		assertEquals("element a b", node.serialize());
		assertEquals("[(element)[[( )(a)]][[( )(b)]]]", toDebugString(node));
	}
	
	public void testNodeModel_03() throws Exception {
		Element element = getFirstElement("element a b c");
		AbstractNode node = NodeUtil.getNode(element);
		assertEquals("element a b c", node.serialize());
		assertEquals("[(element)[[( )(a)]][[( )(b)]][[( )(c)]]]", toDebugString(node));
	}
	
	public void testNodeModel_04() throws Exception {
		Element element = getFirstElement("element a b c d");
		AbstractNode node = NodeUtil.getNode(element);
		assertEquals("element a b c d", node.serialize());
		assertEquals("[(element)[[( )(a)]][[( )(b)]][[( )(c)]][[( )(d)]]]", toDebugString(node));
	}
	
	public void testNodeModel_05() throws Exception {
		Element element = getFirstElement("element a b c d e");
		AbstractNode node = NodeUtil.getNode(element);
		assertEquals("element a b c d e", node.serialize());
		assertEquals("[(element)[[( )(a)]][[( )(b)]][[( )(c)]][[( )(d)]][[( )(e)]]]", toDebugString(node));
	}
	
	public void testNodeModel_06() throws Exception {
		Element element = getFirstElement("element a.a");
		AbstractNode node = NodeUtil.getNode(element);
		assertEquals("element a.a", node.serialize());
		assertEquals("[(element)[[( )(a)(.)(a)]]]", toDebugString(node));
	}
	
	public void testNodeModel_07() throws Exception {
		Element element = getFirstElement("element a.a b.b");
		AbstractNode node = NodeUtil.getNode(element);
		assertEquals("element a.a b.b", node.serialize());
		assertEquals("[(element)[[( )(a)(.)(a)]][[( )(b)(.)(b)]]]", toDebugString(node));
	}
	
	public void testNodeModel_08() throws Exception {
		Element element = getFirstElement("element a.a b.b c.c");
		AbstractNode node = NodeUtil.getNode(element);
		assertEquals("element a.a b.b c.c", node.serialize());
		assertEquals("[(element)[[( )(a)(.)(a)]][[( )(b)(.)(b)]][[( )(c)(.)(c)]]]", toDebugString(node));
	}
	
	public void testNodeModel_09() throws Exception {
		Element element = getFirstElement("element a.a b.b c.c d.d");
		AbstractNode node = NodeUtil.getNode(element);
		assertEquals("element a.a b.b c.c d.d", node.serialize());
		assertEquals("[(element)[[( )(a)(.)(a)]][[( )(b)(.)(b)]][[( )(c)(.)(c)]][[( )(d)(.)(d)]]]", toDebugString(node));
	}
	
	public void testNodeModel_10() throws Exception {
		Element element = getFirstElement("element a.a b.b c.c d.d e.e");
		AbstractNode node = NodeUtil.getNode(element);
		assertEquals("element a.a b.b c.c d.d e.e", node.serialize());
		assertEquals("[(element)[[( )(a)(.)(a)]][[( )(b)(.)(b)]][[( )(c)(.)(c)]][[( )(d)(.)(d)]][[( )(e)(.)(e)]]]", toDebugString(node));
	}
	
	public void testNodeModel_11() throws Exception {
		Model model = getModel("element a.a ");
		AbstractNode node = NodeUtil.getNode(model);
		assertEquals("element a.a ", node.serialize());
		assertEquals("[[(element)[[( )(a)(.)(a)]]]( )]", toDebugString(node));
	}
	
	public void testNodeModel_12() throws Exception {
		Model model = getModel(" element a.a /* */");
		AbstractNode node = NodeUtil.getNode(model);
		assertEquals(" element a.a /* */", node.serialize());
		assertEquals("[[( )(element)[[( )(a)(.)(a)]]]( )(/* */)]", toDebugString(node));
	}
	
	public void testNodeModel_13() throws Exception {
		Model model = getModel(" element a.a /* */");
		AbstractNode node = NodeUtil.getNode(model);
		assertEquals(" element a.a /* */", node.serialize());
		assertEquals("[[( )(element)[[( )(a)(.)(a)]]]( )(/* */)]", toDebugString(node));
	}
	
	public String toDebugString(AbstractNode node) throws Exception {
		StringBuilder result = new StringBuilder();
		appendDebugStringTo(node, result);
		return result.toString();
	}
	
	protected void appendDebugStringTo(AbstractNode node, StringBuilder result) {
		if (node instanceof CompositeNode) {
			result.append("[");
			for(AbstractNode child: ((CompositeNode) node).getChildren()) {
				appendDebugStringTo(child, result);
			}
			result.append("]");
		} else {
			result.append("(");
			result.append(((LeafNode)node).getText());
			result.append(")");
		}
	}

	public Element getFirstElement(String model) throws Exception {
		Model m = getModel(model);
		Element element = m.getElements().get(0);
		return element;
	}
	
	@Override
	public Model getModel(String model) throws Exception {
		return (Model) super.getModel(model);
	}
	
	public Model getModel2(String model) throws Exception {
		return getModel(model + "\n" + model);
	}

}
