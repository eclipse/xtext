/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.unorderedGroups;

import java.io.InputStream;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarParserTest extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	@Test public void testKeyword() throws Exception {
		Keyword keyword = (Keyword) getModel("'keyword'");
		assertNotNull(keyword);
		assertEquals("keyword", keyword.getValue());
	}
	
	@Test public void testAlternatives() throws Exception {
		Alternatives alternatives = (Alternatives) getModel("'keyword'|'keyword'");
		assertNotNull(alternatives);
		assertEquals(2, alternatives.getElements().size());
	}
	
	@Test public void testGroup() throws Exception {
		Group group = (Group) getModel("'keyword' 'keyword'");
		assertNotNull(group);
		assertEquals(2, group.getElements().size());
	}
	
	@Test public void testRuleCall() throws Exception {
		RuleCall ruleCall = (RuleCall) getModel("STRING");
		assertNotNull(ruleCall);
		assertEquals("STRING", ruleCall.getRule().getName());
	}
	
	@Test public void testAction() throws Exception {
		Action action = (Action) getModel("{ExplicitType}");
		assertNotNull(action);
		assertEquals("ExplicitType", action.getType().getClassifier().getName());
	}
	
	@Test public void testAssignment() throws Exception {
		Assignment assignment = (Assignment) getModel("name=ID");
		assertNotNull(assignment);
		assertEquals("ID", ((RuleCall) assignment.getTerminal()).getRule().getName());
	}
	
	@Test public void testUnorderedGroup_01() throws Exception {
		UnorderedGroup group = (UnorderedGroup) getModel("'keyword' & 'keyword'");
		assertNotNull(group);
		assertEquals(2, group.getElements().size());
	}
	
	@Test public void testUnorderedGroup_02() throws Exception {
		UnorderedGroup group = (UnorderedGroup) getModel("'keyword' & 'keyword' & 'keyword'");
		assertNotNull(group);
		assertEquals(3, group.getElements().size());
	}
	
	@Test public void testPrecedencies_01() throws Exception {
		Alternatives alternatives = (Alternatives) getModel("'keyword' | 'keyword' & 'keyword' | 'keyword'");
		assertNotNull(alternatives);
		assertEquals(3, alternatives.getElements().size());
	}
	
	@Test public void testPrecedencies_02() throws Exception {
		UnorderedGroup group = (UnorderedGroup) getModel("('keyword' | 'keyword') & ('keyword' | 'keyword')");
		assertNotNull(group);
		assertEquals(2, group.getElements().size());
		assertTrue(group.getElements().get(0) instanceof Alternatives);
		assertTrue(group.getElements().get(1) instanceof Alternatives);
	}
	
	@Test public void testPrecedencies_03() throws Exception {
		UnorderedGroup group = (UnorderedGroup) getModel("'keyword' 'keyword' & 'keyword' 'keyword'");
		assertNotNull(group);
		assertEquals(2, group.getElements().size());
		assertTrue(group.getElements().get(0) instanceof Group);
		assertTrue(group.getElements().get(1) instanceof Group);
	}
	
	@Test public void testPrecedencies_04() throws Exception {
		Group group = (Group) getModel("'keyword' ('keyword' & 'keyword') 'keyword'");
		assertNotNull(group);
		assertEquals(3, group.getElements().size());
		assertTrue(group.getElements().get(0) instanceof Keyword);
		assertTrue(group.getElements().get(1) instanceof UnorderedGroup);
		assertTrue(group.getElements().get(2) instanceof Keyword);
	}
	
	@Test public void testPrecedencies_05() throws Exception {
		UnorderedGroup group = (UnorderedGroup) getModel("name=ID & 'keyword'");
		assertNotNull(group);
		assertEquals(2, group.getElements().size());
		assertTrue(group.getElements().get(0) instanceof Assignment);
		assertTrue(group.getElements().get(1) instanceof Keyword);
	}
	
	@Test public void testNotAllowedInAssignment() throws Exception {
		getModelAndExpect("name=(ID & STRING)", 2);
	}
	
	@Override
	protected InputStream getAsStream(String model) {
		return super.getAsStream(surroundWithGrammar(model));
	}
	
	@Override
	public AbstractElement getModel(String model) throws Exception {
		return (AbstractElement) super.getModel(model);
	}
	
	@Override
	protected AbstractElement getModel(XtextResource resource) {
		Grammar grammar = (Grammar) super.getModel(resource);
		return grammar.getRules().get(0).getAlternatives();
	}

	protected String surroundWithGrammar(String model) {
		String header = "grammar org.some.Grammar with org.eclipse.xtext.common.Terminals\n"
			+ "generate name 'http://my.uri'\n"
			+ "RootRule: ";
		String footer = ";";
		return header + model + footer;
	}

}
