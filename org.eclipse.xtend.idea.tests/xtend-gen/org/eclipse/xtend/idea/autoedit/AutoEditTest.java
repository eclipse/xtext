/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autoedit;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend.idea.autoedit.AbstractCStyleLanguageAutoEditTest;
import org.eclipse.xtext.idea.tests.LibraryUtil;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AutoEditTest extends AbstractCStyleLanguageAutoEditTest {
  public AutoEditTest() {
    super(XtendFileType.INSTANCE);
  }
  
  @Override
  protected void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
    LibraryUtil.addXtendLibrary(model);
  }
  
  @Override
  public void testSingleQuotedStringLiteral_15() {
  }
  
  public void testCurlyBraceBlockAndRichStrings_0() {
    this.configureByText("\n{|\n\'\'\'«{null}»\'\'\'}");
    this.myFixture.type("\n");
    this.assertState("\n{\n\t|\n\'\'\'«{null}»\'\'\'}");
  }
  
  public void testIndentationEdit_1() {
    this.configureByText("   \'|\'");
    this.myFixture.type("\n");
    this.assertState("   \'\n   |\'");
  }
  
  public void testIndentationEdit_2() {
    this.configureByText("  |");
    this.myFixture.type("\n");
    this.assertState("  \n  |");
  }
  
  public void testIndentationEdit_3() {
    this.configureByText("  \'\'\'\n  |\n\'\'\'");
    this.myFixture.type("\n");
    this.assertState("  \'\'\'\n  \n  |\n\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_1() {
    this.configureByText("\'\'\'|\'\'\'");
    this.myFixture.type("{");
    this.assertState("\'\'\'{|\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{\n\t|\n}\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{\n\t\n\t|\n}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_2() {
    this.configureByText("\'\'\'{|\n}\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{\n\t|\n}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_3() {
    this.configureByText("\'\'\'|\'\'\'");
    this.myFixture.type("}");
    this.assertState("\'\'\'}|\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_4() {
    this.configureByText("\'\'\'foo {|\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'foo {\n\t|\n}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_5() {
    this.configureByText("\'\'\'{|}\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{\n\t|\n}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_6() {
    this.configureByText("\'\'\'{| }\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{\n\t|\n}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_7() {
    this.configureByText("\'\'\'{ |foo }\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{ \n\t|foo\n}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_8() {
    this.configureByText("\'\'\'{ foo| }\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{ foo\n |}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_9() {
    this.configureByText("\'\'\'\"{\" foo| }\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'\"{\" foo\n |}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_10() {
    this.configureByText("\'\'\'/*{*/ foo|\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'/*{*/ foo\n|\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_11() {
    this.configureByText("\'\'\'{|}\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{\n\t|\n}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_12() {
    this.configureByText("\'\'\'{foo|}\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{foo\n|}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_13() {
    this.configureByText("\'\'\'{foo|bar}\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{foo\n|bar}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_14() {
    this.configureByText("\'\'\'{\nfoo|bar}\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{\nfoo\n|bar}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_15() {
    this.configureByText("\'\'\'{\nfoo}|{bar}\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{\nfoo}\n|{bar}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_16() {
    this.configureByText("\'\'\'{\n|}\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{\n\n|}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_17() {
    this.configureByText("\'\'\'{\n|\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{\n\n|\n}\'\'\'");
  }
  
  public void testCurlyBracesBlockInRichString_18() {
    this.configureByText("\'\'\'{{foo}|{bar}}\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'{{foo}\n|{bar}}\'\'\'");
  }
  
  public void testRichStringLiteral_01() {
    this.configureByText("\'\'|");
    this.myFixture.type("\'");
    this.assertState("\'\'\'|\'\'\'");
    this.myFixture.type("\'");
    this.assertState("\'\'\'\'|\'\'");
    this.myFixture.type("\'");
    this.assertState("\'\'\'\'\'|\'");
    this.myFixture.type("\'");
    this.assertState("\'\'\'\'\'\'|");
  }
  
  public void testRichStringLiteral_02() {
    this.configureByText("\'\'\'|\'\'\'");
    this.myFixture.type("\n");
    this.assertState("\'\'\'\n|\'\'\'");
  }
  
  public void testRichStringLiteral_03() {
    this.configureByText("  \'\'\'|\'\'\'");
    this.myFixture.type("\n");
    this.assertState("  \'\'\'\n  |\'\'\'");
  }
  
  public void testRichStringLiteral_04() {
    this.configureByText("\'\'\'|\'\'\'");
    this.myFixture.type("\"");
    this.assertState("\'\'\'\"|\"\'\'\'");
  }
  
  public void testRichStringLiteral_05() {
    this.configureByText("\'\'\'|\'\'\'");
    this.myFixture.type("«");
    this.assertState("\'\'\'«|»\'\'\'");
  }
  
  public void testRichStringLiteral_06() {
    this.configureByText("\'\'\'«foobar|»\'\'\'");
    this.myFixture.type("»");
    this.assertState("\'\'\'«foobar»|\'\'\'");
  }
  
  public void testRichStringLiteral_07() {
    this.configureByText("\'\'\'«|»\'\'\'");
    this.myFixture.type(AbstractCStyleLanguageAutoEditTest.BS);
    this.assertState("\'\'\'|\'\'\'");
  }
  
  public void testRichStringLiteral_08() {
    this.configureByText("\'\'\' foobar |\'\'\'");
    this.myFixture.type("\'");
    this.assertState("\'\'\' foobar \'|\'\'");
    this.myFixture.type("\'");
    this.assertState("\'\'\' foobar \'\'|\'");
    this.myFixture.type("\'");
    this.assertState("\'\'\' foobar \'\'\'|");
  }
  
  public void testRichStringLiteral_09() {
    this.configureByText("\'\'\' |«foobar» \'\'\'");
    this.myFixture.type("«");
    this.assertState("\'\'\' «|»«foobar» \'\'\'");
    this.myFixture.type("a");
    this.assertState("\'\'\' «a|»«foobar» \'\'\'");
    this.myFixture.type("»");
    this.assertState("\'\'\' «a»|«foobar» \'\'\'");
  }
  
  public void testRichStringLiteral_10() {
    this.configureByText("\'\'\' «foobar» |\'\'\'");
    this.myFixture.type("\'");
    this.assertState("\'\'\' «foobar» \'|\'\'");
    this.myFixture.type("\'");
    this.assertState("\'\'\' «foobar» \'\'|\'");
    this.myFixture.type("\'");
    this.assertState("\'\'\' «foobar» \'\'\'|");
  }
  
  public void testRichStringLiteral_11() {
    this.configureByText("\'\'\' text \'\'|");
    this.myFixture.type("\'");
    this.assertState("\'\'\' text \'\'\'|");
  }
  
  @Override
  public void testSingleQuotedStringLiteral_3() {
    this.configureByText("|\'");
    this.myFixture.type("\'");
    this.assertState("\'|\'");
    this.myFixture.type("\'");
    this.assertState("\'\'|");
    this.myFixture.type("\'");
    this.assertState("\'\'\'|\'\'\'");
  }
}
