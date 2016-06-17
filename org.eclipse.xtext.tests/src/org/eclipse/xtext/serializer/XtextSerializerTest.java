/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.BaseInheritanceTestLanguageGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.InheritanceTestLanguageGrammarAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.testing.serializer.SerializerTestHelper;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextSerializerTest extends AbstractXtextTests {
	@Inject
	private SerializerTestHelper tester;

	private Grammar load(URI uri) {
		XtextResourceSet rs = new XtextResourceSet();
		return (Grammar) rs.getResource(uri, true).getContents().get(0);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
		getInjector().injectMembers(this);
	}

	@Test
	@Ignore
	public void testXtextXtextWithNM() throws Exception {
		Grammar grammar = load(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"));
		tester.assertSerializeWithNodeModel(grammar);
	}

	@Test
	@Ignore("To be done")
	public void testXtextXtextWithoutNM() throws Exception {
		Grammar grammar = load(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"));
		tester.assertSerializeWithoutNodeModel(grammar);
	}

	@Test
	public void testGroup() {
		XtextGrammarAccess grammarAccess = get(XtextGrammarAccess.class);
		String string = get(ISerializer.class).serialize(grammarAccess.getGrammarAccess().getGroup_2());
		Assert.assertEquals("(\"with\" usedGrammars+=[Grammar|GrammarID] (\",\" usedGrammars+=[Grammar|GrammarID])*)?", string);
	}
	
	@Test
	public void testFQNInSuper_01() {
		GrammarProvider grammarProvider = new GrammarProvider("org.eclipse.xtext.grammarinheritance.InheritanceTestLanguage", new Provider<XtextResourceSet>() {
			@Override
			public XtextResourceSet get() {
				return XtextSerializerTest.this.get(XtextResourceSet.class);
			}
		});
		grammarProvider.setClassLoader(getClass().getClassLoader());
		TerminalsGrammarAccess gaTerminals = new TerminalsGrammarAccess(grammarProvider);
		BaseInheritanceTestLanguageGrammarAccess gaBaseInheritanceTestLanguage = new BaseInheritanceTestLanguageGrammarAccess(grammarProvider, gaTerminals);
		InheritanceTestLanguageGrammarAccess grammarAccess = new InheritanceTestLanguageGrammarAccess(grammarProvider, gaBaseInheritanceTestLanguage, gaTerminals);
		String string = get(ISerializer.class).serialize(grammarAccess.getFQNRule().getAlternatives());
		Assert.assertEquals("ID (\".\" ID)*", string);
	}
	
	@Ignore("Serialization does not have the correct context information")
	@Test
	public void testFQNInSuper_02() {
		Grammar grammar = load(URI.createURI("classpath:/org/eclipse/xtext/grammarinheritance/InheritanceTestLanguage.xtext"));
		AbstractRule rule = GrammarUtil.findRuleForName(grammar, "FQN");
		Assert.assertNotNull(rule);
		Group group = (Group) rule.getAlternatives();
		RuleCall ruleCall = (RuleCall) group.getElements().get(0);
		TerminalRule id = (TerminalRule) ruleCall.getRule();
		Assert.assertSame(grammar, GrammarUtil.getGrammar(id));
		String string = get(ISerializer.class).serialize(rule.getAlternatives());
		Assert.assertEquals("ID (\".\" ID)*", string);
		// currently wrong result is 
		Assert.assertEquals("super::ID (\".\" super::ID)*", string);
	}
}
