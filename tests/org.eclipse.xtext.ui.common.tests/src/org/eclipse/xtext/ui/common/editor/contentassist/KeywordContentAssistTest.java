/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.parser.keywords.KeywordsUiTestLanguageStandaloneSetup;
import org.eclipse.xtext.parser.keywords.KeywordsUiTestLanguageUiModule;
import org.eclipse.xtext.ui.common.service.UIPluginModule;
import org.eclipse.xtext.ui.common.tests.Activator;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class KeywordContentAssistTest extends AbstractContentAssistProcessorTest {

	public ISetup getKeywordsLangSetup() {
		return new KeywordsUiTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new KeywordsUiTestLanguageUiModule(), new UIPluginModule(Activator.getInstance()));
			}
		};
	}
	
	public void testKeywordWithBackslashes() throws Exception {
		newBuilder(getKeywordsLangSetup()).assertText(
				"foo\\bar", "foo\\", "\\bar", "\\",
				"\"a\"", "'b'", "'c'", "\"d\"");
	}
}
