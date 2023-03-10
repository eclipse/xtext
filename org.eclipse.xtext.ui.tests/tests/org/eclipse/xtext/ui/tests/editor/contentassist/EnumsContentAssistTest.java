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
import org.eclipse.xtext.ui.tests.enumrules.ui.tests.EnumRulesUiTestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(EnumRulesUiTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class EnumsContentAssistTest extends AbstractContentAssistTest {

    @Test public void testEnumCompletion_01() throws Exception {
    	newBuilder().assertText("existing", "generated");
    }
    
    @Test public void testEnumCompletion_02() throws Exception {
    	newBuilder().append("exi").assertText("existing");
    }
    
    @Test public void testEnumCompletion_03() throws Exception {
    	newBuilder().append(" ").assertText("existing", "generated");
    }
    
    @Test public void testEnumCompletion_04() throws Exception {
    	newBuilder().append("existing").assertText("existing");
    }
    
    @Test public void testEnumCompletion_05() throws Exception {
    	newBuilder().append("existing ").assertText("SameName", "DifferentLiteral", "overridden");
    }
    
    @Test public void testEnumCompletion_06() throws Exception {
    	newBuilder().append("existing Same").assertText("SameName");
    }
    
    @Test public void testEnumCompletion_07() throws Exception {
    	newBuilder().append("generated SameName").assertTextAtCursorPosition(0, "existing", "generated");
    }
    
    @Test public void testEnumCompletion_08() throws Exception {
    	newBuilder().append(" generated SameName").assertTextAtCursorPosition(0, "existing", "generated");
    }
    
    @Test public void testEnumCompletion_09() throws Exception {
    	newBuilder().append(" generated SameName").assertTextAtCursorPosition(2, "generated");
    }

}
