/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.parser;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorComparisonFragment;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

/**
 * Contributes unit test for {@link XtextAntlrGeneratorComparisonFragment}.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextAntlrGeneratorComparisonFragmentTest extends XtextAntlrGeneratorComparisonFragment {
  @Test
  public void match_test01() {
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
  public void match_test02() {
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
  public void unmatchedTokens_test01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("RULE_RICH_TEXT : \'\\\'\\\'\\\'\' RULE_IN_RICH_STRING* (\'\\\'\\\'\\\'\'|(\'\\\'\' \'\\\'\'?)? EOF);");
    _builder.newLine();
    final String testee = _builder.toString();
    this.compare(testee, testee);
  }
  
  @Test
  public void unmatchedTokens_test02() {
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
  public void mismatch_test01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hans hugo");
    _builder.newLine();
    final String testee = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("hugo");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.compare(testee, expected);
  }
  
  @Test(expected = AssertionError.class)
  public void mismatch_test02() {
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
  public void mismatch_test03() {
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
  public void mismatch_test04() {
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
  public void mismatch_test05() {
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
  
  protected Pair<Integer, Integer> compare(final CharSequence grammar, final CharSequence grammarReference) {
    return super.compareGrammars(grammar, grammarReference, "", "");
  }
  
  @Override
  public void handleMismatch(final String absoluteGrammarFileName, final String absoluteGrammarFileNameReference, final String match, final String matchReference, final int lineNo, final int lineNoReference) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Inputs differs at token ");
    _builder.append(match, "");
    _builder.append(" (line ");
    _builder.append(lineNo, "");
    _builder.append("), expected token ");
    _builder.append(matchReference, "");
    _builder.append(" (line ");
    _builder.append(lineNoReference, "");
    _builder.append(" ).");
    _builder.newLineIfNotEmpty();
    Assert.fail(_builder.toString());
  }
  
  @Override
  public void handleUnexpectedCharSequence(final String absoluteGrammarFileName, final int lineNo) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Noticed an unmatched character sequence in/before line ");
    _builder.append(lineNo, "");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    Assert.fail(_builder.toString());
  }
  
  @Override
  public void copyFile(final String from, final String to) {
  }
}
