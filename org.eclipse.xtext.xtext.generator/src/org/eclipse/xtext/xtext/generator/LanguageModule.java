/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.xtext.RuleNames;

import com.google.inject.Binder;

/**
 * Language-specific Guice module that is used in a child injector of the global
 * injector derived from {@link DefaultGeneratorModule}.
 */
class LanguageModule extends AbstractGenericModule {
	private final XtextGeneratorLanguage language;

	public void configureLanguage(Binder binder) {
		binder.bind(IXtextGeneratorLanguage.class).toProvider(() -> language);
	}

	public void configureGrammar(Binder binder) {
		binder.bind(Grammar.class).toProvider(() -> language.getGrammar());
	}

	public void configureRuleNames(Binder binder) {
		binder.bind(RuleNames.class).toProvider(() -> language.getRuleNames());
	}

	public void configureAdditionalBindings(Binder binder) {
		binder.install(language.getGuiceModule());
	}

	public LanguageModule(XtextGeneratorLanguage language) {
		this.language = language;
	}
}
