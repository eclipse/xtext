/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.parser;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.parser.PsiXtextTokenStream;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.TokenSourceProvider;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractXtextPsiParser implements PsiParser {
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private ITokenDefProvider tokenDefProvider;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private TokenTypeProvider tokenTypeProvider;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private TokenSourceProvider tokenSourceProvider;
  
  @Override
  public ASTNode parse(final IElementType root, final PsiBuilder builder) {
    try {
      ASTNode _xblockexpression = null;
      {
        PsiXtextTokenStream _createTokenStream = this.createTokenStream(builder);
        AbstractPsiAntlrParser _createParser = this.createParser(builder, _createTokenStream);
        final Procedure1<AbstractPsiAntlrParser> _function = new Procedure1<AbstractPsiAntlrParser>() {
          @Override
          public void apply(final AbstractPsiAntlrParser it) {
            Map<Integer, String> _tokenDefMap = AbstractXtextPsiParser.this.tokenDefProvider.getTokenDefMap();
            it.setTokenTypeMap(_tokenDefMap);
          }
        };
        final AbstractPsiAntlrParser parser = ObjectExtensions.<AbstractPsiAntlrParser>operator_doubleArrow(_createParser, _function);
        PsiBuilder.Marker rootMarker = builder.mark();
        final String entryRuleName = this.getEntryRuleName(root);
        boolean _notEquals = (!Objects.equal(entryRuleName, null));
        if (_notEquals) {
          parser.parse(entryRuleName);
        } else {
          parser.parse();
        }
        rootMarker.done(root);
        _xblockexpression = builder.getTreeBuilt();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String getEntryRuleName(final IElementType type) {
    String _xifexpression = null;
    if ((type instanceof IGrammarAwareElementType)) {
      String _switchResult = null;
      EObject _grammarElement = ((IGrammarAwareElementType)type).getGrammarElement();
      final EObject grammarElement = _grammarElement;
      boolean _matched = false;
      if (!_matched) {
        if (grammarElement instanceof AbstractRule) {
          _matched=true;
          _switchResult = ((AbstractRule)grammarElement).getName();
        }
      }
      if (!_matched) {
        if (grammarElement instanceof RuleCall) {
          _matched=true;
          AbstractRule _rule = ((RuleCall)grammarElement).getRule();
          _switchResult = _rule.getName();
        }
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  protected abstract AbstractPsiAntlrParser createParser(final PsiBuilder builder, final TokenStream tokenStream);
  
  protected PsiXtextTokenStream createTokenStream(final PsiBuilder builder) {
    PsiXtextTokenStream _xblockexpression = null;
    {
      final TokenSource tokenSource = this.createTokenSource(builder);
      PsiXtextTokenStream _psiXtextTokenStream = new PsiXtextTokenStream(builder, tokenSource, this.tokenDefProvider);
      final Procedure1<PsiXtextTokenStream> _function = new Procedure1<PsiXtextTokenStream>() {
        @Override
        public void apply(final PsiXtextTokenStream it) {
          final Integer lookAhead = builder.<Integer>getUserData(IASTNodeAwareNodeModelBuilder.LOOK_AHEAD_KEY);
          boolean _notEquals = (!Objects.equal(lookAhead, null));
          if (_notEquals) {
            it.initCurrentLookAhead((lookAhead).intValue());
          }
          HashSet<String> _initialHiddenTokens = AbstractXtextPsiParser.this.getInitialHiddenTokens();
          it.setInitialHiddenTokens(((String[])Conversions.unwrapArray(_initialHiddenTokens, String.class)));
        }
      };
      _xblockexpression = ObjectExtensions.<PsiXtextTokenStream>operator_doubleArrow(_psiXtextTokenStream, _function);
    }
    return _xblockexpression;
  }
  
  protected TokenSource createTokenSource(final PsiBuilder builder) {
    CharSequence _originalText = builder.getOriginalText();
    return this.tokenSourceProvider.createTokenSource(_originalText);
  }
  
  protected HashSet<String> getInitialHiddenTokens() {
    HashSet<String> _xblockexpression = null;
    {
      HashSet<String> hiddenTokens = CollectionLiterals.<String>newHashSet();
      TokenSet _whitespaceTokens = this.tokenTypeProvider.getWhitespaceTokens();
      IElementType[] _types = _whitespaceTokens.getTypes();
      final Function1<IElementType, String> _function = new Function1<IElementType, String>() {
        @Override
        public String apply(final IElementType it) {
          return it.toString();
        }
      };
      List<String> _map = ListExtensions.<IElementType, String>map(((List<IElementType>)Conversions.doWrapArray(_types)), _function);
      Iterables.<String>addAll(hiddenTokens, _map);
      TokenSet _commentTokens = this.tokenTypeProvider.getCommentTokens();
      IElementType[] _types_1 = _commentTokens.getTypes();
      final Function1<IElementType, String> _function_1 = new Function1<IElementType, String>() {
        @Override
        public String apply(final IElementType it) {
          return it.toString();
        }
      };
      List<String> _map_1 = ListExtensions.<IElementType, String>map(((List<IElementType>)Conversions.doWrapArray(_types_1)), _function_1);
      Iterables.<String>addAll(hiddenTokens, _map_1);
      _xblockexpression = hiddenTokens;
    }
    return _xblockexpression;
  }
  
  @Pure
  protected ITokenDefProvider getTokenDefProvider() {
    return this.tokenDefProvider;
  }
  
  @Pure
  protected TokenTypeProvider getTokenTypeProvider() {
    return this.tokenTypeProvider;
  }
  
  @Pure
  protected TokenSourceProvider getTokenSourceProvider() {
    return this.tokenSourceProvider;
  }
}
