/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.parser;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;

/**
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendAntlrGrammarGeneratorHelper {
  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;

  public String compileTokens(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("tokens {");
    _builder.newLine();
    {
      LinkedHashSet<String> _tokens = this.getTokens(it);
      for(final String token : _tokens) {
        _builder.append("\t");
        _builder.append("KW_");
        String _javaIdentifier = this._grammarAccessExtensions.toJavaIdentifier(token, true);
        _builder.append(_javaIdentifier, "\t");
        _builder.append(" = \'");
        String _antlrString = AntlrGrammarGenUtil.toAntlrString(token);
        _builder.append(_antlrString, "\t");
        _builder.append("\' ;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  public LinkedHashSet<String> getTokens(final Grammar it) {
    final LinkedHashSet<String> tokens = CollectionLiterals.<String>newLinkedHashSet();
    List<ParserRule> _allParserRules = GrammarUtil.allParserRules(it);
    List<EnumRule> _allEnumRules = GrammarUtil.allEnumRules(it);
    Iterable<AbstractRule> _plus = Iterables.<AbstractRule>concat(_allParserRules, _allEnumRules);
    for (final AbstractRule rule : _plus) {
      this.collectTokens(rule, tokens);
    }
    return tokens;
  }

  protected void _collectTokens(final Keyword it, final Set<String> tokens) {
    boolean _contains = tokens.contains(it.getValue());
    boolean _not = (!_contains);
    if (_not) {
      String _value = it.getValue();
      tokens.add(_value);
    }
  }

  protected void _collectTokens(final AbstractRule it, final Set<String> tokens) {
    this.collectTokens(it.getAlternatives(), tokens);
  }

  protected void _collectTokens(final EObject it, final Set<String> tokens) {
    final Consumer<EObject> _function = (EObject it_1) -> {
      this.collectTokens(it_1, tokens);
    };
    it.eContents().forEach(_function);
  }

  public void collectTokens(final EObject it, final Set<String> tokens) {
    if (it instanceof Keyword) {
      _collectTokens((Keyword)it, tokens);
      return;
    } else if (it instanceof AbstractRule) {
      _collectTokens((AbstractRule)it, tokens);
      return;
    } else if (it != null) {
      _collectTokens(it, tokens);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, tokens).toString());
    }
  }
}
