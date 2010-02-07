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
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarParserTest extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	public void testKeyword() throws Exception {
		Keyword keyword = (Keyword) getModel("'keyword'");
		assertNotNull(keyword);
		assertEquals("keyword", keyword.getValue());
	}
	
	public void testAlternatives() throws Exception {
		Alternatives alternatives = (Alternatives) getModel("'keyword'|'keyword'");
		assertNotNull(alternatives);
		assertEquals(2, alternatives.getGroups().size());
	}
	
	public void testGroup() throws Exception {
		Group group = (Group) getModel("'keyword' 'keyword'");
		assertNotNull(group);
		assertEquals(2, group.getTokens().size());
	}
	
	public void testRuleCall() throws Exception {
		RuleCall ruleCall = (RuleCall) getModel("STRING");
		assertNotNull(ruleCall);
		assertEquals("STRING", ruleCall.getRule().getName());
	}
	
	public void testAction() throws Exception {
		Action action = (Action) getModel("{ExplicitType}");
		assertNotNull(action);
		assertEquals("ExplicitType", action.getType().getClassifier().getName());
	}
	
	public void testAssignment() throws Exception {
		Assignment assignment = (Assignment) getModel("name=ID");
		assertNotNull(assignment);
		assertEquals("ID", ((RuleCall) assignment.getTerminal()).getRule().getName());
	}
	
	public void testUnorderedGroup_01() throws Exception {
		UnorderedGroup group = (UnorderedGroup) getModel("'keyword' & 'keyword'");
		assertNotNull(group);
		assertEquals(2, group.getElements().size());
	}
	
	public void testUnorderedGroup_02() throws Exception {
		UnorderedGroup group = (UnorderedGroup) getModel("'keyword' & 'keyword' & 'keyword'");
		assertNotNull(group);
		assertEquals(3, group.getElements().size());
	}
	
	public void testPrecedencies_01() throws Exception {
		Alternatives alternatives = (Alternatives) getModel("'keyword' | 'keyword' & 'keyword' | 'keyword'");
		assertNotNull(alternatives);
		assertEquals(3, alternatives.getGroups().size());
	}
	
	public void testPrecedencies_02() throws Exception {
		UnorderedGroup group = (UnorderedGroup) getModel("('keyword' | 'keyword') & ('keyword' | 'keyword')");
		assertNotNull(group);
		assertEquals(2, group.getElements().size());
		assertTrue(group.getElements().get(0) instanceof Alternatives);
		assertTrue(group.getElements().get(1) instanceof Alternatives);
	}
	
	public void testPrecedencies_03() throws Exception {
		UnorderedGroup group = (UnorderedGroup) getModel("'keyword' 'keyword' & 'keyword' 'keyword'");
		assertNotNull(group);
		assertEquals(2, group.getElements().size());
		assertTrue(group.getElements().get(0) instanceof Group);
		assertTrue(group.getElements().get(1) instanceof Group);
	}
	
	public void testPrecedencies_04() throws Exception {
		Group group = (Group) getModel("'keyword' ('keyword' & 'keyword') 'keyword'");
		assertNotNull(group);
		assertEquals(3, group.getTokens().size());
		assertTrue(group.getTokens().get(0) instanceof Keyword);
		assertTrue(group.getTokens().get(1) instanceof UnorderedGroup);
		assertTrue(group.getTokens().get(2) instanceof Keyword);
	}
	
	public void testPrecedencies_05() throws Exception {
		UnorderedGroup group = (UnorderedGroup) getModel("name=ID & 'keyword'");
		assertNotNull(group);
		assertEquals(2, group.getElements().size());
		assertTrue(group.getElements().get(0) instanceof Assignment);
		assertTrue(group.getElements().get(1) instanceof Keyword);
	}
	
	public void testNotAllowedInAssignment() throws Exception {
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
