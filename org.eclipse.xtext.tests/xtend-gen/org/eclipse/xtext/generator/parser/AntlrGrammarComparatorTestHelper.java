/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.parser;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.parser.AntlrGrammarComparator;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class AntlrGrammarComparatorTestHelper {
  public static class ComparisonError extends AssertionError {
    private final int lineNoTestee;
    
    private final int lineNoExpected;
    
    public ComparisonError(final String msg) {
      super(msg);
      this.lineNoTestee = (-1);
      this.lineNoExpected = (-1);
    }
    
    public ComparisonError(final int lineNoTestee, final int lineNoExpected, final String msg) {
      super(msg);
      this.lineNoTestee = lineNoTestee;
      this.lineNoExpected = lineNoExpected;
    }
  }
  
  private static class TestErrorHandler implements AntlrGrammarComparator.IErrorHandler {
    @Override
    public void handleMismatch(final String match, final String matchReference, final AntlrGrammarComparator.ErrorContext context) {
      AntlrGrammarComparator.MatchState _testedGrammar = context.getTestedGrammar();
      int _lineNumber = _testedGrammar.getLineNumber();
      AntlrGrammarComparator.MatchState _referenceGrammar = context.getReferenceGrammar();
      int _lineNumber_1 = _referenceGrammar.getLineNumber();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Inputs differs at token ");
      _builder.append(match, "");
      _builder.append(" (line ");
      AntlrGrammarComparator.MatchState _testedGrammar_1 = context.getTestedGrammar();
      int _lineNumber_2 = _testedGrammar_1.getLineNumber();
      _builder.append(_lineNumber_2, "");
      _builder.append("), expected token ");
      _builder.append(matchReference, "");
      _builder.append(" (line ");
      AntlrGrammarComparator.MatchState _referenceGrammar_1 = context.getReferenceGrammar();
      int _lineNumber_3 = _referenceGrammar_1.getLineNumber();
      _builder.append(_lineNumber_3, "");
      _builder.append(").");
      _builder.newLineIfNotEmpty();
      AntlrGrammarComparatorTestHelper.fail(_lineNumber, _lineNumber_1, _builder.toString());
    }
    
    @Override
    public void handleInvalidGeneratedGrammarFile(final AntlrGrammarComparator.ErrorContext context) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Noticed an unmatched character sequence in \'testee\' in/before line ");
      AntlrGrammarComparator.MatchState _testedGrammar = context.getTestedGrammar();
      int _lineNumber = _testedGrammar.getLineNumber();
      _builder.append(_lineNumber, "");
      _builder.append(".");
      _builder.newLineIfNotEmpty();
      AntlrGrammarComparatorTestHelper.fail(_builder.toString());
    }
    
    @Override
    public void handleInvalidReferenceGrammarFile(final AntlrGrammarComparator.ErrorContext context) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Noticed an unmatched character sequence in \'expected\' in/before line ");
      AntlrGrammarComparator.MatchState _referenceGrammar = context.getReferenceGrammar();
      int _lineNumber = _referenceGrammar.getLineNumber();
      _builder.append(_lineNumber, "");
      _builder.append(".");
      _builder.newLineIfNotEmpty();
      AntlrGrammarComparatorTestHelper.fail(_builder.toString());
    }
  }
  
  private final AntlrGrammarComparator comparator = new AntlrGrammarComparator();
  
  private final AntlrGrammarComparatorTestHelper.TestErrorHandler errorHandler = new AntlrGrammarComparatorTestHelper.TestErrorHandler();
  
  public AntlrGrammarComparator.ErrorContext compare(final CharSequence grammar, final CharSequence grammarReference) {
    return this.comparator.compareGrammars(grammar, grammarReference, this.errorHandler);
  }
  
  /**
   * This method delegates to 'compare(..., ...)' and expects a {@link ComparisonError} reporting a mismatch
   * in the given line numbers. If so the error is dropped. If the error reports different line numbers
   * the error is re-thrown indicating a failure in the test. If no error occurs in 'compare(..., ...)'
   * this test is supposed to fail.
   */
  public void compareAndExpectMismatchInLines(final String testee, final String expected, final int lineNoTestee, final int lineNoExpected) {
    try {
      this.compare(testee, expected);
    } catch (final Throwable _t) {
      if (_t instanceof AntlrGrammarComparatorTestHelper.ComparisonError) {
        final AntlrGrammarComparatorTestHelper.ComparisonError e = (AntlrGrammarComparatorTestHelper.ComparisonError)_t;
        if (((lineNoTestee == e.lineNoTestee) && (lineNoExpected == e.lineNoExpected))) {
          return;
        } else {
          throw e;
        }
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Expected mismatch in lines ");
    _builder.append(lineNoTestee, "");
    _builder.append("/");
    _builder.append(lineNoExpected, "");
    _builder.append(".");
    AntlrGrammarComparatorTestHelper.fail(_builder.toString());
  }
  
  private static void fail(final String msg) {
    throw new AntlrGrammarComparatorTestHelper.ComparisonError(msg);
  }
  
  private static void fail(final int lineNoTestee, final int lineNoExpected, final String msg) {
    throw new AntlrGrammarComparatorTestHelper.ComparisonError(lineNoTestee, lineNoExpected, msg);
  }
}
