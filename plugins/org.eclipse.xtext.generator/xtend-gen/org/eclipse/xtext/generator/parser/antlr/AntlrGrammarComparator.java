/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.parser.antlr;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtend.lib.annotations.AccessorType;
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
 * @since 2.9
 */
@SuppressWarnings("all")
public class AntlrGrammarComparator {
  public static abstract class AbstractErrorHandler {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private int lineNumber = 1;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private int lineNumberReference = 1;
    
    @Accessors
    private String absoluteGrammarFileName;
    
    @Accessors
    private String absoluteGrammarFileNameReference;
    
    private boolean treatingReferenceGrammar = false;
    
    private void handleUnexpectedCharSequence(final int lineCount) {
      if (this.treatingReferenceGrammar) {
        this.handleInvalidGrammarFile(this.absoluteGrammarFileNameReference, (this.lineNumberReference + lineCount));
      } else {
        this.handleInvalidGrammarFile(this.absoluteGrammarFileName, (this.lineNumber + lineCount));
      }
    }
    
    public abstract void handleInvalidGrammarFile(final String absoluteGrammarFileName, final int lineNo);
    
    public abstract void handleMismatch(final String match, final String matchReference);
    
    @Pure
    public int getLineNumber() {
      return this.lineNumber;
    }
    
    @Pure
    public int getLineNumberReference() {
      return this.lineNumberReference;
    }
    
    @Pure
    public String getAbsoluteGrammarFileName() {
      return this.absoluteGrammarFileName;
    }
    
    public void setAbsoluteGrammarFileName(final String absoluteGrammarFileName) {
      this.absoluteGrammarFileName = absoluteGrammarFileName;
    }
    
    @Pure
    public String getAbsoluteGrammarFileNameReference() {
      return this.absoluteGrammarFileNameReference;
    }
    
    public void setAbsoluteGrammarFileNameReference(final String absoluteGrammarFileNameReference) {
      this.absoluteGrammarFileNameReference = absoluteGrammarFileNameReference;
    }
  }
  
  private final static List<String> SINGLE_CHAR_TOKENS = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("\\(", "\\)", "\\[", "\\]", "\\{", "\\}", "\\|", "=", "\\?", "\\*", "\\+", ":", ";"));
  
  private final static String QUOTED_TOKENS = IterableExtensions.join(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("\'(\\\\\')+\'", "(\'[^\']*\')", "(\"[^\"]*\")")), "|");
  
  private final static String TOKEN = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      String _join = IterableExtensions.join(AntlrGrammarComparator.SINGLE_CHAR_TOKENS, "|");
      _builder.append(_join, "");
      _builder.append("|");
      _builder.append(AntlrGrammarComparator.QUOTED_TOKENS, "");
      _builder.append("|[^\\s\'\"");
      String _join_1 = IterableExtensions.join(AntlrGrammarComparator.SINGLE_CHAR_TOKENS);
      _builder.append(_join_1, "");
      _builder.append("]+");
      return _builder.toString();
    }
  }.apply();
  
  private final static String NEWLINE = "\\r?\\n|\\r";
  
  private final static String WS = "( |\\t)+";
  
  private final Pattern p_token = Pattern.compile(AntlrGrammarComparator.TOKEN);
  
  private final Pattern p_newline = Pattern.compile(AntlrGrammarComparator.NEWLINE);
  
  private final Pattern p_ws = Pattern.compile(AntlrGrammarComparator.WS);
  
  private final Pattern compoundPattern = new Function0<Pattern>() {
    public Pattern apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(");
      _builder.append(AntlrGrammarComparator.TOKEN, "");
      _builder.append(")|(");
      _builder.append(AntlrGrammarComparator.NEWLINE, "");
      _builder.append(")|(");
      _builder.append(AntlrGrammarComparator.WS, "");
      _builder.append(")");
      Pattern _compile = Pattern.compile(_builder.toString(), Pattern.MULTILINE);
      return _compile;
    }
  }.apply();
  
  /**
   * Performs the actual comparison of given and expected grammar.
   * 
   * @return {@link Pair} containing the number of lines of the tested grammar (key)
   * 			and the referenced grammar (value) for logging purposes
   */
  public void compareGrammars(final CharSequence grammar, final CharSequence grammarReference, final AntlrGrammarComparator.AbstractErrorHandler errorHandler) {
    final Matcher compoundMatcher = this.compoundPattern.matcher(grammar);
    final Matcher compoundMatcherReference = this.compoundPattern.matcher(grammarReference);
    int previousEnd = 0;
    int previousEndReference = 0;
    boolean continue_ = true;
    boolean continueReference = true;
    while ((continue_ || continueReference)) {
      {
        if (continue_) {
          errorHandler.treatingReferenceGrammar = false;
          final Pair<Boolean, Integer> res = this.nextToken(compoundMatcher, previousEnd, errorHandler);
          Boolean _key = res.getKey();
          continue_ = (_key).booleanValue();
          int _lineNumber = errorHandler.lineNumber;
          Integer _value = res.getValue();
          errorHandler.lineNumber = (_lineNumber + (_value).intValue());
          if (continue_) {
            int _end = compoundMatcher.end();
            previousEnd = _end;
          }
        }
        String _xifexpression = null;
        if (continue_) {
          _xifexpression = compoundMatcher.group();
        } else {
          _xifexpression = "««eof»»";
        }
        final String match = _xifexpression;
        if (continueReference) {
          errorHandler.treatingReferenceGrammar = true;
          final Pair<Boolean, Integer> res_1 = this.nextToken(compoundMatcherReference, previousEndReference, errorHandler);
          Boolean _key_1 = res_1.getKey();
          continueReference = (_key_1).booleanValue();
          int _lineNumberReference = errorHandler.lineNumberReference;
          Integer _value_1 = res_1.getValue();
          errorHandler.lineNumberReference = (_lineNumberReference + (_value_1).intValue());
          if (continueReference) {
            int _end_1 = compoundMatcherReference.end();
            previousEndReference = _end_1;
          }
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
          errorHandler.handleMismatch(match, matchReference);
        }
      }
    }
  }
  
  /**
   * continue matching until the next token is found, count newlines while doing so.
   * 
   * @return the number of newlines passed while searching
   */
  private Pair<Boolean, Integer> nextToken(final Matcher matcher, final int previousEnd, final AntlrGrammarComparator.AbstractErrorHandler errorHandler) {
    int newlineCounter = 0;
    int thePreviousEnd = previousEnd;
    while (matcher.find()) {
      {
        int _start = matcher.start();
        boolean _notEquals = (_start != thePreviousEnd);
        if (_notEquals) {
          errorHandler.handleUnexpectedCharSequence(newlineCounter);
        }
        final String match = matcher.group();
        Matcher _matcher = this.p_newline.matcher(match);
        boolean _matches = _matcher.matches();
        if (_matches) {
          newlineCounter++;
          int _end = matcher.end();
          thePreviousEnd = _end;
        } else {
          Matcher _matcher_1 = this.p_ws.matcher(match);
          boolean _matches_1 = _matcher_1.matches();
          if (_matches_1) {
            int _end_1 = matcher.end();
            thePreviousEnd = _end_1;
          } else {
            Matcher _matcher_2 = this.p_token.matcher(match);
            boolean _matches_2 = _matcher_2.matches();
            if (_matches_2) {
              return Pair.<Boolean, Integer>of(Boolean.valueOf(true), Integer.valueOf(newlineCounter));
            }
          }
        }
      }
    }
    return Pair.<Boolean, Integer>of(Boolean.valueOf(false), Integer.valueOf(newlineCounter));
  }
}
