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
import org.eclipse.xtext.ui.tests.enumrules.EnumRulesUiTestLanguageRuntimeModule;
import org.eclipse.xtext.ui.tests.enumrules.EnumRulesUiTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.enumrules.ui.EnumRulesUiTestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EnumsContentAssistTest extends AbstractContentAssistProcessorTest {
	
	public ISetup getEnumsLangSetup() {
		return new EnumRulesUiTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(
						new EnumRulesUiTestLanguageRuntimeModule(),
						new EnumRulesUiTestLanguageUiModule(Activator.getInstance()),
						new SharedStateModule()));
			}
		};
	}

    public void testEnumCompletion_01() throws Exception {
    	newBuilder(getEnumsLangSetup()).assertText("existing", "generated");
    }
    
    public void testEnumCompletion_02() throws Exception {
    	newBuilder(getEnumsLangSetup()).append("exi").assertText("existing");
    }
    
    public void testEnumCompletion_03() throws Exception {
    	newBuilder(getEnumsLangSetup()).append(" ").assertText("existing", "generated");
    }
    
    public void testEnumCompletion_04() throws Exception {
    	newBuilder(getEnumsLangSetup()).append("existing").assertText("existing");
    }
    
    public void testEnumCompletion_05() throws Exception {
    	newBuilder(getEnumsLangSetup()).append("existing ").assertText("SameName", "DifferentLiteral", "overridden");
    }
    
    public void testEnumCompletion_06() throws Exception {
    	newBuilder(getEnumsLangSetup()).append("existing Same").assertText("SameName");
    }
    
    public void testEnumCompletion_07() throws Exception {
    	newBuilder(getEnumsLangSetup()).append("generated SameName").assertTextAtCursorPosition(0, "existing", "generated");
    }
    
    public void testEnumCompletion_08() throws Exception {
    	newBuilder(getEnumsLangSetup()).append(" generated SameName").assertTextAtCursorPosition(0, "existing", "generated");
    }
    
    public void testEnumCompletion_09() throws Exception {
    	newBuilder(getEnumsLangSetup()).append(" generated SameName").assertTextAtCursorPosition(2, "generated");
    }

}
