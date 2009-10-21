/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.antlr;

import java.util.Collection;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.XtextGrammarUiTestLanguageStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.ui.common.editor.contentassist.DatatypeRuleTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.common.editor.contentassist.DatatypeRuleTestLanguageUiModule;
import org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.DatatypeRuleTestLanguageParser;
import org.eclipse.xtext.ui.common.editor.contentassist.services.DatatypeRuleTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.common.service.UIPluginModule;
import org.eclipse.xtext.ui.common.tests.Activator;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug281198ParserTest extends AbstractXtextTests {

	protected DatatypeRuleTestLanguageGrammarAccess grammarAccess;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new DatatypeRuleTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(
						new DatatypeRuleTestLanguageUiModule(),
						new UIPluginModule(Activator.getInstance()));
			}
		});
		grammarAccess = get(DatatypeRuleTestLanguageGrammarAccess.class);
	}

	@Override
	protected void tearDown() throws Exception {
		grammarAccess = null;
		super.tearDown();
	}
	
	public void testBug() {
		String input ="Types\n" +
				"Type StringType;\n" +
				"Composite error base";
		Set<AbstractElement> expected = Sets.<AbstractElement>newHashSet(
				grammarAccess.getTypeIdAccess().getIDTerminalRuleCall_0()
		);
		assertFollowers(input, expected);
	}

	protected Collection<FollowElement> getFollowSet(String input) {
		AbstractContentAssistParser parser = get(DatatypeRuleTestLanguageParser.class);
		return parser.getFollowElements(input);
	}
	
	private void assertFollowers(String input, Set<AbstractElement> expected) {
		Collection<FollowElement> followSet = getFollowSet(input);
//		Collection<FollowElement> followList = com.google.common.collect.Lists.newArrayList(getFollowSet(input));
		assertEquals(expected.size(), followSet.size());
		Set<AbstractElement> grammarElements = computeSearchElements(followSet);
		assertEquals(grammarElements.toString(), expected, grammarElements);
	}

	private Set<AbstractElement> computeSearchElements(Collection<FollowElement> followSet) {
		return  Sets.newHashSet(
				Iterables.transform(followSet, new Function<FollowElement, AbstractElement>(){
					public AbstractElement apply(FollowElement from) {
						return from.getGrammarElement();
					}
				}));
	}
}
