/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.parser.antlr;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Compares two charSequences of ANTLR grammars token by token.
 * Ignores differences in white space, and counts line breaks for usable error diagnosis.
 * 
 * @author Christian Schneider - Initial contribution and API
 * @noreference
 */
@Deprecated
@SuppressWarnings("all")
public class AntlrGrammarComparator {
  public interface IErrorHandler {
    void handleInvalidGeneratedGrammarFile(final AntlrGrammarComparator.ErrorContext context);
    
    void handleInvalidReferenceGrammarFile(final AntlrGrammarComparator.ErrorContext context);
    
    void handleMismatch(final String matched, final String expected, final AntlrGrammarComparator.ErrorContext context);
  }
  
  public static final class ErrorContext {
    @Accessors
    private AntlrGrammarComparator.MatchState testedGrammar = new AntlrGrammarComparator.MatchState();
    
    @Accessors
    private AntlrGrammarComparator.MatchState referenceGrammar = new AntlrGrammarComparator.MatchState();
    
    public AntlrGrammarComparator.MatchState reset() {
      AntlrGrammarComparator.MatchState _xblockexpression = null;
      {
        AntlrGrammarComparator.MatchState _matchState = new AntlrGrammarComparator.MatchState();
        this.testedGrammar = _matchState;
        AntlrGrammarComparator.MatchState _matchState_1 = new AntlrGrammarComparator.MatchState();
        _xblockexpression = this.referenceGrammar = _matchState_1;
      }
      return _xblockexpression;
    }
    
    @Pure
    public AntlrGrammarComparator.MatchState getTestedGrammar() {
      return this.testedGrammar;
    }
    
    public void setTestedGrammar(final AntlrGrammarComparator.MatchState testedGrammar) {
      this.testedGrammar = testedGrammar;
    }
    
    @Pure
    public AntlrGrammarComparator.MatchState getReferenceGrammar() {
      return this.referenceGrammar;
    }
    
    public void setReferenceGrammar(final AntlrGrammarComparator.MatchState referenceGrammar) {
      this.referenceGrammar = referenceGrammar;
    }
  }
  
  public static final class MatchState {
    @Accessors
    private String absoluteFileName;
    
    @Accessors
    private int lineNumber = 1;
    
    private int position = 0;
    
    @Accessors
    private String previousToken;
    
    @Accessors
    private String currentToken;
    
    @Pure
    public String getAbsoluteFileName() {
      return this.absoluteFileName;
    }
    
    public void setAbsoluteFileName(final String absoluteFileName) {
      this.absoluteFileName = absoluteFileName;
    }
    
    @Pure
    public int getLineNumber() {
      return this.lineNumber;
    }
    
    public void setLineNumber(final int lineNumber) {
      this.lineNumber = lineNumber;
    }
    
    @Pure
    public String getPreviousToken() {
      return this.previousToken;
    }
    
    public void setPreviousToken(final String previousToken) {
      this.previousToken = previousToken;
    }
    
    @Pure
    public String getCurrentToken() {
      return this.currentToken;
    }
    
    public void setCurrentToken(final String currentToken) {
      this.currentToken = currentToken;
    }
  }
  
  private static final List<String> SINGLE_CHAR_TOKENS = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("\\(", "\\)", "\\[", "\\]", "\\{", "\\}", "\\|", "=", "\\?", "\\*", "\\+", ":", ";"));
  
  private static final String QUOTED_TOKENS = IterableExtensions.join(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("\'(\\\\\')+\'", "(\'[^\']*\')", "(\"[^\"]*\")")), "|");
  
  private static final String TOKEN = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      String _join = IterableExtensions.join(AntlrGrammarComparator.SINGLE_CHAR_TOKENS, "|");
      _builder.append(_join);
      _builder.append("|");
      _builder.append(AntlrGrammarComparator.QUOTED_TOKENS);
      _builder.append("|[^\\s\'\"");
      String _join_1 = IterableExtensions.join(AntlrGrammarComparator.SINGLE_CHAR_TOKENS);
      _builder.append(_join_1);
      _builder.append("]+");
      return _builder.toString();
    }
  }.apply();
  
  private static final String NEWLINE = "\\r?\\n|\\r";
  
  private static final String WS = "( |\\t)+";
  
  private static final String SL_COMMENT = "//[^\\r\\n]*";
  
  private static final String ML_COMMENT = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/\\*(\\*[^/]|[^\\*])*\\*/");
      return _builder.toString();
    }
  }.apply();
  
  private final Pattern p_slComment = Pattern.compile(AntlrGrammarComparator.SL_COMMENT);
  
  private final Pattern p_mlComment = Pattern.compile(AntlrGrammarComparator.ML_COMMENT);
  
  private final Pattern p_token = Pattern.compile(AntlrGrammarComparator.TOKEN);
  
  private final Pattern p_newline = Pattern.compile(AntlrGrammarComparator.NEWLINE);
  
  private final Pattern p_ws = Pattern.compile(AntlrGrammarComparator.WS);
  
  private final Pattern compoundPattern = new Function0<Pattern>() {
    @Override
    public Pattern apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(");
      _builder.append(AntlrGrammarComparator.SL_COMMENT);
      _builder.append(")|(");
      _builder.append(AntlrGrammarComparator.ML_COMMENT);
      _builder.append(")|(");
      _builder.append(AntlrGrammarComparator.TOKEN);
      _builder.append(")|(");
      _builder.append(AntlrGrammarComparator.NEWLINE);
      _builder.append(")|(");
      _builder.append(AntlrGrammarComparator.WS);
      _builder.append(")");
      Pattern _compile = Pattern.compile(_builder.toString(), Pattern.MULTILINE);
      return _compile;
    }
  }.apply();
  
  private AntlrGrammarComparator.ErrorContext errorContext;
  
  /**
   * Performs the actual comparison of given and expected grammar.
   * 
   * @return {@link Pair} containing the number of lines of the tested grammar (key)
   * 			and the referenced grammar (value) for logging purposes
   */
  public AntlrGrammarComparator.ErrorContext compareGrammars(final CharSequence grammar, final CharSequence grammarReference, final String absoluteGrammarFileName, final String absoluteGrammarFileNameReference, final AntlrGrammarComparator.IErrorHandler errorHandler) {
    AntlrGrammarComparator.ErrorContext _errorContext = new AntlrGrammarComparator.ErrorContext();
    this.errorContext = _errorContext;
    this.errorContext.testedGrammar.absoluteFileName = absoluteGrammarFileName;
    this.errorContext.referenceGrammar.absoluteFileName = absoluteGrammarFileNameReference;
    return this.compareGrammars(grammar, grammarReference, errorHandler);
  }
  
  /**
   * Performs the actual comparison of given and expected grammar.
   * 
   * @return {@link Pair} containing the number of lines of the tested grammar (key)
   * 			and the referenced grammar (value) for logging purposes
   */
  public AntlrGrammarComparator.ErrorContext compareGrammars(final CharSequence grammar, final CharSequence grammarReference, final AntlrGrammarComparator.IErrorHandler errorHandler) {
    if ((this.errorContext == null)) {
      AntlrGrammarComparator.ErrorContext _errorContext = new AntlrGrammarComparator.ErrorContext();
      this.errorContext = _errorContext;
    }
    final Matcher compoundMatcher = this.compoundPattern.matcher(grammar);
    final Matcher compoundMatcherReference = this.compoundPattern.matcher(grammarReference);
    boolean continue_ = true;
    boolean continueReference = true;
    while ((continue_ || continueReference)) {
      {
        if (continue_) {
          continue_ = this.nextToken(compoundMatcher, this.errorContext.testedGrammar, errorHandler);
        }
        String _xifexpression = null;
        if (continue_) {
          _xifexpression = compoundMatcher.group();
        } else {
          _xifexpression = "««eof»»";
        }
        final String match = _xifexpression;
        if (continueReference) {
          continueReference = this.nextToken(compoundMatcherReference, this.errorContext.referenceGrammar, errorHandler);
        }
        String _xifexpression_1 = null;
        if (continueReference) {
          _xifexpression_1 = compoundMatcherReference.group();
        } else {
          _xifexpression_1 = "««eof»»";
        }
        final String matchReference = _xifexpression_1;
        boolean _notEquals = (!Objects.equal(matchReference, match));
        if (_notEquals) {
          errorHandler.handleMismatch(match, matchReference, this.errorContext);
        }
      }
    }
    return this.errorContext;
  }
  
  /**
   * continue matching until the next token is found, count newlines while doing so.
   * 
   * @return the number of newlines passed while searching
   */
  private boolean nextToken(final Matcher matcher, final AntlrGrammarComparator.MatchState state, final AntlrGrammarComparator.IErrorHandler errorHandler) {
    while (matcher.find()) {
      {
        state.currentToken = matcher.group();
        int _start = matcher.start();
        boolean _notEquals = (_start != state.position);
        if (_notEquals) {
          this.handleInvalidGrammarFile(errorHandler, state);
        }
        final String match = matcher.group();
        state.previousToken = match;
        state.position = matcher.end();
        boolean _matches = this.p_newline.matcher(match).matches();
        if (_matches) {
          state.lineNumber++;
        } else {
          if ((this.p_slComment.matcher(match).matches() || this.p_ws.matcher(match).matches())) {
          } else {
            boolean _matches_1 = this.p_mlComment.matcher(match).matches();
            if (_matches_1) {
              final Matcher newlines = this.p_newline.matcher(match);
              while (newlines.find()) {
                state.lineNumber++;
              }
            } else {
              boolean _matches_2 = this.p_token.matcher(match).matches();
              if (_matches_2) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  private void handleInvalidGrammarFile(final AntlrGrammarComparator.IErrorHandler errorHandler, final AntlrGrammarComparator.MatchState state) {
    if ((state == this.errorContext.testedGrammar)) {
      errorHandler.handleInvalidGeneratedGrammarFile(this.errorContext);
    } else {
      errorHandler.handleInvalidReferenceGrammarFile(this.errorContext);
    }
  }
}
