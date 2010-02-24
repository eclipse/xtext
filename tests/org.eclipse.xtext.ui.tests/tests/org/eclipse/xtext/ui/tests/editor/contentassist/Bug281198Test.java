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
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.DatatypeRuleTestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug281198Test extends AbstractContentAssistProcessorTest {

	public ISetup getDatatypeRuleTestLanguageSetup() {
		return new DatatypeRuleTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new DatatypeRuleTestLanguageRuntimeModule() ,new DatatypeRuleTestLanguageUiModule(Activator
						.getInstance()), new SharedStateModule()));
			}
		};
	}

	public void testBug281198_01() throws Exception {
		newBuilder(getDatatypeRuleTestLanguageSetup()).append(
				"Types\n" + "Type StringType;\n" + "Composite error base ").assertText("StringType", "error");
	}
}
