/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.antlr;

import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug348427TestLanguageGrammarAccess;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class GrammarCallHierarchyHelperTest extends AbstractXtextTests {
	
	@Inject Bug348427TestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug348427TestLanguageStandaloneSetup.class);
		injectMembers(this);
	}
	
	@Test public void testCallHierarchy() {
		Assert.assertFalse(newHelper().doSwitch(grammarAccess.getScenario1_1Rule()));
		Assert.assertTrue(newHelper().doSwitch(grammarAccess.getScenario1_2Rule()));
		Assert.assertTrue(newHelper().doSwitch(grammarAccess.getScenario1_3Rule()));
		Assert.assertFalse(newHelper().doSwitch(grammarAccess.getScenario1_4Rule()));
	}

	private Switch<Boolean> newHelper() {
		AbstractElement previous = grammarAccess.getChild1_1Access().getEndKeyword_5();
		AbstractElement next = grammarAccess.getChild1_3Access().getNameIDTerminalRuleCall_0_0();
		Switch<Boolean> helper = createHelper(previous, "end", next);
		return helper;
	}

	protected Switch<Boolean> createHelper(AbstractElement previous, String previousText, AbstractElement next) {
		return new ParserBasedContentAssistContextFactory.CallHierarchyHelper(next, previousText, previous);
	}
	
}
