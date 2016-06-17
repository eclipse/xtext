/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.parser;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.parser.AntlrGrammarComparatorTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;

/**
 * Contributes unit tests for {@link AntlrGrammarComparator}.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class AntlrGrammarComparatorTest {
  @Extension
  private AntlrGrammarComparatorTestHelper _antlrGrammarComparatorTestHelper = new AntlrGrammarComparatorTestHelper();
  
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
    this._antlrGrammarComparatorTestHelper.compare(testee, testee);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test
  public void stringMatch_00b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans");
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test
  public void stringMatch_01b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans hugo");
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_01b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hugo hans");
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_02b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans hugo");
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_03b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans");
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hu");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans hugo");
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void stringMismatch_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hans hu");
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test
  public void matchAllTokens01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("RULE_RICH_TEXT : \'\\\'\\\'\\\'\' RULE_IN_RICH_STRING* (\'\\\'\\\'\\\'\'|(\'\\\'\' \'\\\'\'?)? EOF);");
    _builder.newLine();
    final String testee = _builder.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, testee);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, testee);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
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
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test
  public void sLCommentIgnoring01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("A: \'A\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// rule B");
    _builder.newLine();
    _builder.append("B: \'B\'");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("A: \'A\'");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("B: \'B\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test
  public void sLCommentIgnoring01b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("A: \'A\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("B: \'B\'");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("A: \'A\'");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("// rule B");
    _builder_1.newLine();
    _builder_1.append("B: \'B\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test
  public void mismatchWithSLComment01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("A: \'A\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("B: \'B\'");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("A: \'A\'");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("// rule B");
    _builder_1.newLine();
    _builder_1.append("B: \'C\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compareAndExpectMismatchInLines(testee, expected, 3, 4);
  }
  
  @Test(expected = AssertionError.class)
  public void mismatchWithSLComment01b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("A: \'A\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("B: \'B\'");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("A: \'A\'");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("// rule B");
    _builder_1.newLine();
    _builder_1.append("B: \'C\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compareAndExpectMismatchInLines(testee, expected, 4, 4);
  }
  
  @Test
  public void mLCommentIgnoring01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("A: \'A\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* rule B");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("B: \'B\'");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("A: \'A\'");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("B: \'B\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test
  public void mLCommentIgnoring01b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("A: \'A\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("B: \'B\'");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("A: \'A\'");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/*");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* rule B");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("B: \'B\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compare(testee, expected);
  }
  
  @Test
  public void mismatchWithMLComment01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("A: \'A\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("B: \'B\'");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("A: \'A\'");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/*");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* rule B");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("B: \'C\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compareAndExpectMismatchInLines(testee, expected, 3, 6);
  }
  
  @Test(expected = AssertionError.class)
  public void mismatchWithMLComment01b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("A: \'A\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("B: \'B\'");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("A: \'A\'");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/*");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* rule B");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("B: \'C\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this._antlrGrammarComparatorTestHelper.compareAndExpectMismatchInLines(testee, expected, 3, 5);
  }
}
