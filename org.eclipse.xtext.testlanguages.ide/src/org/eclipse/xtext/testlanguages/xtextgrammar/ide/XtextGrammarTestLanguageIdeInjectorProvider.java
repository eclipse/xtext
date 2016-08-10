/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.xtextgrammar.ide;

import org.eclipse.xtext.testlanguages.xtextgrammar.XtextGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.xtextgrammar.tests.XtextGrammarTestLanguageInjectorProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextGrammarTestLanguageIdeInjectorProvider extends XtextGrammarTestLanguageInjectorProvider {

	@Override
	protected Injector internalCreateInjector() {
		return new XtextGrammarTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(createRuntimeModule(), createIdeModule());
			}

			private XtextGrammarTestLanguageIdeModule createIdeModule() {
				return new XtextGrammarTestLanguageIdeModule();
			}
		}.createInjectorAndDoEMFRegistration();
	}

}
