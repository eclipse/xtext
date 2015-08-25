package org.eclipse.xtext.xtext.generator;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class LanguageModule extends AbstractGenericModule {
  private final LanguageConfig2 language;
  
  public void configureLanguage(final Binder binder) {
    AnnotatedBindingBuilder<LanguageConfig2> _bind = binder.<LanguageConfig2>bind(LanguageConfig2.class);
    _bind.toInstance(this.language);
  }
  
  public void configureNaming(final Binder binder) {
    AnnotatedBindingBuilder<XtextGeneratorNaming> _bind = binder.<XtextGeneratorNaming>bind(XtextGeneratorNaming.class);
    XtextGeneratorNaming _naming = this.language.getNaming();
    _bind.toInstance(_naming);
  }
  
  public ScopedBindingBuilder configureGrammar(final Binder binder) {
    AnnotatedBindingBuilder<Grammar> _bind = binder.<Grammar>bind(Grammar.class);
    final Provider<Grammar> _function = new Provider<Grammar>() {
      @Override
      public Grammar get() {
        return LanguageModule.this.language.getGrammar();
      }
    };
    return _bind.toProvider(_function);
  }
  
  public ScopedBindingBuilder configureRuleNames(final Binder binder) {
    AnnotatedBindingBuilder<RuleNames> _bind = binder.<RuleNames>bind(RuleNames.class);
    final Provider<RuleNames> _function = new Provider<RuleNames>() {
      @Override
      public RuleNames get() {
        return LanguageModule.this.language.getRuleNames();
      }
    };
    return _bind.toProvider(_function);
  }
  
  public void configureAdditionalBindings(final Binder binder) {
    Module _guiceModule = this.language.getGuiceModule();
    binder.install(_guiceModule);
  }
  
  public LanguageModule(final LanguageConfig2 language) {
    super();
    this.language = language;
  }
}
