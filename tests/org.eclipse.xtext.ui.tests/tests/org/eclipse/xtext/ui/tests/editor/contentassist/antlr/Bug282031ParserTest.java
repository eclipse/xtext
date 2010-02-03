/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.antlr;

import java.util.Collection;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.ui.UIPluginModule;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.LookAheadContentAssistTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentassist.antlr.LookAheadContentAssistTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.LookAheadContentAssistTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.LookAheadContentAssistTestLanguageUiModule;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug282031ParserTest extends AbstractXtextTests {

	protected LookAheadContentAssistTestLanguageGrammarAccess grammarAccess;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new LookAheadContentAssistTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(
						new LookAheadContentAssistTestLanguageUiModule(),
						new UIPluginModule(Activator.getInstance()));
			}
		});
		grammarAccess = get(LookAheadContentAssistTestLanguageGrammarAccess.class);
	}

	@Override
	protected void tearDown() throws Exception {
		grammarAccess = null;
		super.tearDown();
	}
	
	public void testBug() {
		String input ="( value1 ";
		Set<AbstractElement> expected = Sets.<AbstractElement>newHashSet(
				grammarAccess.getPairAccess().getEqualsSignKeyword_1(),
				grammarAccess.getModelAccess().getAttributeAssignment_0_1()
		);
		assertFollowers(input, expected);
	}

	protected Collection<FollowElement> getFollowSet(String input) {
		AbstractContentAssistParser parser = get(LookAheadContentAssistTestLanguageParser.class);
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
