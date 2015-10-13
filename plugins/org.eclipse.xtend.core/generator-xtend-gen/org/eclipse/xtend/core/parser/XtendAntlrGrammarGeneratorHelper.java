/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.parser;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
  
  public String compileOptions(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("options {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("superClass=AbstractInternalAntlrParser;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
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
    String _value = it.getValue();
    boolean _contains = tokens.contains(_value);
    boolean _not = (!_contains);
    if (_not) {
      String _value_1 = it.getValue();
      tokens.add(_value_1);
    }
  }
  
  protected void _collectTokens(final AbstractRule it, final Set<String> tokens) {
    AbstractElement _alternatives = it.getAlternatives();
    this.collectTokens(_alternatives, tokens);
  }
  
  protected void _collectTokens(final EObject it, final Set<String> tokens) {
    EList<EObject> _eContents = it.eContents();
    final Procedure1<EObject> _function = new Procedure1<EObject>() {
      @Override
      public void apply(final EObject it) {
        XtendAntlrGrammarGeneratorHelper.this.collectTokens(it, tokens);
      }
    };
    IterableExtensions.<EObject>forEach(_eContents, _function);
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
