/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Element;
import org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Model;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug317840Test extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug317840TestLanguageStandaloneSetup.class);
	}
	
	@Test public void testCanParse_01_00() throws Exception {
		getModel("element a");
	}
	
	@Test public void testCanParse_01_01() throws Exception {
		getModel("element a b");
	}
	
	@Test public void testCanParse_01_02() throws Exception {
		getModel("element a b c");
	}
	
	@Test public void testCanParse_01_03() throws Exception {
		getModel("element a b c d");
	}
	
	@Test public void testCanParse_01_04() throws Exception {
		getModel("element a b c d e");
	}
	
	@Test public void testCanParse_01_05() throws Exception {
		getModel("element a b c d e f");
	}
	
	@Test public void testCanParse_01_06() throws Exception {
		getModel("element a b c d e f g");
	}
	
	@Test public void testCanParse_01_07() throws Exception {
		getModel2("element a");
	}
	
	@Test public void testCanParse_01_08() throws Exception {
		getModel2("element a b");
	}
	
	@Test public void testCanParse_01_09() throws Exception {
		getModel2("element a b c");
	}
	
	@Test public void testCanParse_01_10() throws Exception {
		getModel2("element a b c d");
	}
	
	@Test public void testCanParse_01_11() throws Exception {
		getModel2("element a b c d e");
	}
	
	@Test public void testCanParse_01_12() throws Exception {
		getModel2("element a b c d e f");
	}
	
	@Test public void testCanParse_01_13() throws Exception {
		getModel2("element a b c d e f g");
	}
	
	@Test public void testCanParse_02_00() throws Exception {
		getModel("element a.a");
	}
	
	@Test public void testCanParse_02_01() throws Exception {
		getModel("element a.a b.b");
	}
	
	@Test public void testCanParse_02_02() throws Exception {
		getModel("element a.a b.b c.c");
	}
	
	@Test public void testCanParse_02_03() throws Exception {
		getModel("element a.a b.b c.c d.d");
	}
	
	@Test public void testCanParse_02_04() throws Exception {
		getModel("element a.a b.b c.c d.d e.e");
	}
	
	@Test public void testCanParse_02_05() throws Exception {
		getModel("element a.a b.b c.c d.d e.e f.f");
	}
	
	@Test public void testCanParse_02_06() throws Exception {
		getModel("element a.a b.b c.c d.d e.e f.f g.g");
	}
	
	@Test public void testCanParse_02_07() throws Exception {
		getModel2("element a.a");
	}
	
	@Test public void testCanParse_02_08() throws Exception {
		getModel2("element a.a b.b");
	}
	
	@Test public void testCanParse_02_09() throws Exception {
		getModel2("element a.a b.b c.c");
	}
	
	@Test public void testCanParse_02_10() throws Exception {
		getModel2("element a.a b.b c.c d.d");
	}
	
	@Test public void testCanParse_02_11() throws Exception {
		getModel2("element a.a b.b c.c d.d e.e");
	}
	
	@Test public void testCanParse_02_12() throws Exception {
		getModel2("element a.a b.b c.c d.d e.e f.f");
	}
	
	@Test public void testCanParse_02_13() throws Exception {
		getModel2("element a.a b.b c.c d.d e.e f.f g.g");
	}
	
	@Test public void testCanParse_03_00() throws Exception {
		getModel("element a.a ");
	}
	
	@Test public void testCanParse_03_01() throws Exception {
		getModel("element a.a b.b /* */");
	}
	
	@Test public void testCanParse_03_02() throws Exception {
		getModel("element a.a b.b c.c /* */ ");
	}
	
	@Test public void testCanParse_03_03() throws Exception {
		getModel("element a.a b.b c.c /* */ d.d");
	}
	
	@Test public void testCanParse_03_04() throws Exception {
		getModel("element a.a b.b c.c d.d /* */e.e");
	}
	
	@Test public void testCanParse_03_05() throws Exception {
		getModel("element a.a //\nb.b c.c d.d e.e f.f");
	}
	
	@Test public void testCanParse_03_06() throws Exception {
		getModel(" element a.a b.b c.c d.d e.e f.f g.g ");
	}
	
	@Test public void testCanParse_03_07() throws Exception {
		getModel2("element a.a ");
	}
	
	@Test public void testCanParse_03_08() throws Exception {
		getModel2("element a.a b.b /* */");
	}
	
	@Test public void testCanParse_03_09() throws Exception {
		getModel2("element a.a b.b c.c /* */ ");
	}
	
	@Test public void testCanParse_03_10() throws Exception {
		getModel2("element a.a b.b c.c /* */ d.d");
	}
	
	@Test public void testCanParse_03_11() throws Exception {
		getModel2("element a.a b.b c.c d.d /* */e.e");
	}
	
	@Test public void testCanParse_03_12() throws Exception {
		getModel2("element a.a //\nb.b c.c d.d e.e f.f");
	}
	
	@Test public void testCanParse_03_13() throws Exception {
		getModel2(" element a.a b.b c.c d.d e.e f.f g.g ");
	}
	
	@Test public void testCannotParse_01_00() throws Exception {
//		getModelAndExpect("element", 1);
//		getModelAndExpect("element a .a", 1);
//		getModelAndExpect("element element", 1);
//		getModelAndExpect("element a.a .b", 1);
		getModelAndExpect("element a. a", 1);
	}
	
	@Test public void testCannotParse_01_01() throws Exception {
		getModelAndExpect("element a /* */. ", 1);
	}
	
	@Test public void testCannotParse_01_02() throws Exception {
		getModelAndExpect("element a.", 1);
	}
	
	@Test public void testCannotParse_01_03() throws Exception {
		getModelAndExpect("element .a", 1);
	}
	
	@Test public void testSemanticModel_01() throws Exception {
		Element element = getFirstElement("element a");
		assertEquals("a", element.getFirst().getName());
		assertNull(element.getSecond());
		assertTrue(element.getThird().isEmpty());
		assertTrue(element.getForth().isEmpty());
	}
	
	@Test public void testSemanticModel_02() throws Exception {
		Element element = getFirstElement("element a b");
		assertEquals("a", element.getFirst().getName());
		assertEquals("b", element.getSecond().getName());
		assertTrue(element.getThird().isEmpty());
		assertTrue(element.getForth().isEmpty());
	}
	
	@Test public void testSemanticModel_03() throws Exception {
		Element element = getFirstElement("element a b c");
		assertEquals("a", element.getFirst().getName());
		assertNull(element.getSecond());
		assertEquals(1, element.getThird().size());
		assertEquals("b", element.getThird().get(0).getName());
		assertEquals(1, element.getForth().size());
		assertEquals("c", element.getForth().get(0).getName());
	}
	
	@Test public void testSemanticModel_04() throws Exception {
		Element element = getFirstElement("element a b c d");
		assertEquals("a", element.getFirst().getName());
		assertEquals("b", element.getSecond().getName());
		assertEquals(1, element.getThird().size());
		assertEquals("c", element.getThird().get(0).getName());
		assertEquals(1, element.getForth().size());
		assertEquals("d", element.getForth().get(0).getName());
	}
	
	@Test public void testSemanticModel_05() throws Exception {
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
	
	@Test public void testSemanticModel_06() throws Exception {
		Element element = getFirstElement("element a.a");
		assertEquals("a.a", element.getFirst().getName());
		assertNull(element.getSecond());
		assertTrue(element.getThird().isEmpty());
		assertTrue(element.getForth().isEmpty());
	}
	
	@Test public void testSemanticModel_07() throws Exception {
		Element element = getFirstElement("element a.a b.b");
		assertEquals("a.a", element.getFirst().getName());
		assertEquals("b.b", element.getSecond().getName());
		assertTrue(element.getThird().isEmpty());
		assertTrue(element.getForth().isEmpty());
	}
	
	@Test public void testSemanticModel_08() throws Exception {
		Element element = getFirstElement("element a.a b.b c.c");
		assertEquals("a.a", element.getFirst().getName());
		assertNull(element.getSecond());
		assertEquals(1, element.getThird().size());
		assertEquals("b.b", element.getThird().get(0).getName());
		assertEquals(1, element.getForth().size());
		assertEquals("c.c", element.getForth().get(0).getName());
	}
	
	@Test public void testSemanticModel_09() throws Exception {
		Element element = getFirstElement("element a.a b.b c.c d.d");
		assertEquals("a.a", element.getFirst().getName());
		assertEquals("b.b", element.getSecond().getName());
		assertEquals(1, element.getThird().size());
		assertEquals("c.c", element.getThird().get(0).getName());
		assertEquals(1, element.getForth().size());
		assertEquals("d.d", element.getForth().get(0).getName());
	}
	
	@Test public void testSemanticModel_10() throws Exception {
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
	
	@Test public void testNodeModel_01() throws Exception {
		Element element = getFirstElement("element a");
		INode node = NodeModelUtils.getNode(element);
		assertEquals("element a", node.getText());
		assertEquals("[(element)[[( )(a)]]]", toDebugString(node));
	}
	
	@Test public void testNodeModel_02() throws Exception {
		Element element = getFirstElement("element a b");
		INode node = NodeModelUtils.getNode(element);
		assertEquals("element a b", node.getText());
		assertEquals("[(element)[[( )(a)]][[( )(b)]]]", toDebugString(node));
	}
	
	@Test public void testNodeModel_03() throws Exception {
		Element element = getFirstElement("element a b c");
		INode node = NodeModelUtils.getNode(element);
		assertEquals("element a b c", node.getText());
		assertEquals("[(element)[[( )(a)]][[( )(b)]][[( )(c)]]]", toDebugString(node));
	}
	
	@Test public void testNodeModel_04() throws Exception {
		Element element = getFirstElement("element a b c d");
		INode node = NodeModelUtils.getNode(element);
		assertEquals("element a b c d", node.getText());
		assertEquals("[(element)[[( )(a)]][[( )(b)]][[( )(c)]][[( )(d)]]]", toDebugString(node));
	}
	
	@Test public void testNodeModel_05() throws Exception {
		Element element = getFirstElement("element a b c d e");
		INode node = NodeModelUtils.getNode(element);
		assertEquals("element a b c d e", node.getText());
		assertEquals("[(element)[[( )(a)]][[( )(b)]][[( )(c)]][[( )(d)]][[( )(e)]]]", toDebugString(node));
	}
	
	@Test public void testNodeModel_06() throws Exception {
		Element element = getFirstElement("element a.a");
		INode node = NodeModelUtils.getNode(element);
		assertEquals("element a.a", node.getText());
		assertEquals("[(element)[[( )(a)(.)(a)]]]", toDebugString(node));
	}
	
	@Test public void testNodeModel_07() throws Exception {
		Element element = getFirstElement("element a.a b.b");
		INode node = NodeModelUtils.getNode(element);
		assertEquals("element a.a b.b", node.getText());
		assertEquals("[(element)[[( )(a)(.)(a)]][[( )(b)(.)(b)]]]", toDebugString(node));
	}
	
	@Test public void testNodeModel_08() throws Exception {
		Element element = getFirstElement("element a.a b.b c.c");
		INode node = NodeModelUtils.getNode(element);
		assertEquals("element a.a b.b c.c", node.getText());
		assertEquals("[(element)[[( )(a)(.)(a)]][[( )(b)(.)(b)]][[( )(c)(.)(c)]]]", toDebugString(node));
	}
	
	@Test public void testNodeModel_09() throws Exception {
		Element element = getFirstElement("element a.a b.b c.c d.d");
		INode node = NodeModelUtils.getNode(element);
		assertEquals("element a.a b.b c.c d.d", node.getText());
		assertEquals("[(element)[[( )(a)(.)(a)]][[( )(b)(.)(b)]][[( )(c)(.)(c)]][[( )(d)(.)(d)]]]", toDebugString(node));
	}
	
	@Test public void testNodeModel_10() throws Exception {
		Element element = getFirstElement("element a.a b.b c.c d.d e.e");
		INode node = NodeModelUtils.getNode(element);
		assertEquals("element a.a b.b c.c d.d e.e", node.getText());
		assertEquals("[(element)[[( )(a)(.)(a)]][[( )(b)(.)(b)]][[( )(c)(.)(c)]][[( )(d)(.)(d)]][[( )(e)(.)(e)]]]", toDebugString(node));
	}
	
	@Test public void testNodeModel_11() throws Exception {
		Model model = getModel("element a.a ");
		INode node = NodeModelUtils.getNode(model);
		assertEquals("element a.a ", node.getText());
		assertEquals("[[(element)[[( )(a)(.)(a)]]]( )]", toDebugString(node));
	}
	
	@Test public void testNodeModel_12() throws Exception {
		Model model = getModel(" element a.a /* */");
		INode node = NodeModelUtils.getNode(model);
		assertEquals(" element a.a /* */", node.getText());
		assertEquals("[[( )(element)[[( )(a)(.)(a)]]]( )(/* */)]", toDebugString(node));
	}
	
	@Test public void testNodeModel_13() throws Exception {
		Model model = getModel(" element a.a /* */");
		INode node = NodeModelUtils.getNode(model);
		assertEquals(" element a.a /* */", node.getText());
		assertEquals("[[( )(element)[[( )(a)(.)(a)]]]( )(/* */)]", toDebugString(node));
	}
	
	public String toDebugString(INode node) throws Exception {
		StringBuilder result = new StringBuilder();
		appendDebugStringTo(node, result);
		return result.toString();
	}
	
	protected void appendDebugStringTo(INode node, StringBuilder result) {
		if (node instanceof ICompositeNode) {
			result.append("[");
			for(INode child: ((ICompositeNode) node).getChildren()) {
				appendDebugStringTo(child, result);
			}
			result.append("]");
		} else {
			result.append("(");
			result.append(((ILeafNode)node).getText());
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
