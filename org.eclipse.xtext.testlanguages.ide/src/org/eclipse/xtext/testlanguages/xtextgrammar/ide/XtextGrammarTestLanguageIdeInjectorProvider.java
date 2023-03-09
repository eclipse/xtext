/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.xtextgrammar.ide;

import org.eclipse.xtext.testlanguages.xtextgrammar.XtextGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.xtextgrammar.tests.XtextGrammarTestLanguageInjectorProvider;
import org.eclipse.xtext.util.Modules2;

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
				return Guice.createInjector(Modules2.mixin(createRuntimeModule(), createIdeModule()));
			}

			private XtextGrammarTestLanguageIdeModule createIdeModule() {
				return new XtextGrammarTestLanguageIdeModule();
			}
		}.createInjectorAndDoEMFRegistration();
	}

}
