/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.testlanguages.ContentAssistTestLanguageRuntimeModule;
import org.eclipse.xtext.ui.tests.testlanguages.ContentAssistTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.testlanguages.ui.ContentAssistTestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistGrammarContentAssistTest extends AbstractContentAssistProcessorTest {

	public ISetup getContentAssistGrammarSetup() {
		return new ContentAssistTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new ContentAssistTestLanguageRuntimeModule(), new ContentAssistTestLanguageUiModule(Activator.getInstance()),new SharedStateModule()));
			}
		};
	}
	
	public void testCompleteAbstractRuleCall() throws Exception {
		newBuilder(getContentAssistGrammarSetup())
			.appendNl("abstract rules")
			.appendNl("R1 ();")
			.append("R2 rule :").assertText(
					"R1",
					"R2",
					":" // current is always a suggestion
			);
	}
	
	/**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269593
     */
    public void testCompleteAbstractRuleCallWithSpace() throws Exception {
        newBuilder(getContentAssistGrammarSetup())
        .appendNl("abstract rules")
        .appendNl("R1 ();")
        .append("R2 rule : ").assertText(
                        "R1",
                        "R2"
        );
    }
}
