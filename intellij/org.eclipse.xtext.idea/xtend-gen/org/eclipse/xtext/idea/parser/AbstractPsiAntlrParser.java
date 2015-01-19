package org.eclipse.xtext.idea.parser;

import com.google.common.base.Objects;
import com.intellij.lang.PsiBuilder;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.psi.tree.IElementType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MissingTokenException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.UnwantedTokenException;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.parser.CompositeMarker;
import org.eclipse.xtext.idea.parser.PsiXtextTokenStream;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public abstract class AbstractPsiAntlrParser extends Parser {
  private List<String> readableTokenNames;
  
  @Accessors
  @Extension
  private ISyntaxErrorMessageProvider _iSyntaxErrorMessageProvider;
  
  private final PsiBuilder psiBuilder;
  
  private final TokenTypeProvider tokenTypeProvider;
  
  private final LinkedList<PsiBuilder.Marker> leafMarkers = CollectionLiterals.<PsiBuilder.Marker>newLinkedList();
  
  private final LinkedList<CompositeMarker> compositeMarkers = CollectionLiterals.<CompositeMarker>newLinkedList();
  
  private String currentError;
  
  public AbstractPsiAntlrParser(final PsiBuilder builder, final TokenStream input, final TokenTypeProvider tokenTypeProvider) {
    this(builder, input, tokenTypeProvider, new RecognizerSharedState());
  }
  
  public AbstractPsiAntlrParser(final PsiBuilder builder, final TokenStream input, final TokenTypeProvider tokenTypeProvider, final RecognizerSharedState state) {
    super(input, state);
    this.psiBuilder = builder;
    this.tokenTypeProvider = tokenTypeProvider;
  }
  
  public AbstractPsiAntlrParser(final TokenStream input, final RecognizerSharedState state) {
    super(input, state);
    this.psiBuilder = null;
    this.tokenTypeProvider = null;
    throw new UnsupportedOperationException();
  }
  
  protected abstract String getFirstRuleName();
  
  public void parse() throws RecognitionException {
    String _firstRuleName = this.getFirstRuleName();
    this.parse(_firstRuleName);
  }
  
  public void parse(final String entryRuleName) throws RecognitionException {
    try {
      final String antlrEntryRuleName = this.normalizeEntryRuleName(entryRuleName);
      try {
        this.invokeEntryRule(antlrEntryRuleName);
        this.appendAllTokens();
      } catch (final Throwable _t) {
        if (_t instanceof InvocationTargetException) {
          final InvocationTargetException ite = (InvocationTargetException)_t;
          Throwable _targetException = ite.getTargetException();
          final Throwable targetException = _targetException;
          boolean _matched = false;
          if (!_matched) {
            if (targetException instanceof RecognitionException) {
              _matched=true;
              this.appendAllTokens();
              throw targetException;
            }
          }
          if (!_matched) {
            if (targetException instanceof ProcessCanceledException) {
              _matched=true;
              throw targetException;
            }
          }
          throw ite;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Object invokeEntryRule(final String antlrEntryRuleName) {
    try {
      Object _xblockexpression = null;
      {
        Class<? extends AbstractPsiAntlrParser> _class = this.getClass();
        final Method method = _class.getMethod(antlrEntryRuleName);
        method.setAccessible(true);
        _xblockexpression = method.invoke(this);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String appendAllTokens() {
    String _xblockexpression = null;
    {
      while ((!this.psiBuilder.eof())) {
        this.input.consume();
      }
      String _xifexpression = null;
      boolean _notEquals = (!Objects.equal(this.currentError, null));
      if (_notEquals) {
        String _xblockexpression_1 = null;
        {
          this.psiBuilder.error(this.currentError);
          _xblockexpression_1 = this.currentError = null;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected String normalizeEntryRuleName(final String entryRuleName) {
    String _xblockexpression = null;
    {
      boolean _startsWith = entryRuleName.startsWith("entryRule");
      if (_startsWith) {
        return entryRuleName;
      }
      boolean _startsWith_1 = entryRuleName.startsWith("rule");
      if (_startsWith_1) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("entry");
        String _firstUpper = StringExtensions.toFirstUpper(entryRuleName);
        _builder.append(_firstUpper, "");
        return _builder.toString();
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entryRule");
      _builder_1.append(entryRuleName, "");
      _xblockexpression = _builder_1.toString();
    }
    return _xblockexpression;
  }
  
  @Override
  public String getSourceName() {
    return this.input.getSourceName();
  }
  
  protected void markComposite(final IElementType elementType) {
    PsiBuilder.Marker _mark = this.psiBuilder.mark();
    int _currentLookAhead = this.getCurrentLookAhead();
    CompositeMarker _compositeMarker = new CompositeMarker(_mark, _currentLookAhead, elementType);
    this.compositeMarkers.push(_compositeMarker);
  }
  
  protected void markLeaf() {
    final PsiBuilder.Marker marker = this.psiBuilder.mark();
    this.leafMarkers.push(marker);
  }
  
  protected void precedeComposite(final IElementType elementType) {
    final CompositeMarker compositeMarker = this.compositeMarkers.pop();
    CompositeMarker _precede = compositeMarker.precede(elementType);
    this.compositeMarkers.push(_precede);
    this.compositeMarkers.push(compositeMarker);
  }
  
  protected void drop() {
    PsiBuilder.Marker _pop = this.leafMarkers.pop();
    _pop.drop();
  }
  
  protected void doneComposite() {
    CompositeMarker _pop = this.compositeMarkers.pop();
    _pop.done();
  }
  
  protected void doneLeaf(final Token matchedToken, final IElementType elementType) {
    boolean _equals = Objects.equal(matchedToken, null);
    if (_equals) {
      this.drop();
      return;
    }
    final PsiBuilder.Marker marker = this.leafMarkers.pop();
    final int endTokenIndex = this.psiBuilder.rawTokenIndex();
    marker.rollbackTo();
    final int startTokenIndex = this.psiBuilder.rawTokenIndex();
    final int n = ((endTokenIndex - startTokenIndex) - 1);
    for (int i = 0; (i < n); i++) {
      this.psiBuilder.advanceLexer();
    }
    this.psiBuilder.remapCurrentToken(elementType);
    boolean _notEquals = (!Objects.equal(this.currentError, null));
    if (_notEquals) {
      final PsiBuilder.Marker errorMarker = this.psiBuilder.mark();
      this.psiBuilder.advanceLexer();
      errorMarker.error(this.currentError);
      this.currentError = null;
    } else {
      this.psiBuilder.advanceLexer();
    }
  }
  
  protected int getCurrentLookAhead() {
    if ((this.input instanceof PsiXtextTokenStream)) {
      return ((PsiXtextTokenStream)this.input).getCurrentLookAhead();
    }
    String _simpleName = PsiXtextTokenStream.class.getSimpleName();
    String _plus = ("the input should be an instance of " + _simpleName);
    throw new IllegalStateException(_plus);
  }
  
  @Override
  protected Object recoverFromMismatchedToken(final IntStream input, final int ttype, final BitSet follow) {
    try {
      boolean _mismatchIsUnwantedToken = this.mismatchIsUnwantedToken(input, ttype);
      if (_mismatchIsUnwantedToken) {
        boolean _isEmpty = this.leafMarkers.isEmpty();
        final boolean marked = (!_isEmpty);
        if (marked) {
          this.drop();
        }
        final UnwantedTokenException unwantedTokenException = new UnwantedTokenException(ttype, input);
        final int startTokenIndex = this.psiBuilder.rawTokenIndex();
        final PsiBuilder.Marker marker = this.psiBuilder.mark();
        this.beginResync();
        input.consume();
        this.endResync();
        this.reportError(unwantedTokenException);
        boolean _notEquals = (!Objects.equal(this.currentError, null));
        if (_notEquals) {
          final int endTokenIndex = this.psiBuilder.rawTokenIndex();
          marker.rollbackTo();
          final int n = ((endTokenIndex - startTokenIndex) - 1);
          for (int i = 0; (i < n); i++) {
            this.psiBuilder.advanceLexer();
          }
          final PsiBuilder.Marker errorMarker = this.psiBuilder.mark();
          this.psiBuilder.advanceLexer();
          String _errorMessage = this.getErrorMessage(unwantedTokenException, ((String[])Conversions.unwrapArray(this.readableTokenNames, String.class)));
          errorMarker.error(_errorMessage);
          this.currentError = null;
        }
        if (marked) {
          this.markLeaf();
        }
        Object matchedSymbol = this.getCurrentInputSymbol(input);
        input.consume();
        return matchedSymbol;
      }
      boolean _mismatchIsMissingToken = this.mismatchIsMissingToken(input, follow);
      if (_mismatchIsMissingToken) {
        Object inserted = this.getMissingSymbol(input, null, ttype, follow);
        MissingTokenException _missingTokenException = new MissingTokenException(ttype, input, inserted);
        this.reportError(_missingTokenException);
        return null;
      }
      throw new MismatchedTokenException(ttype, input);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void recover(final IntStream input, final RecognitionException re) {
    boolean _equals = Objects.equal(this.currentError, null);
    if (_equals) {
      String _errorMessage = this.getErrorMessage(re, ((String[])Conversions.unwrapArray(this.readableTokenNames, String.class)));
      this.currentError = _errorMessage;
    }
    for (final PsiBuilder.Marker leafMarker : this.leafMarkers) {
      leafMarker.drop();
    }
    this.leafMarkers.clear();
    super.recover(input, re);
  }
  
  @Override
  public void reportError(final RecognitionException e) {
    if (this.state.errorRecovery) {
      return;
    }
    this.state.syntaxErrors++;
    this.state.errorRecovery = true;
    boolean _equals = Objects.equal(this.currentError, null);
    if (_equals) {
      String _errorMessage = this.getErrorMessage(e, ((String[])Conversions.unwrapArray(this.readableTokenNames, String.class)));
      this.currentError = _errorMessage;
    }
  }
  
  @Override
  public void emitErrorMessage(final String msg) {
    throw new UnsupportedOperationException();
  }
  
  public void setTokenTypeMap(final Map<Integer, String> tokenTypeMap) {
    String[] tokenNames = this.getTokenNames();
    int _length = tokenNames.length;
    String[] _newArrayOfSize = new String[_length];
    this.readableTokenNames = ((List<String>)Conversions.doWrapArray(_newArrayOfSize));
    for (int i = 0; (i < tokenNames.length); i++) {
      boolean _containsKey = tokenTypeMap.containsKey(Integer.valueOf(i));
      if (_containsKey) {
        String _get = tokenTypeMap.get(Integer.valueOf(i));
        this.readableTokenNames.set(i, _get);
      } else {
        String _get_1 = tokenNames[i];
        this.readableTokenNames.set(i, _get_1);
      }
    }
  }
  
  @Pure
  public ISyntaxErrorMessageProvider get_iSyntaxErrorMessageProvider() {
    return this._iSyntaxErrorMessageProvider;
  }
  
  public void set_iSyntaxErrorMessageProvider(final ISyntaxErrorMessageProvider _iSyntaxErrorMessageProvider) {
    this._iSyntaxErrorMessageProvider = _iSyntaxErrorMessageProvider;
  }
}
