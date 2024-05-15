/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.antlr;

import java.util.Collection;

import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguageRuntimeModule;
import org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.Bug303200TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug303200TestLanguageUiModule;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug303200Test extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new Bug303200TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new Bug303200TestLanguageRuntimeModule(),
						new Bug303200TestLanguageUiModule(TestsActivator.getInstance()),
						new SharedStateModule()));
			}
		});
	}
	
	@Test public void testBug303200_01() throws Exception {
		Bug303200TestLanguageParser parser = get(Bug303200TestLanguageParser.class);
		Collection<FollowElement> followElements = parser.getFollowElements("function f() {", false);
		assertEquals(4, followElements.size());
	}
	
	@Test public void testBug303200_02() throws Exception {
		Bug303200TestLanguageParser parser = get(Bug303200TestLanguageParser.class);
		Collection<FollowElement> elements = parser.getFollowElements("function f() {", false);
		for (FollowElement element: elements) {
			recursiveTestFollowElements(parser, element);
		}
	}
	
	@Test public void testBug303200_03() throws Exception {
		Bug303200TestLanguageParser parser = get(Bug303200TestLanguageParser.class);
		Collection<FollowElement> followElements = Lists.newArrayList(parser.getFollowElements("function f() {} function f() {", false));
		assertEquals(4, followElements.size());
	}
	
	protected void recursiveTestFollowElements(Bug303200TestLanguageParser parser, FollowElement element) {
		if (element.getLookAhead() > 1) {
			Collection<FollowElement> elements = parser.getFollowElements(element);
			for(FollowElement followElement: elements) {
				assertTrue(followElement.getLookAhead() < element.getLookAhead());
				recursiveTestFollowElements(parser, followElement);
			}
		}
	}
}
