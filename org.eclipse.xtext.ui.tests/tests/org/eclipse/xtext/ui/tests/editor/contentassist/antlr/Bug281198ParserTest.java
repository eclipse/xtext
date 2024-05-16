/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.antlr;

import java.util.Collection;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.editor.contentassist.DatatypeRuleTestLanguageRuntimeModule;
import org.eclipse.xtext.ui.tests.editor.contentassist.DatatypeRuleTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.DatatypeRuleTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.DatatypeRuleTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.DatatypeRuleTestLanguageUiModule;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

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
	public void setUp() throws Exception {
		super.setUp();
		with(new DatatypeRuleTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new DatatypeRuleTestLanguageRuntimeModule(),
						new DatatypeRuleTestLanguageUiModule(TestsActivator.getInstance()),
						new SharedStateModule()));
			}
		});
		grammarAccess = get(DatatypeRuleTestLanguageGrammarAccess.class);
	}

	@Override
	public void tearDown() throws Exception {
		grammarAccess = null;
		super.tearDown();
	}
	
	@Test public void testBug() {
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
		return parser.getFollowElements(input, false);
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
					@Override
					public AbstractElement apply(FollowElement from) {
						return from.getGrammarElement();
					}
				}));
	}
}
