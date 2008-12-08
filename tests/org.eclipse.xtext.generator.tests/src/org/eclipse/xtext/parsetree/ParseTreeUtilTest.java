/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * Unit test for <code>ParseTreeUtil</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see ParseTreeUtil
 */
public class ParseTreeUtilTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
	}

	public void testGetGrammarElementFromNode() throws Exception {
		String text = "spielplatz 1 \"junit\" {  ";
		CompositeNode rootNode = getRootNode(text);
		AbstractNode lastCompleteNodeByOffset = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, text.length());
		AbstractElement grammarElementFromNode = ParseTreeUtil.getGrammarElementFromNode(lastCompleteNodeByOffset);
		assertTrue("expect Keyword as last complete grammar element", grammarElementFromNode instanceof Keyword);

		text = "spielplatz 1 \"junit\" { kind (k1 ";
		rootNode = getRootNode(text);
		lastCompleteNodeByOffset = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, text.length());
		grammarElementFromNode = ParseTreeUtil.getGrammarElementFromNode(lastCompleteNodeByOffset);
		assertTrue("expect Keyword as last complete grammar element", grammarElementFromNode instanceof RuleCall);
	}

	public void testGetLastCompleteNodeByOffset() throws Exception {
		String text = "spielplatz 1 \"junit\" {  ";
		CompositeNode rootNode = getRootNode(text);
		AbstractNode lastCompleteNodeByOffset = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, text.length());
		assertTrue("expect leafnode as last complete element", lastCompleteNodeByOffset instanceof LeafNode);
		assertEquals("expect leafnode with text '{'", ((LeafNode) lastCompleteNodeByOffset).getText(), "{");
	}

	public void testGetCurrentNodeByOffset() throws Exception {

		String text = "spielplatz 1 \"junit\" { kin  ";
		CompositeNode rootNode = getRootNode(text);
		LeafNode currentNodeByOffset = ParseTreeUtil.getCurrentNodeByOffset(rootNode, 26);
		assertEquals("expect leafnode with text 'kin'", currentNodeByOffset.getText(), "kin");

		text = "spielplatz 1 \"junit\" { kind (";
		rootNode = getRootNode(text);
		currentNodeByOffset = ParseTreeUtil.getCurrentNodeByOffset(rootNode, text.length());
		assertEquals("expect leafnode with text '('", currentNodeByOffset.getText(), "(");

		text = "spielplatz 1 \"junit\" { kind (  ";
		rootNode = getRootNode(text);
		currentNodeByOffset = ParseTreeUtil.getCurrentNodeByOffset(rootNode, text.length());
		assertEquals("expect leafnode with WS text '__'", currentNodeByOffset.getText(), "  ");

		text = "spielplatz 1 \"junit\" { kind (";
		rootNode = getRootNode(text);
		currentNodeByOffset = ParseTreeUtil.getCurrentNodeByOffset(rootNode, text.length() - 1);
		assertEquals("expect leafnode with WS text '_'", currentNodeByOffset.getText(), " ");

		text = "spielplatz 1 \"junit\" { kind (";
		rootNode = getRootNode(text);
		currentNodeByOffset = ParseTreeUtil.getCurrentNodeByOffset(rootNode, 0);
		assertEquals("expect leafnode with WS text 'spielplatz'", currentNodeByOffset.getText(), "spielplatz");

	}

	public void testGetElementSetValidFromOffsetEmptyText() throws Exception {
		String text = "";
		CompositeNode rootNode = getRootNode(text);
		Set<AbstractElement> elementSetValidFromOffset = ParseTreeUtil.getElementSetValidFromOffset(rootNode, text
				.length());
		assertEquals("expect only 1 item", 1, elementSetValidFromOffset.size());
		assertEqualsClass(elementSetValidFromOffset, Group.class);
	}

	public void testGetElementSetValidFromOffset() throws Exception {
		String text = "spielplatz ";
		CompositeNode rootNode = getRootNode(text);
		Set<AbstractElement> elementSetValidFromOffset = ParseTreeUtil.getElementSetValidFromOffset(rootNode, text
				.length());
		assertEquals("expect only 1 item", 1, elementSetValidFromOffset.size());
		assertEqualsClass(elementSetValidFromOffset, Assignment.class);

		// Keyword Assignment [Assignment|Keyword]
		text = "spielplatz 1 ";
		rootNode = getRootNode(text);
		elementSetValidFromOffset = ParseTreeUtil.getElementSetValidFromOffset(rootNode, text.length());
		assertEquals("expect only 2 items", 2, elementSetValidFromOffset.size());
		assertEqualsClass(elementSetValidFromOffset, Assignment.class, Keyword.class);

		// Keyword Assignment Assignment [Keyword]
		text = "spielplatz 1 \"junit\" ";
		rootNode = getRootNode(text);
		elementSetValidFromOffset = ParseTreeUtil.getElementSetValidFromOffset(rootNode, text.length());
		assertEquals("expect only 1 item", 1, elementSetValidFromOffset.size());
		assertEqualsClass(elementSetValidFromOffset, Keyword.class);

		// Keyword Assignment Assignment Keyword [Alternatives|Keyword]
		text = "spielplatz 1 \"junit\" { ";
		rootNode = getRootNode(text);
		elementSetValidFromOffset = ParseTreeUtil.getElementSetValidFromOffset(rootNode, text.length());
		assertEquals("expect only 2 items", 2, elementSetValidFromOffset.size());
		assertEqualsClass(elementSetValidFromOffset, Alternatives.class, Keyword.class);

		// Keyword Assignment Assignment Keyword [Keyword]
		text = "spielplatz 1 \"junit\" { kind ";
		rootNode = getRootNode(text);
		elementSetValidFromOffset = ParseTreeUtil.getElementSetValidFromOffset(rootNode, text.length());
		assertEquals("expect only 1 item", 1, elementSetValidFromOffset.size());
		assertEqualsClass(elementSetValidFromOffset, Keyword.class);

		// Keyword Assignment Assignment Keyword Keyword [Assignment]
		text = "spielplatz 1 \"junit\" { kind ( ";
		rootNode = getRootNode(text);
		elementSetValidFromOffset = ParseTreeUtil.getElementSetValidFromOffset(rootNode, text.length());
		assertEquals("expect only 1 item", 1, elementSetValidFromOffset.size());
		assertEqualsClass(elementSetValidFromOffset, Assignment.class);

		// Keyword Assignment Assignment Keyword
		text = "spielplatz 1 \"junit\" { kind (kind1 0) kind (kind2 0) erwachsener (e1 1)  erwachsener (e2 2) familie ( asd ";
		rootNode = getRootNode(text);
		elementSetValidFromOffset = ParseTreeUtil.getElementSetValidFromOffset(rootNode, text.length());
		assertEquals("expect only 1 item", 1, elementSetValidFromOffset.size());
		assertEqualsClass(elementSetValidFromOffset, Assignment.class);
	}

	private void assertEqualsClass(Set<AbstractElement> set, Class<?>... expectedClass) {
		assertEquals("size of abstract element set must equal class array", set.size(), expectedClass.length);
		Iterator<Class<?>> classIterator = Arrays.asList(expectedClass).iterator();
		for (Iterator<AbstractElement> iterator = set.iterator(); iterator.hasNext();) {
			AbstractElement abstractElement = iterator.next();
			Class<?> nextClass = classIterator.next();
			assertTrue("class '" + nextClass + "' must be assignable from '" + abstractElement.getClass() + "'",
					nextClass.isAssignableFrom(abstractElement.getClass()));
		}
	}

}
