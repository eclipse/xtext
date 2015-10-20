/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.parser;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarComparator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Contributes unit tests for {@link AntlrGrammarComparator}.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class AntlrGrammarComparatorTest {
  private static class TestErrorHandler extends AntlrGrammarComparator.AbstractErrorHandler {
    public TestErrorHandler() {
      this.setAbsoluteGrammarFileName("testee");
      this.setAbsoluteGrammarFileNameReference("expected");
    }
    
    @Override
    public void handleMismatch(final String match, final String matchReference) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Inputs differs at token ");
      _builder.append(match, "");
      _builder.append(" (line ");
      int _lineNumber = this.getLineNumber();
      _builder.append(_lineNumber, "");
      _builder.append("), expected token ");
      _builder.append(matchReference, "");
      _builder.append(" (line ");
      int _lineNumberReference = this.getLineNumberReference();
      _builder.append(_lineNumberReference, "");
      _builder.append(" ).");
      _builder.newLineIfNotEmpty();
      Assert.fail(_builder.toString());
    }
    
    @Override
    public void handleInvalidGrammarFile(final String testeeOrExpected, final int lineNo) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Noticed an unmatched character sequence in ");
      _builder.append(testeeOrExpected, "");
      _builder.append(" in/before line ");
      _builder.append(lineNo, "");
      _builder.append(".");
      _builder.newLineIfNotEmpty();
      Assert.fail(_builder.toString());
    }
  }
  
  private AntlrGrammarComparator comparator = new AntlrGrammarComparator();
  
  private AntlrGrammarComparatorTest.TestErrorHandler errorHandler = new AntlrGrammarComparatorTest.TestErrorHandler();
  
  private void compare(final CharSequence grammar, final CharSequence grammarReference) {
    this.comparator.compareGrammars(grammar, grammarReference, this.errorHandler);
  }
  
  /**
   * The pattern of "\"" is not expected to occur in ANTLR grammar,
   *  so I use it for testing the unmatched token check.
   */
  @Test(expected = AssertionError.class)
  public void unmatchedTokens01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"\\\"\"a");
    _builder.newLine();
    final String testee = _builder.toString();
    this.compare(testee, testee);
  }
  
  @Test
  public void stringMatch_00a() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test
  public void stringMatch_00b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans");
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test
  public void stringMatch_01a() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans hugo");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test
  public void stringMatch_01b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans hugo");
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_01a() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hugo hans");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_01b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hugo hans");
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_02a() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans hugo");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_02b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans hugo");
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_03a() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_03b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans");
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hu");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans hugo");
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans hu");
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test
  public void regExMatch01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("RULE_IN_RICH_STRING?");
    _builder.newLine();
    final String expected = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_IN_RICH_STRING ?");
    _builder_1.newLine();
    final String testee = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test
  public void regExMatch02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("RULE_IN_RICH_STRING*");
    _builder.newLine();
    final String expected = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_IN_RICH_STRING *");
    _builder_1.newLine();
    final String testee = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test
  public void regExMatch03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("RULE_IN_RICH_STRING+");
    _builder.newLine();
    final String expected = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_IN_RICH_STRING +");
    _builder_1.newLine();
    final String testee = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test
  public void snippetMatch01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar InternalStatemachine;");
    _builder.newLine();
    _builder.append("options {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("superClass=AbstractInternalAntlrParser;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar InternalStatemachine ;");
    _builder_1.newLine();
    _builder_1.append("options{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("superClass = AbstractInternalAntlrParser");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(";");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String testee = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test
  public void snippetMatch02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((\t\'abstract\' ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("| \t\'annotation\' ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("| \t\'class\' ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("| \t\'(\' ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("|  RULE_ID | \tRULE_HEX )");
    _builder.newLine();
    final String expected = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("(\'abstract\' | \'annotation\' | \'class\' | \'(\' | RULE_ID | RULE_HEX )");
    _builder_1.newLine();
    final String testee = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test
  public void matchAllTokens01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("RULE_RICH_TEXT : \'\\\'\\\'\\\'\' RULE_IN_RICH_STRING* (\'\\\'\\\'\\\'\'|(\'\\\'\' \'\\\'\'?)? EOF);");
    _builder.newLine();
    final String testee = _builder.toString();
    this.compare(testee, testee);
  }
  
  @Test
  public void matchAllTokens02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("RULE_RICH_TEXT_START : \'\\\'\\\'\\\'\' RULE_IN_RICH_STRING* (\'\\\'\' \'\\\'\'?)? \'\\u00AB\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("RULE_RICH_TEXT_END : \'\\u00BB\' RULE_IN_RICH_STRING* (\'\\\'\\\'\\\'\'|(\'\\\'\' \'\\\'\'?)? EOF);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("RULE_RICH_TEXT_INBETWEEN : \'\\u00BB\' RULE_IN_RICH_STRING* (\'\\\'\' \'\\\'\'?)? \'\\u00AB\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("RULE_COMMENT_RICH_TEXT_INBETWEEN : \'\\u00AB\\u00AB\' ~((\'\\n\'|\'\\r\'))* (\'\\r\'? \'\\n\' RULE_IN_RICH_STRING* (\'\\\'\' \'\\\'\'?)? \'\\u00AB\')?;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("RULE_COMMENT_RICH_TEXT_END : \'\\u00AB\\u00AB\' ~((\'\\n\'|\'\\r\'))* (\'\\r\'? \'\\n\' RULE_IN_RICH_STRING* (\'\\\'\\\'\\\'\'|(\'\\\'\' \'\\\'\'?)? EOF)|EOF);");
    _builder.newLine();
    final String testee = _builder.toString();
    this.compare(testee, testee);
  }
  
  @Test(expected = AssertionError.class)
  public void mismatchOfParantheses01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans ( ( hugo )");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans ( hugo )");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void mismatchOfParantheses02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans ( hugo ) )");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans ( hugo )");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void mismatchOfParantheses03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ \'(\' ( \')\' }");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("{ \'(\' \')\' }");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void mismatchOfParantheses04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ \'(\' \'( \')\' }");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("{ \'(\' \'(\' \')\' }");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
}
