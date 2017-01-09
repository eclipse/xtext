/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Binder;
import com.google.inject.Provider;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.xtext.RuleNames;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;

@FinalFieldsConstructor
@SuppressWarnings("all")
class LanguageModule extends AbstractGenericModule {
  private final XtextGeneratorLanguage language;
  
  public void configureLanguage(final Binder binder) {
    final Provider<IXtextGeneratorLanguage> _function = () -> {
      return this.language;
    };
    binder.<IXtextGeneratorLanguage>bind(IXtextGeneratorLanguage.class).toProvider(_function);
  }
  
  public void configureGrammar(final Binder binder) {
    final Provider<Grammar> _function = () -> {
      return this.language.getGrammar();
    };
    binder.<Grammar>bind(Grammar.class).toProvider(_function);
  }
  
  public void configureRuleNames(final Binder binder) {
    final Provider<RuleNames> _function = () -> {
      return this.language.getRuleNames();
    };
    binder.<RuleNames>bind(RuleNames.class).toProvider(_function);
  }
  
  public void configureAdditionalBindings(final Binder binder) {
    binder.install(this.language.getGuiceModule());
  }
  
  public LanguageModule(final XtextGeneratorLanguage language) {
    super();
    this.language = language;
  }
}
