/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autoedit;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.eclipse.xtext.idea.tests.AbstractAutoEditTest;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractCStyleLanguageAutoEditTest extends AbstractAutoEditTest {
  protected final static String BS = "\b";
  
  public AbstractCStyleLanguageAutoEditTest(final LanguageFileType fileType) {
    super(fileType);
  }
  
  public void testParenthesis_1() {
    this.configureByText("|");
    this.myFixture.type("(");
    this.assertState("(|)");
    this.myFixture.type("(");
    this.assertState("((|))");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("(|)");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("|");
  }
  
  public void testParenthesis_2() {
    this.configureByText("|");
    this.myFixture.type("(");
    this.assertState("(|)");
    this.myFixture.type(")");
    this.assertState("()|");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("(|");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("|");
  }
  
  public void testParenthesis_3() {
    this.configureByText("|");
    this.myFixture.type("(");
    this.assertState("(|)");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("|");
  }
  
  public void testParenthesis_4() {
    this.configureByText("|foobar");
    this.myFixture.type("(");
    this.assertState("(|foobar");
  }
  
  public void testParenthesis_5() {
    this.configureByText("|");
    this.myFixture.type(")");
    this.assertState(")|");
    this.myFixture.type(")");
    this.assertState("))|");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState(")|");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("|");
  }
  
  public void testParenthesis_6() {
    this.configureByText("(|\n)");
    this.myFixture.type(")");
    this.assertState("()|\n)");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("(|\n)");
  }
  
  public void testParenthesis_7() {
    this.configureByText("(((|)");
    this.myFixture.type(")");
    this.assertState("((()|)");
    this.myFixture.type(")");
    this.assertState("((())|)");
    this.myFixture.type(")");
    this.assertState("((()))|");
  }
  
  public void testParenthesis_8() {
    this.configureByText("(foobar|)");
    this.myFixture.type(")");
    this.assertState("(foobar)|");
  }
  
  public void testParenthesis_9() {
    this.configureByText("|\'\')");
    this.myFixture.type("(");
    this.assertState("(|\'\')");
  }
  
  public void testParenthesis_10() {
    this.configureByText("(|\'\')");
    this.myFixture.type("(");
    this.assertState("((|\'\')");
  }
  
  public void testSingleQuotedStringLiteral_1() {
    this.configureByText("|");
    this.myFixture.type("\'");
    this.assertState("\'|\'");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("|");
  }
  
  public void testSingleQuotedStringLiteral_2() {
    this.configureByText("|");
    this.myFixture.type("\'");
    this.assertState("\'|\'");
    this.myFixture.type("\'");
    this.assertState("\'\'|");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\'|");
  }
  
  public void testSingleQuotedStringLiteral_3() {
    this.configureByText("|\'");
    this.myFixture.type("\'");
    this.assertState("\'|\'");
    this.myFixture.type("\'");
    this.assertState("\'\'|");
    this.myFixture.type("\'");
    this.assertState("\'\'\'|\'");
  }
  
  public void testSingleQuotedStringLiteral_4() {
    this.configureByText("|foo");
    this.myFixture.type("\'");
    this.assertState("\'|foo");
    this.myFixture.type("\'");
    this.assertState("\'\'|foo");
  }
  
  public void testSingleQuotedStringLiteral_5() {
    this.configureByText("|foo");
    this.myFixture.type("\'");
    this.assertState("\'|foo");
    this.myFixture.type("\'");
    this.assertState("\'\'|foo");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\'|foo");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("|foo");
  }
  
  public void testSingleQuotedStringLiteral_6() {
    this.configureByText("\'| \'");
    this.myFixture.type("\'");
    this.assertState("\'\'| \'");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\'| \'");
  }
  
  public void testSingleQuotedStringLiteral_7() {
    this.configureByText("\'\' \'| \'");
    this.myFixture.type("\'");
    this.assertState("\'\' \'\'| \'");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\'\' \'| \'");
  }
  
  public void testSingleQuotedStringLiteral_8() {
    this.configureByText("\'| \' \' \'");
    this.myFixture.type("\'");
    this.assertState("\'\'| \' \' \'");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\'| \' \' \'");
  }
  
  public void testSingleQuotedStringLiteral_9() {
    this.configureByText("foo|{}");
    this.selectText((-3), 3);
    this.myFixture.type("\'");
    this.assertState("\'|\'{}");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("|{}");
  }
  
  public void testSingleQuotedStringLiteral_10() {
    this.configureByText("foo|{}");
    this.selectText((-2), 2);
    this.myFixture.type("\'");
    this.assertState("f\'|\'{}");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("f|{}");
  }
  
  public void testSingleQuotedStringLiteral_11() {
    this.configureByText("|foo{}");
    this.selectText(0, 2);
    this.myFixture.type("\'");
    this.assertState("\'|o{}");
  }
  
  public void testSingleQuotedStringLiteral_12() {
    this.configureByText("|foo{}");
    this.selectText(0, 1);
    this.myFixture.type("\'");
    this.assertState("\'|oo{}");
  }
  
  public void testSingleQuotedStringLiteral_13() {
    this.configureByText("\'a|");
    this.myFixture.type("\'");
    this.assertState("\'a\'|");
  }
  
  public void testSingleQuotedStringLiteral_14() {
    this.configureByText("|\'test\'");
    this.myFixture.type("\'");
    this.assertState("\'|\'\'test\'");
  }
  
  public void testSingleQuotedStringLiteral_15() {
    this.configureByText("\'|\'\'test\'");
    this.myFixture.type("\'");
    this.assertState("\'\'|\'test\'");
    this.myFixture.type("\'");
    this.assertState("\'\'\'|\'\'test\'");
  }
  
  public void testDoubleQuotedStringLiteral_1() {
    this.configureByText("|");
    this.myFixture.type("\"");
    this.assertState("\"|\"");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("|");
  }
  
  public void testDoubleQuotedStringLiteral_2() {
    this.configureByText("|");
    this.myFixture.type("\"");
    this.assertState("\"|\"");
    this.myFixture.type("\"");
    this.assertState("\"\"|");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\"|");
  }
  
  public void testDoubleQuotedStringLiteral_3() {
    this.configureByText("|\"");
    this.myFixture.type("\"");
    this.assertState("\"|\"");
    this.myFixture.type("\"");
    this.assertState("\"\"|");
    this.myFixture.type("\"");
    this.assertState("\"\"\"|\"");
  }
  
  public void testDoubleQuotedStringLiteral_4() {
    this.configureByText("|foo");
    this.myFixture.type("\"");
    this.assertState("\"|foo");
    this.myFixture.type("\"");
    this.assertState("\"\"|foo");
  }
  
  public void testDoubleQuotedStringLiteral_5() {
    this.configureByText("|foo");
    this.myFixture.type("\"");
    this.assertState("\"|foo");
    this.myFixture.type("\"");
    this.assertState("\"\"|foo");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\"|foo");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("|foo");
  }
  
  public void testDoubleQuotedStringLiteral_6() {
    this.configureByText("\"| \"");
    this.myFixture.type("\"");
    this.assertState("\"\"| \"");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\"| \"");
  }
  
  public void testDoubleQuotedStringLiteral_7() {
    this.configureByText("\"\" \"| \"");
    this.myFixture.type("\"");
    this.assertState("\"\" \"\"| \"");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\"\" \"| \"");
  }
  
  public void testDoubleQuotedStringLiteral_8() {
    this.configureByText("\"| \" \" \"");
    this.myFixture.type("\"");
    this.assertState("\"\"| \" \" \"");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\"| \" \" \"");
  }
  
  public void testDoubleQuotedStringLiteral_9() {
    this.configureByText("\"a|");
    this.myFixture.type("\"");
    this.assertState("\"a\"|");
  }
  
  public void testDoubleQuotedStringLiteral_10() {
    this.configureByText("|\"test\"");
    this.myFixture.type("\"");
    this.assertState("\"|\"\"test\"");
  }
  
  public void testCurlyBracesBlock_1() {
    this.configureByText("|");
    this.myFixture.type("{");
    this.assertState("{|}");
    this.myFixture.type("\n");
    this.assertState("{\n\t|\n}");
    this.myFixture.type("\n");
    this.assertState("{\n\t\n\t|\n}");
  }
  
  public void testCurlyBracesBlock_2() {
    this.configureByText("{|\n}");
    this.myFixture.type("\n");
    this.assertState("{\n\t|\n}");
  }
  
  public void testCurlyBracesBlock_3() {
    this.configureByText("|");
    this.myFixture.type("}");
    this.assertState("}|");
  }
  
  public void testCurlyBracesBlock_4() {
    this.configureByText("foo {|");
    this.myFixture.type("\n");
    this.assertState("foo {\n\t|\n}");
  }
  
  public void testCurlyBracesBlock_5() {
    this.configureByText("{|}");
    this.myFixture.type("\n");
    this.assertState("{\n\t|\n}");
  }
  
  public void testCurlyBracesBlock_6() {
    this.configureByText("{| }");
    this.myFixture.type("\n");
    this.assertState("{\n\t|\n}");
  }
  
  public void testCurlyBracesBlock_7() {
    this.configureByText("{ |foo }");
    this.myFixture.type("\n");
    this.assertState("{ \n\t|foo }");
  }
  
  public void testCurlyBracesBlock_8() {
    this.configureByText("{ foo| }");
    this.myFixture.type("\n");
    this.assertState("{ foo\n|}");
  }
  
  public void testCurlyBracesBlock_9() {
    this.configureByText("\'{\' foo| }");
    this.myFixture.type("\n");
    this.assertState("\'{\' foo\n|}");
  }
  
  public void testCurlyBracesBlock_10() {
    this.configureByText("/*{*/ foo|");
    this.myFixture.type("\n");
    this.assertState("/*{*/ foo\n|");
  }
  
  public void testCurlyBracesBlock_11() {
    this.configureByText("{|}");
    this.myFixture.type("\n");
    this.assertState("{\n\t|\n}");
  }
  
  public void testCurlyBracesBlock_12() {
    this.configureByText("{foo|}");
    this.myFixture.type("\n");
    this.assertState("{foo\n|}");
  }
  
  public void testCurlyBracesBlock_13() {
    this.configureByText("{foo|bar}");
    this.myFixture.type("\n");
    this.assertState("{foo\n\t|bar}");
  }
  
  public void testCurlyBracesBlock_14() {
    this.configureByText("{\nfoo|bar}");
    this.myFixture.type("\n");
    this.assertState("{\nfoo\n|bar}");
  }
  
  public void testCurlyBracesBlock_15() {
    this.configureByText("{\nfoo}|{bar}");
    this.myFixture.type("\n");
    this.assertState("{\nfoo}\n|{bar}");
  }
  
  public void testCurlyBracesBlock_16() {
    this.configureByText("{\n|}");
    this.myFixture.type("\n");
    this.assertState("{\n\n|}");
  }
  
  public void testCurlyBracesBlock_17() {
    this.configureByText("{\n|");
    this.myFixture.type("\n");
    this.assertState("{\n\n\t|");
  }
  
  public void testCurlyBracesBlock_18() {
    this.configureByText("{{foo}|{bar}}");
    this.myFixture.type("\n");
    this.assertState("{{foo}\n\t|{bar}}");
  }
  
  public void testCurlyBracesBlock_19() {
    this.configureByText("{{|");
    this.myFixture.type("\n");
    this.assertState("{{\n\t|\n}}");
    this.myFixture.type("\n");
    this.assertState("{{\n\t\n\t|\n}}");
  }
  
  public void testCurlyBracesWithSelection_1() {
    this.configureByText("{|foo}");
    this.selectText(0, 3);
    this.myFixture.type("{");
    this.assertState("{{|}}");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("{|}");
  }
  
  public void testCurlyBracesWithSelection_2() {
    this.configureByText("{|foo}");
    this.selectText(0, 2);
    this.myFixture.type("{");
    this.assertState("{{|o}");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("{|o}");
  }
  
  public void testCurlyBracesWithSelection_3() {
    this.configureByText("{|foo}");
    this.selectText(0, 1);
    this.myFixture.type("{");
    this.assertState("{{|oo}");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("{|oo}");
  }
  
  public void testCurlyBracesWithSelection_4() {
    this.configureByText("{{|foo}}");
    this.selectText(0, 3);
    this.myFixture.type("}");
    this.assertState("{{}|}");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("{{|}");
  }
  
  public void testCurlyBracesWithSelection_5() {
    this.configureByText("{{|foo}}");
    this.selectText(0, 2);
    this.myFixture.type("}");
    this.assertState("{{}|o}}");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("{{|o}}");
    this.myFixture.type("{");
    this.assertState("{{{|o}}");
  }
  
  /**
   * @see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=472623">Ignored because of 472623</a>
   */
  public void ignore_testMLComments_01() {
    this.configureByText("|");
    this.myFixture.type("/");
    this.myFixture.type("*");
    this.assertState("/*|");
    this.myFixture.type("\n");
    this.assertState("/*\n|\n */");
  }
  
  public void testMLComments_01() {
    this.configureByText("/*\n * |\n */");
    this.myFixture.type("\n");
    this.assertState("/*\n * \n * |\n */");
    this.myFixture.type("foo bar");
    this.myFixture.type("\n");
    this.assertState("/*\n * \n * foo bar\n * |\n */");
  }
  
  /**
   * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=472623">Ignored because of 472623</a>
   */
  public void ignore_testMLComments_02() {
    this.configureByText("   |");
    this.myFixture.type("/");
    this.myFixture.type("*");
    this.assertState("   /*|");
    this.myFixture.type("\n");
    this.assertState("   /*\n   |\n    */");
  }
  
  public void testMLComments_02() {
    this.configureByText("   /*\n    * |\n    */");
    this.myFixture.type("\n");
    this.assertState("   /*\n    * \n    * |\n    */");
    this.myFixture.type("foo bar");
    this.myFixture.type("\n");
    this.assertState("   /*\n    * \n    * foo bar\n    * |\n    */");
  }
  
  public void testMLComments_03() {
    this.configureByText("/*\n *| */");
    this.myFixture.type("\n");
    this.assertState("/*\n *\n  * | */");
  }
  
  public void testMLComments_04() {
    this.configureByText("\t/*\n\t *|\n\t */");
    this.myFixture.type("\n");
    this.assertState("\t/*\n\t *\n\t * |\n\t */");
  }
  
  public void testMLComments_05() {
    this.configureByText("foo /*\n     *|\n      */");
    this.myFixture.type("\n");
    this.assertState("foo /*\n     *\n     * |\n      */");
  }
  
  public void testMLComments_07() {
    this.configureByText("/* */|");
    this.myFixture.type("\n");
    this.assertState("/* */\n|");
  }
  
  public void testMLComments_08() {
    this.configureByText("  /* foo | */");
    this.myFixture.type("\n");
    this.assertState("  /* foo \n   * | */");
  }
  
  public void testMLComments_09() {
    this.configureByText("/* foo |*/");
    this.myFixture.type("\n");
    this.assertState("/* foo \n* |*/");
  }
  
  public void testMLComments_10() {
    this.configureByText("   /* foo |*/");
    this.myFixture.type("\n");
    this.assertState("   /* foo \n   * |*/");
  }
  
  public void testMLComments_11() {
    this.configureByText("/* */\n * |");
    this.myFixture.type("\n");
    this.assertState("/* */\n * \n|");
  }
  
  public void testMLComments_12() {
    this.configureByText("foo /*| */");
    this.myFixture.type("\n");
    this.assertState("foo /*\n |*/");
  }
  
  public void testMLComments_13() {
    this.configureByText("/* foo| */");
    this.myFixture.type("\n");
    this.assertState("/* foo\n * | */");
  }
  
  public void testMLComments_14() {
    this.configureByText("/* foo|*/");
    this.myFixture.type("\n");
    this.assertState("/* foo\n* |*/");
  }
  
  public void testMLComments_15() {
    this.configureByText("  /* foo| */");
    this.myFixture.type("\n");
    this.assertState("  /* foo\n   * | */");
  }
  
  public void testMLComments_16() {
    this.configureByText("  /* foo|*/");
    this.myFixture.type("\n");
    this.assertState("  /* foo\n  * |*/");
  }
  
  public void testMLComments_17() {
    this.configureByText("  /*\n| *\n */");
    this.myFixture.type("\n");
    this.assertState("  /*\n\n| *\n */");
  }
  
  public void testBug453205_01() {
    this.configureByText((("/*|\n" + "* comment\n") + "*/"));
    this.myFixture.type("\n");
    this.assertState(((("/*\n" + "|\n") + "* comment\n") + "*/"));
  }
  
  public void testBug453205_02() {
    this.configureByText((("/**********|\n" + " * \"Fancy\"\n") + "**********/"));
    this.myFixture.type("\n");
    this.assertState(((("/**********\n" + "|\n") + " * \"Fancy\"\n") + "**********/"));
  }
  
  public void testBug341093_01() {
    this.configureByText(("/**/\n" + "//test|"));
    this.myFixture.type("\n");
    this.assertState((("/**/\n" + "//test\n") + "|"));
  }
  
  public void testBug341093_02() {
    this.configureByText((("/*\n" + " **/\n") + "//test|"));
    this.myFixture.type("\n");
    this.assertState(((("/*\n" + " **/\n") + "//test\n") + "|"));
  }
  
  public void testBug341093_03() {
    this.configureByText(((("/***********\n" + " * text|\n") + "\n") + "***********/"));
    this.myFixture.type("\n");
    this.assertState((((("/***********\n" + " * text\n") + " * |\n") + "\n") + "***********/"));
  }
  
  public void testBug335634_01() {
    this.configureByText("// /*|\ntest");
    this.myFixture.type("\n");
    this.assertState("// /*\n|\ntest");
  }
  
  public void testBug335634_02() {
    this.configureByText("// /|");
    this.myFixture.type("*");
    this.assertState("// /*|");
  }
  
  public void testBug335634_03() {
    this.configureByText(" // /|");
    this.myFixture.type("*");
    this.assertState(" // /*|");
  }
  
  public void testBug335634_04() {
    this.configureByText(" // /|\n");
    this.myFixture.type("*");
    this.assertState(" // /*|\n");
  }
  
  public void testBug335634_05() {
    this.configureByText("// /|");
    this.myFixture.type("{");
    this.assertState("// /{|");
  }
  
  public void testBug335634_06() {
    this.configureByText(" // /|");
    this.myFixture.type("{");
    this.assertState(" // /{|");
  }
  
  public void testBug335634_07() {
    this.configureByText(" // /\n|");
    this.myFixture.type("{");
    this.assertState(" // /\n {|}");
  }
  
  public void testSingleLineComment_01() {
    this.configureByText("  // test|test");
    this.myFixture.type("\n");
    this.assertState("  // test\n  // |test");
  }
  
  public void testSingleLineComment_02() {
    this.configureByText("  // test|test\n");
    this.myFixture.type("\n");
    this.assertState("  // test\n  // |test\n");
  }
  
  public void testSingleLineComment_03() {
    this.configureByText("  // test|");
    this.myFixture.type("\n");
    this.assertState("  // test\n  |");
  }
  
  public void testSingleLineComment_04() {
    this.configureByText("  // test|\n");
    this.myFixture.type("\n");
    this.assertState("  // test\n  |\n");
  }
  
  public void testBug338423_01() {
    this.configureByText("[{|}]");
    this.myFixture.type("\n");
    this.assertState("[{\n\t|\n}]");
  }
  
  public void testBug338423_02() {
    this.configureByText("[{}|]");
    this.myFixture.type("\n");
    this.assertState("[{}\n|]");
  }
  
  public void testBug358555() {
    this.configureByText("/* | /**/");
    this.myFixture.type("\n");
    this.assertState("/* \n |/**/\n  */");
  }
}
