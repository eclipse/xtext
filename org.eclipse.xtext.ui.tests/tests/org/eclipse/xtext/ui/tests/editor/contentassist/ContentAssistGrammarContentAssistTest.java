/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.tests.testlanguages.ui.tests.ContentAssistTestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(ContentAssistTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class ContentAssistGrammarContentAssistTest extends AbstractContentAssistTest {
	
	@Test public void testCompleteAbstractRuleCall() throws Exception {
		newBuilder()
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
    @Test public void testCompleteAbstractRuleCallWithSpace() throws Exception {
        newBuilder()
        .appendNl("abstract rules")
        .appendNl("R1 ();")
        .append("R2 rule : ").assertText(
                        "R1",
                        "R2"
        );
    }

}
