/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.parser;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class TokenNames {
  @Inject
  @Extension
  private GrammarAccess _grammarAccess;
  
  protected List<String> _getTokens(final Grammar it, final Set<String> known) {
    ArrayList<String> _xblockexpression = null;
    {
      final ArrayList<String> tokens = CollectionLiterals.<String>newArrayList();
      List<ParserRule> _allParserRules = GrammarUtil.allParserRules(it);
      List<EnumRule> _allEnumRules = GrammarUtil.allEnumRules(it);
      Iterable<AbstractRule> _plus = Iterables.<AbstractRule>concat(_allParserRules, _allEnumRules);
      for (final AbstractRule rule : _plus) {
        {
          final List<String> ruleTokens = this.getTokens(rule, known);
          Iterables.<String>addAll(tokens, ruleTokens);
        }
      }
      _xblockexpression = tokens;
    }
    return _xblockexpression;
  }
  
  protected List<String> _getTokens(final AbstractRule it, final Set<String> known) {
    AbstractElement _alternatives = it.getAlternatives();
    return this.getTokens(_alternatives, known);
  }
  
  protected List<String> _getTokens(final EObject it, final Set<String> known) {
    EList<EObject> _eContents = it.eContents();
    final Function1<EObject, List<String>> _function = new Function1<EObject, List<String>>() {
      @Override
      public List<String> apply(final EObject it) {
        return TokenNames.this.getTokens(it, known);
      }
    };
    List<List<String>> _map = ListExtensions.<EObject, List<String>>map(_eContents, _function);
    Iterable<String> _flatten = Iterables.<String>concat(_map);
    return IterableExtensions.<String>toList(_flatten);
  }
  
  protected List<String> _getTokens(final Keyword it, final Set<String> known) {
    List<String> _xifexpression = null;
    boolean _and = false;
    String _value = it.getValue();
    boolean _contains = known.contains(_value);
    boolean _not = (!_contains);
    if (!_not) {
      _and = false;
    } else {
      String _value_1 = it.getValue();
      boolean _add = known.add(_value_1);
      _and = _add;
    }
    if (_and) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("KW_");
      String _value_2 = it.getValue();
      String _javaIdentifier = this._grammarAccess.toJavaIdentifier(_value_2, true);
      _builder.append(_javaIdentifier, "");
      _builder.append(" = \'");
      String _value_3 = it.getValue();
      String _antlrString = AntlrGrammarGenUtil.toAntlrString(_value_3);
      _builder.append(_antlrString, "");
      _builder.append("\'");
      _xifexpression = CollectionLiterals.<String>newArrayList(_builder.toString());
    } else {
      _xifexpression = CollectionLiterals.<String>emptyList();
    }
    return _xifexpression;
  }
  
  public List<String> getTokens(final EObject it, final Set<String> known) {
    if (it instanceof Keyword) {
      return _getTokens((Keyword)it, known);
    } else if (it instanceof AbstractRule) {
      return _getTokens((AbstractRule)it, known);
    } else if (it instanceof Grammar) {
      return _getTokens((Grammar)it, known);
    } else if (it != null) {
      return _getTokens(it, known);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, known).toString());
    }
  }
}
