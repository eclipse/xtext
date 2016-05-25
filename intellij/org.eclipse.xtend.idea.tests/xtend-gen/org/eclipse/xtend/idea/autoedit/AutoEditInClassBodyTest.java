/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autoedit;

import com.intellij.psi.PsiFile;
import org.eclipse.xtend.idea.autoedit.AbstractCStyleLanguageAutoEditTest;
import org.eclipse.xtend.idea.autoedit.AutoEditTest;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AutoEditInClassBodyTest extends AutoEditTest {
  private final static String PREFIX = "class Foo {\n";
  
  private final static String SUFFIX = "\n}";
  
  @Override
  protected PsiFile configureByText(final String code) {
    return super.configureByText(((AutoEditInClassBodyTest.PREFIX + code) + AutoEditInClassBodyTest.SUFFIX));
  }
  
  @Override
  protected void assertState(final String editorState) {
    super.assertState(((AutoEditInClassBodyTest.PREFIX + editorState) + AutoEditInClassBodyTest.SUFFIX));
  }
  
  @Override
  public void testCurlyBracesBlock_1() {
    this.configureByText("|");
    this.myFixture.type("{");
    this.assertState("\t{|}");
    this.myFixture.type("\n");
    this.assertState("\t{\n\t\t|\n\t}");
    this.myFixture.type("\n");
    this.assertState("\t{\n\t\t\n\t\t|\n\t}");
  }
  
  @Override
  public void testIndentationEdit_2() {
    this.configureByText("  |");
    this.myFixture.type("\n");
    this.assertState("  \n\t|");
  }
  
  @Override
  public void testBug341093_01() {
    this.configureByText(("/**/\n" + "//test|"));
    this.myFixture.type("\n");
    this.assertState((("/**/\n" + "//test\n") + "\t|"));
  }
  
  @Override
  public void testBug341093_02() {
    this.configureByText((("/*\n" + " **/\n") + "//test|"));
    this.myFixture.type("\n");
    this.assertState(((("/*\n" + " **/\n") + "//test\n") + "\t|"));
  }
  
  @Override
  public void testMLComments_07() {
    this.configureByText("/* */|");
    this.myFixture.type("\n");
    this.assertState("/* */\n\t|");
  }
  
  @Override
  public void testMLComments_11() {
    this.configureByText("/* */\n * |");
    this.myFixture.type("\n");
    this.assertState("/* */\n * \n\t|");
  }
  
  @Override
  public void testSingleLineComment_03() {
    this.configureByText("  // test|");
    this.myFixture.type("\n");
    this.assertState("  // test\n\t|");
  }
  
  @Override
  public void testSingleLineComment_04() {
    this.configureByText("  // test|\n");
    this.myFixture.type("\n");
    this.assertState("  // test\n\t|\n");
  }
  
  @Override
  public void testCurlyBracesBlock_10() {
    this.configureByText("/*{*/ foo|");
    this.myFixture.type("\n");
    this.assertState("/*{*/ foo\n|");
  }
  
  @Override
  public void testCurlyBracesBlock_17() {
    this.configureByText("{\n|");
    this.myFixture.type("\n");
    this.assertState("{\n\n\t|");
  }
  
  @Override
  public void testCurlyBracesBlock_19() {
    this.configureByText("{{|");
    this.myFixture.type("\n");
    this.assertState("{{\n\t|\n}}");
    this.myFixture.type("\n");
    this.assertState("{{\n\t\n\t|\n}}");
  }
  
  @Override
  public void testParenthesis_1() {
    this.configureByText("|");
    this.myFixture.type("(");
    this.assertState("\t(|)");
    this.myFixture.type("(");
    this.assertState("\t((|))");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\t(|)");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\t|");
  }
  
  @Override
  public void testParenthesis_2() {
    this.configureByText("|");
    this.myFixture.type("(");
    this.assertState("\t(|)");
    this.myFixture.type(")");
    this.assertState("\t()|");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\t(|");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\t|");
  }
  
  @Override
  public void testParenthesis_3() {
    this.configureByText("|");
    this.myFixture.type("(");
    this.assertState("\t(|)");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\t|");
  }
  
  @Override
  public void testParenthesis_4() {
    this.configureByText("|foobar");
    this.myFixture.type("(");
    this.assertState("\t(|foobar");
  }
  
  @Override
  public void testParenthesis_5() {
    this.configureByText("|");
    this.myFixture.type(")");
    this.assertState("\t)|");
    this.myFixture.type(")");
    this.assertState("\t))|");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\t)|");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\t|");
  }
  
  @Override
  public void testParenthesis_9() {
    this.configureByText("|\'\')");
    this.myFixture.type("(");
    this.assertState("\t(|\'\')");
  }
}
