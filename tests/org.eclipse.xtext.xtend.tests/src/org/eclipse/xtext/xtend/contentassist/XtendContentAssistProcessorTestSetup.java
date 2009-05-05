/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.XtextGrammarTestLanguageRuntimeModule;
import org.eclipse.xtext.XtextGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.XtextGrammarTestLanguageUiModule;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.XtextUiModule;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageRuntimeModule;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageStandaloneSetup;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageUiModule;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguageRuntimeModule;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguageStandaloneSetup;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageUiModule;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistProcessorTestSetup;
import org.eclipse.xtext.ui.common.service.UIPluginModule;
import org.eclipse.xtext.xtend.tests.Activator;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendContentAssistProcessorTestSetup implements IContentAssistProcessorTestSetup {

	public ISetup getRefGrammarSetup() {
		return new ReferenceGrammarTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ReferenceGrammarTestLanguageRuntimeModule(), new ReferenceGrammarTestLanguageUiModule(),
						new UIPluginModule(Activator.getDefault()));
			}
		};
	}

	public ISetup getXtextGrammarTestSetup() {
		return new XtextGrammarTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtextGrammarTestLanguageRuntimeModule(), new XtextGrammarTestLanguageUiModule(),
						new UIPluginModule(Activator.getDefault()));
			}
		};
	}

	public ISetup getXtextSetup() {
		return new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtextRuntimeModule(), new XtextUiModule(),
						new UIPluginModule(Activator.getDefault()));
			}
		};
	}

	public ISetup getContentAssistGrammarSetup() {
		return new ContentAssistTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ContentAssistTestLanguageRuntimeModule(), new ContentAssistTestLanguageUiModule(),
						new UIPluginModule(Activator.getDefault()));
			}
		};
	}

	public ISetup getKeywordsLangSetup() {
		return new KeywordsTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new KeywordsTestLanguageRuntimeModule(), new KeywordsTestLanguageUiModule(),
						new UIPluginModule(Activator.getDefault()));
			}
		};
	}

	public ISetup getEnumsLangSetup() {
		return new EnumRulesTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new EnumRulesTestLanguageRuntimeModule(), new EnumRulesTestLanguageUiModule(),
						new UIPluginModule(Activator.getDefault()));
			}
		};
	}


}
