/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.parser;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.xbase.idea.parser.OperatorTokenTypeProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

@Singleton
@SuppressWarnings("all")
public class DefaultOperatorTokenTypeProvider implements OperatorTokenTypeProvider {
  private final static char SINGLE_QUOTE = '\'';
  
  private final TokenSet operatorTokens;
  
  @Inject
  public DefaultOperatorTokenTypeProvider(final OperatorMapping operatorMapping, final TokenTypeProvider tokenTypeProvider, final ITokenDefProvider tokenDefProvider) {
    final HashSet<IElementType> tokenTypes = CollectionLiterals.<IElementType>newHashSet();
    Set<QualifiedName> _operators = operatorMapping.getOperators();
    final Function1<QualifiedName, String> _function = new Function1<QualifiedName, String>() {
      @Override
      public String apply(final QualifiedName it) {
        return it.toString();
      }
    };
    Iterable<String> _map = IterableExtensions.<QualifiedName, String>map(_operators, _function);
    final Set<String> operators = IterableExtensions.<String>toSet(_map);
    final Map<Integer, String> tokenDefMap = tokenDefProvider.getTokenDefMap();
    Set<Integer> _keySet = tokenDefMap.keySet();
    for (final Integer antlrTokenType : _keySet) {
      {
        final String value = tokenDefMap.get(antlrTokenType);
        char _charAt = value.charAt(0);
        boolean _equals = (_charAt == DefaultOperatorTokenTypeProvider.SINGLE_QUOTE);
        if (_equals) {
          int _length = value.length();
          int _minus = (_length - 1);
          final String keyword = value.substring(1, _minus);
          final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
            @Override
            public Boolean apply(final String it) {
              return Boolean.valueOf(it.contains(keyword));
            }
          };
          boolean _exists = IterableExtensions.<String>exists(operators, _function_1);
          if (_exists) {
            IElementType _iElementType = tokenTypeProvider.getIElementType((antlrTokenType).intValue());
            tokenTypes.add(_iElementType);
          }
        }
      }
    }
    TokenSet _create = TokenSet.create(((IElementType[])Conversions.unwrapArray(tokenTypes, IElementType.class)));
    this.operatorTokens = _create;
  }
  
  @Override
  public TokenSet getOperatorTokens() {
    return this.operatorTokens;
  }
}
