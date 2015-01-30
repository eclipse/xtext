/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.parser.antlr;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.util.List;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.8
 */
@SuppressWarnings("all")
public abstract class AbstractAntlrXtendGeneratorFragment extends AbstractAntlrGeneratorFragment {
  protected Module createModule(final Grammar grammar) {
    final Module _function = new Module() {
      @Override
      public void configure(final Binder binder) {
        AnnotatedBindingBuilder<Grammar> _bind = binder.<Grammar>bind(Grammar.class);
        _bind.toInstance(grammar);
        AnnotatedBindingBuilder<Naming> _bind_1 = binder.<Naming>bind(Naming.class);
        Naming _naming = AbstractAntlrXtendGeneratorFragment.this.getNaming();
        _bind_1.toInstance(_naming);
        AnnotatedBindingBuilder<IGrammarAccess> _bind_2 = binder.<IGrammarAccess>bind(IGrammarAccess.class);
        Xtend2GeneratorFragment.GenericGrammarAccess _genericGrammarAccess = new Xtend2GeneratorFragment.GenericGrammarAccess(grammar);
        _bind_2.toInstance(_genericGrammarAccess);
        AbstractAntlrXtendGeneratorFragment.this.addLocalBindings(binder);
      }
    };
    return _function;
  }
  
  protected void addLocalBindings(final Binder binder) {
  }
  
  @Override
  public void generate(final Grammar grammar, final XpandExecutionContext ctx) {
    this.checkGrammar(grammar);
    Module _createModule = this.createModule(grammar);
    Injector _createInjector = Guice.createInjector(_createModule);
    _createInjector.injectMembers(this);
    List<Object> _parameters = this.getParameters(grammar);
    Xtend2ExecutionContext _xtend2ExecutionContext = new Xtend2ExecutionContext(ctx);
    this.generate(grammar, _parameters, _xtend2ExecutionContext);
  }
  
  protected abstract void generate(final Grammar grammar, final List<Object> parameters, final Xtend2ExecutionContext ctx);
  
  @Override
  public void addToPluginXmlRt(final Grammar grammar, final XpandExecutionContext ctx) {
    List<Object> _parameters = this.getParameters(grammar);
    Xtend2ExecutionContext _xtend2ExecutionContext = new Xtend2ExecutionContext(ctx);
    this.addToPluginXmlRt(grammar, _parameters, _xtend2ExecutionContext);
  }
  
  protected abstract void addToPluginXmlRt(final Grammar grammar, final List<Object> parameters, final Xtend2ExecutionContext ctx);
  
  @Override
  public void addToPluginXmlUi(final Grammar grammar, final XpandExecutionContext ctx) {
    List<Object> _parameters = this.getParameters(grammar);
    Xtend2ExecutionContext _xtend2ExecutionContext = new Xtend2ExecutionContext(ctx);
    this.addToPluginXmlUi(grammar, _parameters, _xtend2ExecutionContext);
  }
  
  protected abstract void addToPluginXmlUi(final Grammar grammar, final List<Object> parameters, final Xtend2ExecutionContext ctx);
  
  @Override
  public void addToPluginXmlTests(final Grammar grammar, final XpandExecutionContext ctx) {
    List<Object> _parameters = this.getParameters(grammar);
    Xtend2ExecutionContext _xtend2ExecutionContext = new Xtend2ExecutionContext(ctx);
    this.addToPluginXmlTests(grammar, _parameters, _xtend2ExecutionContext);
  }
  
  protected abstract void addToPluginXmlTests(final Grammar grammar, final List<Object> parameters, final Xtend2ExecutionContext ctx);
  
  @Override
  public void addToStandaloneSetup(final Grammar grammar, final XpandExecutionContext ctx) {
    List<Object> _parameters = this.getParameters(grammar);
    Xtend2ExecutionContext _xtend2ExecutionContext = new Xtend2ExecutionContext(ctx);
    this.addToStandaloneSetup(grammar, _parameters, _xtend2ExecutionContext);
  }
  
  protected abstract void addToStandaloneSetup(final Grammar grammar, final List<Object> parameters, final Xtend2ExecutionContext ctx);
}
