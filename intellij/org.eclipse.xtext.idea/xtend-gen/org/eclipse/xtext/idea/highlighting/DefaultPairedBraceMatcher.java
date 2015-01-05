package org.eclipse.xtext.idea.highlighting;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class DefaultPairedBraceMatcher implements PairedBraceMatcher {
  private final static char KEYWORD_START_CHARACTER = '\'';
  
  @Inject
  private IGrammarAccess grammarAccess;
  
  @Inject
  private ITokenDefProvider tokenDefProvider;
  
  @Inject
  private TokenTypeProvider tokenTypeProvider;
  
  @Inject
  private IBracePairProvider bracePairProvider;
  
  public int getCodeConstructStart(final PsiFile file, final int openingBraceOffset) {
    return openingBraceOffset;
  }
  
  public BracePair[] getPairs() {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList();
    final BracePair[] _result;
    synchronized (_createCache_getPairs) {
      if (_createCache_getPairs.containsKey(_cacheKey)) {
        return _createCache_getPairs.get(_cacheKey);
      }
      Collection<org.eclipse.xtext.ide.editor.bracketmatching.BracePair> _pairs = this.bracePairProvider.getPairs();
      final Function1<org.eclipse.xtext.ide.editor.bracketmatching.BracePair, List<BracePair>> _function = new Function1<org.eclipse.xtext.ide.editor.bracketmatching.BracePair, List<BracePair>>() {
        public List<BracePair> apply(final org.eclipse.xtext.ide.editor.bracketmatching.BracePair it) {
          String _leftBrace = it.getLeftBrace();
          String _rightBrace = it.getRightBrace();
          boolean _isStructural = it.isStructural();
          return DefaultPairedBraceMatcher.this.findPairs(_leftBrace, _rightBrace, _isStructural);
        }
      };
      Iterable<List<BracePair>> _map = IterableExtensions.<org.eclipse.xtext.ide.editor.bracketmatching.BracePair, List<BracePair>>map(_pairs, _function);
      Iterable<BracePair> _flatten = Iterables.<BracePair>concat(_map);
      _result = ((BracePair[]) ((BracePair[])Conversions.unwrapArray(_flatten, BracePair.class)));
      _createCache_getPairs.put(_cacheKey, _result);
    }
    _init_getPairs(_result);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, BracePair[]> _createCache_getPairs = CollectionLiterals.newHashMap();
  
  private void _init_getPairs(final BracePair[] it) {
  }
  
  protected List<BracePair> findPairs(final String leftBraceKeyword, final String rightBraceKeyword, final boolean structural) {
    List<Pair<Keyword, Keyword>> _findKeywordPairs = this.grammarAccess.findKeywordPairs(leftBraceKeyword, rightBraceKeyword);
    final Function1<Pair<Keyword, Keyword>, BracePair> _function = new Function1<Pair<Keyword, Keyword>, BracePair>() {
      public BracePair apply(final Pair<Keyword, Keyword> it) {
        Keyword _first = it.getFirst();
        Keyword _second = it.getSecond();
        return DefaultPairedBraceMatcher.this.createPair(_first, _second, structural);
      }
    };
    return ListExtensions.<Pair<Keyword, Keyword>, BracePair>map(_findKeywordPairs, _function);
  }
  
  protected BracePair createPair(final Keyword leftBraceKeyword, final Keyword rightBraceKeyword, final boolean structural) {
    BracePair _xblockexpression = null;
    {
      final IElementType leftBraceTokenType = this.getTokenType(leftBraceKeyword);
      final IElementType rightBraceTokenType = this.getTokenType(rightBraceKeyword);
      _xblockexpression = this.createPair(leftBraceTokenType, rightBraceTokenType, structural);
    }
    return _xblockexpression;
  }
  
  protected BracePair createPair(final IElementType leftBraceTokenType, final IElementType rightBraceTokenType, final boolean structural) {
    return new BracePair(leftBraceTokenType, rightBraceTokenType, structural);
  }
  
  protected IElementType getTokenType(final Keyword keyword) {
    HashMap<String, IElementType> _tokenTypes = this.getTokenTypes();
    String _value = keyword.getValue();
    String _plus = ("\'" + _value);
    String _plus_1 = (_plus + "\'");
    return _tokenTypes.get(_plus_1);
  }
  
  protected HashMap<String, IElementType> getTokenTypes() {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList();
    final HashMap<String, IElementType> _result;
    synchronized (_createCache_getTokenTypes) {
      if (_createCache_getTokenTypes.containsKey(_cacheKey)) {
        return _createCache_getTokenTypes.get(_cacheKey);
      }
      HashMap<String, IElementType> _xblockexpression = null;
      {
        final HashMap<String, IElementType> tokenTypes = CollectionLiterals.<String, IElementType>newHashMap();
        final Map<Integer, String> tokenDefMap = this.tokenDefProvider.getTokenDefMap();
        Set<Integer> _keySet = tokenDefMap.keySet();
        for (final Integer antlrTokenType : _keySet) {
          {
            final String value = tokenDefMap.get(antlrTokenType);
            char _charAt = value.charAt(0);
            boolean _equals = (_charAt == DefaultPairedBraceMatcher.KEYWORD_START_CHARACTER);
            if (_equals) {
              final IElementType tokenType = this.tokenTypeProvider.getIElementType((antlrTokenType).intValue());
              tokenTypes.put(value, tokenType);
            }
          }
        }
        _xblockexpression = tokenTypes;
      }
      _result = _xblockexpression;
      _createCache_getTokenTypes.put(_cacheKey, _result);
    }
    _init_getTokenTypes(_result);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, HashMap<String, IElementType>> _createCache_getTokenTypes = CollectionLiterals.newHashMap();
  
  private void _init_getTokenTypes(final HashMap<String, IElementType> it) {
  }
  
  public boolean isPairedBracesAllowedBeforeType(final IElementType lbraceType, final IElementType contextType) {
    return true;
  }
}
