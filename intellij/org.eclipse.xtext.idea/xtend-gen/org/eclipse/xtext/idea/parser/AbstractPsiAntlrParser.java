package org.eclipse.xtext.idea.parser;

import com.google.common.base.Objects;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.parser.PsiXtextTokenStream;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider;
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
  
  private final /* PsiBuilder */Object psiBuilder;
  
  private final TokenTypeProvider tokenTypeProvider;
  
  private final /* LinkedList<Marker> */Object leafMarkers /* Skipped initializer because of errors */;
  
  private final /* LinkedList<Marker> */Object compositeMarkers /* Skipped initializer because of errors */;
  
  private final /* HashMap<Marker, Integer> */Object lookAheads /* Skipped initializer because of errors */;
  
  private String currentError;
  
  public AbstractPsiAntlrParser(final /* PsiBuilder */Object builder, final TokenStream input, final TokenTypeProvider tokenTypeProvider) {
    this(builder, input, tokenTypeProvider, new RecognizerSharedState());
  }
  
  public AbstractPsiAntlrParser(final /* PsiBuilder */Object builder, final TokenStream input, final TokenTypeProvider tokenTypeProvider, final RecognizerSharedState state) {
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
    throw new Error("Unresolved compilation problems:"
      + "\nProcessCanceledException cannot be resolved to a type."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition.");
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
    throw new Error("Unresolved compilation problems:"
      + "\neof cannot be resolved"
      + "\n! cannot be resolved"
      + "\nerror cannot be resolved");
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
  
  public String getSourceName() {
    return this.input.getSourceName();
  }
  
  protected void markComposite() {
    throw new Error("Unresolved compilation problems:"
      + "\nmark cannot be resolved");
  }
  
  protected void markLeaf() {
    throw new Error("Unresolved compilation problems:"
      + "\nmark cannot be resolved");
  }
  
  protected Object drop() {
    throw new Error("Unresolved compilation problems:"
      + "\ndrop cannot be resolved");
  }
  
  protected void doneComposite(final /* IElementType */Object elementType) {
    throw new Error("Unresolved compilation problems:"
      + "\nCreateElementType cannot be resolved."
      + "\nThe method putUserData is undefined for the type AbstractPsiAntlrParser"
      + "\ndone cannot be resolved");
  }
  
  protected void doneLeaf(final Token matchedToken, final /* IElementType */Object elementType) {
    throw new Error("Unresolved compilation problems:"
      + "\nrawTokenIndex cannot be resolved"
      + "\nrollbackTo cannot be resolved"
      + "\nrawTokenIndex cannot be resolved"
      + "\n- cannot be resolved"
      + "\n- cannot be resolved"
      + "\nadvanceLexer cannot be resolved"
      + "\nremapCurrentToken cannot be resolved"
      + "\nmark cannot be resolved"
      + "\nadvanceLexer cannot be resolved"
      + "\nerror cannot be resolved"
      + "\nadvanceLexer cannot be resolved");
  }
  
  protected int getCurrentLookAhead() {
    if ((this.input instanceof PsiXtextTokenStream)) {
      return ((PsiXtextTokenStream)this.input).getCurrentLookAhead();
    }
    String _simpleName = PsiXtextTokenStream.class.getSimpleName();
    String _plus = ("the input should be an instance of " + _simpleName);
    throw new IllegalStateException(_plus);
  }
  
  protected Object recoverFromMismatchedToken(final IntStream input, final int ttype, final BitSet follow) {
    throw new Error("Unresolved compilation problems:"
      + "\nrawTokenIndex cannot be resolved"
      + "\nmark cannot be resolved"
      + "\nrawTokenIndex cannot be resolved"
      + "\nrollbackTo cannot be resolved"
      + "\n- cannot be resolved"
      + "\n- cannot be resolved"
      + "\nadvanceLexer cannot be resolved"
      + "\nmark cannot be resolved"
      + "\nadvanceLexer cannot be resolved"
      + "\nerror cannot be resolved");
  }
  
  public void recover(final IntStream input, final RecognitionException re) {
    throw new Error("Unresolved compilation problems:"
      + "\ndrop cannot be resolved");
  }
  
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
