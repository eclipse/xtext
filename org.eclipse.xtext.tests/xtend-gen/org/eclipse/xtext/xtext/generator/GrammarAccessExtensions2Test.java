/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.common.TerminalsStandaloneSetup;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(GrammarAccessExtensions2Test.XtextInjectorProvider.class)
@SuppressWarnings("all")
public class GrammarAccessExtensions2Test {
  public static class XtextInjectorProvider implements IInjectorProvider {
    @Override
    public Injector getInjector() {
      Injector _xblockexpression = null;
      {
        TerminalsStandaloneSetup.doSetup();
        XtextRuntimeModule _xtextRuntimeModule = new XtextRuntimeModule();
        _xblockexpression = Guice.createInjector(_xtextRuntimeModule, new com.google.inject.Module() {
          @Override
          public void configure(final Binder binder) {
            AnnotatedBindingBuilder<IXtextProjectConfig> _bind = binder.<IXtextProjectConfig>bind(IXtextProjectConfig.class);
            StandardProjectConfig _standardProjectConfig = new StandardProjectConfig();
            _bind.toInstance(_standardProjectConfig);
          }
        });
      }
      return _xblockexpression;
    }
  }
  
  @Inject
  @Extension
  private ParseHelper<Grammar> _parseHelper;
  
  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;
  
  @Test
  public void testGrammarFragmentToString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl");
    _builder.newLine();
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("OpOther:");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("\'->\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'..<\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'>\' \'..\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'..\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'=>\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'>\' (=>(\'>\' \'>\') | \'>\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'<\' (=>(\'<\' \'<\') | \'<\' | \'=>\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'<>\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'?:\';");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("//OpOther:");
    _builder_1.newLine();
    _builder_1.append("//\t\'->\'");
    _builder_1.newLine();
    _builder_1.append("//\t| \'..<\'");
    _builder_1.newLine();
    _builder_1.append("//\t| \'>\' \'..\'");
    _builder_1.newLine();
    _builder_1.append("//\t| \'..\'");
    _builder_1.newLine();
    _builder_1.append("//\t| \'=>\'");
    _builder_1.newLine();
    _builder_1.append("//\t| \'>\' (=> (\'>\' \'>\') | \'>\') | \'<\' (=> (\'<\' \'<\') | \'<\' | \'=>\') | \'<>\'");
    _builder_1.newLine();
    _builder_1.append("//\t| \'?:\';");
    _builder_1.newLine();
    this.firstRuleIsConvertedTo(_builder, _builder_1);
  }
  
  private void firstRuleIsConvertedTo(final CharSequence text, final CharSequence expected) {
    try {
      final String actual = this._grammarAccessExtensions.grammarFragmentToString(IterableExtensions.<AbstractRule>head(this._parseHelper.parse(Strings.toUnixLineSeparator(text)).getRules()), "//");
      Assert.assertEquals(expected.toString().trim(), actual);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
