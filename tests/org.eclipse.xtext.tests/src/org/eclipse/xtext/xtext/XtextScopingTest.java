/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.ICrossReferenceSerializer;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextScopingTest extends AbstractXtextTests {
	
	private Grammar grammar;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass().getClassLoader());
		Resource resource = resourceSet.getResource(
				URI.createURI("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xtext"), true);
		grammar = (Grammar) resource.getContents().get(0);
	}
	
	@Override
	public void tearDown() throws Exception {
		grammar = null;
		super.tearDown();
	}
	
	@Test public void testSetup() {
		assertNotNull(grammar);
	}

	@Test public void testScope_01() {
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "AbstractCallOverridenParserRule");
		assertNotNull(rule);
		Group group = (Group) rule.getAlternatives();
		Assignment ass = (Assignment) group.getElements().get(1);
		assertNotNull(ass);
		RuleCall call = (RuleCall) ass.getTerminal();
		AbstractRule calledRule = call.getRule();
		assertNotNull(calledRule);
		XtextGrammarAccess ga = (XtextGrammarAccess) get(IGrammarAccess.class);
		String text = get(ICrossReferenceSerializer.class).serializeCrossRef(call, ga.getRuleCallAccess().getRuleAbstractRuleCrossReference_0_0(), calledRule, null);
		assertNotNull(text);
		assertEquals(calledRule.getName(), text);
	}
}
