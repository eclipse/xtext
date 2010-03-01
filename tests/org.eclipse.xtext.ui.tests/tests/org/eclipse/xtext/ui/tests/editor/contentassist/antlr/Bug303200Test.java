/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.antlr;

import java.util.Collection;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguageRuntimeModule;
import org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug303200TestLanguageUiModule;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.Bug303200TestLanguageParser;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug303200Test extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new Bug303200TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new Bug303200TestLanguageRuntimeModule(),
						new Bug303200TestLanguageUiModule(Activator.getInstance()),
						new SharedStateModule()));
			}
		});
	}
	
	public void testBug303200_01() throws Exception {
		Bug303200TestLanguageParser parser = get(Bug303200TestLanguageParser.class);
		parser.getFollowElements("function f() {");
		// don't throw NPE
	}
	
	
	public void testBug303200_02() throws Exception {
		Bug303200TestLanguageParser parser = get(Bug303200TestLanguageParser.class);
		Collection<FollowElement> elements = parser.getFollowElements("function f() {");
		for (FollowElement element: elements) {
			recursiveTestFollowElements(parser, element);
		}
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
